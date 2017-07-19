<%-- 
    Document   : nav
    Author     : Simone Genovesi
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<c:if test="${c=='bacheca' || c=='profilo'}">
    <h1 id="nb">${x.getNome()}: ${t}</h1>
    <a href='descrizione.html'>Descrizione</a>
    <a href='login.html'>Login</a>
    <img src="${user.getUrlAvatar()}" alt="utente" class="logout">
    <a href="login.html?logout=1" class="logout">${user.getNome()}: Logout</a>
</c:if>
