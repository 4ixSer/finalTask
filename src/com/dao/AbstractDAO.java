package com.dao;

import java.util.List;

import com.db.WrapperConnector;
import com.entity.Entity;

public abstract class AbstractDAO <T extends Entity> {
    protected WrapperConnector connector;

    public abstract List<T> findAll();
    public abstract T findEntityById(int id);
    public abstract boolean delete(int id);
    public abstract boolean delete(T entity);
    public abstract boolean create(T entity);
    public abstract T update(T entity);
}
