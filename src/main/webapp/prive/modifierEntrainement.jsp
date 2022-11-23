<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<%@page import="java.time.LocalDate,classes.Entrainement"%>
<%Entrainement entrainement = (Entrainement)request.getAttribute("entrainement");%>
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

		<div class="mb-3">
			<%--@declare id="date"--%><label for="date" class="form-label">Date</label>
			<input  placeholder="date" name="date-entrainement" type="date" class="form-control" value="<%=entrainement.getDate()%>">
		</div>
		<div class="mb-3">
			<%--@declare id="joueurs"--%><label for="joueurs" class="form-label">Joueurs</label>
			<input placeholder="joueurs" name="joueurs-entrainement" type="text" class="form-control" value="<%=entrainement.getJoueur().getPrenom()%> <%=entrainement.getJoueur().getNom()%>">
		</div>
		<div class="mb-3">
			<%--@declare id="heure"--%><label for="heure" class="form-label">Heure</label>
			<input placeholder="heure" name="heure-entrainement" type="text" class="form-control" value="<%=entrainement.getHeure()%>">
		</div>
		<div class="mb-3">
			<%--@declare id="court"--%><label for="court" class="form-label">Court</label>
			<input placeholder="court" name="court-entrainement" type="text" class="form-control" value="<%=entrainement.getCourt().getNom()%>">
		</div>

		<button type="submit" class="btn btn-outline-success">Enregistrer</button>
	</form>
</container>
</body>
<%@ include file="../general/footer.jsp" %>
</html>