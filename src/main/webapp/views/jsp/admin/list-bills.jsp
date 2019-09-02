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
		<h2>Bill List</h2>

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
					<th class="text-info">Bill Id</th>
					<th class="text-info">Date Order</th>
					<th class="text-info">Total</th>
					<th class="text-info">Revenue</th>
					<th class="text-info">Ship Status</th>
					<th class="text-info">Address</th>
					<th class="text-info">Phone</th>
					<th class="text-info">Note</th>
					<th class="text-info">Customer</th>
					<th class="text-info">Employee</th>
					<th class="text-info">Detail Bill</th>
				</tr>
			</thead>
			<tbody>

				<c:forEach var="tempBill" items="${theBills}">
					<tr>
						<td class="text-success">${tempBill.billId}</td>
						<td>${tempBill.dateOrder}</td>
						<td>${tempBill.total}</td>
						<td>${tempBill.revenue}</td>

						<c:if test="${tempBill.shipStatus == 'SHIPPHING' }">
							<td>
								<c:url var="setShipSuccess"
									value="/admin/bill/setShipSuccess">
									<c:param name="theBillId" value="${tempBill.id}" />
								</c:url>
								<a class="btn btn-outline-warning" href="${setShipSuccess}">Shipping</a>

								<c:url var="setShipCancel" value="/admin/bill/setShipCancel">
									<c:param name="theBillId" value="${tempBill.id}" />
								</c:url>
								<a class="btn btn-outline-danger" href="${setShipCancel}">Cancel</a>
							</td>
						</c:if>

						<c:if test="${tempBill.shipStatus == 'FINISH' }">
							<td>
								<span class="badge badge-success">${tempBill.shipStatus}</span>
							</td>
						</c:if>
						<c:if test="${tempBill.shipStatus == 'CANCEL' }">
							<td>
								<span class="badge badge-danger">${tempBill.shipStatus}</span>
							</td>
						</c:if>
						<c:if test="${tempBill.shipStatus == 'SUCCESS' }">
							<td>
								<span class="badge badge-info">${tempBill.shipStatus}</span>
							</td>
						</c:if>

						<td>${tempBill.address}</td>
						<td>${tempBill.phone}</td>
						<td>${tempBill.note}</td>
						<td>${tempBill.customer.name}</td>
						<td>${tempBill.employee.lastName}</td>
						<td>
							<!-- DISPLAY WITH ADMIN -->
							<security:authorize access="hasRole('ADMIN')">
							<c:url var="getDetailBill" value="/admin/bill/getDetailBill">
									<c:param name="theBillId" value="${tempBill.id}" />
							</c:url>
							<a class="btn btn-outline-warning" href="${getDetailBill}">Get Detail</a>
							</security:authorize>
							<!-- DISPLAY WITH STAFF -->
							<security:authorize access="hasRole('STAFF')">
							<c:url var="getDetailBill" value="/staff/bill/getDetailBill">
									<c:param name="theBillId" value="${tempBill.id}" />
							</c:url>
							<a class="btn btn-outline-warning" href="${getDetailBill}">Get Detail</a>
							</security:authorize>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		
		<!-- DISPLAY WITH ADMIN -->
		<security:authorize access="hasRole('ADMIN')">
		<a href="<c:url value='/admin/bill/showForm'/>"><button
				type="button" class="btn btn-success">Add Bill</button></a>
		</security:authorize>
		<!-- DISPLAY WITH STAFF -->
		<security:authorize access="hasRole('STAFF')">
		<a href="<c:url value='/staff/bill/showForm'/>"><button
				type="button" class="btn btn-success">Add Bill</button></a>
		</security:authorize>
	</div>







	<div class="jumbotron text-center" style="margin-bottom: 0">
		<p>Footer</p>
	</div>

</body>

</html>