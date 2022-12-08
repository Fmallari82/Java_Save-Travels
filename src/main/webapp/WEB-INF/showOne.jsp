<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="css/style.css">
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<title>Insert title here</title>
</head>
<body>
<div>
	<h1 class="d-flex justify-content-between">
	Expense Details
	</h1>
	<a href="/savetravels/all">Go Back</a>
</div>
	<h3>
		Expense Name: <c:out value="${oneSaveTravel.expenseName}" />
	</h3>
	<h3>
		Vendor Name:
		<c:out value="${oneSaveTravel.vendor}" />
	</h3>
	<h3>
		Amount:
		<c:out value="${oneSaveTravel.amount}" />
	</h3>
	<h3>
		Description:
		<c:out value="${oneSaveTravel.description}" />
	</h3>

	<form action="/savetravels/all" method="get">
		<input type="hidden" name="_method" value="home">     
		<input type="submit" value="Home">
	</form>



	<script type="text/javascript" src="/js/app.js"></script>
	<script src="/webjars/jquery/jquery.min.js"></script>
	<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>