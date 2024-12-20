<%@page import="java.util.Base64"%>
<%@page import="java.util.Date"%>
<%@page import="java.security.Key"%>
<%@page import="javax.servlet.http.Cookie"%>
<%@page import="io.jsonwebtoken.Jwts"%>
<%@page import="io.jsonwebtoken.security.Keys"%>
<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%
    String id = request.getParameter("id");
    String pwd = request.getParameter("pwd");

    // 자격 증명 확인
    String validId = "ok";
    String validPwd = "1111";

    if(id != null && pwd != null && id.equals(validId) && pwd.equals(validPwd)) {
        // 서블릿 컨텍스트에서 Base64로 인코딩된 비밀 키 가져오기
        String encodedKey = (String) getServletContext().getAttribute("secretKey");
        byte[] decodedKey = Base64.getDecoder().decode(encodedKey);
        Key secretKey = Keys.hmacShaKeyFor(decodedKey);
        
        // 토큰 생성
        String jwt = Jwts.builder()
                        .setSubject(id)         // 토큰 용도(제목)
                        .setIssuedAt(new Date()) // 생성 시간 설정
                        .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60)) // 1시간 유효
                        .signWith(secretKey)    // hmac 알고리즘으로 암호화
                        .compact();             // 토큰 생성
                        
        Cookie jwtCookie = new Cookie("jwt", jwt);
        jwtCookie.setHttpOnly(true); // 클라이언트에서 수정 불가
        jwtCookie.setPath("/");
        response.addCookie(jwtCookie);
        response.sendRedirect("success.jsp");
    } else {
        // 자격 증명이 유효하지 않은 경우 오류 메세지 출력
        out.println("<html><body>");
        out.println("<h2>로그인 실패</h2>");
        out.println("<a href='login.html'>다시 로그인</a>");
        out.println("</body></html>");
    }
%>
