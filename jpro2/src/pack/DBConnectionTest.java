package pack;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnectionTest {
	String url = "jdbc:mariadb://localhost:3306/MyDB";
	String dbName = "MyDB";
	String ID = "root";
	String PW = "rsefaqt25!";

	public DBConnectionTest() {
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			System.out.println("Driver 로딩 성공");
			Connection conn = DriverManager.getConnection(url + dbName, ID, PW);
			System.out.println("서버 연결 성공");
		} catch (ClassNotFoundException e) {
			System.out.println("Driver 로딩 실패");
		} catch (SQLException e) {
			System.out.println("서버 연결 실패");
			// TODO: handle exception
		}
	}

	public static void main(String[] args) {
		new DBConnectionTest();

	}

}
