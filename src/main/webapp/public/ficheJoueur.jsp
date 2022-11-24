<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page
	import="java.util.List,java.time.LocalDate,classes.Joueur,models.JoueurDAOimpl"%>
<%
Joueur joueur = (Joueur) request.getAttribute("joueur");
%>
<!DOCTYPE html>
<html>
<head>
<%@include file="../general/head.jsp"%>
<link rel="stylesheet" href="../style.css" type="text/css" />
<title><%=joueur.getPrenom()%> <%=joueur.getNom()%> | Roland
	Garros</title>
</head>

<%@include file="../general/nav.jsp"%>
<body>

	<a href="/joueurs"><span class="material-symbols-outlined">arrow_back</span></a>
	<h1 class="m-auto"><%=joueur.getPrenom()%>
		<%=joueur.getNom()%></h1>
		<p class="m-auto text-align">
			<span class="material-symbols-outlined m-1 logo2">workspace_premium</span> classement individuel : <span><%=joueur.getClassement()%></span>
		</p>
	<div class="d-flex justify-content-evenly">

		<div>
			<h2>Informations générales</h2>
			<div>
				<p>
					<span class="material-symbols-outlined logo">cake</span><span>Age
						: </span><%=joueur.getAge()%>
					ans
				</p>
				<p>
					<span class="material-symbols-outlined logo">calendar_month</span><span>Date
						de naissance : </span><%=joueur.getDateNaissance()%>
				</p>
				<p>
					<span class="material-symbols-outlined logo">location_on</span><span>Lieu
						de naissance : </span><%=joueur.getLieuNaissance()%></p>
				<p>
					<span class="material-symbols-outlined logo">flag</span><span>Nationalité
						: </span>
				<p>
					<span class="material-symbols-outlined logo">height</span><span>Taille
						: </span><%=joueur.getTaille()%>
					m
				</p>
				<p>
					<span class="material-symbols-outlined logo">weight</span><span>Poids
						: </span><%=joueur.getPoids()%>
					kg
				</p>
				<p>
					<span class="material-symbols-outlined logo">face</span><span>Sexe
						: </span>
					<%=joueur.getSexeComplet()%></p>
			</div>
		</div>

		<div>
			<h2>Carrière professionnelle</h2>
			<div>
				<p>
					<span class="material-symbols-outlined logo">calendar_month</span><span>Debut
						de carrière : </span><%=joueur.getDateCarriere()%>
				</p>
				<p>
					<span class="material-symbols-outlined logo">front_hand</span><span>Main
						: </span><%=joueur.getMainComplet()%></p>
				<p>
					<span class="material-symbols-outlined logo">person</span><span>Entraîneur
						: </span><%=joueur.getEntraineur().getNomComplet()%>
				</p>
			</div>
		</div>
	</div>
</body>
<%@include file="../general/footer.jsp"%>
</html>