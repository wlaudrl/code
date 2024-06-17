package pack;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ServletExam")
public class ServletExam extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String num = request.getParameter("num");
		String name = request.getParameter("name");
		String jum = request.getParameter("jum");

		response.setContentType("text/html;charset=utf-8"); // mime type 과 문자 코드
		PrintWriter out = response.getWriter();
		out.println("<html><body>");
		out.println("<h1>세션 처리 결과</h1>");
		out.println("<br><br><a href='getdata.html'>새로 입력</a>");
		out.println("<br><br><a href='getdata.html'>세션 삭제</a>");
		out.println("</html></body>");
		out.close();

	}

}
