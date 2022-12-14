<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.List,java.time.LocalDate,classes.Joueur"%>
<%List<Joueur> joueurs = (List<Joueur>)request.getAttribute("joueurs");%>
<!DOCTYPE html>
<html>
	<head>
	<%@include file="../general/head.jsp" %>
	<title> Editer Joueurs| Roland Garros</title>
	</head>
	
	<%@include file="../general/nav.jsp" %>
	<body>
	<div class="container">
		<h1 class="text-center m-4">Editer Joueur</h1>
		<!--  Filtres -->	
		<form action="/joueurs/editer"class="btn-group m-auto" method="post">
		  <button type="submit" class="btn btn-outline-success btn-sm" name="btn-nom" value="btn-nom">Nom</button>
		  <button type="submit" class="btn btn-outline-success btn-sm" name="btn-classement" value="btn-classement">Classement</button>
		  <button type="submit" class="btn btn-outline-success btn-sm" name="btn-homme" value="btn-homme">Homme</button>
		  <button type="submit" class="btn btn-outline-success btn-sm" name="btn-femme" value="btn-femme">Femme</button>
		</form>
		
		
		
		
		<!-- Liste des joueurs  -->
		<table class="table  table-striped">
			<thead>
			  <tr>
			    <th scope="col">Nom</th>
			    <th scope="col">Sexe</th>
			    <th scope ="col">Date de naissance </th>
			    <th scope = "col">Lieu de naissance </th>
			    <th scope = "col">Nationalité </th>
			    <th scope = "col">Taille </th>
			    <th scope = "col">Poids </th>
			    <th scope="col">Classement en simple</th>
			    <th scope="col">Main</th>
			    <th scope="col">Date début de carrière</th>
		       	<th scope="col">Entraineur</th>
		       	<th scope="col"></th>
		       
			  </tr>
			</thead>
			<tbody>
				<%for (Joueur joueur:joueurs) {

				      Integer id = joueur.getId();
				      String nom = joueur.getNomComplet();
				      LocalDate  dateNaissance = joueur.getDateNaissance();
				      String lieuNaissance = joueur.getLieuNaissance();
				      String nationalite = joueur.getNationalite();
				      Integer taille = joueur.getTaille();
				      Float poids = joueur.getPoids();
				      String main = joueur.getMainComplet();
				      LocalDate dateCarriere = joueur.getDateCarriere();
				      Integer classement = joueur.getClassement();
				      String sexe = joueur.getSexeComplet();
				      String entraineur = "Inconnu";
				      
				      if(joueur.getEntraineur()!=null){
				    	  entraineur = joueur.getEntraineur().getNomComplet();
				      }
				      
				      %>
				
				<tr>
				  <td><%=nom%></td>
				  <td><%=sexe%></td>
				  <td><%=dateNaissance%></td>
				  <td><%=lieuNaissance%></td>
				  <td><%=nationalite%></td>
				  <td><%=taille%></td>
				  <td><%=poids%></td>
				  <td><%=classement%></td>
				  <td><%=main%></td>
				  <td><%=dateCarriere%></td>
				  <td><%=entraineur%></td>
				  <td>
				  	<a href="/joueur/modifier?id=<%=id%>">
				  		<span class="material-symbols-outlined">edit_square</span>
					</a>
				  	<a href="/joueur/supprimer?id=<%=id%>">
				  		<span class="material-symbols-outlined">delete</span>
			  		</a>
				  </td>
					  	
				</tr>
				
				<%}%>
				
 			</tbody>
		</table>
		<div class="d-flex justify-content-evenly">
		
			<!--  bouton ajout joueur -->			
			<a href="/joueur/ajouter" class="btn btn-outline-success btn-sm">Créer un joueur</a>

			<!--  importer fichier CSV -->

			<form class="input-group input-group-sm" method="post" action="/fileuploadservlet" enctype="multipart/form-data">
				<input type="file" name="file" class="form-control" />
				<input class="input-group-text ms-2" type="submit" value="Télécharger" />
			</form>
			
		</div>
	</div>
	</body>
	<%@include file="../general/footer.jsp" %>
</html>