<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>Put Your Wishlists here</h1>

	<form method="post" action="${pageContext.servletContext.contextPath}/wishList/create">
		<input type="text" placeholder="Enter product name "
			name="productName" required="required"> <input type="text"
			placeholder="Enter product details " name="productDetails"
			required="required"> <input type="number"
			placeholder="Enter product count " name="count" required="required">
		<button type="submit">create</button>
	</form>

</body>
</html>