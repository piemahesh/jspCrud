<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="${pageContext.servletContext.contextPath}/userRegister" method="post">
		<input type="email" name="email" placeholder="Enter email" required="required"> <input
			type="text" name="username" placeholder="Enter username" required="required">
		<input type="password" name="password" placeholder="Enter password"
			required="required">
		<button type="submit">register</button>
	</form>
</body>
</html>