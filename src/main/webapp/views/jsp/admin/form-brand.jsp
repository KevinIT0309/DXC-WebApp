<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	isELIgnored="false" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Form Brand</title>
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
		action="saveBrand?${_csrf.parameterName}=${_csrf.token}"
		modelAttribute="brandModel" class="form-horizontal"
		enctype="multipart/form-data">
		<form:input path="id" type="hidden" />
		<div class="form-group">
			<label class="control-label col-sm-4" for="product.productname">Name
				Brands</label>
			<div class="col-sm-4">
				<form:input path="name" type="text" class="form-control" id="name"
					name="name" placeholder="Enter name of brand" />
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