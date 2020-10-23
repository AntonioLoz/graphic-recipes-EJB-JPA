/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.antonio.graphicrecipes.dao;

import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author Antonio
 * @param <T>
 * @param <E>
 */

@Remote
public interface Dao<T, E> {
    T get(E id);
    List<T> getAll();
    void save(T t);
    void update(T t);
    void delete(T t);
}