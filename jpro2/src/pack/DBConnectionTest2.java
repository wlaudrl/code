package pack;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBConnectionTest2 {
	String driver = "org.mariadb.jdbc.Driver";
	Connection con;
	PreparedStatement stmt;
	ResultSet rs;

	public DBConnectionTest2() {
		try {
			Class.forName(driver);
			con = DriverManager.getConnection("jdbc:mariadb://localhost:3306/MyDB\"", "root", "rsefaqt25!");

			if (con != null) {
				System.out.println("DB 접속 성공");
			}

		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로드 실패");
		} catch (SQLException e) {
			System.out.println("DB 접속 실패");
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		DBConnectionTest2 dbcon = new DBConnectionTest2();
	}
}
