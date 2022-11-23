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
							<span class="material-symbols-outlined">edit_square</span>
						</a>
						<a href="/joueur/supprimer?id=<%=id%>">
							<span class="material-symbols-outlined">delete</span>
						</a>
					  </td>
					<%}%>
					  	
				</tr>
				
				<%}%>
				
 			</tbody>
		</table>
		<div>
			<!--  bouton ajout joueur TODO-->
			<a href="/joueur/ajouter" class="btn btn-outline-secondary">Ajouter un Entrainement</a>
			
		</div>
		
	</body>
	<%@include file="../general/footer.jsp" %>
</html>