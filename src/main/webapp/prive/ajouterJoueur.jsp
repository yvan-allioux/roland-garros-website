<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.List,java.time.LocalDate,classes.Entraineur"%>
<%List<Entraineur> entraineurs = (List<Entraineur>)request.getAttribute("entraineurs");%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="../general/head.jsp" %>
<title>Ajouter un joueur | Roland Garros</title>
</head>
<%@ include file="../general/nav.jsp" %>
<body>
<div class="container">
	<h1 class="text-center m-4">Ajouter joueur</h1>
  <form action="/joueur/ajouter" method="post">
	  <div class="mb-3">
	    <label for="exampleInputEmail1" class="form-label">Nom</label>
	    <input type="text" class="form-control" name="nom-joueur" placeholder="Dupont">
	  </div>
	  <div class="mb-3">
	    <label for="exampleInputPassword1" class="form-label">Prenom</label>
	    <input type="text" class="form-control" name="prenom-joueur" placeholder="Jean">
	  </div>
	   <div class="form-item-container ">
	    <div>
		    <label for="ddn" class="form-label">Date de naissance</label>
		    <input type="date" class="form-control" name="ddn" placeholder="1999-03-30">
		  </div>
		   <div>
		    <label for="ldn" class="form-label">Lieu de naissance</label>
		    <input type="text" class="form-control" name="ldn" placeholder="Paris">
		  </div>
		  <div>
		    <label for="nationalite" class="form-label">Nationalité</label>
		    <input type="text" class="form-control" name="nationalite" placeholder="Français">
		  </div>
	  </div>
	  <div class="form-item-container">
		  <div>
		    <label for="sexe" class="form-label">Sexe</label>
		    <select  class="form-select" name="sexe">
		    	<option value="F" selected>Femme</option>
		    	<option value="H">Homme</option>
		    </select>
		  </div>
		  <div>
		    <label for="taille" class="form-label">Taille (cm)</label>
		    <input type="text" class="form-control" name="taille" placeholder="175">
		  </div>
		  <div>
		    <label for="poids" class="form-label">Poids (kg)</label>
		    <input type="text" class="form-control" name="poids" placeholder="62">
		  </div>
	  </div>
	  <div class="form-item-container">
		  <div>
		    <label for="main" class="form-label">Main</label>
		    <select class="form-select" name="main">
		    	<option value="D">Droitier</option>
		    	<option value="G">Gaucher</option>
		    </select>
		  </div>
	  </div>
	  <div class="form-item-container">
		  <div>
		    <label for="ddc" class="form-label">Date de début de carrière</label>
		    <input type="date" class="form-control" name="ddc" placeholder="2015-01-01">
		  </div>
		  <div>
		    <label for="entraineur" class="form-label">Entraineur</label>
		    <select  class="form-select" name="entraineur">
		    	<%for(Entraineur e:entraineurs){%>
		    	<option value="<%=e.getId()%>"><%=e.getNomComplet()%></option>
		    	<%}%>
		    </select>
		  </div>
	  </div>
	  <button type="submit" class="btn btn-primary m-2">Envoyer</button>
  </form>
</div>
</body>
<%@ include file="../general/footer.jsp" %>
</html>