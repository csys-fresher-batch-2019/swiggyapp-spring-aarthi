<%@ page import="com.aarthi.aarthihotel.dao.FoodItemDAO" %>
<%@ page import="com.aarthi.aarthihotel.dao.DAOFactory" %>
<%@ page import="com.aarthi.aarthihotel.model.FoodItem" %>
<%@ page import="com.aarthi.aarthihotel.dao.RatingDAO" %>
<%@ page import="com.aarthi.aarthihotel.model.Rating" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<form action="listfoods.jsp">

<%
FoodItemDAO ob=DAOFactory.getFoodItemDAO();
  List<FoodItem> l=new ArrayList<FoodItem>();
  l= ob.findBySearchName("itemname");
  
  %>
<div class="text-block">
<input type="text" name="itemname" > 
  


<button type="submit" >search</button>
<%
for (FoodItem f : l) {%>


<div class="left">
<div class="card-desk">
<div class="card" style="width: 18rem;height: 22rem;">
 <img src="assets/images/<%=f.getImage() %>" class="card-img-top" alt="..." height="180" width="150">
  <div class="card-body">
  <h5 class="card-title"><%=f.getItemId()%> &nbsp <%=f.getItemName() %> &nbsp Rs.<%=f.getPrice() %><input type="hidden" name="price_<%=f.getItemId()%>" value="<%=f.getPrice()%>"></h5>
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


var ch = document.getElementById("ItemId_" + itemId);
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
   
  
    </div>
  </div>
  
  </div>
  </div> 
<%} %>


</form>