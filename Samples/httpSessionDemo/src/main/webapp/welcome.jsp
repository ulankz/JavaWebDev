<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login Succcess</title>
</head>
<body>
	<%
	// allow access only if session exists
	String user = null;
	if(session.getAttribute("user") == null)
	{
		response.sendRedirect("login.jsp");
	}
	else{
		user = (String) session.getAttribute("user");
	}
	String userName = null;
	String sessionID = null;
	Cookie[] cookies = request.getCookies();
	if(cookies != null){
		for(Cookie cookie : cookies){
			if(cookie.getName().equals("user")) userName = cookie.getValue();
			if(cookie.getName().equals("JSESSIONID")) sessionID = cookie.getValue();
		}
	} 
	 %>
	 <h3>HI <%=userName%> , Login successful. Your Session ID= <%=sessionID %></h3>
	 <br>
	 User = <%= user %>
	 <br>
	 <a href = "checkoutPage.jsp">Checkout page</a>
	 <form action="LogoutServlet"  method= "post">
	 	<input type = "submit" value = "Logout">
	 </form>
</body>
</html>