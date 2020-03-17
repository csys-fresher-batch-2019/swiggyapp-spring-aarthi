<%
String param = request.getParameter("rating");
int rating = Integer.parseInt(param);
%>
<% for ( int i=1; i<=5 ;i++) {
    	
    if ( i <= rating) {%>
<span class='fa fa-star checked'></span>
<%}
    else{%>
<span class='fa fa-star'></span>
<% }
    
    }
    
    %>
