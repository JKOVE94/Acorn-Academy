<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("UTF-8");
%>
<jsp:useBean id="bean" class="pack.buisness.FormBean" />
<jsp:setProperty property="*" name="bean" />
<jsp:useBean id="processDao" class="pack.buisness.ProcessDao" />
<%
boolean b = processDao.insData(bean);
if (b) {
	response.sendRedirect("list.jsp");

}
else{
	response.sendRedirect("fail.jsp");
}
%>