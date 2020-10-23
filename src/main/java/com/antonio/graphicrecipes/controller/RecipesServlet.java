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

public class RecipesServlet extends HttpServlet {

    @EJB(beanName="RecipeDAO")
    private final IRecipeDAO recipeDAO = new RecipeDAO();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String action = request.getParameter("action");

        switch (action) {

            case "recipes": {
                RequestDispatcher rd = request.getRequestDispatcher("recipes.jsp");
                List<Recipe> recipes = recipeDAO.getAll();
                request.setAttribute("recipes", recipes);
                rd.forward(request, response);
                break;
            }

            case "filter": {
                RequestDispatcher rd = request.getRequestDispatcher("recipes.jsp");
                String filter = (String) request.getParameter("filteredby");
                List<Recipe> recipes = recipeDAO.getByFilter(filter);
                System.out.println(recipes);
                request.setAttribute("recipes", recipes);
                rd.forward(request, response);
                break;
            }

            case "recipe": {
                RequestDispatcher rd = request.getRequestDispatcher("recipe.jsp");
                Recipe recipe = recipeDAO.get(request.getParameter("recipeSelected"));
                request.setAttribute("recipe", recipe);
                rd.forward(request, response);
                break;
            }
        }
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
