<%-- 
    Document   : recipe
    Created on : 14 jul. 2020, 14:21:21
    Author     : Antonio
--%>

<%@page import="com.antonio.graphicrecipes.entity.Recipe"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="src/styles/styles.css">
        <title>Graphic Recipes | Recipe</title>
    </head>
    <body>
        <header class="header">
            <div>
                <img class="imgHeader" src="src/images/gr_logo.png">  
            </div>

            <div class="headerRight">
                <a class="bottonHeader" href="./aboutus"> ABOUT US </a>
                <a class="bottonHeader" href="./login?action=contact"> CONTACT </a>
                <a class="bottonHeader active" href="./recipes?action=recipes"> RECIPES </a>
                <a class="bottonHeader " href="./home"> HOME </a>

                <input class="searchText" type="search" name="search" placeholder="Search here"/>
            </div>
        </header>

        <aside class="aside">
            <a class="bottonAside" href="./recipes?action=filter&filteredby=entrees"> ENTRESS </a><br></br>
            <a class="bottonAside" href="./recipes?action=filter&filteredby=mains"> MAINS </a><br></br>
            <a class="bottonAside" href="./recipes?action=filter&filteredby=desert"> DESERT </a><br></br>
            <a class="bottonAside" href="./recipes?action=filter&filteredby=gourmet"> GROUMET </a><br></br>
            <a class="bottonAside" href="./recipes?action=filter&filteredby=sweet"> SWEET </a><br></br>
            <a class="bottonAside" href="./recipes?action=filter&filteredby=savory"> SAVORY </a><br></br>
        </aside>

        <section class="sectionRecipe">
            <div class = "sectionRecipeLeft">
                <h3 class ="nameRecipeRecipe">${recipe.name}</h3>
                <div class="imageRecipe">Image here</div>
            </div>
                
            <div class="sectionRecipeRight">
                <h5 class="ingredientsRecipe">Ingredients:</h5>
                <p class="descriptionRecipe">${recipe.description}</p>
            </div>
        </section>
    </body>
</html>
