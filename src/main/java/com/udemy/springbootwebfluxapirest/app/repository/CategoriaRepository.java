package com.udemy.springbootwebfluxapirest.app.repository;


import com.udemy.springbootwebfluxapirest.app.model.Categoria;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface CategoriaRepository extends ReactiveMongoRepository<Categoria,String> {
}
