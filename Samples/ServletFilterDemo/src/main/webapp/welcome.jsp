<html>
<head>
<title>Welcome page!</title>
</head>
<body>
<%
	String user = (String) session.getAttribute("user");
	String userName = null;
	String sessionID = null;
	Cookie[] cookies = request.getCookies();
	if(cookies!=null)
		for(Cookie cookie : cookies){
			if(cookie.getName().equals("user")) userName  = cookie.getValue();
			if(cookie.getName().equals("JSESSIONID")) sessionID = cookie.getValue();
		}
	
%>
<h3>
	Hi <%=userName %>, Login successful. Your Session ID= <%=sessionID %>
</h3>
User<%=user %>
<br>
<a href = "checkout.jsp"> Checkout page</a>
<form action="LogoutServlet" method = "post">
	<input type="submit" value="Logout">
</form>
</body>
</html>
