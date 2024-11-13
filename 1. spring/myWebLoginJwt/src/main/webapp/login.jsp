<%@page import="java.util.Base64"%>
<%@page import="java.util.Date"%>
<%@page import="io.jsonwebtoken.Jwts"%>
<%@page import="java.security.Key"%>
<%@page import="io.jsonwebtoken.security.Keys"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String id = request.getParameter("id");
String pwd = request.getParameter("pwd");

//자격 증명 확인 (DB 생략)
String validId = "ok";
String validPwd = "123";

//자격 증명이 되면 JWT 생성하여 쿠키에 저장 - Client Side
if(id != null & pwd != null && id.equals(validId) && pwd.equals(validPwd)){
	
	// 고정된 비밀 키 사용 (예제용)  최소 256비트 길이의 비밀 키
	//String secretKeyString = "mySuperSecretKey12345678901234567890123456789012"; //실제로는 모든 클라이언트에 동일한 key를 주면 안된다. 추후에는 자동화 가능
	
	//java.security / jsonwebtoken.security.Keys
	//Key secretKey = Keys.hmacShaKeyFor(secretKeyString.getBytes()); //암호화
	
    // 위의 작업을 주석 처리하고 아래 내용으로 변경하자.

    // 서블릿 컨텍스트에서 Base64로 인코딩된 비밀 키 가져오기  java.util.Base64
    String encodedKey = (String) getServletContext().getAttribute("secretKey");
    byte[] decodedKey = Base64.getDecoder().decode(encodedKey);
    Key secretKey = Keys.hmacShaKeyFor(decodedKey);
		
	System.out.println(secretKey);
	
	long expirationTime = 1000 * 60 * 60; //1시간 
	
	//JWT 생성
	String jwt = Jwts.builder()
					.setSubject(id)
					.claim("name", "신기해")
					.setIssuedAt(new Date())
					.setExpiration(new Date(System.currentTimeMillis()+expirationTime))
					.signWith(secretKey)
					.compact();
	
	//쿠키에 JWT 저장
	Cookie jwtCookie = new Cookie("jwt", jwt);
	jwtCookie.setHttpOnly(true); // 수정불가
	jwtCookie.setPath("/");
	response.addCookie(jwtCookie);
	
	
	response.sendRedirect("success.jsp");
}
else{
	out.println("<html><body>");
	out.println("<h3>로그인 실패</h3>");
	out.println("<a href='login.html'>다시 로그인</a>");
	out.println("</body></html>");
}
%>