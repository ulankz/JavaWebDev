<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login Success Page</title>
</head>
<body>
<% 
	String userName = null;
	Cookie[] cookies = request.getCookies();
	if(cookies != null){
		for(Cookie cookie : cookies){
			if(cookie.getName().equals("user"))
				userName = cookie.getValue();
		}
	}
if(userName == null)
	response.sendRedirect("login.jsp");
%>
<h3> Hi <%=userName %>, Logged successfully!</h3>
<br>
<form action="LogoutServlet" method = "post">
	<input type = "submit" value = "Logout"/>
</form>
</body>
</html>