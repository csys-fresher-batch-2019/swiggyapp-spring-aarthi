<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="com.aarthi.aarthihotel.dao.MenuDAO" %>
    <%@ page import="com.aarthi.aarthihotel.dao.DAOFactory" %>
    <%@ page import="com.aarthi.aarthihotel.model.FoodItem" %> 
    <%@ page import="com.aarthi.aarthihotel.dao.RatingDAO" %>
    <%@ page import="com.aarthi.aarthihotel.model.Rating" %>
    <%@ page import="java.util.List" %>
    <%@ page import="java.util.ArrayList" %>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<style>
.checked {
  color: orange;
}
.left{
float:left;
padding-left:10px;
padding-right:20px;
padding-top:20px;
padding-bottom:20px;
}

</style>
<body style='background-color:"#F7F9F9";'> 
<body>
<%MenuDAO obj=DAOFactory.getMenuDAO(); 
List<FoodItem> l=new ArrayList<FoodItem>();
l= obj.findFoods();
for (FoodItem f : l) {%>
<div class="left">
<div class="card-desk">
<div class="card" style="width: 18rem;height: 22rem;">
 <img src="assets/images/<%=f.getImage() %>" class="card-img-top" alt="..." height="180" width="150">
  <div class="card-body">
  <h5 class="card-title"><%=f.getItemName() %> &nbsp Rs.<%=f.getPrice() %><input type="hidden" name="price_<%=f.getItemId()%>" value="<%=f.getPrice()%>"></h5>
    <h5 class="card-title"><span class ="btn btn-success btn-sm"><%=f.getFoodType() %>   </span></h5>
    <% RatingDAO ob=DAOFactory.getRatingDAO();  %>
    <h5 class="card-title">Ratings:
    
    <% int rating=ob.findRate(f.getItemName());
    %>
  	<jsp:include page="ratings.jsp">
  		<jsp:param value="<%=rating %>" name="rating"/>
  	</jsp:include> 
    
     
    </div>
  </div>
  
  </div>
  </div> 
<%} %>

    

</body>
</html>