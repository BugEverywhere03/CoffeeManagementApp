package com.bugeverywhere.app.model.repository;

import java.util.List;

public interface ICommon <T> {
    public List<T> findAll();
    public boolean save(T t);
    public boolean delete(T t);
}
