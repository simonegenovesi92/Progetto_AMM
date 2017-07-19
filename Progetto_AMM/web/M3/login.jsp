<%-- 
    Document   : login
    Author     : Simone Genovesi
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Login NerdBook.</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="author" content="Simone Genovesi">
        <meta name="keywords" content="login social socialnetwork loggati nerdbook">
        <link rel="stylesheet" type="text/css" href="style.css" media="screen">
    </head>
    <body>
        <header>
            <nav>
                <a href="descrizione.html">Descrizione</a>
                <a href="profilo.html">Profilo</a>
                <a href="bacheca.html">Bacheca</a>
            </nav>
            
            <h1 id="log-title"><img src="img/nerdbook-icon.png" alt="NerdBook" width="54" height="44" class="icon-pic">Login.</h1>
        </header>
        
        <div id="Login">
            <form method="post" action="login.html">
                <c:if test="${errore == true}">
                <div id="errati">
                     <h2>Errore login</h2>
                     <p>Nome utente o password sono errati.</p>
                </div>
                </c:if>
                <div>
                    <label for="utente">Nome Utente</label>
                    <input name="utente" id="utente" type="text"/> 
                </div>
                <div>
                    <label for="password">Password</label>
                    <input name="password" id="password" type="password"/>
                </div>
                <div>
                    <button type="submit">Accedi</button>
                </div>
            </form>
        </div>               
    </body>
</html>
