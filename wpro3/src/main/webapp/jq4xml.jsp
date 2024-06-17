<?xml version="1.0" encoding="UTF-8"?>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>

<%@ page language="java" contentType="text/xml; charset=UTF-8"
    pageEncoding="UTF-8"%>
<sangpums>
<%
//sangdata table을 읽어 XML 형식으로 출력
Connection conn = null;
PreparedStatement pstmt = null;
ResultSet rs = null;

try{
	Class.forName("org.mariadb.jdbc.Driver");
	
	String url = "jdbc:mariadb://localhost:3306/MyDB";   
	conn = DriverManager.getConnection(url, "root", "rsefaqt25!");
	pstmt = conn.prepareStatement("select * from sangdata");
	rs = pstmt.executeQuery();
	
// 	Thread.sleep(5000);
	
	//rs.next();
	//out.print(rs.getString("sang"));
	while(rs.next()){
%>
	<sangpum>
		<code><% out.print(rs.getString("code"));%></code>
		<sang><%=rs.getString("sang")%></sang>
		<su><%=rs.getString("su")%></su>	
		<danga><%=rs.getString("dan")%></danga>		
	</sangpum>
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
</sangpums>