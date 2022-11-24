<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<%@page import="classes.Court,classes.Joueur,java.util.List,java.time.LocalDate,classes.Entrainement"%>
<%
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
<container class="container wrapper">
	<form action="../entrainement/ajouter" method="POST" class="row g-3 m-3">

		<div class="mb-3"> <%--date--%>
			<%--@declare id="date"--%><label for="date" class="form-label">Date</label>
			<input  placeholder="date" name="date-entrainement" type="date" class="form-control" value="<%=LocalDate.now()%>">
		</div>


		<%--<div class="col-md-6"> &lt;%&ndash;prenom&ndash;%&gt;
			&lt;%&ndash;@declare id="joueursPrenom"&ndash;%&gt;<label for="joueursPrenom" class="form-label">Prenom joueurs</label>
			<input placeholder="joueursPrenom" name="joueursPrenom-entrainement" type="text" class="form-control" value="Carol">
		</div>
		<div class="col-md-6"> &lt;%&ndash;nom&ndash;%&gt;
			&lt;%&ndash;@declare id="joueursNom"&ndash;%&gt;<label for="joueursNom" class="form-label">Nom joueurs</label>
			<input placeholder="joueursNom" name="joueursNom-entrainement" type="text" class="form-control" value="Danvers">
		</div>--%>
		<div class="mb-3">
			<%--@declare id="joueur1"--%><label for="joueur1" class="form-label">Joueur</label>
			<select class="form-select" name="idJoueur-entrainement">
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
			<input placeholder="heure" name="heure-entrainement" type="text" class="form-control" value="16:20">
		</div>
		<%--<div class="mb-3"> &lt;%&ndash;court&ndash;%&gt;
			&lt;%&ndash;@declare id="court"&ndash;%&gt;<label for="court" class="form-label">Court</label>
			<input placeholder="court" name="court-entrainement" type="text" class="form-control" value="Manhattan">
		</div>--%>

		<div class="mb-3">
			<%--@declare id="joueur1"--%><label for="joueur1" class="form-label">Court</label>
			<select class="form-select" name="idCourt-entrainement">
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