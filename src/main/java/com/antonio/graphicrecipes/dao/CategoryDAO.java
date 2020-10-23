/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.antonio.graphicrecipes.dao;

import com.antonio.graphicrecipes.entity.Category;
import java.util.List;
import java.util.function.Consumer;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author Antonio
 */
@Stateless
public class CategoryDAO implements Dao<Category, Integer>{
    
    @PersistenceContext
    private EntityManager em;
    
    
    public CategoryDAO() {
        
    }
    
    
    @Override
    public Category get(Integer id) {
        return em.find(Category.class, id);
    }
    
    public List<Category> getByName(String name){
        TypedQuery query = em.createQuery("SELECT c FROM Category c WHERE c.name= : name", Category.class);
        query.setParameter("name", name);
        return query.getResultList();
    }

    @Override
    public List<Category> getAll() {
        TypedQuery query = em.createQuery("SELECT c FROM Category c", Category.class);
        return query.getResultList();
    }

    @Override
    public void save(Category t) {
        executeTransaction(entityManager -> entityManager.persist(t));
    }

    @Override
    public void update(Category t) {
        executeTransaction(entityManager -> entityManager.merge(t));
    }

    @Override
    public void delete(Category t) {
        executeTransaction(entityManager -> entityManager.remove(t));
    }
    
    private void executeTransaction(Consumer<EntityManager> action){
        action.accept(em);
    }
}
