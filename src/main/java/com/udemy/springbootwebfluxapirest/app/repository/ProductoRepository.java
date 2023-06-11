package com.udemy.springbootwebfluxapirest.app.repository;

import com.udemy.springbootwebfluxapirest.app.model.Producto;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface ProductoRepository extends ReactiveMongoRepository<Producto,String> {
}
