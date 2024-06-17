<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("utf-8"); %>
<jsp:useBean id="bean" class="pack.board.BoardFormBean" />
<jsp:setProperty property="*" name="bean" />
<jsp:useBean id="boardMgr" class="pack.board.BoardMgr" />

<%
bean.setBip(request.getRemoteAddr());
bean.setBdate();
int newNum = boardMgr.currentMaxNum() + 1;
bean.setNum(newNum);
bean.setGnum(newNum);

boardMgr.saveData(bean);

response.sendRedirect("boardlist.jsp?page=1");


%>