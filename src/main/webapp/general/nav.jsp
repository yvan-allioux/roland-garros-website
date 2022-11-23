<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>

<header>
    <nav class="navbar navbar-expand-lg bg-light">
        <div class="container-fluid">
        	<img src="/medias/logo.svg" width="40px">	
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <!--  PARTIE PUBLIC -->
            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                	<li class="nav-item">  	
            			<a class="nav-link" href="/home"><span class="material-symbols-outlined">home</span></a>
           			</li>
                    <li class="nav-item">
                        <a class="nav-link" href="/joueurs">Joueurs</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/matchs">Matchs</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/entrainement">Entraînements</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/home">Statistiques</a>
                    </li>
                    <!--  PARTIE PRIVE  -->
                    <% if(session.getAttribute("login")!=null){%>
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                            Privé
                        </a>
                        <ul class="dropdown-menu">

                            <% if((session.getAttribute("login")!=null) && ( (session.getAttribute("role").equals('E')) || (session.getAttribute("role").equals('A') ))){%>
                            <li><a class="dropdown-item" href="/joueurs/editer">Editer joueur</a></li>
                            <%--<li><a class="dropdown-item" href="#">Editer entraîneur</a></li>--%>
                            <%}%>

                            <% if((session.getAttribute("login")!=null) && ((session.getAttribute("role").equals('M')) || (session.getAttribute("role").equals('A')))){%>
                            <li><a class="dropdown-item" href="#">Editer match</a></li>
                            <li><a class="dropdown-item" href="entrainement/edit">Editer entraînement</a></li>
                            <%}%>

                        </ul>
                    </li>
                    <%}%>
                </ul>
                <%--test if login is null PERMER D'AFICHER DES INFO/PAGE UNIQUEMENT QUAND ON EST CONECTE --%>
                
                <div class="d-flex">
                <% if(session.getAttribute("login")!=null){%>
                	<p class="nav-item m-2">bonjour ${sessionScope.login} role : ${sessionScope.role}</p>
                    <a class="nav-link m-2" href="./deconnexion"><span class="material-symbols-outlined">logout</span></a>
                <%}else { %>
                	<a class="nav-link" href="../connexion"><span class="material-symbols-outlined">login</span></a>
                <%}%>
                </div>
                
            </div>

        </div>
    </nav>

</header>