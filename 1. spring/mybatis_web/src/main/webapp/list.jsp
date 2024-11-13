<%@page import="pack.buisness.DataDto"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- useBean은 싱글톤 패턴이다 객체변수-->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="대현"%>
<jsp:useBean id="processDao" class="pack.buisness.ProcessDao" />


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	ArrayList<DataDto> list = (ArrayList) processDao.selectAll();
	%>
	<!-- not physical, 논리적인 요청명 -->
	<h2>** 상품 정보(MyBatis) **</h2>
	<a href="ins.html">상품추가</a><br>
	<div style="color:red">
		코드를 클릭하면 삭제, 품명을 클릭하면 수정!
	</div>
	<table border="1">
		<tr>
			<th>코드</th>
			<th>품명</th>
			<th>수량</th>
			<th>단가</th>
		</tr>

		<대현:forEach var="l" items="<%=list%>">
			<tr>
				<td><a href="delete.jsp?code=${l.code }">${l.code }</a></td>
				<td><a href="update.jsp?code=${l.code }">${l.sang}</a></td>
				<td>${l.su }</td>
				<td>${l.dan}</td>
			</tr>
		</대현:forEach>

	</table>
</body>
</html>