<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
// jsp09logout.jsp copy

// 쿠키에서 jwt를 제거
Cookie jwtCookie = new Cookie("jwt", "");
jwtCookie.setMaxAge(0); // 쿠키 제거
response.addCookie(jwtCookie); // 다시 넣어 주기

response.sendRedirect("jsp10jwtlogin.html");
// jsp09sessionLogin.html로 이동
%>