<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	isELIgnored="false" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Form Customer</title>
<link rel="stylesheet" href="<c:url value="/resources/css/login.css" />">

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

	<form:form method="post"
		action="saveCustomer?${_csrf.parameterName}=${_csrf.token}"
		modelAttribute="customerModel" class="form-horizontal"
		enctype="multipart/form-data">
		<form:input path="id" type="hidden" />

		<div class="form-group">
			<label class="control-label col-sm-4">Name Customer</label>
			<div class="col-sm-4">
				<form:input path="name" type="text" class="form-control"
					id="name" name="name"
					placeholder="Enter Name of customer" />
			</div>
		</div>

		<div class="form-group">
			<label class="control-label col-sm-4">Birthday Customer</label>
			<div class="col-sm-4">
				<form:input path="birthday" type="text" class="form-control"
					id="birthday" name="birthday"
					placeholder="Enter birthday of customer" />
			</div>
		</div>

		<div class="form-group">
			<label class="control-label col-sm-4">Sex Customer</label>
			<div class="col-sm-4">
				<form:input path="sex" type="text" class="form-control" id="sex"
					name="sex" placeholder="Enter sex of customer" />
			</div>
		</div>

		<div class="form-group">
			<label class="control-label col-sm-4">Address Customer</label>
			<div class="col-sm-4">
				<form:input path="address" type="text" class="form-control"
					id="address" name="address" placeholder="Enter Address of customer" />
			</div>
		</div>

		<div class="form-group">
			<label class="control-label col-sm-4">Email Customer</label>
			<div class="col-sm-4">
				<form:input path="email" type="text" class="form-control" id="email"
					name="email" placeholder="Enter email of customer" />
			</div>
		</div>

		<div class="form-group">
			<label class="control-label col-sm-4">Phone Customer</label>
			<div class="col-sm-4">
				<form:input path="phone" type="text" class="form-control" id="phone"
					name="phone" placeholder="Enter phone of customer" />
			</div>
		</div>

		<div class="form-group">
			<div class="col-sm-offset-4 col-sm-6">
				<button type="submit" class="btn btn-success">Save</button>
				<button type="button" onclick="location.href='./list'"
					class="btn btn-defaulf">Cancel</button>
			</div>
		</div>
	</form:form>


	<div class="footer">
		<p>Footer</p>
	</div>

</body>
</html>