<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="${pageContext.servletContext.contextPath}/userLogin"
		method="post">
		<input type="email" name="email" placeholder="Enter email"> <input
			type="password" name="password" placeholder="Enter password">
		<button type="submit">login</button>
	</form>

</body>
</html>