<%-- 
    Document   : recipes
    Created on : 8 jul. 2020, 11:26:43
    Author     : Antonio
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="src/styles/styles.css">
        <title>Graphic Recipes | Recipes</title>
    </head>
    <body>
        <header class ="header">
            <img class="imgHeader" src="src/images/gr_logo.png">  
             
            <div class="headerRight">
                <a class="bottonHeader" href="./aboutus"> ABOUT US </a>
                <a class="bottonHeader" href="./login?action=contact"> CONTACT </a>
                <a class="bottonHeader active" href="./recipes?action=recipes"> RECIPES </a>
                <a class="bottonHeader" href="./home"> HOME </a>

                <input class="searchText" type="search" name="search" placeholder="Search here"/>
            </div>
        </header>
        
        <div>
            <div class="aside">
                <p><a class="bottonAside" href="./recipes?action=filter&filteredby=entrees"> ENTRESS </a></p>
                <p><a class="bottonAside" href="./recipes?action=filter&filteredby=mains"> MAINS </a></p>
                <p><a class="bottonAside" href="./recipes?action=filter&filteredby=desert"> DESERT </a></p>
                <p><a class="bottonAside" href="./recipes?action=filter&filteredby=gourmet"> GROUMET </a></p>
                <p><a class="bottonAside" href="./recipes?action=filter&filteredby=sweet"> SWEET </a></p>
                <p><a class="bottonAside" href="./recipes?action=filter&filteredby=savory"> SAVORY </a></p>
            </div>
            
            <div class="gridContainer">
                <c:forEach items="${recipes}" var="recipe">
                    <div class="gridItem">
                        <p class = "nameRecipe"><strong>${recipe.name}</strong></p>
                        <p><a class="bottonGrid" href="./recipes?action=recipe&recipeSelected=${recipe.name}">Learn More</a></p>
                    </div>
                </c:forEach>
            </div>
        </div>
    </body>
</html>