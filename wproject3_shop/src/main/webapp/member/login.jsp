<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
String id = (String)session.getAttribute("idkey");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="../css/board.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="../js/script.js"></script>

<script type="text/javascript">
window.onload = () => {
	document.querySelector("#btnLogin").addEventListener("click", funcLogin);
	document.querySelector("#btnNewmember").addEventListener("click", funcNewmember);
}
</script>
</head>
<body>
<%
if(id != null){  // login 한 경우
%>
<!-- 
	<b><%=id%></b>님 환영합니다 ~<p/>
	이제부터 저희가 준비한 기능을 사용할 수 있습니다<br>
	<a href="logout.jsp">로그아웃</a>
-->
	<script type="text/javascript">
		location.href="../guest/guest_index.jsp";
	</script>
<%}else{%>  <!-- login 안한 경우 --> 
	<form name="loginForm">
	<table>
		<tr>
			<td>* 회원 로그인 *</td>
		</tr>
		<tr>
			<td>아이디 : </td>
			<td><input type="text" name="id"></td>
		</tr>
		<tr>
			<td>비밀번호 : </td>
			<td><input type="text" name="passwd"></td>
		</tr>
		<tr>
			<td colspan="2">
				<input type="button" value="로 그 인" id="btnLogin">
				<input type="button" value="회원가입" id="btnNewmember">
			</td>
		</tr>
	</table>
	</form>
<%
}
%>
</body>
</html>