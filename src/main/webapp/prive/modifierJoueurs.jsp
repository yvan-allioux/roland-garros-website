<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.List,java.time.LocalDate,classes.Joueur,classes.Entraineur"%>
<%Joueur joueur = (Joueur)request.getAttribute("joueur");
List<Entraineur> entraineurs = (List<Entraineur>)request.getAttribute("entraineurs");%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="../general/head.jsp" %>
<title>Editer Joueur | Roland Garros</title>
</head>
<%@ include file="../general/nav.jsp" %>
<body>

	<form action="../joueur/modifier?id=<%=joueur.getId()%>" method="post" class="row g-3">
	  <div class="col-md-6">
	    <label for="exampleInputEmail1" class="form-label">Nom</label>
	    <input type="text" class="form-control" name="nom-joueur" value="<%=joueur.getNom()%>">
	  </div>
	  <div class="col-md-6">
	    <label for="exampleInputPassword1" class="form-label">Prenom</label>
	    <input type="text" class="form-control" name="prenom-joueur" value="<%=joueur.getPrenom()%>">
	  </div>
	    	<div class="col-md-4">
		    <label for="ddn" class="form-label">Date de naissance</label>
		    <input type="date" class="form-control" id="ddn" value="<%=joueur.getDateNaissance()%>">
		  </div>
		   <div class="col-md-4">
		    <label for="ldn" class="form-label">Lieu de naissance</label>
		    <input type="text" class="form-control" id="ldn" value="<%=joueur.getLieuNaissance()%>">
		  </div>
		  <div class="col-md-4">
		    <label for="nationalite" class="form-label">Nationalité</label>
		    <input type="text" class="form-control" id="nationalite" value="<%=joueur.getNationalite()%>">
		  </div>
		  <div class="col-md-4">
		    <label for="sexe" class="form-label">Sexe</label>
		    <select  class="form-select" id="sexe">
		    <%if(joueur.getSexe().equals("F")){ %>
		    	<option value="F" selected>Femme</option>
		    	<option value="H">Homme</option>
		    <%}else if(joueur.getSexe().equals("H")){ %>
		    	<option value="F">Femme</option>
		    	<option value="H" selected>Homme</option>
		    <%} %>
		    </select>
		  </div>
		  <div class="col-md-4">
		    <label for="taille" class="form-label">Taille</label>
		    <input type="text" class="form-control" id="taille" value="<%=joueur.getTaille()%>">
		  </div>
		  <div class="col-md-4">
		    <label for="poids" class="form-label">Poids</label>
		    <input type="text" class="form-control" id="poids" value="<%=joueur.getPoids()%>">
		  </div>
	  
		  <div class="col-md-7">
		    <label for="ddc" class="form-label">Date de début de carrière</label>
		    <input type="date" class="form-control" id="ddc" value="<%=joueur.getDateCarriere()%>">
		  </div>
		  <div class="col-md-3" disabled>
		    <label for="classement" class="form-label">Classement</label>
		    <input type="text" class="form-control" id="classement" disabled value="<%=joueur.getClassement()%>">
		  </div>
		  <div class="col-md-2">
		    <label for="main" class="form-label">Main</label>
		    <select class="form-select" id="main">
		    	<option value="D">Droitier</option>
		    	<option value="G">Gaucher</option>
		    </select>
		  </div>

		  <div class="col-md-12">

		    <label for="entraineur" class="form-label">Entraineur</label>
		    <select  class="form-select" name="entraineur" id="entraineur">
		    	<option value="<%=joueur.getEntraineur()%>" selected><%=joueur.getEntraineur().getNomComplet()%></option>
		    	<%for(Entraineur e:entraineurs){ 
		    		if(e.getId()!=joueur.getEntraineur().getId()){%>
		    	<option value="<%=e.getId()%>"><%=e.getNomComplet()%></option>
		    	<%	}
		    	} %>
		    </select>
		  </div>
	  <button type="submit" class="btn btn-secondary">Enregistrer</button>
  </form>
</body>
<%@ include file="../general/footer.jsp" %>
</html>
