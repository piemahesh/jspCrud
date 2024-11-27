<%@page import="java.sql.Timestamp"%>
<%@page import="java.time.LocalDateTime"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%!int a = 10;
	String name = "ocean";%>
	<%=a%>
	<p>${name}</p>
	<h1>this is about page</h1>
	
	<% 
// 	response.sendRedirect("/crud_proj/protected/contact.jsp");
	
	%>
<%-- 	<%= LocalDateTime.now() %> --%>
	<%= new Timestamp(System.currentTimeMillis()) %>
	
	<!-- user=> valid {you are valid user} is not valid {you are not valid user} -->
	
<%-- 	<jsp:forward page="/protected/contact.jsp"></jsp:forward> --%>
	
	<!-- 	/crud_proj/src/main/java/crud_proj/utils/Color.java -->
<%-- 	<jsp:useBean id="user" class="crud_proj.utils.Color" --%>
<%-- 		scope="application"></jsp:useBean> --%>
<%-- 	<jsp:setProperty property="NORMCOLOR" name="user" value="blue" /> --%>
<%-- 	<jsp:getProperty property="NORMCOLOR" name="user" /> --%>
	
<!-- Color user = new Color(); user.setNORMCOLOR("blue"); user.getProperty();  -->
	
	
<%-- 	<%=user.getNORMCOLOR()%> --%>
	
<%-- 	<div style="color: ${color}; font-size: 34px;"> --%>
<%-- 		<%=user.getNORMCOLOR()%> --%>
<!-- 	</div> -->


	<%-- <jsp:include page=""></jsp:include> --%>
</body>
</html>