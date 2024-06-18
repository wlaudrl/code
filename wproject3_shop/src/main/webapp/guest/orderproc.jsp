<%@page import="pack.order.OrderMgr"%>
<%@page import="pack.order.OrderBean"%>
<%@page import="java.util.Enumeration"%>
<%@page import="java.util.Hashtable"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<jsp:useBean id="cartMgr" class="pack.order.CartMgr" scope="session" />
<jsp:useBean id="boardMgr" class="pack.board.BoardMgr" />
<jsp:useBean id="productMgr" class="pack.product.ProductMgr" />
<%
Hashtable hCart = cartMgr.getCartList();

Enumeration enu = hCart.keys();

if (hCart.isEmpty()) {
%>
<script>
	alert("주문내역이 없습니다");
	location.href = "orderlist.jsp";
</script>
<%
} else {
while (enu.hasMoreElements()) {
	OrderBean orderBean = (OrderBean) hCart.get(enu.nextElement());
	OrderMgr.insertOrder(orderBean); //  주문정보 DB에 저장
	productMgr.reduceProduct(orderBean); //  주문 수량 만큼 재고량 빼기
	cartMgr.deleteCart(orderBean);
}
%>
<script>
	alert("주문처리가 완료되었습니다 \n 대단히 감사합니다");
	location.href = "orderlist.jsp";
</script>
<%
}
%>
