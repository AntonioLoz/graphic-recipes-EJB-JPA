<%-- 
    Document   : home
    Created on : 7 jul. 2020, 12:38:47
    Author     : Antonio
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="src/styles/styles.css">
        <title>Graphic Recipes | Home</title>
    </head>
    <body>
        <img class="imgHeader" src="src/images/gr_logo.png">  

        <header class ="header">
            <img class="imgHeader" src="src/images/gr_logo.png">  

            <div class="headerRight">
                <a class="bottonHeader" href="./aboutus"> ABOUT US </a>
                <a class="bottonHeader" href="./login?action=contact"> CONTACT </a>
                <a class="bottonHeader" href="./recipes?action=recipes"> RECIPES </a>
                <a class="bottonHeader active" href="./home"> HOME </a>

                <input class="searchText" type="search" name="search" placeholder="Search here"/>
            </div>
        </header>

        <div class="sectionHome">
        <%int i=1;%>
        <c:forEach items="${recipes}" var="recipe">
            <div id="section<%=i%>">
                <h2>${recipe.name}</h2>
                <p>${recipe.shortDescription}</p>
                <a href="./recipes?action=recipe&recipeSelected=${recipe.name}">Learn More</a>
            </div>
            <%i++;%>
        </c:forEach>
        </div>
        <div class ="buttonsNavigation">
            <a href="#section1" class="buttonsSection"> </a>
            <a href="#section2" class="buttonsSection"></a>
            <a href="#section3" class="buttonsSection"></a>
            <a href="#section4" class="buttonsSection"></a>
        </div>
    </body>
</html>
