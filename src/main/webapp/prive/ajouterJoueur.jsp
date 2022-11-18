<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.time.LocalDate,classes.Joueur"%>
<%Joueur joueur = (Joueur)request.getAttribute("joueur");%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="../general/head.jsp" %>
<title>Ajouter un joueur | Roland Garros</title>
</head>
<%@ include file="../general/nav.jsp" %>
<body>

	<form action="../joueur/ajouter" method="post">
	  <div class="mb-3">
	    <label for="exampleInputEmail1" class="form-label">Nom</label>
	    <input type="text" class="form-control" name="nom-joueur" placeholder="Dupont">
	  </div>
	  <div class="mb-3">
	    <label for="exampleInputPassword1" class="form-label">Prenom</label>
	    <input type="text" class="form-control" name="prenom-joueur" placeholder="Jean">
	  </div>
	  <button type="submit" class="btn btn-primary">Submit</button>
  </form>
</body>
<%@ include file="../general/footer.jsp" %>
</html>