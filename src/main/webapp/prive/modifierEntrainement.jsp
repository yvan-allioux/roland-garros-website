<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<%@page import="java.util.List,java.time.LocalDate,classes.Entrainement,classes.Joueur"%>
<%@ page import="classes.Court" %>
<%
	Entrainement entrainement = (Entrainement)request.getAttribute("entrainement");
	List<Joueur> listejoueurs = (List<Joueur>) request.getAttribute("listejoueurs");
	List<Court> listecourts = (List<Court>) request.getAttribute("listecourts");
%>
<!DOCTYPE html>
<html>
<head>
	<%@ include file="/general/head.jsp" %>
	<link rel="stylesheet" href="../style.css" type="text/css" />
	<title>Editer Entrainement | Roland Garros</title>
</head>
<%@ include file="../general/nav.jsp" %>
<body>
<container class="container">
	<form action="../entrainement/modifier?id=<%=entrainement.getId()%>" method="POST" class="row g-3 m-3">

		<div class="mb-3"><%--hidden id entrainement--%>
			<input  placeholder="id" name="id-entrainement" type="hidden" class="form-control" value="<%=entrainement.getId()%>">
		</div>


		<div class="mb-3"> <%--date--%>
			<%--@declare id="date"--%><label for="date" class="form-label">Date</label>
			<input  placeholder="date" name="date-entrainement" type="date" class="form-control" value="<%=entrainement.getDate()%>">
		</div>

		<div class="mb-3">
			<%--@declare id="joueur1"--%><label for="joueur1" class="form-label">Joueur</label>
			<select class="form-select" name="idJoueur-entrainement">
				<option value="<%=entrainement.getJoueur().getId()%>" selected> <%=entrainement.getJoueur().getNomComplet()%> </option>
				<%
					for (Joueur j : listejoueurs) {
				%>
				<option value="<%=j.getId()%>"><%=j.getNomComplet()%></option>
				<%
					}
				%>
			</select>
		</div>


		<div class="mb-3"> <%--heure--%>
			<%--@declare id="heure"--%><label for="heure" class="form-label">Heure</label>
			<input placeholder="heure" name="heure-entrainement" type="text" class="form-control" value="<%=entrainement.getHeure()%>">
		</div>

		<div class="mb-3">
			<%--@declare id="joueur1"--%><label for="joueur1" class="form-label">Court</label>
			<select class="form-select" name="idCourt-entrainement">
				<option value="<%=entrainement.getCourt().getId()%>" selected> <%=entrainement.getCourt().getNom()%> </option>
				<%
					for (Court j : listecourts) {
				%>
				<option value="<%=j.getId()%>"><%=j.getNom()%></option>
				<%
					}
				%>
			</select>
		</div>

		<button type="submit" class="btn btn-outline-success">Enregistrer</button>
	</form>
</container>
</body>
<%@ include file="../general/footer.jsp" %>
</html>