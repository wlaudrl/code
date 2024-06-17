package pack;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/ServletEx7Session")
public class ServletEx7Session extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// session : 각 클라이언트의 정보를 웹 서버에 메모리 확보 후 저장
		HttpSession session = request.getSession(true); // 세션이 있으면 읽고, 없으면 세션을 생성
//		HttpSession session = request.getSession(false); // 세션이 있으면 읽고, 없으면 세션을 생성 안함

		session.setMaxInactiveInterval(10); // 1분간 유효 세션에 값을 주지않으면 기본 값 30분

		// session 아이디 생성 후 서버 뿐만 아니라 클라이언트 컴퓨터의 cookie 에도 저장됨
		if (session != null) {
			session.setAttribute("name", "홍길동");
			// 복수 작성 가능 // 크기는 동적이다
		}

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<html><body>");
		out.println("session id : " + session.getId());
		out.println("<br>사용자명  : " + session.getAttribute("name"));
		out.println("</body></html>");
		out.close();
	}

}
