<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	isELIgnored="false" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Form Bill</title>
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

	<!-- test create and update product with upload image  -->
	<form:form method="post"
		action="saveBill?${_csrf.parameterName}=${_csrf.token}"
		modelAttribute="theBill" class="form-horizontal"
		enctype="multipart/form-data">

		<fieldset>

			<!-- test -->
			<%-- 		<c:set var="product.productDetail" value="${productDetail}"></c:set>
		<c:set var="productDetail.product" value="${product}"></c:set> --%>
			<!-- test -->

			<legend style="text-align: center;">Add a Bill</legend>

			<form:input path="bill.id" type="hidden" />

			<div class="form-group">
				<label class="control-label col-sm-4">User</label>
				<div class="col-sm-4">
					<form:select path="bill.customer.id"
						class="form-control input-sm">
						<form:options items="${listCustomer}" itemLabel="name" itemValue="id" />
					</form:select>
				</div>
			</div>
			
			
			<div class="form-group">
				<label class="control-label col-sm-4" >Product</label>
				<div class="col-sm-4">
					<form:select path="product.id" class="form-control input-sm">
						<form:options items="${listProduct}" itemLabel="name" itemValue="id" />
					</form:select>
				</div>
			</div>
			
			<div class="form-group">
				<label class="control-label col-sm-4">Quantity</label>
				<div class="col-sm-4">
					<form:input path="quantity" type="text" class="form-control"
						id="quantity" name="quantity" placeholder="Enter quantity for this product" />
				</div>
			</div>



			<div class="form-group">
				<div class="col-sm-offset-4 col-sm-6">
					<button type="submit" class="btn btn-success">Save Bill</button>
					<button type="button" onclick="location.href='./list'"
						class="btn btn-danger">Cancel</button>
				</div>
			</div>
		</fieldset>
	</form:form>



	<div class="jumbotron text-center" style="margin-bottom: 0">


		<p>Footer</p>
	</div>



</body>
</html>