<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>My Swiggy Hotel</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<style>
body {
	background-image: url('assets/images/image.jpg');
	background-repeat: no-repeat;
	background-attachment: fixed;
	background-size: 100% 100%;
}

.left {
	float: right;
	padding-left: 60px;
}
</style>
<body>

	<nav class="navbar navbar-inverse">
		<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-brand" href="#">My Swiggy Hotel</a>
			</div>
			<ul class="nav navbar-nav">
				<li class="dropdown"><a class="dropdown-toggle"
					data-toggle="dropdown" href="#">Menus <span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="Food.jsp">Foods</a></li>
						<li><a href="Snacks.jsp">Snacks and Shakes</a></li>
						<li><a href="Desserts.jsp">Desserts</a></li>
					</ul></li>
				<li><a href="AdminLogin.jsp">AdminLogin</a></li>
				<li><a href="login.jsp">Login</a></li>
				<li><a href="Logout.jsp">Logout</a></li>
			</ul>
		</div>
	</nav>



</body>
</html>



