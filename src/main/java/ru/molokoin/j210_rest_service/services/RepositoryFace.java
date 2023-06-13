package ru.molokoin.j210_rest_service.services;

import java.util.Collection;

import jakarta.ejb.Local;

@Local
public interface RepositoryFace {
    <T> Collection<T> findAll(Class<T> clazz);
    <T> T findById(Class<T> clazz, Integer id);
    <T> void delete(Class<T> clazz, Integer id);
    <T> void save(T entity);
    <T> void update(T entity);
}
