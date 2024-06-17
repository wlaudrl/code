package pack;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pack.other.ServletEx2Other;

@WebServlet("/ServletEx2")
public class ServletEx2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ServletEx2Other other;

	public void init(ServletConfig config) throws ServletException {
//		서버는 init() 메소드를 호해서 Servlet을  초기화 합니다.
		other = new ServletEx2Other("홍길동");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8"); // mime type 과 문자 코드
		PrintWriter out = response.getWriter();
		out.println("<html><body>");
		out.println("<h1>서블릿 문서 Ex2</h1>");

		// 지역변수 출력
		int a = 10, b = 20;
		out.println("a: " + a + ", b:" + b);

		// 현재 클래스에 메소드 호출
		int tot = clacData(a, b);
		out.println("<br>두 수의 합은 : " + tot);

		// 클래스 호출
//		ServletEx2Other other = new ServletEx2Other("홍길동");
		String ir = other.getIrum();
		out.println("<br>이름은 : " + ir);

		out.println("</html></body>");
		out.close();
	}

	private int clacData(int a, int b) {
		int imsi = a + b;
		return imsi;
	}

}
