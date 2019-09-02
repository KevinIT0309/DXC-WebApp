<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<spring:url var="css" value="/resources/css"></spring:url>
<spring:url var="js" value="/resources/js"></spring:url>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Page</title>
<link rel="stylesheet" href="${css}/myapp.css">
<link href="https://fonts.googleapis.com/css?family=Ubuntu"
	rel="stylesheet">
<link rel="stylesheet" href="${css}/font-awesome.min.css">
</head>
<body>
	<div class="main">
		<p class="sign" align="center">Sign in</p>
		<form action="logincheck" method="post" class="form1">
			<input name="userName" class="un " type="text" align="center" placeholder="Username">
			<input name="passWord" class="pass" type="password" align="center"
				placeholder="Password"> <button type="submit" class="submit" align="center">Sign
				in</button>
			<p class="forgot" align="center">
				<a href="#">Forgot Password? 
			</p>
		</form>
	</div>
</body>
</html>