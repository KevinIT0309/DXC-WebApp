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

<!-- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -->
<script type="text/javascript">
	$(document).ready(function() {

		$('#buttonDemo1').click(function() {
			$.ajax({
				type : 'GET',
				url : '${pageContext.request.contextPath}/api/ajaxrest/demo1',
				success : function(result) {
					$('#result').text(result);
				}
			});

		});

	});
</script>
<!-- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -->


<style type="text/css">
.example_e {
	background: #404040;
	color: #f2f2f2 !important;
	font-weight: 100;
	border-radius: 2px;
	padding: 20px;
	text-transform: uppercase;
	border-radius: 0% solid;
	display: inline-block;
	transition: all 0.3s ease 0s;
}

.example_e:hover {
	color: #404040 !important;
	text-decoration: none;
	border-radius: 2px;
	border-color: green;
	font-weight: 700 !important;
	letter-spacing: 3px;
	background: none;
	-webkit-box-shadow: 0px 5px 40px -10px rgba(0, 0, 0, 0.57);
	-moz-box-shadow: 0px 5px 40px -10px rgba(0, 0, 0, 0.57);
	transition: all 0.3s ease 0s;
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

	<h2>This is page of cart</h2>


	<div class="row">
		<div class="col-sm-4">
			<div class="container">
				<c:choose>
					<c:when test="${!empty cart}">

						<div class="jumbotron jumbotron-fluid"
							style="background-color: #eeeeee;">
							<div class="container">
								<c:forEach items="${cart}" var="item">
									<c:set var='id' value='${item.product.id}' />
									
										<div class="card" style="width: 13rem;">
											<img class="card-img-top"
												src="./resources/images/${item.product.productDetail.image}"
												alt="Card image cap">
	
											<ul class="list-group list-group-flush">
												<li class="list-group-item"><span class="text-info">Name</span> : ${item.product.name}</li>
												<li class="list-group-item"><span class="text-info">Quantity</span> : ${item.quantity}</li>
												<li class="list-group-item">
													<c:url var="deleteItem" value="" />
													<a href="${deleteItem}" class="btn btn-outline-danger btn-block">Delete Item</a>
												</li>

											</ul>
											
										</div>
									
									<hr>
								</c:forEach>
							</div>
						</div>
					</c:when>
					<c:otherwise>

						<div class="jumbotron jumbotron-fluid">
							<div class="container">
								<strong>Your Cart is Empty , please add cart some product</strong>
							</div>
						</div>
					</c:otherwise>

				</c:choose>
			</div>
		</div>
		<div class="col-sm-4">
			<div class="container">
				<div class="card-body">
					<c:choose>
						<c:when test="${empty cart}">
							<c:url var="countinueShopping" value="/" />
							<a href="${countinueShopping}"
								class="btn btn-outline-dark btn-block">Continues Shopping</a>
						</c:when>
						<c:otherwise>

							<c:url var="buy" value="/cart/buy" />
							<div class="button_cont" align="center">
								<a href="${buy}" class="example_e">Confirm Your Payment</a>
							</div>
							<hr>

							<c:url var="clear" value="/cart/clearCart" />
							<a href="${clear}" class="btn btn-outline-warning btn-block">Clear
								Cart</a>
							<c:url var="countinueShopping" value="/" />
							<a href="${countinueShopping}"
								class="btn btn-outline-success btn-block">Continues Shopping</a>
						</c:otherwise>
					</c:choose>

				</div>
			</div>
		</div>
		<div class="col-sm-4">.col-sm-3</div>
	</div>





	<fieldset>
		<legend>Ajax</legend>
		<input type="button" value="Click me" id="buttonDemo1" /> <br /> <span
			id="result"></span>
	</fieldset>


	<div class="jumbotron text-center" style="margin-bottom: 0px;">
		<p>Footer</p>
	</div>



</body>
</html>



