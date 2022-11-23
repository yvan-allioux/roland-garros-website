<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="java.util.List,java.time.LocalDate,classes.Joueur,classes.Entraineur"%>
<%Joueur joueur = (Joueur)request.getAttribute("joueur");
List<Entraineur> entraineurs = (List<Entraineur>)request.getAttribute("entraineurs");%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/general/head.jsp" %>
<meta charset="UTF-8">
<title>Modifier un match - Roland Garros</title>
</head>
<%@ include file="../general/nav.jsp" %>
<body>
	

</body>
<%@ include file="../general/footer.jsp" %>
</html>