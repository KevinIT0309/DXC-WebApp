<%@ page language="java" contentType="text/html; charset=UTF-8"
	isELIgnored="false" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ page session="false"%>

<head>
<title>User</title>
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
		<h2>User List</h2>
		
		<c:url var="urlDashboard" value="/admin/managerment" />
		<a href="${urlDashboard}"><button type="button"
				class="btn btn-warning">Back DashBoard</button></a>
		<hr>

		<table class="table table-bordered">
			<thead>
				<tr>
					<th class="text-info" >Id</th>
					<th class="text-info" >Email</th>
					<th class="text-info" >User Name</th>
					<th class="text-info" >First Name</th>
					<th class="text-info" >Last Name</th>
					<th class="text-info" >Earn Money</th>
					<th class="text-info">Role</th>
					<th>Update</th>
					<th>Delete</th>

				</tr>
			</thead>
			<tbody>

				<c:forEach var="tempUser" items="${users}">
					<tr>
						<td>${tempUser.id}</td>
						<td>${tempUser.email}</td>
						<td>${tempUser.username}</td>
						<td>${tempUser.firstName}</td>
						<td>${tempUser.lastName}</td>
						<td>${tempUser.earnMoney}</td>
						<td>
							<c:forEach items="${tempUser.roles}" var="role">
								<c:if test="${role.roleName == 'ADMIN'}">
									<span class="badge badge-danger">${role.roleName}</span>
								</c:if>
								<c:if test="${role.roleName == 'STAFF'}">
									<span class="badge badge-warning">${role.roleName}</span>
								</c:if>
								<c:if test="${role.roleName == 'USER'}">
									<span class="badge badge-info">${role.roleName}</span>
								</c:if>
							</c:forEach>
						</td>
						
						<td>
							<c:url var="updateLink" value="/admin/user/update">
								<c:param name="userId" value="${tempUser.id}" />
							</c:url>
							<a href="${updateLink}">
								<button type="button" class="btn btn-outline-info btn-sm">Update</button>
							</a>
						</td>
							
						<td>
							<c:url var="deleteLink" value="/admin/user/delete">
								<c:param name="userId" value="${tempUser.id}" />
							</c:url>
							<a href="${deleteLink}"
							onclick="if (!(confirm('Are you sure you want to delete this user?'))) return false">
							<button type="button" class="btn btn-outline-danger btn-sm">Delete</button>
							</a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>

		<a href="<c:url value='/registration'/>"><button
				type="button" class="btn btn-success">Add User</button></a>
	</div>

<div class="jumbotron text-center" style="margin-bottom:0">
  <p>Footer</p>
</div>

</body>