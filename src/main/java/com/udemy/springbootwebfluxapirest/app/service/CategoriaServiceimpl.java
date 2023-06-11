package com.udemy.springbootwebfluxapirest.app.service;

import com.udemy.springbootwebfluxapirest.app.model.Categoria;
import com.udemy.springbootwebfluxapirest.app.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CategoriaServiceimpl implements CategoriaService{
    @Autowired
    private CategoriaRepository categoriaRepository;

    @Override
    public Flux<Categoria> findAll() {
        return categoriaRepository.findAll();
    }

    @Override
    public Mono<Categoria> findById(String id) {
        return categoriaRepository.findById(id);
    }

    @Override
    public Mono<Categoria> save(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

    @Override
    public Mono<Void> delete(Categoria categoria) {
        return categoriaRepository.delete(categoria);
    }

    @Override
    public Mono<Void> deleteById(String id) {
        return categoriaRepository.deleteById(id);
    }
}
