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
    <label for="exampleInputEmail1" class="form-label">Pseudo</label>
    <input type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp">
  </div>
  <div class="mb-3">
    <label for="exampleInputPassword1" class="form-label">Mot de passe</label>
    <input type="password" class="form-control" id="exampleInputPassword1">
  </div>
  <button type="submit" class="btn btn-primary">Se connecter</button>
</form>

</body>
<%@include file="../general/footer.jsp" %>
</html>