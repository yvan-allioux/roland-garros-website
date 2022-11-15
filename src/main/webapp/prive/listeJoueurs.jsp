<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.List,Joueur"%>
<%List<Joueur> joueurs = (List<Joueur>)request.getAttribute("joueurs");%>
<%out.print("EHOH");
out.print(joueurs);%>
<!DOCTYPE html>
<html>
	<head>
	<%@include file="../general/head.jsp" %>
	<title> Editer Joueurs| Roland Garros</title>
	</head>
	
	<%@include file="../general/nav.jsp" %>
	<body>	
		<!--  Filtres -->	
		<div class="btn-group" >
		  <button type="button" class="btn btn-outline-dark">Nom</button>
		  <button type="button" class="btn btn-outline-dark">Classement</button>
		  <button type="button" class="btn btn-outline-dark">Homme</button>
		  <button type="button" class="btn btn-outline-dark">Femme</button>
		</div>
		
		<!--  importer fichier CSV -->
		<div class="input-group input-group-sm">
		  <input type="file" class="form-control" id="inputTelechargement" placeholder="Username">
		  <label class="input-group-text" for="inputTelechargement">Télécharger</label>
		</div>
		
		
		<!-- Liste des joueurs  -->
		<table class="table  table-striped">
			<thead>
			  <tr>
			    <th scope="col">Nom</th>
			    <th scope="col">Prenom</th>
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
				      
				      String prenom = joueur.getPrenom();
				
				      String nom = joueur.getNom();%>
				
				<tr>
				  <th scope="row">1</th>
				  <td><%=id%></td>
				  <td><%=prenom%></td>
				  <td><%=nom%></td>
				  <td>Mark</td>
				  <td>AA</td>
				  <td>AA</td>
				  <td>Mark</td>
				  <td>AA</td>
				  <td>AA</td>
				  <td>Mark</td>
				  <td>AA</td>
				  <td>
				  	<a href="">
				  		<span class="material-symbols-outlined">edit_square</span>
					</a>
				  	<a href="">
				  		<span class="material-symbols-outlined">delete</span>
			  		</a>
				  </td>
					  	
				</tr>
				
				<%}%>
				
 			</tbody>
		</table>
	</body>
	<%@include file="../general/footer.jsp" %>
</html>