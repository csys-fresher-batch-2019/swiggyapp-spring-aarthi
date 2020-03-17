<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<style>
body {
  background-image: url('assets/images/secure.jpg');
  background-repeat:no-repeat;
  background-attachment:fixed;
  background-size:100% 100%;
}
</style>
<body>
<font size=5  color="#1CE1E1">
<center>
<h2>AdminLogin</h2>
<form action="AdminsLogin">

<pre>Enter UserName   :<input type="text" name="username"  placeholder="Enter userName" required autofocus/></pre>
<pre>Enter PassWord   :<input type="password" name="password" placeholder="Enter PassWord" required/></pre>

<button type="submit">submit</button>
</font>
</form>
</center>

</body>
</html>