<%@page import="com.ims.pojo.Category"%>
<div>
	You can edit your category over here.
	<% 
		Category ct=(Category)request.getAttribute("category");
	%>
	
	<form action="category" method="post">
		Name is : <input type="text" name="category_name" value="<%=ct.getName() %>"/>
		<br/>
		Description is:<input type="text" name="category_desc" value="<%=ct.getDescription() %>"/>
		<input type="hidden" name="category_id" value="<%=ct.getId() %>"/>
		<br/>
		<input type="submit" value="Submit"/>
	</form> 
	
	
</div>

