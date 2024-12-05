<%@page import="pack.buisness.DataDto"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="f"%>


<jsp:useBean id="ProcessDao" class="pack.buisness.ProcessDao"></jsp:useBean>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>회원 정보(Mybatis + Model 1)</h2>
	<a href="ins.jsp">회원 추가</a>
	<table border="1">
		<tr>
			<th>id</th>
			<th>name</th>
			<th>pwd</th>
			<th>date</th>
		</tr>
		<%
		ArrayList<DataDto> list = (ArrayList<DataDto>) ProcessDao.selectAll();
		%>
		<c:set var="list" value="<%=list%>" />
		<c:if test="${empty list}">
			<tr>
				<td colspan="4">자료 없음</td>
			</tr>
		</c:if>
		<c:forEach var="m" items="${list}">
			<tr>
			<td><a href="del.jsp?id=${m.id}">${m.id}</a></td>
			<td><a href="up.jsp?id=${m.id}">${m.name}</a></td>
			<td>${m.passwd}</td>
			<td>${f:substring(m.regdate,0,10)}</td>
		
		</c:forEach>
		<tr>
		<td colspan="4">id 클릭은 삭제, name 클릭은 수정</td>
		</tr>
	</table>
</body>
</html>