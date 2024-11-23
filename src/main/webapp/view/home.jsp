<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="auth.jsp"></jsp:include>
	
	<%=session.getAttribute("email")%>
	<h1>
		<%-- 		welcome page <span>${request.getAttribute("username")}</span> --%>
		${username}
	</h1>
	<jsp:include page="logout.jsp"></jsp:include>
	<a href="${pageContext.servletContext.contextPath}/view/about.jsp">about
		page </a>
	<a href="${pageContext.servletContext.contextPath}/view/contact.jsp">contact
		page </a>
</body>
</html>