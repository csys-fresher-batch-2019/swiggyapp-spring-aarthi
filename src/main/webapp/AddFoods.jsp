<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<style>
body {
  background-image: url('assets/images/sw.jpg');
  background-repeat:no-repeat;
  background-attachment:fixed;
  background-size:100% 100%;
}
</style>
<body>

<font size=5  color="#1CE1E1">
<center>
<h2>AddItems</h2>
<form action="AddFood">
<pre>Enter ItemName:<input type="text" name="itemname" placeholder="Enter itemname" autofocus/></pre>
<pre>Enter FoodType:<input type="text" name="foodtype" placeholder="Enter foodtype"/></pre>
<pre>Enter Price   :<input type="text" name="price" placeholder="Enter price"/></pre>
<pre>Enter MenuIdn :<input type="number" name="menuid"  placeholder="Enter menuid" min="1" max="3"/></pre>
<pre>Enter Images  :<input type="text" name="images" placeholder="Enter images" /></pre>
<button type="submit" >AddItem</button>
</br></br>
<a href="deleteItems.jsp">deleteItems</a>
</br></br>

</font>
</br></br>
</font>
</form>
</center>
</body>
</html>