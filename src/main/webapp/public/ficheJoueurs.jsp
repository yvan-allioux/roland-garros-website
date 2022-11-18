<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.List,java.time.LocalDate,classes.Joueur,models.JoueurDAOImpl"%>
<%JoueurDAOImpl joueurDAO = new JoueurDAOImpl();
Joueur joueur = joueurDAO.getJoueurById(1);%>
<!DOCTYPE html>
<html>
<head>
	<%@include file="../general/head.jsp" %>
	<title> XX | Roland Garros</title>
	</head>
	
	<%@include file="../general/nav.jsp" %>
<body>

</body>
</html>