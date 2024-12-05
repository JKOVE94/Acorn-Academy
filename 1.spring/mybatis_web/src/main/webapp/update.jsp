<%@page import="pack.buisness.DataDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:useBean id="processDao" class="pack.buisness.ProcessDao" />
<%
String code = request.getParameter("code");

DataDto dto = processDao.selectPart(code);
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="updateok.jsp" method="post">
		코드 : <input type="text" name="code" value="<%=dto.getCode()%>" readonly="readonly"><br />
		품명 : <input type="text" name="sang" value="<%=dto.getSang()%>"><br />
		수량 : <input type="text" name="su" value="<%=dto.getSu()%>"><br />
		단가 : <input type="text" name="dan" value="<%=dto.getDan()%>"><br />
		<input type="submit" value="수정">
</body>
</html>