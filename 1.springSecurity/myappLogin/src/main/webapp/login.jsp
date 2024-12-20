<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%
    String id = request.getParameter("id");
    String pwd = request.getParameter("pwd");

    // 자격 증명 확인
    String validId = "ok";
    String validPwd = "1111";

    if(id != null && pwd != null && id.equals(validId) && pwd.equals(validPwd)) {
    	/* System.out.println("실행"); */
        HttpSession htppsession = request.getSession();
        htppsession.setAttribute("id", id);
        response.sendRedirect("success.jsp");
    }
    // 자격 증명이 유효하지 않은 경우 오류 메세지 출력
    else {
        out.println("<html><body>");
        out.println("<h2>로그인 실패</h2>");
        out.println("<a href='login.html'>다시 로그인</a>");
        out.println("</html></body>");
    }
%>
