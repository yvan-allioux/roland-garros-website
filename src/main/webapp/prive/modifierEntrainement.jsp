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
	<form action="../entrainement/modifier?id=<%=entrainement.getId()%>" method="post" class="row g-3 m-3">
		<div class="col-md-6">
			<%--@declare id="exampleinputemail2"--%><label for="exampleInputEmail2" class="form-label">Nom</label>
			<input type="text" class="form-control" name="nom-entrainement" value="<%=entrainement.getDate()%>">
		</div>
		<div class="col-md-6">
			<%--@declare id="exampleinputpassword1"--%><label for="exampleInputPassword1" class="form-label">Prenom</label>
			<input type="text" class="form-control" name="prenom-entrainement" value="<%=entrainement.getJoueur()%>">
		</div>
		<div class="col-md-4">
			<label for="ddn" class="form-label">Date de naissance</label>
			<input type="date" class="form-control" id="ddn" value="<%=entrainement.getCourt()%>">
		</div>
		<div class="col-md-4">
			<label for="ldn" class="form-label">Lieu de naissance</label>
			<input type="text" class="form-control" id="ldn" value="<%=entrainement.getHeure()%>">
		</div>
		<button type="submit" class="btn btn-secondary">Enregistrer</button>
	</form>
</container>
</body>
<%@ include file="../general/footer.jsp" %>
</html>