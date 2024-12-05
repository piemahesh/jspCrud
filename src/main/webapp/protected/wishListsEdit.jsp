<%@page import="curd_proj.model.WishList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
input {
	width: 100%;
	max-width: 450px;
	margin-top: 15px;
}
</style>
</head>
<body>
	<h1>Edit Your Wishlists here</h1>

	<%=request.getAttribute("id")%>
	<%
	WishList wl = (WishList) request.getAttribute("wishList");
	%>

	<form method="post"
		action="<%=request.getContextPath()%>/wishList/update/<%=request.getAttribute("id")%>">
		<input type="text" placeholder="Enter product name "
			name="productName" required="required"
			value="<%=wl.getProductName()%>"> <br> <input
			type="text" value="<%=wl.getProductDetails()%>"
			placeholder="Enter product details " name="productDetails"
			required="required"><br> <input type="number"
			value="<%=wl.getCount()%>" placeholder="Enter product count "
			name="count" required="required"> <br>
		<button type="submit">Update</button>
	</form>
</body>
</html>