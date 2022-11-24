<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@page import="java.util.List,java.time.LocalDate,classes.Joueur,models.JoueurDAOimpl"%>
<%
	//List<Entrainement> entrainements = (List<Entrainement>)request.getAttribute("entrainement");
    JoueurDAOimpl joueurDAO = new JoueurDAOimpl();
List<Joueur> joueurs = joueurDAO.getAllJoueurs();
%>

<!DOCTYPE html>
<html>
<head>
<%@ include file="../general/head.jsp"%>
<link rel="stylesheet" href="../style.css" type="text/css" />
<title>Statistique  | Roland Garros</title>
</head>
<%@ include file="../general/nav.jsp"%>
<body>
<div class="container">
	<h1 class="text-center m-4">Listes des joueurs et joueuses triés par nombre de match gagnées</h1>
	<!-- liste des joueurs -->
	<div class="cardJoueurs">
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

				%>
				<div class="card">
					<p class="card-text">
						<span> <%=prenom%> <%=nom%>
						</span>
					</p>
					<p class="card-text nationalite"><%=nationalite%></p>
					<p class="card-text">
						<%=sexe%>
						|<%=main%>
					</p>
					<p class="card-text">
						Classement : <span><%=classement%></span>
					</p>
					<p class="card-text">
						Age :
						<%=age%>
						ans
					</p>
					<a class="align-self-end" href="#"><span
						class="material-symbols-outlined">add_circle</span></a>
				</div>
				<%
				}
				
				%>
			</div>
		
	</div>
</div>
</body>
<%@ include file="../general/footer.jsp"%>
</html>