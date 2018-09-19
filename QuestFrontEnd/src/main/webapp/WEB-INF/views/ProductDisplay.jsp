<%@include file="index.jsp"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<table align="center" class="table">
<tr class="success">
	<td colspan="4"><center>Product Details</center></td>
</tr>
<tr>
	<td>Product Name</td>
	<td>Description</td>
	<td>Cost</td>
	<td>Quantity</td>
	<td></td>
</tr>
<c:forEach items="${productList}" var="product">
<tr>	
	<td>${product.productName}</td>
	<td>${product.productDesc}</td>
	<td>${product.cost}</td>
	<td><input type="text" name="quantity"/></td>
	<td>
		<a href="<c:url value="/addToCart/${product.productId}"/>">AddToCart</a>
	</td>
</tr>
</c:forEach>
</table>