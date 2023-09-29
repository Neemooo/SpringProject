package com.example.demo2608.service;

import java.util.List;

public interface IServiceService<Entity> {
    List<Entity> findAll();

    Entity findById(Long id) throws Exception;

    void deleteById(Long id) throws Exception;

    Entity update(Entity entity);

    Entity save(Entity entity);
}
