/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.antonio.graphicrecipes.dao;

import com.antonio.graphicrecipes.entity.User;
import java.util.List;
import java.util.function.Consumer;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/*
 *
 * @author Antonio
 */

@Stateless
public class UserDAO implements IUserDAO {
    
    @PersistenceContext
    private EntityManager em;

    public UserDAO() {
        
    }

    @Override
    public User get(String id) {
        return em.find(User.class, id);
    }

    @Override
    public List<User> getAll() {
        TypedQuery<User> query = em.createQuery("Select u from User u", User.class);
        return query.getResultList();
    }

    @Override
    public void save(User u) {
        System.out.println(u);
        executeTransaction(entityManager -> entityManager.persist(u));
    }

    @Override
    public void update(User u) {
        executeTransaction(entityManager -> entityManager.merge(u));
    }

    @Override
    public void delete(User u) {
        executeTransaction(entityManager -> entityManager.remove(u));
    }
    
    @Override
    public String getPassword(String userId){
        System.out.println("userID ======> " + userId);
        TypedQuery query = em.createQuery("SELECT u.password FROM User u WHERE u.email= :userId OR u.userId= :userId", String.class);
        query.setParameter("userId", userId);
        return (String) query.getSingleResult();
    }
    
    // Metodo encargado de ejecutar la transaccion
    // Mediante Consumer, le pasamos a este metodo 
    // el metodo de EntityManager que deseamos ejecutar.
    private void executeTransaction(Consumer<EntityManager> action) {
            System.out.println("Execute Transaction");
            System.out.println(em);
            action.accept(em);
            System.out.println("Execute Transaction end");
            em.flush();
    }
}
