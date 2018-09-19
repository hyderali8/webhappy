<%@include file="index.jsp"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<h3 align="center">Category Page</h3>
<br/><br/>
<form action="<c:url value="/updateCategory"/>" method="post">
<table align="center" width="50%" class="table-bordered">
	<tr class="success">
		<td colspan="2"><center>Category Detail</center></td>
	</tr>
	
	<tr>
		<td>Category Id</td>
		<td><input type="text" name="categoryId" value="${category.categoryId}" readonly/></td>
	</tr>
	
	<tr>
		<td>Category Name</td>
		<td><input type="text" name="catname" value="${category.categoryName}"/></td>
	</tr>

	<tr>
		<td>Category Description</td>
		<td><input type="text" name="catdesc" value="${category.categoryDescription}"/></td>
	</tr>

	<tr>
		<td colspan="2">
		<center><input type="submit" value="Update Category" class="btn success"/></center>
		</td>
	</tr>
</table>
</form>

</body>
