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

<title>Confirm Transaction Payment</title>
</head>
<body>

	<div class="container">

		<!-- User Authenticated -->
		<security:authorize access="isAuthenticated()">
			<h2 class="form-signin-heading">Confirm your Information</h2>
			<form:form method="POST" action="confirmPayment"
				modelAttribute="theUserCheckoutModel" class="form-signin">

				<div class="form-group">
					<label class="control-label col-sm-4" for="product.price">First
						Name</label>
					<form:input type="text" disabled="true" readonly="readonly"
						path="user.firstName" class="form-control" placeholder="FirstName"
						autofocus="true"></form:input>
				</div>

				<div class="form-group">
					<label class="control-label col-sm-4" for="product.price">Last
						Name</label>
					<form:input type="text" disabled="true" readonly="readonly"
						path="user.lastName" class="form-control" placeholder="LastName"
						autofocus="true"></form:input>
				</div>

				<div class="form-group">
					<label class="control-label col-sm-4" for="product.price">Email</label>
					<form:input type="text" disabled="true" readonly="readonly"
						path="user.email" class="form-control" placeholder="Email"
						autofocus="true"></form:input>
				</div>

				<label class="control-label col-sm-4" for="product.price">City</label>
				<form:select path="city" items="${cityList}" />

				<div class="form-group">
					<label class="control-label col-sm-4" for="product.price">Address</label>
					<form:input type="text" path="address" class="form-control"
						placeholder="Your Address" autofocus="true"></form:input>
				</div>

				<div class="form-group">
					<label class="control-label col-sm-4" for="product.price">Phone
						Number</label>
					<form:input type="text" path="phone" class="form-control"
						placeholder="Your phone number" autofocus="true"></form:input>
				</div>

				<div class="form-group">
					<label class="control-label col-sm-4" for="product.price">Note
						to Deliver</label>
					<div class="card-body">
						<form:textarea path="note" rows="2" cols="40" />
					</div>
				</div>

				<button class="btn btn-lg btn-primary btn-block" type="submit">Order</button>
			</form:form>
		</security:authorize>
		<!-- User Authenticated -->


		<!-- User in Anonymous -->
		<security:authorize access="isAnonymous()">
			<form:form method="POST" action="confirmPayment"
				modelAttribute="theUserCheckoutModel" class="form-signin">

				<hr>
				<h2 class="form-signin-heading">Enter your Information payment</h2>

				<spring:bind path="user.firstName">
					<div class="form-group ${status.error ? 'has-error' : ''}">
						<form:input type="text" path="user.firstName" class="form-control"
							placeholder="Enter your firstName" autofocus="true"></form:input>
						<form:errors path="user.firstName"></form:errors>
					</div>
				</spring:bind>

				<spring:bind path="user.lastName">
					<div class="form-group ${status.error ? 'has-error' : ''}">
						<form:input type="text" path="user.lastName" class="form-control"
							placeholder="Enter you lastName" autofocus="true"></form:input>
						<form:errors path="user.lastName"></form:errors>
					</div>
				</spring:bind>

				<spring:bind path="user.email">
					<div class="form-group ${status.error ? 'has-error' : ''}">
						<form:input type="text" path="user.email" class="form-control"
							placeholder="Enter your email" autofocus="true"></form:input>
						<form:errors path="user.email"></form:errors>
					</div>
				</spring:bind>

				<spring:bind path="phone">
					<div class="form-group ${status.error ? 'has-error' : ''}">
						<form:input type="text" path="phone" class="form-control"
							placeholder="Enter your phone" autofocus="true"></form:input>
						<form:errors path="phone"></form:errors>
					</div>
				</spring:bind>

				<spring:bind path="city">
					<div class="form-group ${status.error ? 'has-error' : ''}">
						<form:select path="city" items="${cityList}" />
						<form:errors path="city"></form:errors>
					</div>
				</spring:bind>

				<spring:bind path="address">
					<div class="form-group ${status.error ? 'has-error' : ''}">
						<form:input type="text" path="address" class="form-control"
							placeholder="Enter your address" autofocus="true"></form:input>
						<form:errors path="address"></form:errors>
					</div>
				</spring:bind>

				<div class="form-group">
					<form:textarea path="note" rows="2" cols="40" />
				</div>

				<button class="btn btn-lg btn-primary btn-block" type="submit">Order</button>
			</form:form>
		</security:authorize>
		<!-- User in Anonymous -->


		<hr>
		<div class="container">
			<div class="card-body">
				<c:url var="cancel" value="/" />
				<a href="${cancel}" class="btn btn-outline-dark btn-block">Cancel</a>
			</div>
		</div>


	</div>

	<div class="jumbotron text-center" style="margin-bottom: 0">
		<p>Footer</p>
	</div>


</body>
</html>



