
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<style>
body {
  background-image: url('assets/images/food3.jpg');
  background-repeat:no-repeat;
  background-attachment:fixed;
  background-size:100% 100%;
}
</style>
<body>

<font size=5  color="#1CE1E1">
<center>
<h2>Login</h2>
<form action="Login">

<pre>Enter Name   :<input type="text" name="name" pattern="^[a-zA-Z]+$" placeholder="Enter Name" required/></pre>
<pre>Enter PhoneNo:<input type="text" name="number" pattern="[0-9]{10}" maxlength="10" placeholder="Enter Phoneno" required/></pre>

<button type="submit">submit</button>

</br></br>
<a href="register.jsp">Register</a>

</form>
</center>


</body>
</html>