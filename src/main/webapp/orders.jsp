<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="com.aarthi.aarthihotel.model.OrderItem" %>
     
      
    <%@ page import= "java.time.*"%>
     <%@ page import="com.aarthi.aarthihotel.dto.Item" %>
     <%@ page import="com.aarthi.aarthihotel.dto.ItemName" %>
   <%@page import="java.util.List" %>
    <%@page import="java.util.ArrayList" %>
   
<!DOCTYPE html>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<style>
body {
  background-image: url('assets/images/order.jpg');
  background-repeat:no-repeat;
  background-attachment:fixed;
  background-size:100% 100%;
}
</style>
<body>


<%
//HttpSession se=request.getSession(false);
//OrderItems orders=(OrderItems)se.getAttribute("orders");
List<String> itemNames=(List<String>)request.getAttribute("itemNames");
//List<String> list2=new ArrayList<String>();
List<Integer> ids=new ArrayList<Integer>();
Integer userid=(Integer)request.getAttribute("uid");
Integer disamts=(Integer)request.getAttribute("discountamt");
Integer orderid=(Integer)request.getAttribute("order");
Integer amts=(Integer)request.getAttribute("amt");
LocalDateTime time=(LocalDateTime)request.getAttribute("date");
LocalDateTime datetime=(LocalDateTime)request.getAttribute("approx");


%>

<h2>Order Details</h2>


<%
int count=0,count1=0;
//Integer noOfItems=Integer.parseInt(itemNames.get(itemNames.size() - 1));
//out.print(noOfItems);
//String noOfItems=(itemNames.get(itemNames.size() - 1));
String itemName=null,itemName1=null;
List<Item> list1=(List<Item>)request.getAttribute("finallist");
//List<OrderItemDetails> listitems=(List<OrderItemDetails>)request.getAttribute("finallist");
out.print("<table border='3'><tr><th>Order Id</th><th>Ordered Date</th><th>Approx Delivered Date</th><th>Total Amount</th><th>After Discount</th></tr>");
out.print("<tr><td>"+orderid+"</td><td>"+time+"</td><td>"+datetime+"</td><td>Rs."+amts+"</td><td>Rs."+disamts+"</td></tr>");
out.print("</table>");

out.print("</br></br>");%>
<h2>Items Details</h2>

<%out.print("<table border='1'>");
out.print("<tr><th>Order Id</th><th>Item Name</th><th>Quantity</th><th>Total Amounts</th><th>Status</th><th>Order Date</th></tr>");
for(Item id:list1)
{%>
	<tr>
	
	<td><%=id.getOrderId() %></td>
	 <%for(String v:itemNames){
		 itemName=itemNames.get(count); 
		// list2.add(itemName);
	 }%>
	 <td><%=itemName%></td> <% count++;%>
		
		
	
	
    	<%ids.add(id.getItemId()); %>
    	<%request.setAttribute("items",ids);%>
    	
    
	 <!-- <td><%=id.getItemId() %></td>-->
	<td><%=id.getQuantity() %></td>
	<td>Rs.<%=id.getTotalAmount() %></td>
	<td><%=id.getStatus() %></td>
	<td><%=id.getOrderedDate() %></td>
	
	</tr>
<%}
out.print("</table>");

//request.setAttribute("lists",list2);%>

</br></br>
<font size=5>
<% out.print("Your Total Amount is:Rs."+disamts+"");%>
</font>

</br></br>
<form action="PaymentDetails.jsp">
<% out.print("<button type='submit'>Pay</button>");%>

</form>
</br></br>






</body>
</html>