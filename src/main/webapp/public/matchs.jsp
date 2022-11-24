<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@page
	import="java.util.List,java.time.LocalDate,java.time.LocalTime,java.time.format.DateTimeFormatter, classes.Match,classes.Equipe,classes.Court,classes.Joueur"%>
<%List<Match> matchsPasses = (List<Match>) request.getAttribute("matchsPasses");
List<Match> matchsPasPasses = (List<Match>) request.getAttribute("matchsPasPasses");%>

<!DOCTYPE html>
<html>
<head>
<%@ include file="../general/head.jsp"%>
<link rel="stylesheet" href="../style.css" type="text/css" />
<title>Matchs | Roland Garros</title>
</head>
<%@ include file="../general/nav.jsp"%>
<body>
	<div class="container">
		<h1>Matchs</h1>

		<!-- MATCHS A VENIR -->
		<h2>Matchs à venir</h2>
		<table class="table align-center">
			<thead>
				<tr>
					<th scope="col"><span class="material-symbols-outlined">calendar_month</span>Date</th>
					<th scope="col"><span class="material-symbols-outlined">schedule</span>Heure</th>
					<th scope="col"><span class="material-symbols-outlined">pin_drop</span>Court</th>
					<th scope="col"><span class="material-symbols-outlined">person</span>Joueurs / Equipes</th>
				</tr>
			</thead>
			<tbody>
				<!-- récuperation des données de chaque matchs -->
				<%
				for (Match match : matchsPasPasses) {
					Integer id = match.getId();
					LocalDate date = match.getDate();
					LocalTime heure = match.getHeure();
					String court = match.getCourt().getNom();
					String j1 = match.getJoueur1().getNomComplet();
					String j2 = match.getJoueur2().getNomComplet();
					Equipe e1 = match.getEquipe1();
					Equipe e2 = match.getEquipe2();
					
					//date du jour
					LocalDate dateJ = LocalDate.now();

					//affichage des matchs à venir
					if (date.isAfter(dateJ)) {
				%>
				<tr>
					<th><%=date%></th>
					<td><%=heure%></td>
					<td><%=court%></td>
					<%
					if (j1 != null && j2 != null) {
					%>
					<td><%=j1%> VS <%=j2%></td>
					<%
					} else if (e1 != null && e2 != null) {
					%>
					<td><%=e1.getNom()%> VS <%=e2.getNom()%></td>
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
					<th scope="col"><span class="material-symbols-outlined">calendar_month</span>Date</th>
					<th scope="col"><span class="material-symbols-outlined">schedule</span>Heure</th>
					<th scope="col"><span class="material-symbols-outlined">pin_drop</span>Court</th>
					<th scope="col"><span class="material-symbols-outlined">person</span>Joueurs / Equipes</th>
					<th scope="col"><span class="material-symbols-outlined">timer</span>Temps de jeu</th>
					<th scope="col"> <span class="material-symbols-outlined">workspace_premium</span>Gagnant</th>
				</tr>
			</thead>
			<tbody>
				<!-- récuperation des données de chaque matchs -->
				<%
				for (Match match : matchsPasses) {
					Integer id = match.getId();
					LocalDate date = match.getDate();
					LocalTime heure = match.getHeure();
					String court = match.getCourt().getNom();
					String j1 = match.getJoueur1().getNomComplet();
					String j2 = match.getJoueur2().getNomComplet();
					Equipe e1 = match.getEquipe1();
					Equipe e2 = match.getEquipe2();
					
					LocalTime temps;
					String gagnant;
					
					DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");
					if (match.getScore()== null){
						temps = LocalTime.parse("00:00", timeFormatter);
					}else {
						temps = match.getScore().getTemps();
					}
					if (match.getScore()== null){
						gagnant = " / ";
					}else{
						gagnant = match.getGagnant().getNomComplet();
					}
					
					// date du jour
					LocalDate dateJ = LocalDate.now();

					//affichage des matchs passés
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
					<td><%=e1.getNom()%> VS <%=e2.getNom()%></td>
					<%
					}
					%>
					<td><%=temps%></td>
					<td><%=gagnant%></td>
				</tr>
				<%
				}
				}
				%>
			</tbody>
		</table>
	</div>
</body>
<%@ include file="../general/footer.jsp"%>
</html>