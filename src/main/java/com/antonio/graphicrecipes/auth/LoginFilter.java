/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.antonio.graphicrecipes.auth;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Antonio
 */
public class LoginFilter implements Filter{
    
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
       response.setContentType("text/html");
       
       System.out.println("Entrada al filtro...");
       
       HttpServletRequest req = (HttpServletRequest) request;
       HttpServletResponse res = (HttpServletResponse) response;
       
       
       HttpSession session = req.getSession(false);
       
       if(session!=null  && session.getAttribute("userId")!=null){
           System.out.println("Sesion no null...");
           System.out.println("Id Session: " + session);
           filterChain.doFilter(request, response);
       }
       else{
           System.out.println("Sesion null...");
           res.sendRedirect(req.getContextPath() + "/login");
       }
    }
}
