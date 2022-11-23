<%@ page import="classes.Entrainement" %>

<%@ page import="java.time.LocalDate" %>
<%@ page import="java.time.LocalTime" %>


<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.List,java.time.LocalDate,classes.Joueur"%>
<%
	List<Entrainement> entrainements = (List<Entrainement>)request.getAttribute("entrainement");
	boolean editMod = (boolean)request.getAttribute("editMod");

	//todo faire des verification si l'user est bien conécté
%>

<!DOCTYPE html>
<html>
	<head>
	<%@include file="../general/head.jsp" %>
	<title> Editer Entrainement| Roland Garros</title>
	</head>
	
	<%@include file="../general/nav.jsp" %>
	<body>
	<container class="container">
		
		<!-- Liste des joueurs  -->
		<table class="table m-2 table-striped">
			<thead>
			  <tr>
			    <th scope="col">Date</th>
			    <th scope="col">Heure</th>
			    <th scope="col">Court</th>
			    <th scope="col">Joueurs</th>
				  <% if(editMod) {%>
				  	<th scope="col">Editer ou suprimer</th>
				  <%}%>

		       
			  </tr>
			</thead>
			<tbody>
				<%for (Entrainement entrainement:entrainements) {
				      Integer id = entrainement.getId();
					  LocalDate date = entrainement.getDate();
					  LocalTime heure = entrainement.getHeure();
				      String prenomJ = entrainement.getJoueur().getPrenom();
				      String nomJ = entrainement.getJoueur().getNom();
					  String court = entrainement.getCourt().getNom();
				      %>
				
				<tr>
				  <td><%=date%></td>
				  <td><%=heure%></td>
				  <td><%=court%></td>
				  <td><%=prenomJ%> <%=nomJ%></td>
					<% if(editMod) {%>
					  <td>
						<a href="/entrainement/modifier?id=<%=id%>">
							<span class="material-symbols-outlined m-1">edit_square</span>
						</a>
						<a href="/joueur/supprimer?id=<%=id%>">
							<span class="material-symbols-outlined m-1">delete</span>
						</a>
					  </td>
					<%}%>
					  	
				</tr>
				
				<%}%>
				
 			</tbody>
		</table>
		<div class="m-3 text-center">
			<!--  bouton ajout joueur TODO-->
			<% if(editMod) {%>
				<a href="/joueur/ajouter" class="btn btn-outline-success">Ajouter un Entrainement</a>
			<%}%>

			
		</div>
	</container>
	</body>
	<%@include file="../general/footer.jsp" %>
</html>