package com.udemy.springbootwebfluxapirest.app.service;

import com.udemy.springbootwebfluxapirest.app.model.Producto;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ProductoService {

    public Flux<Producto> findAll();

    Flux<Producto> findAllConNombreUpperCase();

    Flux<Producto> findAllConNombreUpperCaseRepeat();

    public Mono<Producto> findById(String id);

    public Mono<Producto> save(Producto producto);

    public Mono<Void> delete(Producto producto);

    public Mono<Void> deleteById(String id);

}
