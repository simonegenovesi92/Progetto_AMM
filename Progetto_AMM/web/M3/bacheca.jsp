<%-- 
    Document   : bacheca
    Author     : Simone Genovesi
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <c:if test="${anegativo == false}">
            <title>Bacheca NerdBook  ${session.getNome()}</title>
        </c:if>
        <c:if test="${anegativo == true}">
            <title>Impossibile accedere.</title>
        </c:if>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="author" content="Simone Genovesi">
        <meta name="keywords" content="nerbook social bacheca notizie">
        <link rel="stylesheet" type="text/css" href="style.css" media="screen">
    </head>
    <body>
        <c:if test="${anegativo == false}">
        <header>
            <nav>
                <c:set var="t" value="Bacheca" scope="request"></c:set>
                <c:set var="c" value="bacheca" scope="request"></c:set>
                <jsp:include page="nav.jsp"/>
            </nav>
        </header>
                <jsp:include page="lateral.jsp"/>
        <div id="post">
            <c:if test="${vis == true && session.getAbout() != null}">
            <div class="gr">
                <div class="gr">
                    <img src="${session.getUrlAvatar()}" alt="${session.getNome()}" class="utente" class="pic-utente" id="utente">
                    <label for="utente">${session.getNome()}: Frase di presentazione</label>
                </div>
                <div class="gr">
                    <p>${session.getAbout()}</p>
                </div>
            </div>
            </c:if>
            <c:if test="${vis != true}">
            <div class="gr">
                <div class="gr">
                    <img src="${session.getUrlAvatar()}" alt="${session.getNome()}" class="utente" class="pic-utente" id="gruppo">
                    <label for="gruppo">${session.getNome()}: Descrizione</label>
                </div>
                <div class="gr">
                    <p>${session.getDescrizione()}</p>
                </div>
            </div>
            </c:if>
            <div id="inserT">
            <form action="bacheca.html?visual-bak=${session.getNome()}" method="get">
                <div>
                    <h1>Nuovo post in bacheca</h1>
                </div>
                <c:if test="${t_errore == true}">
                    <div id="sbagliati">
                        <h1>Errore d'inserimento</h1>
                    </div>
                </c:if>
                <c:if test="${insert == true}">
                    <h2>Dettaglio Messaggio</h2>
                    <p><strong>Autore:</strong> ${(n.getAutore()).getNome()}</p>
                    <p><strong>Destinatario:</strong>
                        <c:if test="${vis == true}"> ${(n.getDestinatario()).getNome()}</c:if>
                        <c:if test="${vis != true}"> ${(n.getGruppo()).getNome()}</c:if>
                    </p>
                    <p><strong>Messaggio:</strong> 
                        <c:if test="${medias == 1}">
                            <p>${n.getContenuto()}</p><img class = "postpic" alt="Post" src="${n.getAllegato()}">
                        </c:if>
                        <c:if test="${medias == 2}">
                        <a href="${n.getAllegato()}">${n.getAllegato()}</a><p>${n.getContenuto()}</p>
                        </c:if> 
                        <c:if test="${medias != 2 && medias != 1}">
                            ${n.getContenuto()}
                        </c:if> 
                     </p>
                    <div>
                        <c:if test="${vis == true}">
                        <input type="hidden" name = "visual-bak" value="${session.getNome()}"/>
                        </c:if>
                        <c:if test="${vis != true}">
                        <input type="hidden" name = "visual-group" value="${session.getNome()}"/>
                        </c:if>
                    </div>
                    <button class = "post" type ='submit' name="conf" value=true>Ok!</button>
                    <button class = "post" type ="submit" name="conf" value=false>Annulla</button>
                </c:if>
                <c:if test="${conf == true}">
                    <h2>Hai scritto sulla bacheca di ${session.getNome()}</h2>
                </c:if>
                <c:if test="${insert != true}">
                <div>
                    <label for="stato">Testo:</label><textarea name="stato" rows="2" cols="3" id="stato"></textarea>
                </div>
                <div>
                    <label for="link">Allegato:</label><input type="url" name="link" id="link">
                </div>
                <div>
                    <div class="divimm">
                        <input type="radio" name="tipo" value="img" id="immagine"><label for="immagine">Immagine</label>
                    </div>
                    <div class="divlink">
                        <input type="radio" name="tipo" value="url" id="url"><label for="url">Link</label>
                    </div>
                </div>
                <div>
                   <c:if test="${vis == true}">
                        <input type="hidden" name = "visual-bak" value="${session.getNome()}"/>
                    </c:if>
                    <c:if test="${vis != true}">
                        <input type="hidden" name = "visual-group" value="${session.getNome()}"/>
                    </c:if>
                </div>
                <button class="post" type="submit">Crea messaggio</button>
                <button class="post" type="reset">Reimposta</button>
            </form>
                </c:if>
        </div>
            <c:forEach var="el_post" items="${post}">
            <div>
                <div>
                    <c:if test="${vis == true}">
                        <img src="${session.getUrlAvatar()}" alt="${session.getNome()}" class="utente" class="pic-utente">
                    </c:if>
                    <c:if test="${vis != true}">
                        <img src="${el_post.getAutore().getUrlAvatar()}" alt="${session.getNome()}" class="utente" class="pic-utente" id="utente">
                    </c:if>
                    <label for="utente">
                        <c:if test="${vis == true && el_post.getDestinatario() == null && el_post.getGruppo() == null}">${session.getNome()}</c:if> <%--nome utente bacheca utente--%>
                        <c:if test="${vis == true && el_post.getDestinatario() != null}">${el_post.getAutore().getNome()}: ${session.getNome()}</c:if> <%--nome utente bacheca utente--%>
                        <c:if test="${vis == true && el_post.getGruppo() != null}">${session.getNome()}: ${(el_post.getGruppo()).getNome()}</c:if>
                        <c:if test="${vis != true}">${el_post.getAutore().getNome()}: ${session.getNome()}</c:if>
                    </label>
                </div>
                <c:if test="${el_post.getTipologia() == 'TESTO'}">
                <div>
                    <p>${el_post.getContenuto()}</p>
                </div>
                </c:if>
                <c:if test="${el_post.getTipologia() == 'IMMAGINE'}">
                <div>
                    <p>${el_post.getContenuto()}</p><img alt="Immagine" src="${el_post.getAllegato()}" class="postpic">
                </div>
                </c:if>
                <c:if test="${el_post.getTipologia() == 'URL'}">
                <div>
                    <a href="${el_post.getAllegato()}">${el_post.getAllegato()}</a><p>${el_post.getContenuto()}</p>
                </div>
                </c:if>
            </div>
            </c:forEach>
        </div>
        </c:if>
        <c:if test="${anegativo == true}">
            <h1>Accesso negato</h1>
            <p>Autorizzazioni insufficienti per accedere alla pagina.</p>
        </c:if>
    </body>
</html>
