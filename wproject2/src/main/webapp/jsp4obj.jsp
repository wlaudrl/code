<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("utf-8");  // request : Client로부터의 요청처리
String id = request.getParameter("id");
String pwd = request.getParameter("pwd");
if(!(id.equals("aa") && pwd.equals("11"))){  // id는 aa 그리고 pwd는 11
 	response.sendRedirect("jsp4member.html");  // response : Client로 결과 출력
}


String[] names = request.getParameterValues("name");
String job = request.getParameter("job");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
** 전송된 입력 자료 확인 ** <br>
아이디는 <% out.println(id + "<br>"); // out : 출력 스트림 개체 %>
이름은 <% out.println(names[0] + ", 별명은 " + names[1] + "<br>"); %>
직업은 
<% 
// 어떤 비즈니스 로직 처리...
out.println(job);
// 계속해서 여러 실행문을 적을 수 있다 그런데 출력 할 실행문이 하나인 경우 아래와 같이 할 수 있다
%>
<%=job %>
<hr>
기타 정보 : <br>
client ip : <%= request.getRemoteAddr() %><br>
client domain : <%= request.getRemoteHost() %><br>
protocol : <%= request.getProtocol() %><br>
Method : <%= request.getMethod() %><br>
Server domain : <%= request.getServerName() %><br>
<br>
Sever buffer size = <%= response.getBufferSize() %><br>
Sever CharacterEncoding = <%= request.getCharacterEncoding() %><br>
<br>
Context path : <%= application.getContextPath() %><br><!-- 현재 실행중인 페이지의 외부 환경정보 관련 객체 -->
Session : <%= pageContext.getSession() %>
<br>
Session, page, config, exception 등이 내장 객체에 해당됨
</body>
</html>