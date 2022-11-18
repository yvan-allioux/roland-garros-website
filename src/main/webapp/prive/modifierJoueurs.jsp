<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.time.LocalDate,classes.Joueur"%>
<%Joueur joueur = (Joueur)request.getAttribute("joueur");%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="../general/head.jsp" %>
<title>Editer Joueur | Roland Garros</title>
</head>
<%@ include file="../general/nav.jsp" %>
<body>

	<form action="../joueur/modifier?id=<%=joueur.getId()%>" method="post">
	  <div class="mb-3">
	    <label for="exampleInputEmail1" class="form-label">Nom</label>
	    <input type="text" class="form-control" name="nom-joueur" value="<%=joueur.getNom()%>">
	  </div>
	  <div class="mb-3">
	    <label for="exampleInputPassword1" class="form-label">Prenom</label>
	    <input type="text" class="form-control" name="prenom-joueur" value="<%=joueur.getPrenom()%>">
	  </div>
	   <div class="form-item-container ">
	    <div>
		    <label for="ddn" class="form-label">Date de naissance</label>
		    <input type="date" class="form-control" id="ddn" value="<%=joueur.getDateNaissance()%>">
		  </div>
		   <div>
		    <label for="ldn" class="form-label">Lieu de naissance</label>
		    <input type="text" class="form-control" id="ldn" value="<%=joueur.getLieuNaissance()%>">
		  </div>
		  <div>
		    <label for="nationalite" class="form-label">Nationalité</label>
		    <input type="text" class="form-control" id="nationalite" value="<%=joueur.getNationalite()%>">
		  </div>
	  </div>
	  <div class="form-item-container">
		  <div>
		    <label for="sexe" class="form-label">Sexe</label>
		    <select  class="form-select" id="sexe">
		    <%if(joueur.getSexe()=="F"){ %>
		    	<option value="F" selected>Femme</option>
		    	<option value="H">Homme</option>
		    <%}else if(joueur.getSexe()=="H"){ %>
		    	<option value="F">Femme</option>
		    	<option value="H" selected>Homme</option>
		    <%} %>
		    </select>
		  </div>
		  <div>
		    <label for="taille" class="form-label">Taille</label>
		    <input type="text" class="form-control" id="taille" value="<%=joueur.getSexe()%>">
		  </div>
		  <div>
		    <label for="poids" class="form-label">Poids</label>
		    <input type="text" class="form-control" id="poids" value="<%=joueur.getPoids()%>">
		  </div>
	  </div>
	  <div class="form-item-container">
		  <div>
		    <label for="main" class="form-label">Main</label>
		    <select class="form-select" id="main">
		    	<option value="D">Droitier </option>
		    	<option value="G"> Gaucher </option>
		    </select>
		  </div>
		  <div>
		    <label for="classement" class="form-label">Classement</label>
		    <input type="text" class="form-control" id="classement" value="<%=joueur.getClassement()%>">
		  </div>
	  </div>
	  <div class="form-item-container">
		  <div>
		    <label for="ddc" class="form-label">Date de début de carrière</label>
		    <input type="date" class="form-control" id="ddc" value="<%=joueur.getDateCarriere()%>">
		  </div>
		  <div>
		    <label for="entraineur" class="form-label">Entraineur</label>
		    <input type="text" class="form-control" id="entraineur" value="<%=joueur.getEntraineur()%>"> 
		  </div>
	  </div>
	  <button type="submit" class="btn btn-primary">Submit</button>
  </form>
</body>
<%@ include file="../general/footer.jsp" %>
</html>