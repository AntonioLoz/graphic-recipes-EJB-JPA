/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.antonio.graphicrecipes.dao;

import com.antonio.graphicrecipes.entity.Recipe;
import java.util.List;

/**
 *
 * @author Antonio
 */
public interface IRecipeDAO extends Dao<Recipe, String>{
    List<Recipe> getByFilter(String filter);
}
