/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.antonio.graphicrecipes.controller;

import com.antonio.graphicrecipes.dao.IRecipeDAO;
import com.antonio.graphicrecipes.dao.RecipeDAO;
import com.antonio.graphicrecipes.entity.Recipe;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Antonio
 */
public class HomeServlet extends HttpServlet {

    @EJB(beanName="RecipeDAO")
    private final IRecipeDAO recipeDAO = new RecipeDAO();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        RequestDispatcher rd = request.getRequestDispatcher("home.jsp");
                List<Recipe> recipes = recipeDAO.getAll();
                List<Recipe> subRecipes = new ArrayList<>(); 
                for(int i = (recipes.size() - 1) ; i >= (recipes.size() - 4) ; i--) {
                subRecipes.add(recipes.get(i));
                }
                request.setAttribute("recipes", subRecipes);
                rd.forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
