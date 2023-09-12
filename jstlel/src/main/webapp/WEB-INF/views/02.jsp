<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="servlets.UserVo"%>
<%
	// page scope
	UserVo vo0 = new UserVo();
	vo0.setNo(0L);
	vo0.setName("둘리0");
	
	pageContext.setAttribute("vo", vo0);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h4>scope(객체의 존속 범위)</h4>
	${vo.no}<br>
	${vo.name}<br>
	
	<h4>== request scope ============= </h4>
	${requestScope.vo.no}<br>
	${requestScope.vo.name}<br>
	
	<h4>== session scope ============= </h4>
	${sessionScope.vo.no}<br>
	${sessionScope.vo.name}<br>
	
	<h4>== application scope ============= </h4>
	${applicationScope.vo.no}<br>
	${applicationScope.vo.name}<br>
</body>
</html>