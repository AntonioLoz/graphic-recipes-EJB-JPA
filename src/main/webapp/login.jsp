<%-- 
    Document   : login
    Created on : 30 jun. 2020, 20:52:00
    Author     : Antonio
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/src/css/p.css">
        <title>Graphic Recipes | Login</title>
    </head>
    <body>
        <h1>Graphic Recipes</h1>
        <h3>User login:</h3>
        <form method="POST" action="${pageContext.request.contextPath}/login" id="login">
            <input type="text" name="userId" placeholder="Email or user id"/><br></br>
            <input type="text" name="password" placeholder="Password"/><br></br>
            <input type="submit" value="Entry"/>
        </form>
        <a href="./register">New user</a>
    </body>
</html>
