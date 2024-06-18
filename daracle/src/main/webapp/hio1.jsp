<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>상품 목록</h2>
<%-- <%@ include file="header.jsp"%> --%>
	<table>
		<tr>
			<td><a href="productlist.jsp">전 체</a></td>
    		<td><a href="productlist.jsp">상 의</a></td>
    		<td><a href="productlist.jsp">하 의</a></td>
    		<td><a href="productlist.jsp">잡 화</a></td>
		</tr>
	</table>
	<form action="hio2.jsp" name="frm" method="get" style="text-align: right;">
		<select name="stype">
			<option value="title" selected="selected">판매순</option>
			<option value="name">높은가격순</option>
			<option value="name">낮은가격순</option>
			<option value="name">최신순</option>
		</select>
	</form>
<ul>
	<li>
		<a href="hio2.jsp" >
			<img src="images/good1.jpeg" width="150" title="irum">
		</a>
		<a href="hio2.jsp" >
			<img src="images/good1.jpeg" width="150" title="irum">
		</a>
		<a href="hio2.jsp" >
			<img src="images/good1.jpeg" width="150" title="irum">
		</a>
		<a href="hio2.jsp" >
			<img src="images/good1.jpeg" width="150" title="irum">
		</a>
	</li>
</ul>
<ul>
	<li>
		<a href="product1.html" >
			<img src="images/good1.jpeg" width="150" title="irum">
		</a>
		<a href="product1.html" >
			<img src="images/good1.jpeg" width="150" title="irum">
		</a>
		<a href="product1.html" >
			<img src="images/good1.jpeg" width="150" title="irum">
		</a>
		<a href="product1.html" >
			<img src="images/good1.jpeg" width="150" title="irum">
		</a>
	</li>
</ul>
</body>
</html>