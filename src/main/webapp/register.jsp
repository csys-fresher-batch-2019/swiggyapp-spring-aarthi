
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<style>
body {
  background-image: url('assets/images/food1.jpg');
  background-repeat:no-repeat;
  background-attachment:fixed;
  background-size:100% 100%;
}
</style>

<body>

<font size=6  color="#F1C40F">
<center>
<h2>HotelApp</h2>
</center>
<h3>Registration</h3>
</font>

<font size=6  color="#F1C40F">
<form action="Register">
<pre>Enter Name    :<input type="text" name="name" pattern="^[0-9a-zA-Z]+$"
placeholder="Enter Name" required autofocus/>
</pre>
<pre>Enter PhoneNo :<input type="text" name="phoneno"
pattern="[0-9]{10}" maxlength="10" placeholder="Enter 10 digit PhoneNo" required/>
</pre>
<pre>Enter Address :<textarea type="textarea" name="address" rows="3" cols="20"
placeholder="Enter address" required/>
</textarea>
</pre>
<pre>Enter city    :<select name="cities">
<option value="Tuticorin">Tuticorin</option>
<option value="Tirunelveli">Tirunelveli</option>
<option value="Chennai">Chennai</option>
<option value="Madurai">Madurai</option>
</select>
</pre>

<button type="submit">Register</button>
<br/>
<!-- <font size=6  color="#F1C40F">
<a href="login.jsp">Login</a>
</font>-->
</form>
</font>
</body>
</body>
</html>