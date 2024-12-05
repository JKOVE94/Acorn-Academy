<%@page import="java.util.Base64"%>
<%@page import="io.jsonwebtoken.security.Keys"%>
<%@page import="java.security.Key"%>
<%@page import="io.jsonwebtoken.JwtException"%>
<%@page import="io.jsonwebtoken.Jwts"%>
<%@page import="io.jsonwebtoken.Claims"%>
<%@page import="io.jsonwebtoken.Jws"%>
<%@page import="java.net.HttpCookie"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<%
//HttpSession ses = request.getSession(false);
//if(ses != null && ses.getAttribute("userid") != null ){
//String userId = (String) ses.getAttribute("userid");

//쿠키에서 JWT를 읽어 유효성 검사
Cookie[] cookies = request.getCookies();
String jwt = null;

if (cookies != null) {
	for (Cookie cook : cookies) {
		if (cook.getName().equals("jwt")) {
	jwt = cook.getValue();
	break;
		}
	}
}

if (jwt != null) {
	try {

		 // 고정된 비밀 키 사용 (예제용)  최소 256비트 길이의 비밀 키
	    // String secretKeyString = "mySuperSecretKey12345678901234567890123456789012"; 
	    // Key secretKey = Keys.hmacShaKeyFor(secretKeyString.getBytes());
	    
	    // 위의 작업을 주석 처리하고 아래 내용으로 변경하자.

	    // 서블릿 컨텍스트에서 Base64로 인코딩된 비밀 키 가져오기  java.util.Base64
	    String encodedKey = (String) getServletContext().getAttribute("secretKey");
	    byte[] decodedKey = Base64.getDecoder().decode(encodedKey);
	    Key secretKey = Keys.hmacShaKeyFor(decodedKey);
	    
		//JWT 유효성 검사
		Jws<Claims> claims = Jwts.parserBuilder().setSigningKey(secretKey).build().parseClaimsJws(jwt);
		String userId = claims.getBody().getSubject();
%>

	<h2>로그인 성공 페이지 (인가)</h2>
	<%=userId%>님 환영합니다
	<pre>
이런 저런 작업이 가능
</pre>
	<br>
	<a href="logout.jsp">로그아웃</a>

<%		
	} catch (JwtException e) {
		//JWT가 유효하지 않은 경우 Login 페이지로 이동
		response.sendRedirect("login.html");
	}
}
else{
	//JWT가 없는 경우 로그인 페이지 이동
		response.sendRedirect("login.html");
}
%>
</body>
</html>