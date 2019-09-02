<%@ page language="java" contentType="text/html; charset=UTF-8"
	isELIgnored="false" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ page session="false"%>

<html>
<head>
<title>Bill</title>

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

	<div class="container">
		<h2>BillDetail List</h2>

		
		<!-- DISPLAY WITH ADMIN -->
		<security:authorize access="hasRole('ADMIN')">
			<c:url var="urlDashboard" value="/admin/managerment" />
		</security:authorize>
		<!-- DISPLAY WITH ADMIN -->
		<security:authorize access="hasRole('STAFF')">
			<c:url var="urlDashboard" value="/staff/control" />
		</security:authorize>
		
		<a href="${urlDashboard}"><button type="button" class="btn btn-warning">Back DashBoard</button></a>
		
		<hr>
		<table class="table table-bordered">
			<thead>
				<tr>
					<th class="text-info" >Bill Parent Id</th>
					<th class="text-info" >Product</th>
					<th class="text-info" >Single Price</th>
					<th class="text-info" >Quantity</th>
					<th class="text-info" >Sale Percent</th>
				</tr>
			</thead>
			<tbody>

				<c:forEach var="tempBillDetail" items="${theBillDetails}">
					<tr>
						<td class="text-warning">${tempBillDetail.bill.billId}</td>
						<td>${tempBillDetail.product.name}</td>
						<td>${tempBillDetail.singlePrice}</td>
						<td>${tempBillDetail.quantity}</td>
						<td>${tempBillDetail.salePercent}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	
	
	<div class="jumbotron text-center" style="margin-bottom: 0">
		<p>Footer</p>
	</div>

</body>

</html>