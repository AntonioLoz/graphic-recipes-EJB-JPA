<%-- 
    Document   : register
    Created on : 2 jul. 2020, 13:01:23
    Author     : Antonio
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>
    <head>
        <title>Graphic Recipes | Login</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}src//css/p.css">
    </head>
    <body>
        <h1>Graphic Recipes</h1>
        <h3>User register:</h3>
        
        <form method="POST" action="${pageContext.request.contextPath}/register" id="registerForm" >
            <input type="text" name="userId" placeholder="User id" /><br></br>

            <input type="text" name="name" placeholder="Name" /><br></br>

            <input type="text" name="lastName" placeholder="Last name" /><br></br>

            <input type="email" name="email" placeholder="email" /><br></br>

            <input type="password" name="password" placeholder="Password" /><br></br>
            
            <input type="submit" value="Register" class="button" />
        </form> 
        
    </body>
</html>
