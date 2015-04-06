<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>IMS</title>
</head>
<body>
	Here you can configure product Category.
	
	<form action="category" method="post" >
	
		
		Category Name : <input type="text" name="category_name"/>
		<br/>
		Description :<textarea name="category_desc" rows="10" cols="10"></textarea>
		<br/>
		<input type="submit" value="Save My Category"/>
		
	</form>
</body>
</html>