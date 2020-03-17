<form action="listfoods.jsp">

Food Type:
<!-- <select name="foodtype">
<option value="" >ALL </option>
<option value="NV" >NV </option>
<option value="V" >V </option>
<option value="O" >O </option>
</select>
-->
<%
String foodType=  request.getParameter("foodtype");%>
<input type="radio" name="foodtype" value="ALL" <%= "ALL".equals(foodType)?"checked":"" %>/>ALL
 <input type="radio" name="foodtype" value="NV" <%= "NV".equals(foodType)?"checked":"" %>/>NV
          <input type="radio" name="foodtype" value="V" <%= "V".equals(foodType)?"checked":"" %>/>V
          <input type="radio" name="foodtype" value="O" <%= "O".equals(foodType)?"checked":"" %>/>O

<button type="submit">Search</button>
</form>
<br/><br/>
You have selected FoodType: <%=foodType %>