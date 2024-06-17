package pack;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;

// URL 클래스로 특정 웹 서버 컴의 문서 읽기
// 인터넷이 가능한 서버들의 자원에 접근하여 주소 및 기타 정보를 다루는 클래스
public class Net1URL {
	public static void main(String[] args) {
		try {
			URL url = new URL("https://www.naver.com");
			// https://www.naver.com::80/index.html
			// http 보안용 서버 ==> https. tcp 프로토콜 기반 응용프로그램 계층에서 사용
			InputStream is = url.openStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(is, "UTF-8"));
			// System.out.println(br.read());

			// 읽은 문서 파일로 저장
			PrintWriter pw = new PrintWriter(System.out, true);
			PrintWriter fw = new PrintWriter(new FileOutputStream("/Users/jimyeong-gi/Library/Mobile Documents/com~apple~TextEdit/Documents/my.html"));
			
			String line = "";
			while((line = br.readLine()) != null){
				pw.println(line);  // 콘솔로 저장
				fw.println(line);  // 파일로 저장
				fw.flush();
			}
			br.close();
			pw.close();
			fw.close();
			is.close();
			
			
		} catch (Exception e) {
			System.err.println("err : " + e);
		}

	}

}
