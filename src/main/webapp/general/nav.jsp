<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>

<header>
    <nav class="navbar navbar-expand-lg bg-light">
        <div class="container-fluid">
        	<a href="/home"><img src="/medias/logo.png" width="40px"></a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <!--  PARTIE PUBLIC -->
            <div class=" ms-2 collapse navbar-collapse" id="navbarSupportedContent">
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
                        <a class="nav-link" href="/statistiques">Statistiques</a>
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
                            <li><a class="dropdown-item" href="/matchs/editer">Editer match</a></li>
                            <li><a class="dropdown-item" href="/entrainement/edit">Editer entraînement</a></li>
                            <%}%>

                        </ul>
                    </li>
                    <%}%>
                </ul>
                <%--test if login is null PERMER D'AFICHER DES INFO/PAGE UNIQUEMENT QUAND ON EST CONECTE --%>


                <% if(session.getAttribute("login")!=null){%>
                    <div class="d-flex">
                        <p class="nav-item m-2">bonjour ${sessionScope.login} <% if(session.getAttribute("role").equals('A')){%>| role : Admin<%}%> <% if(session.getAttribute("role").equals('E')){%>role : Editeur de joueur<%}%> <% if(session.getAttribute("role").equals('M')){%>role : Editeur de match<%}%>
                    </div>
                    <div class="d-flex">
                        <a class="nav-link m-2" href="/deconnexion"><span class="material-symbols-outlined">logout</span></a>
                    </div>
                <%}else{%>
                    <div class="d-flex me-2">
                        <a class="nav-link" href="../connexion"><span class="material-symbols-outlined">login</span></a>
                    </div>
                <%}%>


            </div>

        </div>
    </nav>

</header>