<%@page import="java.time.LocalTime"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.List,java.time.LocalDate,classes.Match"%>
<%
List<Match> matchs = (List<Match>) request.getAttribute("matchs");
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
			value="btn-nom">Date</button>
		<button type="submit" class="btn btn-outline-dark"
			name="btn-classement" value="btn-classement">A venir</button>
		<button type="submit" class="btn btn-outline-dark" name="btn-homme"
			value="btn-homme">Passé</button>
	</form>




	<!-- Liste des matchs  -->
	<table class="table  table-striped">
		<thead>
			<tr>
				<th scope="col">Date</th>
				<th scope="col">Heure</th>
				<th scope="col">Gagnant</th>
				<th scope="col"></th>

			</tr>
		</thead>
		<tbody>
			<%
			for (Match match : matchs) {

				Integer id = match.getId();
				LocalDate date = match.getDate();
				LocalTime heure = match.getHeure();
				Integer gagnant = match.getGagnant();
			%>

			<tr>
				<td><%=date%></td>
				<td><%=heure%></td>
				<td><%=gagnant%></td>
				<td>
					<a href="/match/modifier?id=<%=id%>"> <span
						class="material-symbols-outlined">edit_square</span>
				</a> <a href="/match/supprimer?id=<%=id%>"> <span
						class="material-symbols-outlined">delete</span>
				</a>
				</td>

			</tr>

			<%}%>

		</tbody>
	</table>
	<!--  bouton ajout match -->

	<a href="/match/ajouter" class="btn btn-outline-secondary">Ajouter
		un match</a>

	</div>

</body>
<%@include file="../general/footer.jsp"%>
</html>