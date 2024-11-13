<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="processDao" class="pack.buisness.ProcessDao"/>
<%
request.setCharacterEncoding("UTF-8");
String id = request.getParameter("id");

boolean b = processDao.delData(id);

if (b) {
	response.sendRedirect("list.jsp");
}
else{
	response.sendRedirect("fail.jsp");
}
%>