<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ page import="com.aarthi.aarthihotel.dao.FoodItemDAO" %>
<%@ page import="com.aarthi.aarthihotel.dao.DAOFactory" %>
<%@ page import="com.aarthi.aarthihotel.model.FoodItem" %>
<%@ page import="com.aarthi.aarthihotel.dao.RatingDAO" %>
<%@ page import="com.aarthi.aarthihotel.model.Rating" %>

<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>


<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<style>
.text-block
{
   position:absolute;
   top:20px;
   right:20px;
}

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
<form action="SearchFoods" method="get">
<div class="text-block">
<input type="text" name="itemname" > 
 <button type="submit" >search</button>
 </div>
</form>
<!-- <form action="searchfood.jsp">
<div class="text-block">
<button type="submit">SearchByFoodName</button>
</div>
</form>-->

<br/><br/>

<h2>List Foods</h2>
<%
String foodType=  request.getParameter("foodtype");
String itemname = request.getParameter("itemname");
%>
<%

 List<FoodItem> ls=(List<FoodItem>) request.getAttribute("searchlist");%>	 
 

<jsp:include page="FoodTypeFilter.jsp">
  		<jsp:param value="<%=foodType %>" name="foodtype"/>
  	</jsp:include> 



</br></br>
<form action="ItemLists">

<%
   FoodItemDAO ob=DAOFactory.getFoodItemDAO();
   List<FoodItem> l=new ArrayList<FoodItem>();

  l= ob.findAll();

  //l=ob.getFoodsDetailsBySearchName("item");
  
  %>
  


<pre>
<button type="sumbit">Order</button>
</pre>
<%

if(ls==null){
for (FoodItem f : l) {%>

<%if ( foodType == null || "".equals(foodType) || f.getFoodType().equals(foodType) ||"ALL".equals(foodType)) {%>

<div class="left">
<div class="card-desk">
<div class="card" style="width: 18rem;height: 22rem;">
 <img src="assets/images/<%=f.getImage() %>" class="card-img-top" alt="..." height="180" width="150">
  <div class="card-body">
  <h5 class="card-title"> <%=f.getItemName() %> &nbsp Rs.<%=f.getPrice() %><input type="hidden" name="price_<%=f.getItemId()%>" value="<%=f.getPrice()%>"></h5>
    <h5 class="card-title"><span class ="btn btn-success btn-sm"><%=f.getFoodType() %>   </span> &nbsp <input type="checkbox" name="itemId" id="ItemId_<%=f.getItemId()%>"
onchange="disable(<%=f.getItemId()%>)"value="<%=f.getItemId()%>">  &nbsp <select name="qty_<%=f.getItemId()%>"
onchange="disable(<%=f.getItemId()%>)" autofocus>
<option value="0">0</option>
<option value="1">1</option>
<option value="2">2</option>
<option value="3">3</option>
<option value="4">4</option>
<option value="5">5</option>
<option value="6">6</option>
</select>
<script>
function disable(itemId) {


var ch = document.getElementById("ItemId_" +itemId);
if (ch.checked){
ch.checked=false;
}
else{ 
ch.checked=true;
}
}
</script>




 </h5>
    <% RatingDAO obj=DAOFactory.getRatingDAO();  %>
    <h5 class="card-title">Ratings:
    
    <% int rating=obj.findRate(f.getItemName());
    %>
  	<jsp:include page="ratings.jsp">
  		<jsp:param value="<%=rating %>" name="rating"/>
  	</jsp:include> 
    
     </h5>
   
  <%  
 
   } %>
    </div>
  </div>
  
  </div>
  </div> 
<%}}
else{%>


	 
 <%for(FoodItem f:ls) {%>

<div class="left">
<div class="card-desk" class="left">

<div class="card" style="width: 18rem;height: 22rem;">
 <img src="assets/images/<%=f.getImage() %>" class="card-img-top" alt="..." height="180" width="150">
  <div class="card-body">
  <h5 class="card-title"> <%=f.getItemName() %> &nbsp Rs.<%=f.getPrice() %><input type="hidden" name="price_<%=f.getItemId()%>" value="<%=f.getPrice()%>"></h5>
    <h5 class="card-title"><span class ="btn btn-success btn-sm"><%=f.getFoodType() %>   </span> &nbsp <input type="checkbox" name="itemId" id="ItemId_<%=f.getItemId()%>"
onchange="disable(<%=f.getItemId()%>)"value="<%=f.getItemId()%>">  &nbsp <select name="qty_<%=f.getItemId()%>"
onchange="disable(<%=f.getItemId()%>)" autofocus>
<option value="0">0</option>
<option value="1">1</option>
<option value="2">2</option>
<option value="3">3</option>
<option value="4">4</option>
<option value="5">5</option>
<option value="6">6</option>
</select>
<script>
function disable(itemId) {


var ch1 = document.getElementById("ItemId_" +itemId);
if (ch1.checked){
ch1.checked=false;
}
else{ 
ch1.checked=true;
}
}
</script>




 </h5>
    <% RatingDAO obj=DAOFactory.getRatingDAO();  %>
    <h5 class="card-title">Ratings:
    
    <% Integer rating=obj.findRate(f.getItemName());
    if(rating != null){
    %>
  	<jsp:include page="ratings.jsp">
  		<jsp:param value="<%=rating %>" name="rating"/>
  	</jsp:include> 
  	<%} %>
    
     </h5>
   
 
    </div>
    </div>
    </div>
    </div>
 
  <% } %> 
  <% }
 %>




<br/><br/>



<!-- <a href="orderfood.jsp" class="btn btn-primary">Order</a>-->

</form>
</body>
</html>
