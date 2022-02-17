package ua.com.alevel.dao;

import ua.com.alevel.arraylist.CustomArrayList;
import ua.com.alevel.entity.AbstractEntity;

public interface AbstractDao <E extends AbstractEntity> {
    void create(E entity);
    void update(E entity);
    void delete(String id);
    E findById(String id);
    CustomArrayList<E> findAll();
}
