<%@page import="java.net.HttpCookie"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
//HttpSession sess = request.getSession(false);
//`sess.invalidate();
//sess.removeAttribute("userid"); //권장

//쿠키에서 JWT를 제거
Cookie jwtCookie = new Cookie("jwt", "");
jwtCookie.setMaxAge(0);
response.addCookie(jwtCookie);

response.sendRedirect("login.html");

%>