<%@page import="java.time.LocalTime"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.List,java.time.LocalDate,classes.Match"%>
<%

List<Match> matchsPasses = (List<Match>) request.getAttribute("matchsPasses");
List<Match> matchsPasPasses = (List<Match>) request.getAttribute("matchsPasPasses");
%>
<!DOCTYPE html>
<html>
<head>
<%@include file="../general/head.jsp"%>
<title>Editer Matchs| Roland Garros</title>
</head>

<%@include file="../general/nav.jsp"%>
<body>
	<!--  Filtres -->
	<form action="/matchs/editer" class="btn-group" method="post">
		<button type="submit" class="btn btn-outline-dark" name="btn-nom"
			value="btn-nom">Trier par date</button>
	</form>

	<!-- Liste des matchs passés  -->

	<div>
		<h2>Match passés</h2>
		<table class="table  table-striped">
		<thead>
			<tr>
				<th scope="col">Date</th>
				<th scope="col">Heure</th>
				<th scope="col">Joueur1</th>
				<th scope="col">Joueur2</th>
				<!--<th scope="col">Gagnant</th>-->
				<th scope="col"></th>

			</tr>
		</thead>
		<tbody>
			<%
			for (Match m : matchsPasses) {

				Integer id = m.getId();
				LocalDate date = m.getDate();
				LocalTime heure = m.getHeure();
				String joueur1 = m.getJoueur1().getNomComplet();
				String joueur2 = m.getJoueur2().getNomComplet();
				//String gagnant = match.getGagnant().getNomComplet();
			%>

			<tr>
				<td><%=date%></td>
				<td><%=heure%></td>
				<td><%=joueur1%></td>
				<td><%=joueur2%></td>
				<!--  <td><%//gagnant%></td>-->
				<td>
					<%
					if (m.getScore()==null) {
					%> <a
					href="/score/ajouter?id_match=<%=id%>">+</a> 
					<%}%> 
					<a href="/match/supprimer?id=<%=id%>"> <span
						class="material-symbols-outlined">delete</span>
					</a>
				</td>

			</tr>

			<%}%>

		</tbody>
	</table>
	</div>
	<!-- Liste des matchs pas encore passés  -->
	<div>
		<h2>Match pas passés</h2>
		<table class="table  table-striped">
		<thead>
			<tr>
				<th scope="col">Date</th>
				<th scope="col">Heure</th>
				<th scope="col">Joueur1</th>
				<th scope="col">Joueur2</th>
				<th scope="col"></th>

			</tr>
		</thead>
		<tbody>
			<%
			for (Match m : matchsPasses) {

				Integer id = m.getId();
				LocalDate date = m.getDate();
				LocalTime heure = m.getHeure();
				String joueur1 = m.getJoueur1().getNomComplet();
				String joueur2 = m.getJoueur2().getNomComplet();
			%>

			<tr>
				<td><%=date%></td>
				<td><%=heure%></td>
				<td><%=joueur1%></td>
				<td><%=joueur2%></td>
				<!--  <td><%//gagnant%></td>-->
				<td>
					<a href="/match/modifier?id=<%=id%>">
				  		<span class="material-symbols-outlined">edit_square</span>
					</a>
					<a href="/match/supprimer?id=<%=id%>"> <span
						class="material-symbols-outlined">delete</span>
					</a>
				</td>

			</tr>

			<%}%>

		</tbody>
	</table>
	</div>
	
	<!--  bouton ajout match -->

	<a href="/match/ajouter" class="btn btn-outline-secondary">Ajouter
		un match</a>

	</div>

</body>
<%@include file="../general/footer.jsp"%>
</html>