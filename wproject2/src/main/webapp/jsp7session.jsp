<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
String id = request.getParameter("id");

// request.setAttribute("idkey", id);  // 현재 jsp 파일에서만 유효  // private
// application.setAttribute("idkey", id);  // 현재 서비스 중 모두에게 유효 // public

// Servlet인 경우 HttpSession session = request.getSession(true); // 세션이 있으면 읽고, 없으면 세션을 생성
// session.setAttribute("idkey", id);  // session을 참조하는 파일에서만 유효
session.setAttribute("idkey", id);
session.setMaxInactiveInterval(10);  // 10초 간 유효
// 서버가 클라이언트 컴에 session ID를 쿠키에 저장해둠 
// 다음부터는 클라이언트가 서버에 정보 요청 시 session ID가 담긴 쿠키를 들고 감 
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2> * Session Test * </h2>
<form action="jsp7session2.jsp">
보고 싶은 영화 선택 : <br>
<input type="radio" name="movie" value="원더랜드" checked="checked">원더랜드
&nbsp;&nbsp;
<input type="radio" name="movie" value="퓨리오사">퓨리오사
&nbsp;&nbsp;
 <input type="radio" name="movie" value="설계자">설계자
 <input type="submit" value="결과 보기">
</form>
</body>
</html>