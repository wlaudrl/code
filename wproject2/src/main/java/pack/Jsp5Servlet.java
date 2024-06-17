package pack;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Jsp5Servlet")
public class Jsp5Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");

		String data = request.getParameter("data");

		System.out.println("수신 data : " + data);

		// 서버가 다른 파일 호출 방법 1) Redirect 방식 - Client 통해서 Server 에게 파일 요청
		// response.sendRedirect("aaa.html?data=" + data); // HTML 호출 할 경우 값을 넘길 수 없다
//		response.sendRedirect("jsp5called.jsp?data=" + data); // JSP 호출 할 경우 값을 넘길 수 있다 - 값은 String 으로만 가능

		// 서버가 다른 파일 호출 방법 2) forward 방식 - Server 에서 직접 Server 있는 파일 호출
		request.setAttribute("datas", data);
//		request.setAttribute("datas2", data2)
//		request.setAttribute("jikwons", jiklist);
//		request 이름, 값의 형태로 String 또는 자바의 어떤 객체이던 전달이 가능
		/*
		 * RequestDispatcher dispatcher =
		 * request.getRequestDispatcher("jsp5called.jsp"); dispatcher.forward(request,
		 * response);
		 */
		request.getRequestDispatcher("jsp5called.jsp").forward(request, response);
	}

}
