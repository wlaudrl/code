package domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity   // 테이블과의 매핑
@Table(name = "sangdata")   // 엔티티와 매핑할 테이블을 지정. 실제 테이블과 클래스 명이 다르면 적어 준다.
public class SangpumTable {
    @Id
    @Column(name = "code")
    private int code;
    @Column(name = "sang", nullable = false)  // 객체 필드를 테이블 컬럼에 매핑한다.
    private String sang;
    private int su;
    private int dan;
    
    protected SangpumTable() {
    	// 빈 생성자, 기본 생성자는 필수 (JPA가 엔티티 객체 생성 시 기본 생성자를 사용하기 때문)
    }

    public SangpumTable(int code, String sang, int su, int dan) {
        this.code = code;
        this.sang = sang;
        this.su = su;
        this.dan = dan;
    }

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getSang() {
		return sang;
	}

	public void setSang(String sang) {
		this.sang = sang;
	}

	public int getSu() {
		return su;
	}

	public void setSu(int su) {
		this.su = su;
	}

	public int getDan() {
		return dan;
	}

	public void setDan(int dan) {
		this.dan = dan;
	}
}
