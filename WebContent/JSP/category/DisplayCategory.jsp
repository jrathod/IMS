<%@page import="com.ims.pojo.Category"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE>

<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	
	<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
	<title>IMS</title>
<!-- 	<script>
  		$(document).ready(function() {
			//$('#edit').css('display','block');	
		} );
  	</script> -->
	
</head>
<body>
	
	<table border="1">
		<thead>
			<tr>
				<th>Name</th>
				<th>Category</th>
			</tr>
		</thead>
		<tbody>
			<%
				List<Category> cList= (List<Category>)request.getAttribute("categoryList");
				for(Category c:cList){
			%>
				<tr>
					
					<td>
						<input type="text" value="<%= c.getName()%>" readonly="true" ondblclick="this.readonly='';"/>
					</td>
					<td>
						<input type="text" value="<%= c.getDescription()	%>" readonly="true" ondblclick="this.readonly='';"/>
					</td>
					<td>
						<a href="category?action=edit&category_id=<%=c.getId() %>">Update</a>
					</td>
					<td>
						<a href="category?action=delete&category_id=<%=c.getId() %>">Delete</a>
					</td>
				</tr>
			<%
				}
			%>
		
		
		</tbody>
	</table>
	
	<p><a href="categoryAdd.jsp">Add Category</a></p>
</body>
</html>