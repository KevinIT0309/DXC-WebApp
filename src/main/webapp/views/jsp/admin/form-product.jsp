<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	isELIgnored="false" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Form Product</title>
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
		action="saveProduct?${_csrf.parameterName}=${_csrf.token}"
		modelAttribute="productModel" class="form-horizontal"
		enctype="multipart/form-data">

		<fieldset>

			<!-- test -->
			<%-- 		<c:set var="product.productDetail" value="${productDetail}"></c:set>
		<c:set var="productDetail.product" value="${product}"></c:set> --%>
			<!-- test -->

			<legend>Add a product</legend>

			<form:input path="product.id" type="hidden" />

			<spring:bind path="product.name">
				<div class="form-group">
					<label class="control-label col-sm-4" for="product.productname">Name
						Product</label>
					<div class="col-sm-4">
						<form:input path="product.name" type="text" class="form-control"
							id="name" name="name" placeholder="Enter name of product" />
						<form:errors path="product.name"></form:errors>
					</div>

				</div>
			</spring:bind>

			<spring:bind path="product.price">
				<div class="form-group">
					<label class="control-label col-sm-4" for="product.price">Price
						Product</label>
					<div class="col-sm-4">
						<form:input path="product.price" type="text" class="form-control"
							id="price" name="price" placeholder="Enter code of product" />
						<form:errors path="product.price"></form:errors>
					</div>
				</div>
			</spring:bind>

			<spring:bind path="productDetail.info">
				<div class="form-group">
					<label class="control-label col-sm-4">Info Product</label>
					<div class="col-sm-4">
						<form:input path="productDetail.info" type="text"
							class="form-control" id="info" name="info"
							placeholder="Enter Info of product" />
						<form:errors path="productDetail.info"></form:errors>
					</div>
				</div>
			</spring:bind>

			<spring:bind path="productDetail.warranty">
				<div class="form-group">
					<label class="control-label col-sm-4">Warranty Product</label>
					<div class="col-sm-4">
						<form:input path="productDetail.warranty" type="text"
							class="form-control" id="warranty" name="warranty"
							placeholder="Enter warranty of product" />
						<form:errors path="productDetail.warranty"></form:errors>
					</div>
				</div>
			</spring:bind>

			<spring:bind path="product.inventory">
				<div class="form-group">
					<label class="control-label col-sm-4" for="product.inventory">Inventory</label>
					<div class="col-sm-4">
						<form:input path="product.inventory" type="text"
							class="form-control" id="inventory" name="inventory"
							placeholder="Enter inventory" />
						<form:errors path="product.inventory"></form:errors>
					</div>
				</div>
			</spring:bind>


			<div class="form-group">
				<label class="control-label col-sm-4" for="category">Category</label>
				<div class="col-sm-4">
					<form:select path="product.category.id"
						class="form-control input-sm">
						<form:options items="${categorys}" itemLabel="name" itemValue="id" />
					</form:select>
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-4" for="brand">Brand</label>
				<div class="col-sm-4">
					<form:select path="product.brand.id" class="form-control input-sm">
						<form:options items="${brands}" itemLabel="name" itemValue="id" />
					</form:select>
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-4" for="sale">Sale Event</label>
				<div class="col-sm-4">
					<form:select path="product.sale.id" class="form-control input-sm">
						<form:options items="${sales}" itemLabel="event" itemValue="id" />
					</form:select>
				</div>
			</div>

			<spring:bind path="images">
				<div class="form-group">
					<label class="control-label col-sm-4">Image Product</label>
					<div class="col-sm-4">
						<input class="btn btn-primary btn-sm float-left" type="file" name="images" multiple="multiple" />
						<form:errors path="images"></form:errors>
					</div>
				</div>
			</spring:bind>

			<div class="form-group">
				<div class="col-sm-offset-4 col-sm-6">
					<button type="submit" class="btn btn-success">Save</button>
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