<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true"%>
<!DOCTYPE html>

<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="css/style.css">
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<title>Insert title here</title>
</head>
<body>
	<div class="container m3">
		<h1 class="text-center">Save Travels</h1>

		<form action="/savetravels/search">
			<input type="text" name="search" /> <input type="submit"
				value="Search" />
		</form>
		<table class="table table-dark">
			<thead>
				<tr>
					<th scope="col">Expense</th>
					<th scope="col">Vendor</th>
					<th scope="col">Amount</th>
					<th scope="col">Actions</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${allSaveTravels}" var="saveTravel">
					<tr>
						<td><a href="expenses/${saveTravel.id}"><c:out value="${saveTravel.expenseName}" /></a></td>
						<td><c:out value="${saveTravel.vendor}" /></a></td>
						<td>$<c:out value="${saveTravel.amount}" /></a></td>
						<td>
							<div class="d-flex">
								<form action="/savetravels/edit/${saveTravel.id}" method="get">
									    <input type="hidden" name="_method" value="edit">
									    <input type="submit" value="Edit">
								</form>
								<form action="/savetravels/${saveTravel.id}" method="post">
									    <input type="hidden" name="_method" value="delete">
									    <input type="submit" value="Delete">
								</form>
							</div>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>

		<h2>Add an Expense</h2>
		<form:form action="/savetravels/all" method="post" modelAttribute="saveTravel">
			<div class="form-group">
				<form:label path="expenseName">Expense Name: </form:label>
				<form:errors path="expenseName" />
				<form:input path="expenseName" />
			</div>

			<div class="form-group">
				<form:label path="vendor">Vendor: </form:label>
				<form:errors path="vendor" />
				<form:input path="vendor" />
			</div>
			<div class="form-group">
				<form:label path="amount">Amount: </form:label>
				<form:errors path="amount" />
				<form:input  path="amount" />
			</div>
			<div class="form-group">
				<form:label path="description">Description: </form:label>
				<form:errors path="description" />
				<form:textarea path="description" />
			</div>
			<input type="submit" value="Submit" />
		</form:form>
		<script type="text/javascript" src="/js/app.js"></script>
		<script src="/webjars/jquery/jquery.min.js"></script>
		<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
	</div>
</body>
</html>