/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.antonio.graphicrecipes.controller;

import com.antonio.graphicrecipes.dao.IUserDAO;
import com.antonio.graphicrecipes.dao.UserDAO;
import java.io.IOException;
import java.security.Principal;
import java.util.Map;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Antonio
 */

public class LoginServlet extends HttpServlet {
  
    @EJB(beanName="UserDAO")
    private IUserDAO userDao = new UserDAO();
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        System.out.println("Servlet path: " + request.getServletPath());
        System.out.println("Path info: " + request.getPathInfo());
        
        Map<String,  ? extends ServletRegistration> map = request.getServletContext().getServletRegistrations();
        
        for(String servletName : map.keySet()){
            ServletRegistration sr = map.get(servletName);
            
            System.out.println(servletName + ": " + sr.getMappings());
        }
        
        Principal p = request.getUserPrincipal();
        if(p != null){
            System.out.println(p.getName());
        }
        
        else{
            System.out.println("p = null");
        }
        
        
        RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
        rd.forward(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/plain");
        response.setCharacterEncoding("UTF-8");
                
        String user = request.getParameter("userId");
        String pass = request.getParameter("password");
        
        if(user!= null && pass.equals(userDao.getPassword(user))){
            System.out.println("Login: sucess!");
            System.out.println("Comprobando sesion...");
            
            HttpSession session = request.getSession(false);
            
            if(session != null){
                System.out.println("Invalidando sesion...");
                session.invalidate();
            }
            
            System.out.println("Creando nueva sesion...");
            session = request.getSession(true);
            session.setAttribute("userId", user);
          
            
            session.setMaxInactiveInterval(5*60);
            response.sendRedirect(request.getContextPath() + "/home");
        }
        else{
            System.out.println("Login: Fail!");
            response.sendRedirect(request.getContextPath() + "/login");
        }
    }
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
