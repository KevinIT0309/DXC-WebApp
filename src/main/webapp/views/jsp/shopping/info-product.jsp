<%@ page language="java" contentType="text/html; charset=UTF-8"
	isELIgnored="false" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ page session="false"%>

<!DOCTYPE html>


<html>
<head>
<title>Info Product</title>

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

	<hr>

	<div class="row">

		<div class="col-sm-4">
			<div style="margin-left: 1rem" class="row">
				<div class="card" style="width: 25rem;">
					<img class="card-img-top"
						src="./resources/images/${product.productDetail.image}"
						alt="Card image cap">
				</div>
			</div>
		</div>

		<div class="col-sm-4">

			<div class="card-body">
				<p>Name: ${product.name}</p>
				<p>Name: ${product.price}</p>
				<p>Info : ${product.productDetail.info}</p>
			</div>
			<hr>
			<div class="card-body">
				<c:url var="addProductToCart" value="/cart/addProductToCart">
					<c:param name="productId" value="${product.id}" />
				</c:url>
				<a href="${addProductToCart}" class="btn btn-outline-dark btn-block">Add To Cart</a>
			</div>

		</div>


		<div class="col-sm-4">
				<strong>Get Your priority with card Member</strong>
				<img class="card-img-top"
					src="./resources/images/Test-Image/TechZoneCardMember.png"
					alt="Card image cap">

		</div>


	</div>
	<hr>




	<div class="jumbotron text-center" style="margin-bottom: 0">
		<p>Footer</p>
	</div>

</body>
</html>



