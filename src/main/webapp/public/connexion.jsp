<%--import--%>
<%@ page import="java.io.PrintWriter" %>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <%@include file="../general/head.jsp" %>
    <%--<link rel="stylesheet" href="../style.css" type="text/css" />--%>
    <title>Connexion | Roland Garros</title>
</head>
<%@include file="../general/nav.jsp" %>
<body>
<div class="container">
<h1 class="text-center m-4">Connexion</h1>
<form  method="POST" action="connexion" class="formConnexion">
    <div class="mb-3">
        <label for="login" class="form-label">Pseudo</label>
        <input placeholder="login" name="login" type="text" class="form-control" id="login" >
    </div>
    <div class="mb-3">
        <label for="password" class="form-label">Mot de passe</label>
        <input  placeholder="pass" name="password" type="password" class="form-control" id="password">
    </div>
    <button type="submit" class="btn btn-primary">Se connecter</button>
</form>

<p class="fn-2">
<%
    //TODO : Afficher un message d'erreur au bonne endroit la c'est en haut de la page

    //affichage des erreurs
    PrintWriter var = response.getWriter();
    //get
    String paramErreur = request.getParameter("erreur");
    System.out.println(paramErreur);
    //test if string equal
    if(paramErreur != null){
        if(paramErreur.equals("loginInexistant")){
            var.println("Erreur de connexion login inexistant");
        }else if(paramErreur.equals("mdpInvalide")){
            var.println("Erreur de connexion mot de passe invalide");
        }else if(paramErreur.equals("loginVide")){
            var.println("Erreur de connexion login vide");
        }else if(paramErreur.equals("mdpVide")){
            var.println("Erreur de connexion mot de passe vide");
        }else{
            var.println("Erreur de connexion");
        }
    }

%>
</p>
</div>
</body>
<%@include file="../general/footer.jsp" %>
</html>