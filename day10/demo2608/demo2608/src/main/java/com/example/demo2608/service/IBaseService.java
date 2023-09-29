package com.example.demo2608.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IBaseService<Entity> {
    Page<Entity> findAll(Pageable pageable);

    Page<Entity> findByName(String name, Pageable pageable);

    Entity findById(Long id) throws Exception;

    Entity updateOrCreate(Entity entity);

    void deleteById(Long id) throws Exception;
}
