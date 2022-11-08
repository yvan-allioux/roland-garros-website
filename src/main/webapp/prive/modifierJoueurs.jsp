<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="../general/head.jsp" %>
<title>Editer Joueur | Roland Garros</title>
</head>
<%@ include file="../general/nav.jsp" %>
<body>
	<form class="formModifier">
		<div class="form-item-container">
			<div>
			    <label for="nom" class="form-label ">Nom</label>
			    <input type="text" class="form-control" id="nom" value="coucou">
		  	</div>
		 	 <div>
			    <label for="prenom" class="form-label">Prenom</label>
			    <input type="text" class="form-control" id="prenom" value="coucou">
		  	</div>
		</div>
		
	
	  <div class="form-item-container ">
	    <div>
		    <label for="ddn" class="form-label">Date de naissance</label>
		    <input type="date" class="form-control" id="ddn" value=2022-03-16>
		  </div>
		   <div>
		    <label for="ldn" class="form-label">Lieu de naissance</label>
		    <input type="text" class="form-control" id="ldn" value="coucou">
		  </div>
		  <div>
		    <label for="nationalite" class="form-label">Nationalité</label>
		    <input type="text" class="form-control" id="nationalite" value="coucou">
		  </div>
	  </div>
	  <div class="form-item-container">
		  <div>
		    <label for="sexe" class="form-label">Sexe</label>
		    <select  class="form-select" id="sexe">
		    	<option value="F">Femme</option>
		    	<option value="H">Homme</option>
		    </select>
		  </div>
		  <div>
		    <label for="taille" class="form-label">Taille</label>
		    <input type="text" class="form-control" id="taille" value="coucou">
		  </div>
		  <div>
		    <label for="poids" class="form-label">Poids</label>
		    <input type="text" class="form-control" id="poids" value="coucou">
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
		    <input type="text" class="form-control" id="classement" value="coucou">
		  </div>
	  </div>
	  <div class="form-item-container">
		  <div>
		    <label for="ddc" class="form-label">Date de début de carrière</label>
		    <input type="date" class="form-control" id="ddc" value=2022-03-16>
		  </div>
		  <div>
		    <label for="entraineur" class="form-label">Entraineur</label>
		    <input type="text" class="form-control" id="entraineur" value="coucou"> 
		  </div>
	  </div>
	  <button type="submit" class="btn btn-primary">Modifier</button>
  </form>
</body>
<%@ include file="../general/footer.jsp" %>
</html>