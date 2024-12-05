<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
HttpSession sess = request.getSession(false);
//`sess.invalidate();
sess.removeAttribute("userid"); //권장

response.sendRedirect("login.html");

%>