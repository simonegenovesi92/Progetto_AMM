<%-- 
    Document   : lateral
    Author     : Simone Genovesi
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div id='lat'>
    <div id="persone">
        <h1>Persone</h1>
        <div>
            <ul>
                <c:forEach var="el_utenti" items="${utenti}">
                    <li><img src="${el_utenti.getUrlAvatar()}" alt="Utente" class="icon-pic"><a href="bacheca.html?visualizza_bacheca=${el_utenti.getNome()}">${el_utenti.getNome()}</a></li>
                </c:forEach>
            </ul>
        </div>
    </div>
    <div id="gruppi">
        <h1>Gruppi</h1>
            <div>
                <ul>
                    <c:forEach var="el_gruppi" items="${gruppi}">
                        <li><img src="${el_gruppi.getUrlAvatar()}" alt="Utente" class="icon-pic"><a href="bacheca.html?visualizza_gruppo=${el_gruppi.getNome()}">${el_gruppi.getNome()}</a></li>
                    </c:forEach>
                </ul>
            </div>
    </div>
</div>
