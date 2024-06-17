<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<jsp:useBean id="memberMgr" class="pack.member.MemberMgr" />

<%
String id = request.getParameter("id");
boolean b = memberMgr.idCheckProcess(id);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>id 검사</title>
<link href="../css/board.css" rel="stylesheet" type="text/css">
<script src="../js/script.js"></script>
</head>
<body style="text-align: center;margin-top: 30px;">
<b><%=id %></b>
<%
if(b){
%>
 : 이미 사용 중인 id 입니다 !<p/>
 <a href="#" onclick="opener.document.regForm.id.focus();window.close()">닫기</a>
<%}else{%>
 : 사용 가능합니다 !<p/>
 <a href="#" onclick="opener.document.regForm.passwd.focus();window.close()">닫기</a>
<%
}
%>
</body>
</html>