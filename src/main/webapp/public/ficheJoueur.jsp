<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.List,java.time.LocalDate,classes.Joueur,models.JoueurDAOimpl"%>
<%Joueur joueur = (Joueur)request.getAttribute("joueur");%>
<!DOCTYPE html>
<html>
<head>
	<%@include file="../general/head.jsp" %>
	<link rel="stylesheet" href="../style.css" type="text/css" />
	<title> <%=joueur.getPrenom() %> <%= joueur.getNom() %> | Roland Garros</title>
	</head>
	
	<%@include file="../general/nav.jsp" %>
<body>
	<a href="/joueurs"><span class="material-symbols-outlined">arrow_back</span></a>
	<h1><%=joueur.getPrenom() %> <%= joueur.getNom() %></h1>
	
	<div>
		<p> <span><%=joueur.getClassement() %></span>classement individuel </p>	
	</div>
	<h2>Son profil</h2>
	<div>
	</div>
	<div>
		<h3>Informations générales</h3>
		<div>
		<p><span>Age : </span><%= joueur.getAge()%> ans</p>
		<p><span>Date de naissance : </span><%=joueur.getDateNaissance() %> </p>
		<p><span>Lieu de naissance : </span><%=joueur.getLieuNaissance() %></p>
		<p><span>Taille : </span><%=joueur.getTaille() %> m </p>
		<p><span>Poids : </span><%=joueur.getPoids() %> kg</p>
		<p><span>Sexe : </span> <%=joueur.getSexeComplet()%></p>
		</div>
	</div>
		
	<div>
		<h3>Carrière professionnelle</h3>
		<div>
			<p><span>Debut de carrière : </span><%= joueur.getDateCarriere() %> </p>
			<p><span>Main: </span><%= joueur.getMainComplet() %></p>
			<p><span>Entraîneur : </span><%=joueur.getEntraineur() %> </p>
		</div>
	</div>	
</body>
<%@include file="../general/footer.jsp" %>
</html>