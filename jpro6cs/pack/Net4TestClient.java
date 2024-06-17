package pack;

import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class Net4TestClient {
		// 특정 컴의 접속 후 메세지 전달용
	public static void main(String[] args) {
		try {
//			InetAddress ia = InetAddress.getByName("127.0.0.1");  // 192.168.0.27 내거
//			System.out.println(ia);
//			Socket socket = new Socket(ia, 9999);
			
			Socket socket = new Socket("192.168.0.27,", 9999);  // 서버 접속
			
			PrintWriter writer = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(),StandardCharsets.UTF_8), true);
			writer.println("안녕 난 mg 야" + "\n"); // 서버로 자료 전송
			
			writer.close();
			socket.close();
			
		} catch (Exception e) {
			System.out.println("client err : " + e);
		}
		
		

	}

}
