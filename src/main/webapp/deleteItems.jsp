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
  background-image: url('assets/images/dkitem.jpg');
  background-repeat:no-repeat;
  background-attachment:fixed;
  background-size:100% 100%;
}
</style>
<body>
<font size=4  color="#1CE1E1">
<h1>Delete Items</h1>
<form action="deleteFood">
Enter itemname:<input type="text" name="itemname" Placeholder="Enter ItemName" autofocus/>
</br></br>
<button type="submit">DeleteItem</button>
</form>

</body>
</html>