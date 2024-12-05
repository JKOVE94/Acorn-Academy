<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>

<%@ page language="java" contentType="text/plain; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%-- 
{
	"items":[
		{"id":1, "name":"아메리카노", "price":"5000"},
		{"id":2, "name":"라떼", "price":"6000"},
		{"id":3, "name":"고구마라떼", "price":"7000"}
	]
}
 --%>

{
"items":[

<%
Connection conn = null;
PreparedStatement pstmt = null;
ResultSet rs = null;
String result = "";

try {
	Class.forName("org.mariadb.jdbc.Driver");
	String url = "jdbc:mariadb://localhost:3306/test";
	conn = DriverManager.getConnection(url, "root", "jkove1994");
} catch (Exception e) {
	System.out.println("연결 오류 : " + e);
	return;
}

try {
	Thread.sleep(3000);
	pstmt = conn.prepareStatement("select * from sangdata");
	rs = pstmt.executeQuery();
	while(rs.next()){
		result +="{";
		result += "\"id\":" + "\""+ rs.getString("code") + "\",";
		result += "\"name\":" + "\""+ rs.getString("sang") + "\",";
		result += "\"price\":" + "\""+ (rs.getInt("su")*rs.getInt("dan")) + "\"";
		result +="},";
	}
	if(result.length() >0){
		result = result.substring(0,result.length()-1);
	}
	out.print(result);
} catch (Exception e) {
	System.out.println("연결 오류 : " + e);
	return;
} finally {
	rs.close();
	pstmt.close();
	conn.close();
}
%>

]}
