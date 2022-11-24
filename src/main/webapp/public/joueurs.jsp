<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@page import="java.util.List,java.time.LocalDate,classes.Joueur"%>
<%
List<Joueur> joueurs = (List<Joueur>) request.getAttribute("joueurs");
%>

<!DOCTYPE html>
<html>
<head>
<%@ include file="../general/head.jsp"%>
<title>Joueurs | Roland Garros</title>
</head>
<%@ include file="../general/nav.jsp"%>
<body>
<div class="container">
	<h1 class="text-center m-4">Joueurs et Joueuses</h1>
	<!-- liste des joueurs -->
	<div class="cardJoueurs">
		<div class="cardSexe">
			<h2 class="m-3">Dames</h2>
			<div class="card-group">
				<!-- récuperation des données de chaque joueurs -->
				<%
				for (Joueur joueur : joueurs) {

					Integer id = joueur.getId();
					String prenom = joueur.getPrenom();
					String nom = joueur.getNom();
					LocalDate dateNaissance = joueur.getDateNaissance();
					String nationalite = joueur.getNationalite();
					String main = joueur.getMainComplet();
					Integer classement = joueur.getClassement();
					String sexe = joueur.getSexe();
					Integer age = joueur.getAge();

					//affichage des joueurs feminins
					if (sexe.equals("F")) {
				%>
				<div class="card">
					<p class="card-title text-center">
						<span> <%=prenom%> <%=nom%>
						</span>
					</p>
					<p class="card-text ">
						<span class="material-symbols-outlined m-1">flag</span><%=nationalite%></p>

					<p class="card-text">
						<span class="material-symbols-outlined m-1">workspace_premium</span><span><%=classement%></span>
					</p>
					<p class="card-text">
						<span class="material-symbols-outlined m-1">cake</span><%=age%> ans
					</p>
					<p class="card-text">
						<span class="material-symbols-outlined m-1">waving_hand</span><%=main%>
					</p>
					<a class="align-self-end" href="/joueur?id=<%=id%>"><span
						class="material-symbols-outlined">add_circle</span></a>
				</div>
				<%
				}
				}
				%>
			</div>
		</div>
		<div class="cardSexe">
			<h2 class="m-3">Messieurs</h2>
			<div class="card-group">
				<!-- récuperation des données de chaque joueurs -->
				<%
				for (Joueur joueur : joueurs) {
					Integer id = joueur.getId();
					String prenom = joueur.getPrenom();
					String nom = joueur.getNom();
					LocalDate dateNaissance = joueur.getDateNaissance();
					String nationalite = joueur.getNationalite();
					String main = joueur.getMainComplet();
					Integer classement = joueur.getClassement();
					String sexe = joueur.getSexe();
					Integer age = joueur.getAge();

					//affichage des joueurs masculins
					if (sexe.equals("H")) {
				%>
				<div class="card">
					<p class="card-title text-center">
						<span> <%=prenom%> <%=nom%>
						</span>
					</p>
					<p class="card-text ">
						<span class="material-symbols-outlined m-1">flag</span><%=nationalite%></p>

					<p class="card-text">
						<span class="material-symbols-outlined m-1">workspace_premium</span><span><%=classement%></span>
					</p>
					<p class="card-text">
						<span class="material-symbols-outlined m-1">cake</span><%=age%> ans
					</p>
					<p class="card-text">
						<span class="material-symbols-outlined m-1">waving_hand</span><%=main%>
					</p>
					<a class="align-self-end" href="/joueur?id=<%=id%>"><span
						class="material-symbols-outlined">add_circle</span></a>
				</div>
				<%
				}
				}
				%>
			</div>
		</div>
	</div>
</div>
</body>
<%@ include file="../general/footer.jsp"%>
</html>