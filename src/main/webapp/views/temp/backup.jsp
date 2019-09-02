<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
<meta charset="ISO-8859-1" />
<title>Insert title here</title>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1" />
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css" />
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js"></script>
<script src="/postrequest.js"></script>
<script src="/getrequest.js"></script>
</head>
<body>
	<div id="postResultDiv" align="center"></div>
	<div class="container">
		<h2>Stacked form</h2>
		<form id="bookForm">
			<div class="form-group">
				<label for="bookId">Book ID:</label> <input type="text"
					class="form-control" id="bookId" placeholder="Enter Book Id"
					name="bookId">
			</div>
			<div class="form-group">
				<label for="bookName">Book Name:</label> <input type="text"
					class="form-control" id="bookName" placeholder="Enter Book Name"
					name="bookName">
			</div>
			<div class="form-group">
				<label for="author">Author :</label> <input type="text"
					class="form-control" id="author" placeholder="Enter Author name"
					name="author">
			</div>
			<div class="form-group form-check">
				<label class="form-check-label"> <input
					class="form-check-input" type="checkbox" name="remember">
					Remember me
				</label>
			</div>
			<button type="submit" class="btn btn-primary">Submit</button>
		</form>
		<br />
		<div class="col-sm-7" style="margin: 20px 0px 20px 0px">
			<button id="getALlBooks" type="button" class="btn btn-primary">Get
				All Books</button>
			<div id="getResultDiv" style="padding: 20px 10px 20px 50px">
				<ul class="list-group">
				</ul>
			</div>
		</div>
	</div>
</body>




<script type="text/javascript">
$(document).ready(
		function() {

			// GET REQUEST
			$("#getALlBooks").click(function(event) {
				event.preventDefault();
				ajaxGet();
			});

			// DO GET
			function ajaxGet() {
				$.ajax({
					type : "GET",
					url : "getBooks",
					success : function(result) {
						if (result.status == "success") {
							$('#getResultDiv ul').empty();
							var custList = "";
							$.each(result.data,
									function(i, book) {
										var user = "Book Name  "
												+ book.bookName
												+ ", Author  = " + book.author
												+ "<br>";
										$('#getResultDiv .list-group').append(
												user)
									});
							console.log("Success: ", result);
						} else {
							$("#getResultDiv").html("<strong>Error</strong>");
							console.log("Fail: ", result);
						}
					},
					error : function(e) {
						$("#getResultDiv").html("<strong>Error</strong>");
						console.log("ERROR: ", e);
					}
				});
			}
		})
		
		
	// == == == == == == == == == == == == == == == == == //
	$(document).ready(
		function() {

			// SUBMIT FORM
			$("#bookForm").submit(function(event) {
				// Prevent the form from submitting via the browser.
				event.preventDefault();
				ajaxPost();
			});

			function ajaxPost() {

				// PREPARE FORM DATA
				var formData = {
					bookId : $("#bookId").val(),
					bookName : $("#bookName").val(),
					author : $("#author").val()
				}

				// DO POST
				$.ajax({
					type : "POST",
					contentType : "application/json",
					url : "saveBook",
					data : JSON.stringify(formData),
					dataType : 'json',
					success : function(result) {
						if (result.status == "success") {
							$("#postResultDiv").html(
									"" + result.data.bookName
											+ "Post Successfully! <br>"
											+ "---> Congrats !!" + "</p>");
						} else {
							$("#postResultDiv").html("<strong>Error</strong>");
						}
						console.log(result);
					},
					error : function(e) {
						alert("Error!")
						console.log("ERROR: ", e);
					}
				});

			}

		})
	
	
</script>

</html>