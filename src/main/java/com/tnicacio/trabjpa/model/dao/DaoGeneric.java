package com.tnicacio.trabjpa.model.dao;

import java.util.List;

/**
 *
 * @author tnica
 * @param <T>
 */
public interface DaoGeneric<T> {
    
    void insert(T obj);
    void update(T obj);
    void deleteById(Long id);
    T findById(Long id);
    List<T> findAll();
    
}
