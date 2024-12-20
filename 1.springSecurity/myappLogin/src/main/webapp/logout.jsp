<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%
    HttpSession httpSession = request.getSession(false);
    httpSession.removeAttribute("userid");

    //클라이언트 쿠키에 남아있는 JSSESSIONID 삭제
    Cookie cookie = new Cookie("JSESSIONID", null);
    cookie.setMaxAge(0); //쿠키 유효시간 0초
    cookie.setPath("/"); //쿠키 경로 설정
    response.addCookie(cookie);
    
    response.sendRedirect("login.html");
%>

<!DOCTYPE html>
<html>
<head>
    <title></title>
</head>
<body>
</body>
</html>