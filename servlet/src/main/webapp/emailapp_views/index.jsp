<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Send Mail</title>
</head>
<body>
<form action="mail" method = "post">
To:<input type ="text" name = "to" /><br/>
Subject:<input type ="text" name = "subject"/></br>
Message:<input type = "text" name = "message"/></br>
Your email id:<input type="text" name ="user"/></br>
Password:<input type = "password" name = "password"/></br>
<input type = "submit" value = "send"/>
</form>
</body>
</html>