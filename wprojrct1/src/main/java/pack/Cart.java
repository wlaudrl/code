package pack;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Cart")
public class Cart extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String name = request.getParameter("name");
		int price = Integer.parseInt(request.getParameter("price"));

		HttpSession session = request.getSession(true);

		// cart에 담기 예) 김밥 -> 김밥통 -> 냉장고
		ArrayList<Goods> glist = (ArrayList<Goods>) session.getAttribute("list");

		if (glist == null)
			glist = new ArrayList<Goods>(); // Goods 객체를 담을 glist 생성

		glist.add(new Goods(name, price));
		session.setAttribute("list", glist);

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<html><body>" + name + "구입완료");
		out.println("<br>[<a href='myshop.html'>계속 쇼핑</a>] ");
		out.println("[<a href='Buy'>결제하기</a>]<br>");

		out.println("<p><table width='80%'>");
		out.println("<tr><th>상품명</th><th>가격</th></tr>");
		for (int i = 0; i < glist.size(); i++) {
			Goods goods = (Goods) glist.get(i);
			out.println("<tr><td>" + goods.getName() + "</td>");
			out.println("<td>" + goods.getPrice() + "</td></tr>");
		}
		out.println("</table>");
		out.println("</body></html>");
		out.close();
	}

}
