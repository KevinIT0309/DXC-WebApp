<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<spring:url var="css" value="/resources/css"></spring:url>
<spring:url var="js" value="/resources/js"></spring:url>

<c:set var="contextRoot" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home</title>
<link rel="stylesheet" href="${css}/bootstrap.min.css">
<link rel="stylesheet" href="${css}/bootstrap.css">
<link rel="stylesheet" type="text/css" href="${css}/font-awesome.css" />
<link rel="stylesheet" href="${css}/menu.css">
<link rel="stylesheet" href="${css}/flexdis.css">
<link rel="stylesheet" href="${css}/footer.css">
<script type="text/javascript" src="${js}/jquery.min.js"></script>
<script type="text/javascript" src="${js}/bootstrap.js"></script>
<script type="text/javascript" src="${js}/bootstrap.min.js"></script>
<script type="text/javascript" src="${js}/menu.js"></script>
</head>
<body>
<div style="min-height: 100%">
	<header class="header">
		<nav class="navbar navbar-toggleable-md navbar-light pt-0 pb-0 ">
			<button class="navbar-toggler navbar-toggler-right" type="button"
				data-toggle="collapse" data-target="#navbarNavDropdown"
				aria-controls="navbarNavDropdown" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<a class="navbar-brand p-0 mr-5" href="#"><img
				src="http://via.placeholder.com/61x14"></a>
			<div class="float-left">
				<a href="#" class="button-left"><span class="fa fa-fw fa-bars "></span></a>
			</div>
			<div class="collapse navbar-collapse flex-row-reverse"
				id="navbarNavDropdown">
				<ul class="navbar-nav">
					<li class="nav-item dropdown messages-menu"><a
						class="nav-link dropdown-toggle" href="http://example.com"
						id="navbarDropdownMenuLink" data-toggle="dropdown"
						aria-haspopup="true" aria-expanded="false"> <i
							class="fa fa-bell-o"></i> <span
							class="label label-success bg-success">10</span>
					</a>
						<div class="dropdown-menu"
							aria-labelledby="navbarDropdownMenuLink">
							<ul class="dropdown-menu-over list-unstyled">
								<li class="header-ul text-center">You have 4 messages</li>
								<li>
									<!-- inner menu: contains the actual data -->
									<ul class="menu list-unstyled">
										<li>
											<!-- start message --> <a href="#">
												<div class="pull-left">
													<img src="http://via.placeholder.com/160x160"
														class="rounded-circle  " alt="User Image">
												</div>
												<h4>
													Support Team <small><i class="fa fa-clock-o"></i> 5
														mins</small>
												</h4>
												<p>Why not buy a new awesome theme?</p>
										</a>
										</li>
										<!-- end message -->
										<li><a href="#">
												<div class="pull-left">
													<img src="http://via.placeholder.com/160x160"
														class="rounded-circle " alt="User Image">
												</div>
												<h4>
													AdminLTE Design Team <small><i
														class="fa fa-clock-o"></i> 2 hours</small>
												</h4>
												<p>Why not buy a new awesome theme?</p>
										</a></li>
										<li><a href="#">
												<div class="pull-left">
													<img src="http://via.placeholder.com/160x160"
														class="rounded-circle " alt="User Image">
												</div>
												<h4>
													Developers <small><i class="fa fa-clock-o"></i>
														Today</small>
												</h4>
												<p>Why not buy a new awesome theme?</p>
										</a></li>
										<li><a href="#">
												<div class="pull-left">
													<img src="http://via.placeholder.com/160x160"
														class="rounded-circle " alt="User Image">
												</div>
												<h4>
													Sales Department <small><i class="fa fa-clock-o"></i>
														Yesterday</small>
												</h4>
												<p>Why not buy a new awesome theme?</p>
										</a></li>
										<li><a href="#">
												<div class="pull-left">
													<img src="http://via.placeholder.com/160x160"
														class="rounded-circle " alt="User Image">
												</div>
												<h4>
													Reviewers <small><i class="fa fa-clock-o"></i> 2
														days</small>
												</h4>
												<p>Why not buy a new awesome theme?</p>
										</a></li>
									</ul>
								</li>
								<li class="footer-ul text-center"><a href="#">See All
										Messages</a></li>
							</ul>
						</div></li>
					<li class="nav-item dropdown notifications-menu"><a
						class="nav-link dropdown-toggle" href="http://example.com"
						id="navbarDropdownMenuLink" data-toggle="dropdown"
						aria-haspopup="true" aria-expanded="false"> <i
							class="fa fa-envelope-o"></i> <span
							class="label label-warning bg-warning">10</span>
					</a>
						<div class="dropdown-menu"
							aria-labelledby="navbarDropdownMenuLink">
							<ul class="dropdown-menu-over list-unstyled">
								<li class="header-ul text-center">You have 10 notifications</li>
								<li>
									<!-- inner menu: contains the actual data -->
									<ul class="menu list-unstyled">
										<li><a href="#"> <i class="fa fa-users text-aqua"></i>
												5 new members joined today
										</a></li>
										<li><a href="#"> <i class="fa fa-warning text-yellow"></i>
												Very long description here that may not fit into the page
												and may cause design problems
										</a></li>
										<li><a href="#"> <i class="fa fa-users text-red"></i>
												5 new members joined
										</a></li>
										<li><a href="#"> <i
												class="fa fa-shopping-cart text-green"></i> 25 sales made
										</a></li>
										<li><a href="#"> <i class="fa fa-user text-red"></i>
												You changed your username
										</a></li>
									</ul>
								</li>
								<li class="footer-ul text-center"><a href="#">View all</a></li>
							</ul>
						</div></li>

					<li class="nav-item dropdown  user-menu"><a
						class="nav-link dropdown-toggle" href="http://example.com"
						id="navbarDropdownMenuLink" data-toggle="dropdown"
						aria-haspopup="true" aria-expanded="false"> <img
							src="http://via.placeholder.com/160x160" class="user-image"
							alt="User Image"> <span class="hidden-xs">bootstrap
								develop</span>
					</a>
						<div class="dropdown-menu"
							aria-labelledby="navbarDropdownMenuLink">
							<a class="dropdown-item" href="#">Action</a> <a
								class="dropdown-item" href="#">Another action</a> <a
								class="dropdown-item" href="#">Something else here</a>
						</div></li>
				</ul>
			</div>
		</nav>
	</header>
	<div class="main">
		<div class="containerflex">
			<div class="flex-grid">
				<aside class="col sidebar">
					<div class="sidebar left ">
						<div class="user-panel">
							<div class="pull-left image">
								<img src="http://via.placeholder.com/160x160"
									class="rounded-circle" alt="User Image">
							</div>
							<div class="pull-left info">
								<p>bootstrap develop</p>
								<a href="#"><i class="fa fa-circle text-success"></i> Online</a>
							</div>
						</div>
						<ul class="list-sidebar bg-defoult">
							<li><a href="#" data-toggle="collapse"
								data-target="#dashboard" class="collapsed active"> <i
									class="fa fa-user"></i> <span class="nav-label"> User
										Administrator </span> <span class="fa fa-chevron-left pull-right"></span>
							</a>
								<ul class="sub-menu collapse" id="dashboard">
									<li class="active"><a href="${contextRoot}/alluser">All
											Users</a></li>
									<li class="active"><a href="${contextRoot}/registeruser">Register
											User</a></li>
											<li class="active"><a href="${contextRoot}/allcustomer">All
											Customers</a></li>
									<!-- 									<li><a href="#">Buttons</a></li>
									<li><a href="#">Tabs & Accordions</a></li>
									<li><a href="#">Typography</a></li> -->
								</ul></li>
							
							
							<li><a href="#" data-toggle="collapse" data-target="#tables"
								class="collapsed active"><i class="fa fa-table"></i> <span
									class="nav-label">Customer</span><span
									class="fa fa-chevron-left pull-right"></span></a>
								<ul class="sub-menu collapse" id="tables">
									<li class="active"><a href="${contextRoot}/allcustomer">All Customers</a></li>
									<li><a href=""> Data Tables</a></li>
									<li><a href=""> Foo Tables</a></li>
									<li><a href=""> jqGrid</a></li>
								</ul></li>
								<li><a href="#" data-toggle="collapse" data-target="#tables"
								class="collapsed active"><i class="fa fa-table"></i> <span
									class="nav-label">Customer</span><span
									class="fa fa-chevron-left pull-right"></span></a>
								<ul class="sub-menu collapse" id="tables">
									<li class="active"><a href="${contextRoot}/allcustomer">All Customers</a></li>
									<li><a href=""> Data Tables</a></li>
									<li><a href=""> Foo Tables</a></li>
									<li><a href=""> jqGrid</a></li>
								</ul></li>
							<li><a href="#" data-toggle="collapse"
								data-target="#e-commerce" class="collapsed active"><i
									class="fa fa-shopping-cart"></i> <span class="nav-label">Product</span><span
									class="fa fa-chevron-left pull-right"></span></a>
								<ul class="sub-menu collapse" id="e-commerce">
									<li><a href=""> Products grid</a></li>
									<li><a href=""> Products list</a></li>
									<li><a href="">Product edit</a></li>
									<li><a href=""> Product detail</a></li>
									<li><a href="">Cart</a></li>
									<li><a href=""> Orders</a></li>
									<li><a href=""> Credit Card form</a></li>
								</ul></li>
							<li><a href=""><i class="fa fa-pie-chart"></i> <span
									class="nav-label">Metrics</span> </a></li>
							<li><a href="#"><i class="fa fa-files-o"></i> <span
									class="nav-label">Other Pages</span></a></li>
							<li><a href="#"><i class="fa fa-files-o"></i> <span
									class="nav-label">Other Pages</span></a></li>
							<li><a href="#"><i class="fa fa-files-o"></i> <span
									class="nav-label">Other Pages</span></a></li>
							<li><a href="#"><i class="fa fa-files-o"></i> <span
									class="nav-label">Other Pages</span></a></li>
							<li><a href="#"><i class="fa fa-files-o"></i> <span
									class="nav-label">Other Pages</span></a></li>
						</ul>
					</div>


				</aside>
				<section class="col main">
					<c:if test="${userClickRegister==true || userClickEdit == true}">
						<div class="student_form col-md-4" style="color: black;">
							<div class="panel panel-primary">
								<div class="panel-heading">
									<h3 align="center">
										<i class="fa fa-user-plus"></i>Register User
									</h3>
								</div>
								<div class="panel-body">
									<c:if test="${user.id != null}">
										<form action="<%=request.getContextPath()%>/updateUser"
											method="post">
									</c:if>
									<c:if test="${user.id == null}">
										<form action="<%=request.getContextPath()%>/adduser"
											method="post">
									</c:if>
									<div class="form-group">
										<label for="id">User ID: </label> <input value="${user.id}"
											name="id" type="text" class="form-control" id="id"
											<c:if test="${user.id == null}">disabled="1"</c:if>" readonly="1">
									</div>

									<div class="form-group">
										<label for="name">Name: </label> <input
											value="${user.userName}" name="name" type="text"
											class="form-control" id="name">
									</div>
									<div class="form-group">
										<label for="pass">Password: </label> <input
											value="${user.passWord}" name="pass" type="password"
											class="form-control" id="pass">
									</div>
									<%-- 				<div class="form-group">
									<label for="phone">Phone:</label> <input
										value="${user.userRole}" name="phone" type="text"
										class="form-control" id="phone">
								</div> --%>

									<c:if test="${user.id != null}">
										<button type="submit" class="btn btn-warning">
											<i class="fa fa-edit"></i> Update
										</button>
										<a href="<%=request.getContextPath()%>/alluser"
											class="btn btn-primary pull-right"><i
											class="fa fa-user-plus"></i> New</a>
									</c:if>

									<c:if test="${user.id == null}">
										<button type="submit" class="btn btn-success">
											<i class="fa fa-send"></i> Submit
										</button>
									</c:if>
									</form>
								</div>
								<div class="panel-footer"></div>
							</div>
						</div>
					</c:if>
						<!-- CUSTOMER LIST -->
					<c:if test="${userClickAllCustomer==true}">
						<div class="header col-md-8">
							<table
								class="table table-bordered table-responsive table-striped">
								<thead>
									<tr>
										<th colspan="5" style="text-align: center;"><h2>
												<i class="fa fa-users"></i> Customer List
											</h2></th>
									</tr>
									<tr>
										<th>Id</th>
										<th>Name</th>
										<th>Phone</th>
										<th colspan="2">Action</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach var="row" items="${customers}">
										<tr>
											<td>${row.id}</td>
											<td>${row.customername}</td>
											<td>${row.phonenumber}</td>
											<td><a
												href="<%= request.getContextPath()%>/editUser/${row.id}"
												class="btn btn-warning"><i class="fa fa-edit"></i> Edit</a></td>
											<td><a
												onclick="return confirm('Are you want to delete this item?')"
												href="<%= request.getContextPath()%>/deleteCustomer/${row.id}"
												class="btn btn-danger"><i class="fa fa-trash"></i>
													Delete</a></td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>
					</c:if>
					<c:if test="${userClickAllUser==true}">
						<div class="header col-md-8">
							<table
								class="table table-bordered table-responsive table-striped">
								<thead>
									<tr>
										<th colspan="5" style="text-align: center;"><h2>
												<i class="fa fa-users"></i> User List
											</h2></th>
									</tr>
									<tr>
										<th>Id</th>
										<th>Name</th>
										<th>Role</th>
										<th colspan="2">Action</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach var="row" items="${users}">
										<tr>
											<td>${row.id}</td>
											<td>${row.userName}</td>
											<td>${row.userRole}</td>
											<td><a
												href="<%= request.getContextPath()%>/editUser/${row.id}"
												class="btn btn-warning"><i class="fa fa-edit"></i> Edit</a></td>
											<td><a
												onclick="return confirm('Are you want to delete this item?')"
												href="<%= request.getContextPath()%>/deleteUser/${row.id}"
												class="btn btn-danger"><i class="fa fa-trash"></i>
													Delete</a></td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>
					</c:if>
				</section>

			</div>
		</div>
	</div>
</div>
	
	<footer class="bg-dark text-white mt-4">
		<section class="index-link">
			<div class="container container-fluid py-3">
				<div class="row">
					<div class="col-md-3">
						<div class="link-area">
							<h3>ABOUT US</h3>
							<P>Building Consensus among your Senior leaders to leverage
								your digital strengths and work on gaps which are hindering your
								growth.</P>
							<li class="fa-li"><a href="#"><i class="fa fa-twitter"
									aria-hidden="true"></i></a></li>
							<li class="fa-li"><a href="#"><i class="fa fa-facebook"
									aria-hidden="true"></i></a></li>
							<li class="fa-li"><a href="#"><i class="fa fa-linkedin"
									aria-hidden="true"></i></a></li>
						</div>
					</div>
					<div class="col-md-3">
						<div class="link-area">
							<h3>PRODUCT</h3>
							<ul>
								<li><a href="#"> Services-1</a></li>
								<li><a href="#"> Services-1</a></li>
								<li><a href="#"> Services-1</a></li>
								<li><a href="#"> Services-1</a></li>
								<li><a href="#"> Services-1</a></li>
							</ul>
						</div>
					</div>
					<div class="col-md-3">
						<div class="link-area">
							<h3>COMPANY</h3>
							<ul>
								<li><a href="#"> Home</a></li>
								<li><a href="#"> Blog</a></li>
								<li><a href="#"> About</a></li>
								<li><a href="#"> contact</a></li>
								<li><a href="#"> Jobs</a></li>
							</ul>
						</div>
					</div>
					<div class="col-md-3">
						<div class="link-area">
							<h3>LEARM MORE</h3>
							<ul>
								<li><a href="#"> Services-1</a></li>
								<li><a href="#"> Services-1</a></li>
								<li><a href="#"> Services-1</a></li>
								<li><a href="#"> Services-1</a></li>
								<li><a href="#"> Services-1</a></li>
							</ul>
						</div>
					</div>
				</div>
			</div>
		</section>
		<section class="index-social">
			<div class="container">
				<div class="row index-social-link text-center">
					<p class="copy-c">WITINNOVATION 2017. Unlocking Digital
						Opportunities.</p>
				</div>
			</div>
		</section>
	</footer>
</body>
</html>