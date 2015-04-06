<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>IMS</title>
</head>
<body>
	Hello <%=request.getAttribute("username") %>
	<br/>
	<%= new java.util.Date() %>
	<br/>
	<a href="ListCategory.jsp">Product Categories</a>
	<a href="">Product Detail</a>
	<a href="">Sales Detail</a>
</body>
</html>