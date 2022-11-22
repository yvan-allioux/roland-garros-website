<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.List,java.time.LocalDate,classes.Joueur"%>
<%List<Entrainement> entrainements = (List<Entrainement>)request.getAttribute("entrainement");%>
<!DOCTYPE html>
<html>
	<head>
	<%@include file="../general/head.jsp" %>
	<title> Editer Entrainement| Roland Garros</title>
	</head>
	
	<%@include file="../general/nav.jsp" %>
	<body>			
		
		<!-- Liste des joueurs  -->
		<table class="table  table-striped">
			<thead>
			  <tr>
			    <th scope="col">Date</th>
			    <th scope="col">Heure</th>
			    <th scope="col">Court</th>
			    <th scope="col">Joueurs</th>
		       	<th scope="col"></th>
		       
			  </tr>
			</thead>
			<tbody>
				<%for (Entrainement entrainement:entrainements) {
				      Integer id = entrainement.getId();
				      Local Date date = entrainement.getDate();
				      Local Date heure = heure.getHeure()
				      String prenomJ = entrainement.getPrenomJ();
				      String nomJ = entrainement.getNomJ();
				      %>
				
				<tr>
				  <td><%=date%></td>
				  <td><%=heure%></td>
				  <td><%=court%></td>
				  <td><%=prenomJ%> <%=nomJ%></td>
				  <td>
				  	<a href="/entrainement/modifier?id=<%=id%>">
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
		<div>
			<!--  importer fichier CSV -->
			<div class="input-group input-group-sm">
			  <input type="file" class="form-control" id="inputTelechargement" placeholder="Username">
			  <label class="input-group-text" for="inputTelechargement">Télécharger</label>
			</div>
			<!--  bouton ajout joueur -->
			
			<a href="/joueur/ajouter" class="btn btn-outline-secondary">Ajouter un joueur</a>
			
		</div>
		
	</body>
	<%@include file="../general/footer.jsp" %>
</html>