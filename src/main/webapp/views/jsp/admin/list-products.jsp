<%@ page language="java" contentType="text/html; charset=UTF-8"
	isELIgnored="false" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ page session="false"%>

<html>
<head>
<title>Product</title>

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
		<h2>Product List</h2>
		
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
					<th class="text-info" >Name</th>
					<th class="text-info" >Price</th>
					<th class="text-info" >Inventory</th>
					<th class="text-info" >Category</th>
					<th class="text-info">Brand</th>
					<th class="text-info">Sale</th>
					<th class="text-info">Info</th>
					<th class="text-info">Warranty</th>
					<th >Update</th>
					<th>Delete</th>
				</tr>
			</thead>
			<tbody>

				<c:forEach var="tempProduct" items="${products}">
					<tr>
						<td>${tempProduct.name}</td>
						<td>${tempProduct.price}</td>
						<td>${tempProduct.inventory}</td>
						<td>${tempProduct.category.name}</td>
						<td>${tempProduct.brand.name}</td>
						<td>${tempProduct.sale.percent}%</td>
						<td>${tempProduct.productDetail.info}</td>
						<td>${tempProduct.productDetail.warranty}</td>

						<td>
							<!-- DISPLAY WITH ADMIN -->
							<security:authorize access="hasRole('ADMIN')">
								<c:url var="updateLink" value="/admin/product/update">
									<c:param name="productId" value="${tempProduct.id}" />
								</c:url> <a href="${updateLink}">Update</a>
							</security:authorize>
							<!-- DISPLAY WITH STAFF -->
							<security:authorize access="hasRole('STAFF')">
								<c:url var="updateLink" value="/staff/product/update">
									<c:param name="productId" value="${tempProduct.id}" />
								</c:url> <a href="${updateLink}">Update</a>
							</security:authorize>

						</td>
						<td>
							<!-- DISPLAY WITH ADMIN -->
							<security:authorize access="hasRole('ADMIN')">
								<c:url var="deleteLink" value="/admin/product/delete">
										<c:param name="productId" value="${tempProduct.id}" />
								</c:url>
								<a href="${deleteLink}" onclick="if (!(confirm('Are you sure you want to delete this product?'))) return false">Delete</a>
							</security:authorize>
							<!-- DISPLAY WITH STAFF -->
							<security:authorize access="hasRole('STAFF')">
								<c:url var="deleteLink" value="/staff/product/delete">
										<c:param name="productId" value="${tempProduct.id}" />
								</c:url>
								<a href="${deleteLink}" onclick="if (!(confirm('Are you sure you want to delete this product?'))) return false">Delete</a>
							</security:authorize>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>



		<!-- DISPLAY WITH ADMIN -->
		<security:authorize access="hasRole('ADMIN')">
			<a href="<c:url value='/admin/product/showForm'/>">
				<button type="button" class="btn btn-success">Add Product</button>
			</a>
		</security:authorize>
		<!-- DISPLAY WITH STAFF -->
		<security:authorize access="hasRole('STAFF')">
			<a href="<c:url value='/staff/product/showForm'/>">
				<button type="button" class="btn btn-success">Add Product</button>
			</a>
		</security:authorize>
	</div>
	
	
	<div class="jumbotron text-center" style="margin-bottom: 0">
		<p>Footer</p>
	</div>

</body>

</html>