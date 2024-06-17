package pack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.Buffer;

// Thread 와 Socket 을 사용해 간단한 웹 서버 작성
public class Net7SimpleHttpServer {

	private ServerSocket serverSocket;
	private final int PORT;
	
	public Net7SimpleHttpServer(int port) {
		this.PORT = port;
		
	}
	
	public void gogo() throws IOException{
		serverSocket = new ServerSocket(PORT);
		System.out.println("HTML Server started on post : " + PORT);
		
		while(true) {
			try {
				Socket clientSocket = serverSocket.accept();
				System.out.println("Received request from " + clientSocket.getRemoteSocketAddress());
				
				ClientHandler clientHandler = new ClientHandler(clientSocket);
				new Thread(clientHandler).start();
				
			} catch (Exception e) {
				System.out.println("gogo err " + e.getMessage());
				break;
			}
		}
	}
	
	// 내부클래스
	private static class ClientHandler implements Runnable{
		private Socket clientSocket;
		
		public ClientHandler(Socket socket) {
			clientSocket = socket;
		}
		
		@Override
		public void run() {
			try {
				BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
				PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
				
				String requestLine = in.readLine();
				System.out.println("Request : " + requestLine);
				
				// HTTP 요청에 대한 응답 전송
				out.println("HTTP/1.1 200 OK");
				out.println("Content-Type:text/html;charset=UTF-8");
				out.println("");
				out.println("<html><head><title>연습</head></title>");
				out.println("<body>");
				out.println("<h1>홈 페이지 </h1>");
				out.println("<a href='https://www.daum.net'>다음으로</a>출발<br>");
				out.println("<a href='https://www.naver.com'>네이버로</a>가자");
				out.println("</body>");
				out.println("</html>");
				
				out.close();
				in.close();
				clientSocket.close();
			} catch (Exception e) {
				System.out.println("error client request : " + e.getMessage());
			}
			
		}
	}
	
	public static void main(String[] args) {
		int port = 8080;  // 연습용 웹 서버의 디폴트값.
		
		try {
//			Net7SimpleHttpServer httpServer = new Net7SimpleHttpServer(port);
			Net7SimpleHttpServer httpServer = new Net7SimpleHttpServer(port);
			httpServer.gogo();
			
		} catch (Exception e) {
			System.out.println("err : " + e);
		}

	}

}
