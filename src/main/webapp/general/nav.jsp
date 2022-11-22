
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
<header>
	<nav class="navbar navbar-expand-lg bg-light">
  <div class="container-fluid">
    <a class="navbar-brand" href="/home"><span class="material-symbols-outlined">home</span></a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
     <!--  PARTIE PUBLIC -->
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
      <ul class="navbar-nav me-auto mb-2 mb-lg-0 container-fluid">
       <li class="nav-item">
          <a class="nav-link" href="/joueurs">Joueurs</a>
        </li>
         <li class="nav-item">
          <a class="nav-link" href="/matchs">Matchs</a>
        </li>
         <li class="nav-item">
          <a class="nav-link" href="/home">Entraînements</a>
        </li>
         <li class="nav-item">
          <a class="nav-link" href="/home">Statistiques</a>
        </li>
        <!--  PARTIE PRIVE  -->
        <li class="nav-item dropdown">
          <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
           Privé
          </a>
          <ul class="dropdown-menu">
            <li><a class="dropdown-item" href="/joueurs/editer">Editer joueur</a></li>
            <li><a class="dropdown-item" href="#">Editer match</a></li>
             <li><a class="dropdown-item" href="#">Editer entraînement</a></li>
              <li><a class="dropdown-item" href="#">Editer entraîneur</a></li>
          </ul>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="../connexion"><span class="material-symbols-outlined">login</span></a>
        </li>

          <%--test if login is null and role is null--%>
          <% if(session.getAttribute("role")!=null){%>
          <div class="d-flex">
            <li class="nav-item">
                <p>bonjour ${sessionScope.login} role : ${sessionScope.role}</p>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="./deconection"><button class="btn btn-outline-success me-2" type="button">Déconnexion</button></a>
            </li>
          </div>
            <%}%>

       
      </ul>
    </div>
  </div>
</nav>
</header>
</html>