<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="com.aarthi.aarthihotel.dto.Item" %>
    <%@ page import="java.util.List" %>
<!DOCTYPE html >
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
HttpSession sess=request.getSession(false);
out.print("<font size='5'>");
out.print("<pre>orderId :<input type='text' name='name'></pre>");
//out.print("</br></br>");
Integer userId=(Integer)sess.getAttribute("UserId");
out.print("<pre>userId  :<input type='text' name='name' value="+userId+"></pre>");


/*String name=(String)sess.getAttribute("name");
out.print("<pre>Name    :<input type='text' name='name' value="+name+"></pre>");

Long phoneNo=(Long)sess.getAttribute("phoneno");
out.print("<pre>PhoneNo :<input type='number' name='name' value="+phoneNo+"></pre>");*/
out.println("<pre>Items List:</pre>");
out.println("<table  cellspacing='5'><tr><th>ItemId</th><th>ItemName</th><th>Price</th><th>Quantity</th><th>Amounts</th></tr>");

List<Item> list1=(List<Item>)request.getAttribute("itemList");
List<Integer> quants=(List<Integer>)request.getAttribute("quantity");
List<Integer> amount=(List<Integer>)request.getAttribute("amounts");
int count=0;
for(Item list:list1)
{%>
	  <tr>
      
      
      
      
      <% 
     
      int quan=0;
      int totamount=0;
      for(int i=0;i<quants.size();i++)
      {
    	  
    	  quan=quants.get(count); 
    	 }%>
    	<td><%=quan%></td> 
      <% 
      for(int i=0;i<amount.size();i++)
      {
    	  
    	  totamount=amount.get(count); 
    	 }%>
    	<td><%=totamount%></td> <% count++;%>
      
      </tr>
	
	
	
<%}
out.print("</table>");
//Integer totalAmt=(Integer)sess.getAttribute("totalAmts");
out.print("</br>");
out.print("TotalAmounts: "+request.getAttribute("totalAmts"));
%>


</body>
</html>