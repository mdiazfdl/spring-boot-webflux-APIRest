package com.udemy.springbootwebfluxapirest.app.controller;

import com.udemy.springbootwebfluxapirest.app.model.Producto;
import com.udemy.springbootwebfluxapirest.app.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("api/producto")
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    @GetMapping
    public Flux<Producto> listar(){
        return productoService.findAll();
    }
    @GetMapping("/{id}")
    public Mono<Producto> obtener(@PathVariable String id){
        return productoService.findById(id);
    }
    @PostMapping
    public Mono<Producto> crear(Producto producto){
        return productoService.save(producto);
    }
    @DeleteMapping("/{id}")
    public Mono<Void> eliminar (@PathVariable String id){
        return productoService.deleteById(id);
    }

}
