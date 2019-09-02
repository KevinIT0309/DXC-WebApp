<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	isELIgnored="false" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ page session="false"%>
<html>
<head>
<title>ACCESS DENIED</title>
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

	<div class="row">
		<div class="col"></div>
		<div class="col">

			<img src="/TechZone/resources/images/common/404.png">
		</div>
		<div class="col"></div>
	</div>

	<a href="<c:url value='/'/>"><button type="button"
			class="btn btn-outline-dark btn-sm">Home</button></a>


	<div class="alert alert-secondary alert-dismissible">
		<button type="button" class="close" data-dismiss="alert">&times;</button>
		<strong>Access Denied! </strong>You need ADMIN role to access this
		page
	</div>


</body>
</html>