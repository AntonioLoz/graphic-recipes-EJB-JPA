/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.antonio.graphicrecipes.dao;

import com.antonio.graphicrecipes.entity.User;

/**
 *
 * @author Antonio
 */
public interface IUserDAO extends Dao<User, String> {
    //Obtiene un usuario segun se logee con el correo o con el userId
    String getPassword(String userId);
}
