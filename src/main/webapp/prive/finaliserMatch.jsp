<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page
	import="java.util.List,java.time.LocalDate,classes.Joueur,classes.Match,classes.Score,classes.Court"%>
<%
Match match = (Match) request.getAttribute("match");
List<Joueur> joueurs = (List<Joueur>) request.getAttribute("joueurs");
%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/general/head.jsp"%>
<meta charset="UTF-8">
<title>Finaliser match | Roland Garros</title>
</head>
<%@ include file="../general/nav.jsp"%>
<body>

	<form action="../match/finaliser?id=<%=match.getId()%>" method="post" class="m-auto row g-3">


		<div class="col-md-4">
		    <label for="temps" class="form-label">Temps</label>
		    <input type="time" class="form-control" name="temps" value="01:00">
		 </div>
		 
		 <div class="col-md-4">
		    <label for="nbJeux" class="form-label">Nombre de jeux</label>
		    <input type="text" class="form-control" name="nbJeux" value="">
		 </div>
		 <div class="col-md-4">
		    <label for="nbSets" class="form-label">Nombre de sets</label>
		    <input type="text" class="form-control" name="nbSets" value="">
		 </div>
		 

	<div class="col-md-6">  
			<label for="gagnant" class="form-label">Vainqueur</label> 
			<select class="form-select" name="gagnant">
				<option value="<%=match.getJoueur1().getId()%>"><%=match.getJoueur1().getNomComplet()%></option>
				<option value="<%=match.getJoueur2().getId()%>"><%=match.getJoueur2().getNomComplet()%></option>

			</select>
	</div>
	<button type="submit" class="btn btn-secondary m-auto col-md-2">Enregistrer</button>
	</form>

</body>
<%@ include file="../general/footer.jsp"%>
</html>