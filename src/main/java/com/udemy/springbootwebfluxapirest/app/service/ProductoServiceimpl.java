package com.udemy.springbootwebfluxapirest.app.service;

import com.udemy.springbootwebfluxapirest.app.model.Producto;
import com.udemy.springbootwebfluxapirest.app.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ProductoServiceimpl implements ProductoService{
    @Autowired
    private ProductoRepository productoRepository;

    @Override
    public Flux<Producto> findAll() {
        return productoRepository.findAll();
    }

    @Override
    public Flux<Producto> findAllConNombreUpperCase() {
        return productoRepository.findAll()
                .map(producto -> {
                    producto.setNombre(producto.getNombre().toUpperCase());
                    return producto;
                });
    }

    @Override
    public Flux<Producto> findAllConNombreUpperCaseRepeat() {
        return findAllConNombreUpperCase().repeat(5000);
    }

    @Override
    public Mono<Producto> findById(String id) {
        return productoRepository.findById(id);
    }

    @Override
    public Mono<Producto> save(Producto producto) {
        return productoRepository.save(producto);
    }

    @Override
    public Mono<Void> delete(Producto producto) {
        return productoRepository.delete(producto);
    }

    @Override
    public Mono<Void> deleteById(String id) {
        return productoRepository.deleteById(id);
    }
}
