<%@ page import="classes.Entrainement"%>

<%@ page import="java.time.LocalDate"%>
<%@ page import="java.time.LocalTime"%>


<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.List,java.time.LocalDate,classes.Joueur"%>
<%
List<Entrainement> entrainements = (List<Entrainement>) request.getAttribute("entrainement");
boolean editMod = (boolean) request.getAttribute("editMod");

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
		<h1 class="text-center m-4">Entrainements</h1>

		<!-- Liste des joueurs  -->
		<table class="table m-2 table-striped">
			<thead>
				<tr>

					<th scope="col"><span class="material-symbols-outlined">calendar_month</span>Date</th>
					<th scope="col"><span class="material-symbols-outlined">schedule</span>Heure</th>
					<th scope="col"><span class="material-symbols-outlined">pin_drop</span>Court</th>
					<th scope="col"><span class="material-symbols-outlined">person</span>Joueurs</th>

					<%
					if (editMod) {
					%>
					<th scope="col">Editer ou suprimer</th>
					<%}%>


				</tr>
			</thead>
			<tbody>
				<%
				for (Entrainement entrainement : entrainements) {
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
					<%
					if (editMod) {
					%>
					<td><a href="/entrainement/modifier?id=<%=id%>"
						class="text-decoration-none"> <span
							class="material-symbols-outlined m-1">edit_square</span>
					</a> <a href="/entrainement/supprimer?id=<%=id%>"
						class="text-decoration-none"> <span
							class="material-symbols-outlined m-1">delete</span>
					</a></td>
					<%}%>

				</tr>

				<%}%>

			</tbody>
		</table>
		<div class="m-3 text-center">
			<!--  bouton ajout joueur TODO-->
			<%
			if (editMod) {
			%>
			<a href="/entrainement/ajouter" class="btn btn-outline-success">Ajouter
				un Entrainement</a>
			<%}%>


		</div>
	</div>
</body>
<%@include file="../general/footer.jsp"%>
</html>
