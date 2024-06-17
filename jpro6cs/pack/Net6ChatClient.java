package pack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Net6ChatClient {
	private static final String Host = "192.168.0.27";
	private static final int port = 5000;

	public static void main(String[] args) throws UnknownHostException, IOException {
		
		Socket socket = new Socket(Host, port);
		System.err.println("서버에 접속하셨습니다.");
		
		BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
		Scanner scanner = new Scanner(System.in);
		System.out.println("접속자명 입력:");
		String name = scanner.nextLine();
		out.println(name); // 서버로 접속자명 전송
		
		Thread readThread = new Thread(new Runnable() {
			
			@Override
			public void run() {
				try {
					String severMessage;
					while((severMessage = in.readLine()) != null) {
						System.out.println(severMessage);
					}
					
					
				} catch (Exception e) {
					System.out.println("수신데이터 오류 :" + e.getMessage());
				}
				
			}
		});
		readThread.start();
		
		String msg;
		while((msg = scanner.nextLine()) != null) {
			if(!msg.isEmpty()) {
			out.println(msg); // 채팅 메세지 전송
		}
	}
		
		socket.close();
		scanner.close();

}
}
