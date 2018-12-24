<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Welcome page</title>
</head>
<body>
	<% 
		String user = null;
		if(session.getAttribute("user") == null)
		{
			response.sendRedirect("login.jsp");
		}
		else{
			user =  (String) session.getAttribute("user");
		}
		String userName = null;
		String sessionID = null;
		Cookie[] cookies = request.getCookies();
		if(cookies!=null)
			for(Cookie cookie : cookies){
				if(cookie.getName().equals("user")) userName = cookie.getValue();
				if(cookie.getName().equals("JSESSIONID")) sessionID = cookie.getValue();
			}
		else{
			sessionID = session.getId();
		}
	%>
	<h3>
		Hi <%=userName %>, Login successfull. Your Session ID= <%=sessionID%>
	</h3>
	<br>
	User= <%=user%>
	<br>
	<a href = "<%= response.encodeURL("checkout.jsp")%>">Checkout page</a>
	<form action="<%=response.encodeURL("LogoutServlet") %>" method="post">
		<input type = "submit" value = "Logout"/>
	</form>
</body>
</html>