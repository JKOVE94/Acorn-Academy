<%@page import="io.jsonwebtoken.ExpiredJwtException"%>
<%@page import="io.jsonwebtoken.Jwts"%>
<%@page import="java.security.Key"%>
<%@page import="io.jsonwebtoken.security.Keys"%>
<%@page import="java.util.Base64"%>
<%@page import="io.jsonwebtoken.JwtException"%>
<%@page import="io.jsonwebtoken.Claims"%>
<%@page import="io.jsonwebtoken.Jws"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
    //JWT로 확인
    //쿠키에서 JWT 읽
    Cookie[] cookies = request.getCookies();
	String jwt = null;
	if(cookies != null){
		for(Cookie c : cookies){
			if(c.getName().equals("jwt")){
				jwt = c.getValue();
				break;
			}
		}	
	}
	
	if(jwt!=null){
		try{
		   String encodedKey = (String) getServletContext().getAttribute("secretKey");
		    byte[] decodedKey = Base64.getDecoder().decode(encodedKey);
		    Key secretKey = Keys.hmacShaKeyFor(decodedKey);
		    
		    //JWT 유효성 검사
		    Jws<Claims> claims = Jwts.parserBuilder()
			    .setSigningKey(secretKey)
			    .build()
			    .parseClaimsJws(jwt); //전달된 jwt를 파싱 후 유효하면 jws<claims> 객체를 반환, 유효하지 않으면 JwtException, ExpiredJwtException 반환
		
			    String userid = claims.getBody().getSubject().toString(); //sub 클레임 읽기
			    
			    //유효한 경우 메시지 출력
			    %>
				<!DOCTYPE html>
				<html>
				<head>
				<title></title>
				</head>
				<body>
					<h2>로그인 성공 (JWT 사용)</h2>
					<h3>
						환영합니다.
						<%=userid%>님 </h3>
					<a href="logout.jsp">로그아웃</a>
				</body>
				</html>
				<%
		}catch(ExpiredJwtException e){
			System.out.println("만료된 토큰");
			response.sendRedirect("login.html");
		}
		catch(JwtException e){
			System.out.println("유효하지 않은 토큰");
			response.sendRedirect("login.html");
		}
	}
	
	
%>


