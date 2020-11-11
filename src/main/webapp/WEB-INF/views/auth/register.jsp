<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
	integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
	crossorigin="anonymous">
<script src="http://code.jquery.com/jquery-latest.min.js"></script>

<title>Right now</title>
</head>
<body>
	<!-- partial:partials/header.jsp -->
	<%@ include file="../partials/header.jsp"%>
	<!-- partial -->
	<!-- 채팅 -->

	<form action="/test/register" method ="POST">
		<fieldset>
			<legend>Register</legend>
			<div class="form-group">
				<label>Email address</label> <input type="email" name = "email"
					class="form-control" placeholder="Enter email"> <small
					id="emailHelp" class="form-text text-muted">We'll never
					share your email with anyone else.</small>
			</div>
			<div class="form-group">
				<label>NickName</label> <input type="text" name = "username"
					class="form-control" placeholder="Enter name">
			</div>
			<div class="form-group">
				<label>Password</label> <input type="password" name = "password" class="form-control"
					 placeholder="Password">
			</div>
			<div class="form-group">
				<label>Confirm Password</label> <input type="password" class="form-control"
					 placeholder="Confirm Password">
			</div>
			
			<button type="submit" class="btn btn-primary">Submit</button>
		</fieldset>
	</form>



	<!-- Optional JavaScript -->
	<!-- jQuery first, then Popper.js, then Bootstrap JS -->
	<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"
		integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
		integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"
		integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6"
		crossorigin="anonymous"></script>
</body>
</html>
