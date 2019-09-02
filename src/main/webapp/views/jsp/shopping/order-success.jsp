
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

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>

<style type="text/css">

.jumbotron {
  padding: 2rem 1rem;
  margin-bottom: 2rem;
  border-radius: 0.3rem;
	background: #000064;  /* old browsers fallback color*/
	background: -webkit-linear-gradient(to right, #b6fcd5, #468499); 
	background: linear-gradient(to right, #66cccc, #038fff);
}
</style>


<title>Order Success</title>
</head>
<body>

<hr>
	
<!-- 	
	<div class="container">
		<img class="card-img-top"
								src="./resources/images/common/payment-success.png"
								alt="Card image cap">
	</div> -->
	
	
		<div class="row">
		<div class="card" style="width: 18rem;">
			<div class="parent">
				<img class="card-img-top"
					src="./resources/images/Test-Image/03343b8a-59c9-4c13-b71c-2872b5c8127f.jpg"
					alt="Card image cap">
			</div>
			<div class="card-body">
				<h5 class="card-title">Macbook Pro 2019</h5>
				<p class="card-text">Macbook Pro 2019 is highest version laptop
					of Apple</p>
			</div>
			<ul class="list-group list-group-flush">
				<li class="list-group-item">Best for Code</li>
				<li class="list-group-item">Best Sreen Display</li>
				<li class="list-group-item">Powerful Sound</li>
			</ul>
			<div class="card-body">
				<a href="<c:url value='#'/>">
					<button type="button" class="btn btn-outline-success btn-block">Buy</button>
				</a> <a href="<c:url value='#'/>">
					<button type="button" class="btn btn-outline-dark btn-block">Detail</button>
				</a>
			</div>
		</div>

	</div>


	<div class="container">
		<div class="row">
			<div class="col-sm-3"></div>

			<div class="col-sm-6">
			<strong>YOUR ORDER SUCCESSFULLY !</strong>
				<div class="jumbotron">
					<strong class="text-success">Your Bill Id : </strong>
					<span>${theResponseInfoShopping.billId}</span><br>
					<strong>Thank's ${theResponseInfoShopping.user.lastName} for Shopping at TechZone</strong>
				</div>
					<strong class="text-success" >YOUR ITEM</strong><br>
					<c:forEach var="item" items="${theResponseInfoShopping.items}">
						<strong>${item.product.name}</strong>
						<strong>${item.product.price}</strong>
						<br>
					</c:forEach>
					
					<strong class="text-info">Please ready money : ${theResponseInfoShopping.readyMoney}</strong>

				<c:url var="backHome" value="/" />
				<a href="${backHome}" class="btn btn-outline-dark btn-block">Tech Zone</a>
			</div>

			<div class="col-sm-3"></div>
		</div>
	</div>

	<div class="jumbotron text-center" style="margin-bottom: 0">
		<p>Footer</p>
	</div>


</body>
</html>



