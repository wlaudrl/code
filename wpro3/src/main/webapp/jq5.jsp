<?xml version="1.0" encoding="UTF-8"?>

<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>

<%@ page language="java" contentType="text/xml; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jikwons>
<%
String gubun = request.getParameter("gubun");
String name = request.getParameter("name");


//sangdata table을 읽어 XML 형식으로 출력
Connection conn = null;
PreparedStatement pstmt = null;
ResultSet rs = null;

try{
	Class.forName("org.mariadb.jdbc.Driver");
	
	String url = "jdbc:mariadb://localhost:3306/MyDB";   
	conn = DriverManager.getConnection(url, "root", "rsefaqt25!");
	
	String sql = "select jikwon_no, jikwon_name, jikwon_jik, jikwon_pay from jikwon";
	if(gubun.equals("all")){
		pstmt = conn.prepareStatement(sql);
	}else{
		pstmt = conn.prepareStatement(sql += "where jikwon_name like ?");
		pstmt.setString(1, name + "%");
	}
// 	pstmt = conn.prepareStatement("select jikwon_no, jikwon_name, jikwon_jik, jikwon_pay from jikwon");
	
	rs = pstmt.executeQuery();
	

	while(rs.next()){
%>
	<jikwon>
		<sabun><% out.print(rs.getString("jikwon_no"));%></sabun>
		<irum><%=rs.getString("jikwon_name")%></irum>
		<jik><%=rs.getString("jikwon_jik")%></jik>	
		<pay><%=rs.getString("jikwon_pay")%></pay>		
	</jikwon>
<%
		
	}
	
}catch (Exception e){
	System.out.println("에러 : " +e);
	
}finally{
	try{
 		rs.close();
 		pstmt.close();
 		conn.close();
 	}catch (Exception e){
 		
 	}
 
}
%>
</jikwons>