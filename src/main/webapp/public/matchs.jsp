<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@page
	import="java.util.List,java.time.LocalDate,java.time.LocalTime,classes.Match,models.MatchDAOimpl"%>
<%MatchDAOimpl matchDAO = new MatchDAOimpl();
List<Match> matchs = matchDAO.getAllMatchs();%>

<!DOCTYPE html>
<html>
<head>
<%@ include file="../general/head.jsp"%>
<link rel="stylesheet" href="../style.css" type="text/css" />
<title>Matchs | Roland Garros</title>
</head>
<%@ include file="../general/nav.jsp"%>
<body>
	<h1>Matchs</h1>

	<!-- MATCHS A VENIR -->
	<h2>Matchs à venir</h2>
	<table class="table">
		<thead>
			<tr>
				<th scope="col">Date</th>
				<th scope="col">Heure</th>
				<th scope="col">Court</th>
				<th scope="col">Joueurs / Equipes</th>
			</tr>
		</thead>
		<tbody>
			<!-- récuperation des données de chaque joueurs -->
			<%
			for (Match match : matchs) {
				Integer id = match.getId();
				LocalDate date = match.getDate();
				LocalTime heure = match.getHeure();
				String court = match.getCourt();
				String j1 = match.getJoueur1();
				String j2 = match.getJoueur2();
				String e1 = match.getEquipe1();
				String e2 = match.getEquipe2();
				LocalDate dateJ = LocalDate.now();

				//affichage des joueurs feminins
				if (date.isAfter(dateJ)) {
			%>
			<tr>
				<th scope="row"><%=date%></th>
				<td><%=heure%></td>
				<td><%=court%></td>
				<%
				if (j1 != null && j2 != null) {
				%>
				<td><%=j1%> VS <%=j2%></td>
				<%
				} else if (e1 != null && e2 != null) {
				%>
				<td><%=e1%> VS <%=e2%></td>
				<%
				}
				%>
			</tr>
			<%
			}
			}
			%>
		</tbody>
	</table>

	<!--  MATCHS PASSES -->
	<h2>Matchs passés</h2>
	<table class="table">
		<thead>
			<tr>
				<th scope="col">Date</th>
				<th scope="col">Heure</th>
				<th scope="col">Court</th>
				<th scope="col">Joueurs / Equipes</th>
			</tr>
		</thead>
		<tbody>
			<!-- récuperation des données de chaque joueurs -->
			<%
			for (Match match : matchs) {
				Integer id = match.getId();
				LocalDate date = match.getDate();
				LocalTime heure = match.getHeure();
				String court = match.getCourt();
				String j1 = match.getJoueur1();
				String j2 = match.getJoueur2();
				String e1 = match.getEquipe1();
				String e2 = match.getEquipe2();
				LocalDate dateJ = LocalDate.now();

				//affichage des joueurs feminins
				if (date.isBefore(dateJ)) {
			%>
			<tr>
				<th scope="row"><%=date%></th>
				<td><%=heure%></td>
				<td><%=court%></td>
				<%
				if (j1 != null && j2 != null) {
				%>
				<td><%=j1%> VS <%=j2%></td>
				<%
				} else if (e1 != null && e2 != null) {
				%>
				<td><%=e1%> VS <%=e2%></td>
				<%
				}
				%>
			</tr>
			<%
			}
			}
			%>
		</tbody>
	</table>





</body>
<%@ include file="../general/footer.jsp"%>
</html>