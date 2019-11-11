 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 
 
 
 <p class="lead">Shop Name</p>
 
 
<div class="list-group">

	<c:forEach items = "${categories}" var = "category">
		<a href="${contextRoot}/view/category/${category.id}/products" class="list-group-item" id ="a_${category.name}">${category.name}</a> 
	</c:forEach>
</div>