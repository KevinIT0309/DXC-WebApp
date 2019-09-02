<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	isELIgnored="false" pageEncoding="UTF-8"%>
<html>
<head>
<title>Spring Security Login</title>
<link rel="stylesheet" href="<c:url value="/resources/css/cssLogin/login.css" />">

<link rel="stylesheet" href="<c:url value="/bootstrap.min.css" />">

<link rel="stylesheet" href="<c:url value="/bootstrap.min.js" />">

<link href="/bootstrap.min.css" rel="stylesheet">
<script src="/jquery-2.2.1.min.js"></script>
<script src="/bootstrap.min.js"></script>


<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</head>

<body>


 	<div class="container">
		<h3 id="Header">Spring Security Login</h3>
		<c:if test="${param.error ne null}">
			<div style="color: red">Invalid credentials.</div>
		</c:if>
		<c:if test="${param.logout ne null}"><!-- ne (not equal) is != ; handle by /jstl/core -->
			<div class="alert alert-success alert-dismissible">
				<button type="button" class="close" data-dismiss="alert">&times;</button>
				<strong>Success!</strong> You have been logged out successfully
			</div>
			<!-- <div style="color: red">You have been logged out.</div> -->
		</c:if>
		<form:form
			action="${pageContext.request.contextPath}/authenticateTheUser"
			method="POST">
			<div class="form-group">
				<label for="username">UserName:</label> <input type="text"
					class="form-control" id="username" name="username">
			</div>
			<div class="form-group">
				<label for="pwd">Password:</label> <input type="password"
					class="form-control" id="password" name="password">
			</div>

			<button type="submit" class="btn btn-success">Submit</button>

			<!-- Code Message CSRF Protected Default -->
			<input type="hidden" name="${_csrf.parameterName}"
				value="${_csrf.token}" />
			<!-- Code Message CSRF Protected Default -->

			<a href="<c:url value='/'/>"><button type="button"
					class="btn btn-info">Home</button></a>

			<a href="<c:url value='/registration'/>"><button type="button"
					class="btn btn-primary">Register</button></a>

			<%-- <a href="${pageContext.request.contextPath}/registration">Register</a> --%>
		</form:form>
	</div>





</body>
</html>
