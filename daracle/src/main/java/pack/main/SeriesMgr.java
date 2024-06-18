package pack.main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class SeriesMgr {
	private Connection conn;
	private PreparedStatement pstmt, pstmt1, pstmt2;
	private ResultSet rs, rs1, rs2;
	private DataSource ds;
	private String sql;
	
	public SeriesMgr() {
		try {
			Context context = new InitialContext();
			ds = (DataSource)context.lookup("java:comp/env/jdbc_maria");
		} catch (Exception e) {
			System.out.println("DB connect fail: " + e);
		}
	}
	
	// 입력 키워드 기반 검색 결과 추천
	public String series_suggest(String keyword){
		String str = "";
		try {
			conn = ds.getConnection();
			// 입력 키워드와 정확히 일치하는 검색 결과가 없다면, 새로 만들기 옵션 제시
			sql = "select series_title from series where series_title = ?";
			pstmt1 = conn.prepareStatement(sql);
			pstmt1.setString(1, keyword);
			rs1 = pstmt1.executeQuery();
			if(!rs1.next()) str += keyword + " <a href=\"javascript:series_insert('" + keyword + "')\">새로 만들기</a><hr>";
			
			// 입력 키워드가 포함된 검색 결과가 있다면, 해당 결과들 편집 옵션 제시
			sql = "select series_title from series where series_title like ?";
			pstmt2 = conn.prepareStatement(sql);
			pstmt2.setString(1, "%" + keyword + "%");
			rs2 = pstmt2.executeQuery();
			while(rs2.next()) {
				str += rs2.getString(1) + " <a href=\"javascript:series_update('" + rs2.getString(1) + "\">편집하기</a><hr>";
			}
			// 띄어쓰기 해결 필요
		} catch (Exception e) {
			System.out.println("series_suggest err: " + e);
		} finally {
			try {
				if(rs1 != null) rs1.close();
				if(rs2 != null) rs2.close();
				if(pstmt1 != null) pstmt1.close();
				if(pstmt2 != null) pstmt2.close();
				if(conn != null) conn.close();
			} catch (Exception e) {
				System.out.println("cannot close: " + e);
			}
		}
		return str;
	}
	
	// 시리즈 추가
	public String series_insert(String title, String pic){
		String str = "";
		try {
			conn = ds.getConnection();
			sql = "INSERT INTO series(series_title, series_pic) values(?,?);";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, title);
			pstmt.setString(2, pic);
			pstmt.executeQuery();
			
			str += "DB에 시리즈 <b>" + title + "</b> 추가 완료<hr>";
			str += "캐릭터 편집<br>";
			str += "<button class='btn_character_insert' id='character1'>캐릭터1 추가</button>&nbsp;";
			str += "<button class='btn_character_insert' id='character2'>캐릭터2 추가</button>&nbsp;";
			str += "<button class='btn_character_insert' id='character3'>캐릭터3 추가</button>&nbsp;";
			str += "<button class='btn_character_insert' id='character4'>캐릭터4 추가</button>&nbsp;";
		} catch (Exception e) {
			System.out.println("series_suggest err: " + e);
		} finally {
			try {
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (Exception e) {
				System.out.println("cannot close: " + e);
			}
		}
		return str;
	}
	
}
