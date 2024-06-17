<%@page import="pack.board.BoardDto"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:useBean id="boardMgr" class="pack.board.BoardMgr"></jsp:useBean>
<jsp:useBean id="dto" class="pack.board.BoardDto"></jsp:useBean>

<%
int spage = 1;
int pageSu = 0;

int start, end;
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판</title>
<link rel="stylesheet" type="text/css" href="../css/board.css">
<style type="text/css">
.menubar {
	border-radius: 20px; 
	padding: 3px;
	font-size: 90%;
	color: white;
}

.contents {
	text-align: center;
}
</style>
<script type="text/javascript">
window.onload = () => {
	document.querySelector("#btnSearch").onclick = () => {
		if (frm.sword.value === "") {
			frm.sword.focus();
			frm.sword.placeholder = "검색어 입력";
			return;
		}
		frm.submit();
	}
}
</script>
</head>
<body>
<table>
	<tr>
		<td>
			<a href="../index.html">메인</a>&emsp;
			<a href="boardlist.jsp?page=1">최근 목록</a>&emsp;
			<a href="boardwrite.jsp">새 글 작성</a>&emsp;
			<a href="#" onclick="window.open('admin.jsp', '', 'width=300, height=150, top=200, left=300')">관리자용</a>&nbsp;
			<br/><br/>
			<table style="width: 100%">
				<tr style="background-color: #0489B1;">
					<th class="menubar">번호</th>
					<th class="menubar">제목</th>
					<th class="menubar">작성자</th>
					<th class="menubar">작성일</th>
					<th class="menubar">조회수</th>
				</tr>
				<%
				try {
					spage = Integer.parseInt(request.getParameter("page"));
				} catch(Exception e) {
					spage = 1;
				}
				
				if (spage <= 0) {
					spage = 1;
				}
				
				// 검색 --------------------
				String stype = request.getParameter("stype");
				String sword = request.getParameter("sword");
				// ------------------------
				
				boardMgr.totalList(); // 전체 레코드 수 계산
				pageSu = boardMgr.getPageSu(); // 전체 페이지 수 얻기
				
//				ArrayList<BoardDTO> list = boardMgr.getDataAll(spage); // only 페이징 처리
				ArrayList<BoardDto> list = boardMgr.getDataAll(spage, stype, sword); // 페이징 + 검색
				
				for (int i = 0; i < list.size(); i++) {
					dto = (BoardDto)list.get(i); // list의 i번째를 취하여 BoardDTO type으로 casting (명시적, 생략 가능)
					
					// 댓글 들여쓰기 준비
					int nst = dto.getNested();
					String tab = "";
					for (int k = 0; k < nst; k++) {
						tab += "&emsp;";
					}
				%>
				<tr>
					<td class="contents"><%= dto.getNum() %></td>
					<td>
					<%= tab %><a href="boardcontent.jsp?num=<%= dto.getNum() %>&page=<%= spage %>"><%= dto.getTitle() %></a>
					</td>
					<td class="contents"><%= dto.getName() %></td>
					<td class="contents"><%= dto.getBdate() %></td>
					<td class="contents"><%= dto.getReadcnt() %></td>
				</tr>
				<%
				}
				%>
			</table>
			<br/>
			<table style="width: 100%; font-size: 80%">
				<tr>
					<td style="text-align: center;">
					<%
						for (int i = 1; i <= pageSu; i++) {
							if (i == spage) { // 현재 페이지
								out.print("<b style='font-size: 110%'>" + i + "</b>&emsp;");
							} else {
								out.print("<a href='boardlist.jsp?page=" + i + "'>" + i + "</a>&emsp;");								
							}
						}
					%>
					<br/><br/>
					<form action="boardlist.jsp" name="frm" method="get">
						<select name="stype">
							<option value="title" selected="selected">글 제목</option>
							<option value="name">작성자</option>
						</select>
						<input type="text" name="sword">
						<input type="button" value="검색" id="btnSearch">
					</form>
					</td>
				</tr>
			</table>
		</td>
	</tr>
</table>
</body>
</html>