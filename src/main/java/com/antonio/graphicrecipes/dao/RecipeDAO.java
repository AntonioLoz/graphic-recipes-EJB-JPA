/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.antonio.graphicrecipes.dao;

import com.antonio.graphicrecipes.entity.Recipe;
import java.util.List;
import java.util.Optional;
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
public class RecipeDAO implements IRecipeDAO{
    
    @PersistenceContext
    private EntityManager em;
    
    public RecipeDAO(){
        
    }

    @Override
    public Recipe get(String id) {
        return em.find(Recipe.class, id);
    }

    @Override
    public List<Recipe> getAll() {
        TypedQuery<Recipe> query = em.createQuery("SELECT r FROM Recipe r", Recipe.class);
        return query.getResultList();
    }

    @Override
    public void save(Recipe r) {
        executeTransaction(entityManager -> entityManager.persist(r));
    }

    @Override
    public void update(Recipe r) {
        executeTransaction(entityManager -> entityManager.merge(r));
    }

    @Override
    public void delete(Recipe r) {
        executeTransaction(entityManager -> entityManager.remove(r));
    }
    
    @Override
    public List<Recipe> getByFilter(String filter) {
        System.out.println("Filter: " + filter);
        TypedQuery query = em.createQuery("SELECT r FROM Recipe r WHERE r.category.name= :filter", Recipe.class);
        query.setParameter("filter", filter);
        return query.getResultList();
    }
    
    private void executeTransaction(Consumer<EntityManager> action){

            action.accept(em);
            em.flush();
    }



}
