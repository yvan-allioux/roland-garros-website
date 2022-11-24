<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page
	import="java.util.List,java.time.LocalDate,classes.Joueur,classes.Match,classes.Score,classes.Court"%>
<%
Match match = (Match) request.getAttribute("match");
List<Joueur> joueurs = (List<Joueur>) request.getAttribute("joueurs");
List<Court> courts = (List<Court>) request.getAttribute("courts");
%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/general/head.jsp"%>
<meta charset="UTF-8">
<title>Modifier un match - Roland Garros</title>
</head>
<%@ include file="../general/nav.jsp"%>
<body>
	<form action="../match/modifier?id=<%=match.getId()%>" method="post" class="m-auto row g-3">
		
		
		<div class="col-md-4">
		    <label for="ddm" class="form-label">Date du match</label>
		    <input type="date" class="form-control" name="ddm" value="<%=match.getDate()%>">
		</div>
		
		 <div class="col-md-4">
		    <label for="hdm" class="form-label">Heure</label>
		    <input type="time" class="form-control" name="hdm" value="<%=match.getHeure()%>">
		 </div>
		
		 <div class="col-md-4">  
			<label for="court" class="form-label">Court</label> 
			<select class="form-select" name="court">
				<%
				for (Court c : courts) {	
				%>
				<option value="<%=c.getId()%>"><%=c.getNom()%></option>
				<%
				}
				%>
			</select>
		</div>
		 
		<div class="col-md-6">  
			<% if(match.getJoueur1()!=null){ %>
			<label for="joueur1" class="form-label">Joueur 1</label> 
			<select class="form-select" name="joueur1">
				<option value="<%=match.getJoueur1().getId()%>" selected><%=match.getJoueur1().getNomComplet()%></option>
				<%
				for (Joueur j : joueurs) {
				%>
				<option value="<%=j.getId()%>"><%=j.getNomComplet()%></option>
				<%
				}
				%>
			</select>
		</div>
		<div class="col-md-6">
		<label for="joueur2" class="form-label">Joueur 2</label> 
		<select class="form-select" name="joueur2">
			<option value="<%=match.getJoueur2().getId()%>" selected><%=match.getJoueur2().getNomComplet()%></option>
			<%
			for (Joueur j : joueurs) {
				if (j.getId() != match.getJoueur2().getId()) {
			%> 
			<option value="<%=j.getId()%>"><%=j.getNomComplet()%></option>
			<%
				}
			}
			%>
		</select>
		</div>
		<%} %>
		<button type="submit" class="btn btn-secondary m-auto col-md-2">Enregistrer</button>
	</form>

</body>
<%@ include file="../general/footer.jsp"%>
</html>