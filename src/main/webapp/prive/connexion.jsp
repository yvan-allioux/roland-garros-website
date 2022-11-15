<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<%@include file="../general/head.jsp" %>
	<title>Connexion | Roland Garros</title>
</head>
	<%@include file="../general/nav.jsp" %>
<body>
	<form class="formConnexion">
  <div class="mb-3">
    <label for="pseudo" class="form-label">Pseudo</label>
    <input type="text" class="form-control" id="pseudo" >
  </div>
  <div class="mb-3">
    <label for="password" class="form-label">Mot de passe</label>
    <input type="password" class="form-control" id="password">
  </div>
  <button type="submit" class="btn btn-primary">Se connecter</button>
</form>

</body>
<%@include file="../general/footer.jsp" %>
</html>