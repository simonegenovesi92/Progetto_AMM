<%-- 
    Document   : profilo
    Author     : Simone Genovesi
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <c:if test="${anegativo == false}">
            <title>Profilo NerdBook</title>
        </c:if>
        <c:if test="${anegativo == true}">
            <title>Accesso negato</title>
        </c:if>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="author" content="Simone Genovesi">
        <meta name="keywords" content="profilo social socialnetwork nerdbook">
        <link rel="stylesheet" type="text/css" href="style.css" media="screen">
    </head>
    <body>
        <c:if test="${anegativo == false}">
        <header>
            <nav>
                <c:set var="t" value="Profilo" scope="request"></c:set>
                <c:set var="c" value="profilo" scope="request"></c:set>
                <jsp:include page="nav.jsp"/>
            </nav>
        </header>
        <jsp:include page="lateral.jsp"/>
        <c:if test = "${erroredati == false}">
        <div id="conf">
            <div>
                <h2>Conferma inserimento dei dati</h2>
                <p>Dati inseriti!</p>
            </div>
            <div>
                <p class="dati"><strong>Nome:</strong> ${utente.getNome()}</p>
                <p class="dati"><strong>Cognome:</strong> ${utente.getCognome()}</p>
                <p class="dati"><strong>Nato/a il:</strong> ${utente.getDataNascita()}</p>
                <p class="dati"><strong>Indirizzo dell'immagine del profilo:</strong> ${utente.getUrlAvatar()}<img class="pic-utente,utente" id="profilo" alt="Profilo" src="${utente.getUrlAvatar()}"></p>
                <p class="dati"><strong>Frase di presentazione:</strong> ${utente.getAbout()}</p>
            </div>
        </div>
        </c:if>
        <c:if test="${erroredati == true}">
            <div id="conf">
                <div><h2>Errore nell'inserimento dei dati</h2>
                <p>Le due password inserite non corrispondono.</p></div>
            </div>
        </c:if>
        <c:if test="${erroredati == null}">
        <div id="info">
            <div>
                <img src="${utente.getUrlAvatar()}" alt="utente" id="utente">
            </div>
            <form action="" method="post">
                <div>
                    <label for="nome">Nome</label> <input type='text' name="nome" id="nome">
                </div>
                <div>
                    <label for="cognome">Cognome</label><input type='text' name="cognome" id="cognome">
                </div>
                <div>
                    <label for="foto">Indirizzo dell'immagine del profilo</label> <input type='url' name="foto" id="foto">
                </div>
                <div>
                    <label for="stato">Frase di presentazione</label> <textarea name="stato" rows="1" id="stato" placeholder="Su di te..."></textarea>
                </div>
                <div>
                    <label for="compleanno">Nato/a il</label> <input type='date' name="compleanno" id="compleanno">
                </div>
                <div>
                    <label for="password">Password</label> <input type='password' name="password" id ="password">
                </div>
                <div>
                    <label for="confpassword">Conferma password</label><input type='password' name="confpassword" id="confpassword">
                </div>
                <div>
                    <button type="submit" value="profilo">Aggiorna</button>
                </div>
            </form>
        </div>
        </c:if>
        </c:if>
        <c:if test="${anegativo == true}">
            <h1>Accesso negato</h1>
            <p>Autorizzazioni insufficienti per accedere alla pagina.</p>
        </c:if>
    </body>
</html>
