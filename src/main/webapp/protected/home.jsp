<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


	<%=session.getAttribute("email")%>
	<h1>
		<%-- 		welcome page <span>${request.getAttribute("username")}</span> --%>
		${username}
	</h1>
	<jsp:include page="/view/logout.jsp"></jsp:include>
	<a
		href="${pageContext.servletContext.contextPath}/protected/about.jsp">about
		page </a>
	<a
		href="${pageContext.servletContext.contextPath}/protected/contact.jsp">contact
		page </a>
		<a
		href="${pageContext.servletContext.contextPath}/protected/wishlists.jsp">add wishlist </a>
</body>
</html>