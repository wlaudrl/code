package pack;

public class ExamBean { // Client 로 부터 전송되는 복수 개의 값을 한 개의 그룹으로 묶어서 처리하는 Class
	// 이런 용도의 클래스를 FormBean이라고 부른다
	private String name;
	private int kor;
	private int eng;
	private int mat;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getKor() {
		return kor;
	}

	public void setKor(int kor) {
		this.kor = kor;
	}

	public int getEng() {
		return eng;
	}

	public void setEng(int eng) {
		this.eng = eng;
	}

	public int getMat() {
		return mat;
	}

	public void setMat(int mat) {
		this.mat = mat;
	}

}
