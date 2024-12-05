<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<% HttpSession ses = request.getSession(false);
if(ses != null && ses.getAttribute("userid") != null ){
	String userId = (String) ses.getAttribute("userid");
%>
<body>
	<h2>로그인 성공 페이지 (인가)</h2>
	<%=userId %>님 환영합니다  
<pre>
이런 저런 작업이 가능
</pre>
<br>
<a href="logout.jsp">로그아웃</a>
<%
}else{
	response.sendRedirect("login.html");
}
%>
	
</body>
</html>