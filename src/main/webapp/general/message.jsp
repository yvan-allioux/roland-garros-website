<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="/general/head.jsp" %>
<%--<link rel="stylesheet" href="style.css" type="text/css" /> --%>
</head>

<body>

<div class="alert alert-warning alert-dismissible fade show d-flex align-items-center" role="alert">
<span class="material-symbols-outlined">error</span>
  <p> message </p>
  <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
</div>

<div class="alert alert-success alert-dismissible fade show d-flex align-items-center" role="alert">
<span class="material-symbols-outlined">check_circle</span>
  <p> message </p>
  <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
</div>

</body>
</html>