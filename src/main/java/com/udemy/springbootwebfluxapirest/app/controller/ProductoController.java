package com.udemy.springbootwebfluxapirest.app.controller;

import com.udemy.springbootwebfluxapirest.app.model.Producto;
import com.udemy.springbootwebfluxapirest.app.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.net.URI;
import java.util.Date;

@RestController
@RequestMapping("api/producto")
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    @GetMapping
    public Mono<ResponseEntity<Flux<Producto>>> listar() {
        return Mono.just(ResponseEntity.ok(productoService.findAll()));
    }

    @GetMapping("/{id}")
    public Mono<ResponseEntity<Producto>> obtener(@PathVariable String id) {
        return productoService.findById(id).map(p -> ResponseEntity.ok(p))
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Mono<ResponseEntity<Producto>> crear(@RequestBody Producto producto) {
        if (producto.getCreateAt() == null) {
            producto.setCreateAt(new Date());
        }
        return productoService.save(producto).map(p -> ResponseEntity
                .created(URI.create("api/producto/".concat(p.getId())))
                .body(p));
    }

    @DeleteMapping("/{id}")
    public Mono<ResponseEntity<Void>> eliminar(@PathVariable String id) {
        return productoService.findById(id).flatMap(p-> {
            return productoService.delete(p).then(Mono.just(new ResponseEntity<Void>(HttpStatus.NO_CONTENT)));
        }).defaultIfEmpty( new ResponseEntity<Void>(HttpStatus.NOT_FOUND));
    }

    @PutMapping("/{id}")
    public Mono<ResponseEntity<Producto>> editar(@PathVariable String id, @RequestBody Producto producto) {

        return productoService.findById(id).flatMap(p -> {
            p.setNombre(producto.getNombre());
            p.setPrecio(producto.getPrecio());
            p.setCategoria(producto.getCategoria());
            return productoService.save(p);
        }).map(p -> ResponseEntity
                .created(URI.create("api/producto/".concat(p.getId())))
                .body(p))
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

}
