<%@include file="index.jsp"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<h3 align="center">Product Page</h3>
<br/><br/>

<form:form action="addProduct" modelAttribute="product" command="product" method="post">

<table align="center" class="table-bordered">

<tr>
	<td colspan="2"><center>Product Detail </center></td>
</tr>

<tr>
	<td> Product Name</td>
	<td> <form:input path="productName"/></td>
</tr>

<tr>
	<td> Product Description</td>
	<td> <form:input path="productDesc"/></td>
</tr>

<tr>	
	<td> Cost </td>
	<td> <form:input path="price"/></td>
</tr>

<tr>
	<td>Category</td>
	<td> <form:select path="categoryId">
		 	<form:option value="0" label="--Select Category--"/>
		 	<form:options items="${categoryList}"/>
		 </form:select>
	</td>
</tr>

<tr>
	<td>Deal</td>
	<td> <form:select path="dealId">
		 <form:option value="0" label="--Select Deal--"/>
		 </form:select>
	</td>
</tr>

<tr>
	<td colspan="2"><center><input type="submit" value="Insert Product"/></center></td>
</tr>

</table>

</form:form>

<br/><br/>

<table align="center" class="table">
<tr class="success">
	<td colspan="7"><center>Product Details</center></td>
</tr>
<tr>
	<td>Product ID</td>
	<td>Product Name</td>
	<td>Description</td>
	<td>Cost</td>
	<td>Category ID</td>
	<td>Deal Id</td>
	<td>Operation</td>
</tr>
<c:forEach items="${productList}" var="product">
<tr>	
	<td>${product.productId}</td>
	<td>${product.productName}</td>
	<td>${product.productDesc}</td>
	<td>${product.Cost}</td>
	<td>${product.categoryId}</td>
	<td>${product.dealId}</td>
	<td>
		<a href="<c:url value="/deleteProduct/${product.productId}"/>">Delete</a>&nbsp;/&nbsp;
		<a href="<c:url value="/editProduct/${product.productId}"/>">Edit</a>
	</td>
</tr>
</c:forEach>
</table>


