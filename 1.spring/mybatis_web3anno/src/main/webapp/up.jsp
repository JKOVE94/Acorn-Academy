<%@page import="pack.buisness.DataDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%request.setCharacterEncoding("UTF-8");
String id = request.getParameter("id");%>
<jsp:useBean id="processDao" class="pack.buisness.ProcessDao"/>

<%DataDto dto = (DataDto)processDao.selectPart(id); %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2> * 회원 수정 * </h2>
	<form method="post" action="upok.jsp">
		id: <input type="text" name="id" readonly="readonly" value="<%=dto.getId()%>"><br/>
		name : <input type="text" name="name" value="<%=dto.getName()%>" ><br/>
		password : <input type="password" name="passwd"><br/>
		<input type="submit" value="수정">
	</form>

</body>
</html>