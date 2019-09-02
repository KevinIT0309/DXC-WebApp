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
	
	
	

<title>TechZone</title>


<style type="text/css">
.parent {
	width: 17rem;
	height: 17rem;
}

.parent img {
	height: 100%;
	width: 100%;
	align-items: center;
}

.jumbotron {
 
  padding: 2rem 1rem;
 
  margin-bottom: 2rem;
 
  border-radius: 0.3rem;
 
background: #000064;  /* old browsers fallback color*/
 
background: -webkit-linear-gradient(to right, #b6fcd5, #468499); 
 
background: linear-gradient(to right, #66cccc, #038fff);
}
</style>

</head>
<body>






	<nav class="navbar navbar-expand-sm bg-light navbar-light fixed-top">
		<!-- Links -->
		<ul class="navbar-nav">
		
		<security:authorize access="isAuthenticated()">
			<li class="nav-item">
				<div>
					<form:form action="${pageContext.request.contextPath}/logout" method="post">
						<button type="submit" class="btn btn-danger"><spring:message code="home.logout" /></button>
							<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
					</form:form>
				</div>
			</li>
		<%-- <li class="nav-item"><a class="nav-link" href="<c:url value='${pageContext.request.contextPath}/logout'/>"><spring:message code="home.logout" /></a></li> --%>
		</security:authorize>
		
		<security:authorize access="isAnonymous()">
			<li class="nav-item"><a class="nav-link" href="<c:url value='/showMyLoginPage'/>"><spring:message code="home.login" /></a></li>
			<li class="nav-item"><a class="nav-link" href="<c:url value='/registration'/>"><spring:message code="home.register" /></a></li>
		</security:authorize>
		
			<li class="nav-item"><a class="nav-link" href="<c:url value='/cart'/>"><spring:message code="home.cart" /></a></li>
			<security:authorize access="hasRole('ADMIN')">
				<li class="nav-item"><a class="nav-link" title="ADMIN ACCESS" href="<c:url value='/admin/managerment'/>"><spring:message code="home.dashboard" /></a></li>
			</security:authorize>
			<security:authorize access="hasRole('STAFF')">
				<li class="nav-item"><a class="nav-link" title="STAFF ACCESS" href="<c:url value='/staff/control'/>"><spring:message code="home.dashboard" /></a></li>
			</security:authorize>
			
			<li>
				<div class="dropdown">
					<button type="button" class="btn btn-outline-dark dropdown-toggle"
						data-toggle="dropdown">language</button>
					<div class="dropdown-menu">
						<a class="dropdown-item" href="?lang=en">English</a>
						<div class="dropdown-divider"></div>
						<a class="dropdown-item" href="?lang=vn">VietNamess</a>
						<div class="dropdown-divider"></div>
						<a class="dropdown-item" href="#">Another link</a>
					</div>
				</div>
			</li>
		</ul>

		<form class="form-inline" action="/action_search">
			<input style="width: 450px;" class="form-control mr-sm-2" type="text" placeholder="Search product">
			<button class="btn btn-success" type="submit">
				<spring:message code="home.search" />
			</button>
		</form>
	</nav>




	<div class="row">
		<div class="col-sm-4"></div>
		<div class="col-sm-4"></div>
		<div class="col-sm-4"></div>
	</div>

	<hr>

	<div class="container-fluid content-center">
		<div class="row h-100 justify-content-center align-items-center">
			<c:choose>
				<c:when test="${!empty listProduct}">
					<c:forEach var="tempProduct" items="${listProduct}" begin="1"
						end="11">

						<div class="card" style="width: 18rem; margin: 0.2rem;">
							<div class="parent">
								<img class="card-img-top"
									src="./resources/images/${tempProduct.productDetail.image}"
									alt="Card image cap">
							</div>

							<div class="card-body">
								<h5 class="card-title">${tempProduct.name}</h5>
							</div>
							
							<div class="card-body" style="background-color: #f5f5f5">

								<c:url var="addProductToCart" value="/cart/addProductToCart">
									<c:param name="productId" value="${tempProduct.id}" />
								</c:url>
								<a href="${addProductToCart}"
									class="btn btn-outline-success btn-block">Add Cart</a>

								<c:url var="detailProductLink" value="/product">
									<c:param name="productId" value="${tempProduct.id}" />
								</c:url>
								<a href="${detailProductLink}"
									class="btn btn-outline-dark btn-block">Detail</a>

							</div>
						</div>
					</c:forEach>
				</c:when>
			</c:choose>
		</div>
	</div>


	<hr>
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


	<div class="jumbotron text-center" style="margin-bottom: 0">
		<p>Footer</p>
	</div>


</body>
</html>



<!-- <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<div class="w3-top">
  <div class="w3-bar w3-white w3-wide w3-padding w3-card">
    <a href="#home" class="w3-bar-item w3-button"><b>Tech</b>Zone</a>
    Float links to the right. Hide them on small screens
    <div class="w3-right w3-hide-small">
      <a href="#projects" class="w3-bar-item w3-button">Projects</a>
      <a href="#about" class="w3-bar-item w3-button">About</a>
      <a href="#contact" class="w3-bar-item w3-button">Contact</a>
    </div>
  </div>
</div> -->


