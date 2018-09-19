<%@include file="index.jsp"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<h3 align="center">Category Page</h3>
<br/><br/>
<form action="addCategory" method="post">
<table align="center" width="50%" class="table-bordered">
	<tr class="success">
		<td colspan="2"><center>Category Detail</center></td>
	</tr>
	
	<tr>
		<td>Category Name</td>
		<td><input type="text" name="catname"/></td>
	</tr>

	<tr>
		<td>Category Description</td>
		<td><input type="text" name="catdescription"/></td>
	</tr>

	<tr>
		<td colspan="2">
		<center><input type="submit" value="Insert Category" class="btn success"/></center>
		</td>
	</tr>
</table>
</form>

<table align="center" class="table">
<tr class="success">
	<td colspan="3"><center>Category Details</center></td>
</tr>
<tr>
	<td>Category ID</td>
	<td>Category Name</td>
	<td>Description</td>
	<td>Operation</td>
</tr>
<c:forEach items="${categoryList}" var="category">
<tr>	
	<td>${category.categoryId}</td>
	<td>${category.categoryName}</td>
	<td>${category.categoryDescription}</td>
	<td>
		<a href="<c:url value="/deleteCategory/${category.categoryId}"/>">Delete</a>&nbsp;/&nbsp;
		<a href="<c:url value="/editCategory/${category.categoryId}"/>">Edit</a>
	</td>
</tr>
</c:forEach>
</table>

</body>
</html>