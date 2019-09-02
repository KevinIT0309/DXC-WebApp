<%@ page language="java" contentType="text/html; charset=UTF-8"
	isELIgnored="false" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ page session="false"%>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<meta name="description" content="">
<meta name="author" content="">

<title>Create an account</title>

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

		<form:form method="POST" modelAttribute="userForm" class="form-signin">
		
		<hr>
			<h2 class="form-signin-heading">Create TechZone Account</h2>

			<spring:bind path="user.firstName">
				<div class="form-group ${status.error ? 'has-error' : ''}">
					<form:input type="text" path="user.firstName" class="form-control"
						placeholder="FirstName" autofocus="true"></form:input>
					<form:errors path="user.firstName"></form:errors>
				</div>
			</spring:bind>

			<spring:bind path="user.lastName">
				<div class="form-group ${status.error ? 'has-error' : ''}">
					<form:input type="text" path="user.lastName" class="form-control"
						placeholder="LastName" autofocus="true"></form:input>
					<form:errors path="user.lastName"></form:errors>
				</div>
			</spring:bind>

			<spring:bind path="user.email">
				<div class="form-group ${status.error ? 'has-error' : ''}">
					<form:input type="text" path="user.email" class="form-control"
						placeholder="Email" autofocus="true"></form:input>
					<form:errors path="user.email"></form:errors>
				</div>
			</spring:bind>

			<spring:bind path="user.username">
				<div class="form-group ${status.error ? 'has-error' : ''}">
					<form:input type="text" path="user.username" class="form-control"
						placeholder="Username" autofocus="true"></form:input>
					<form:errors path="user.username"></form:errors>
				</div>
			</spring:bind>

			<spring:bind path="user.password">
				<div class="form-group ${status.error ? 'has-error' : ''}">
					<form:input type="password" path="user.password"
						class="form-control" placeholder="Password"></form:input>
					<form:errors path="user.password"></form:errors>
				</div>
			</spring:bind>

			<spring:bind path="user.passwordConfirm">
				<div class="form-group ${status.error ? 'has-error' : ''}">
					<form:input type="password" path="user.passwordConfirm"
						class="form-control" placeholder="Confirm your password"></form:input>
					<form:errors path="user.passwordConfirm"></form:errors>
				</div>
			</spring:bind>


			<div>
				<security:authorize access="hasRole('ADMIN')">
					<strong>Select Role</strong>
					<hr>
						<td><form:checkboxes path="roles" items="${roles}" />
					<hr>
				</security:authorize>
			</div>

			
			<button class="btn btn-lg btn-primary btn-block" type="submit">Submit</button>
		</form:form>
		
		<hr>
		<a href="<c:url value='/'/>"><button type="button"
						class="btn btn-outline-dark btn-sm">Home</button></a>
	</div>

	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
</body>
</html>
