<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String id = request.getParameter("id");
String pwd = request.getParameter("pwd");

//자격 증명 확인 (DB 생략)
String validId = "ok";
String validPwd = "123";

//인증 
if(id != null & pwd != null && id.equals(validId) && pwd.equals(validPwd)){
	//자격 증명이 유효하면 Session 생성
	HttpSession httpSession = request.getSession();
	httpSession.setAttribute("userid", id);
	
	response.sendRedirect("success.jsp");
}
else{
	out.println("<html><body>");
	out.println("<h3>로그인 실패</h3>");
	out.println("<a href='login.html'>다시 로그인</a>");
	out.println("</body></html>");
}
%>