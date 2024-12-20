<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%
    //세션으로 확인
    HttpSession httpSession = request.getSession(false);

    if(httpSession !=null && httpSession.getAttribute("userid") != null){
        String userid = (String)httpSession.getAttribute("userid");

    %>
<!DOCTYPE html>
<html>
<head>
    <title></title>
</head>
<body>
<h2>로그인 성공</h2>
<h3>환영합니다. <%=userid%></h3>
<a href="logout.jsp">로그아웃</a>
</body>
</html>
<%
    }
    else{
        response.sendRedirect("login.html");
    }
%>

