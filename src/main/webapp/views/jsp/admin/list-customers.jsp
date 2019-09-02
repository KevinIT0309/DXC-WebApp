<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	isELIgnored="false" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<title>Category</title>
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
		<h2>Customer List</h2>
				
		<!-- DISPLAY WITH ADMIN -->
		<security:authorize access="hasRole('ADMIN')">
			<c:url var="urlDashboard" value="/admin/managerment" />
		</security:authorize>
		<!-- DISPLAY WITH STAFF -->
		<security:authorize access="hasRole('STAFF')">
			<c:url var="urlDashboard" value="/staff/control" />
		</security:authorize>
		
		<a href="${urlDashboard}"><button type="button" class="btn btn-warning">Back DashBoard</button></a>
		
		<hr>
		<table class="table table-bordered">
			<thead>
				<tr>
					<th class="text-info" >Id</th>
					<th class="text-info" >Name</th>
					<th class="text-info" >BirthDay</th>
					<th class="text-info" >Sex</th>
					<th class="text-info" >Address</th>
					<th class="text-info" >Email</th>
					<th class="text-info" >Phone</th>
					<th>Update</th>
					<th>Delete</th>
					
				</tr>
			</thead>
			<tbody>

				<c:forEach var="tempCustomer" items="${theCustomers}">
					<tr>
						<td>${tempCustomer.id}</td>
						<td>${tempCustomer.name}</td> 
						<td>${tempCustomer.birthday}</td> 
						<td>${tempCustomer.sex}</td>
						<td>${tempCustomer.address}</td>
						<td>${tempCustomer.email}</td>
						<td>${tempCustomer.phone}</td>
						<td>
							<!-- DISPLAY WITH ADMIN -->
							<security:authorize access="hasRole('ADMIN')">
								<c:url var="updateLink" value="/admin/customer/update">
								<c:param name="customerId" value="${tempCustomer.id}" /></c:url>
								<a href="${updateLink}">Update</a>
							</security:authorize>
							<!-- DISPLAY WITH STAFF -->
							<security:authorize access="hasRole('STAFF')">
								<c:url var="updateLink" value="/staff/customer/update">
								<c:param name="customerId" value="${tempCustomer.id}" /></c:url>
								<a href="${updateLink}">Update</a>
							</security:authorize>
						</td>
						<td>
							<!-- DISPLAY WITH ADMIN -->
							<security:authorize access="hasRole('ADMIN')">
								<c:url var="deleteLink" value="/admin/customer/delete">
								<c:param name="customerId" value="${tempCustomer.id}" /></c:url>
								<a href="${deleteLink}"onclick="if (!(confirm('Are you sure you want to delete this category?'))) return false">Delete</a>
							</security:authorize>
							<!-- DISPLAY WITH STAFF -->
							<security:authorize access="hasRole('STAFF')">
								<c:url var="deleteLink" value="/staff/customer/delete">
								<c:param name="customerId" value="${tempCustomer.id}" /></c:url>
								<a href="${deleteLink}"onclick="if (!(confirm('Are you sure you want to delete this category?'))) return false">Delete</a>
							</security:authorize>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
				<!-- DISPLAY WITH ADMIN -->
				<security:authorize access="hasRole('ADMIN')">
				<a href="<c:url value='/admin/customer/showForm'/>"><button type="button"
					class="btn btn-primary">Add Customer</button></a>
				</security:authorize>
				<!-- DISPLAY WITH STAFF -->
				<security:authorize access="hasRole('STAFF')">
				<a href="<c:url value='/staff/customer/showForm'/>"><button type="button"
					class="btn btn-primary">Add Customer</button></a>
				</security:authorize>
	</div>

	<div class="footer">
		<p>Footer</p>
	</div>
</body>

</html>