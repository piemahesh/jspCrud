<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%
	// application => servletContext instance => scope: {application - wide}
	// to share the data across the entire application
	// it accessible in all sessions and request
	// life time is till restart or shutdown
	// sharing global data

	// accessible in jsp through session obj
	// specific to a user (scope:specific user)
	%>
	
	<form action="${pageContext.servletContext.contextPath}/userLogin"
		method="post">
		<input type="email" name="email" placeholder="Enter email"> <input
			type="password" name="password" placeholder="Enter password">
		<button type="submit">login</button>
	</form>


</body>
</html>