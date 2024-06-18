<%@page import="pack.product.ProductDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>


<jsp:useBean id="mainMgr" class="pack.main.mainMgr" />
<%

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>- 제품 상세 페이지 -</h2>
	<form action="cartproc.jsp">
		<table>
			<tr>
				<td style="width: 30%"><img src="images/good1.jpeg" width="150" /></td>
				<td style="width: 50%; vertical-align: top;">
					<table style="width: 100%">
						<tr>
							<td>상품명 :</td>
						</tr>
						<tr>
							<td>가 격 :</td>
						</tr>
						<tr>
							<td>재고량 :</td>
						</tr>
						<tr>
							<td>주문 수량 :</td>
							<td><input type="number" min="1" value="1" name="quantity" style="text-align: center; width: 3cm;"></td>
						</tr>
					</table>
				</td>
				<td style="vertical-align: top;"></td>
			</tr>
			<tr>
				<td colspan="3" style="text-align: center;"><br> <input type="submit" value="장바구니에 담기"> <input type="button" value="바로 주문하기"></td>
			</tr>
			<td style="text-align: center;">
					<h3>* 제품 상세 *</h3>
				</td>
		</table>
	</form>
</body>
</html>