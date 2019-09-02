
<%@ page language="java" contentType="text/html; charset=UTF-8"
	isELIgnored="false" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<title>CartBD</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>

</head>


<body>


	<div class="container">
		<h2>CartDB List</h2>
				<c:url var="urlDashboard" value="/admin/managerment" />
		<a href="${urlDashboard}"><button type="button" class="btn btn-warning">Back DashBoard</button></a>
		<hr>
		<table class="table table-bordered">
			<thead>
				<tr>
					<th>Id</th>
					<th>User</th>
					<th>Product</th>
					<th>Quantity</th>
					<th>Date Order</th>
				</tr>
			</thead>
			<tbody>

				<c:forEach var="tempCartdb" items="${cartDBs}">
					<tr>
						<td>${tempCartdb.id}</td>
						<td>${tempCartdb.user.firstName} ${tempCartdb.user.lastName}</td>
						<td>${tempCartdb.product.name}</td>
						<td>${tempCartdb.quantity}</td>
						<td>${tempCartdb.dateOrder}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>

	<div class="footer">
		<p>Footer</p>
	</div>
</body>

</html>