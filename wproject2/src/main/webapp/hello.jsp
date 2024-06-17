<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
System.out.println("클라이언트에 의해 호출됨");
System.out.println("서버에 WEB-INF 영역 내의 jsp 호출 시도");
// 주의 : redirect 불가
// forwarding 만 가능
%>
<jsp:forward page="WEB-INF/hi.jsp"></jsp:forward>
