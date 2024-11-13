<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("UTF-8");
response.setCharacterEncoding("UTF-8");
%>

<jsp:useBean id="bean" class="pack.buisness.FormBean"/>
<jsp:setProperty property="*" name="bean"/>
<jsp:useBean id="processDao" class="pack.buisness.ProcessDao"/>
<% processDao.upData(bean);
response.sendRedirect("./list.jsp"); // 수정 후 목록보기
%>