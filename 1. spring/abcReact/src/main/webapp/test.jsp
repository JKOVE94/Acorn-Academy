<%@page import="org.json.simple.JSONObject"%>
<%@page import="org.json.simple.JSONArray"%>
<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/json; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
//CORS 해결
response.setHeader("Access-Control-Allow-Origin", "*");
response.setHeader("Access-Control-Allow-Methods", "GET, POST, OPTIONS");

String name = request.getParameter("name");
JSONArray jikwons = new JSONArray(); //JSON 을 어레이 형식으로 보관

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
	pstmt = conn.prepareStatement("select * from jikwon");
	rs = pstmt.executeQuery();
	while(rs.next()){
		JSONObject obj = new JSONObject(); //JSON을 객체 타입으로 저장하고 Key,Value로 저장 가능
		obj.put("jikwonno", rs.getInt("jikwonno"));
		obj.put("jikwonname", rs.getString("jikwonname"));
		obj.put("jikwonjik", rs.getString("jikwonjik"));
		obj.put("jikwonpay", rs.getString("jikwonpay"));
		jikwons.add(obj); //저장된 JSONObject를 JSONArray에 담기
	}
	if(result.length() >0){
		result = result.substring(0,result.length()-1);
	}
	out.print(jikwons.toString());
} catch (Exception e) {
	System.out.println("연결 오류 : " + e);
	return;
} finally {
	rs.close();
	pstmt.close();
	conn.close();
}
%>