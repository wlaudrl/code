package CalkPKG;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JTextField;

public class Calculator extends JFrame {

	private JTextField inputSpace;

	public Calculator() {

		// 계사기의 화면과 버튼을 붙임 - 기본 레이아웃 사용
		setLayout(null);

		// 빈 공간의 JTextField 생성
		inputSpace = new JTextField();
		// 편집가능여부 : 불가능 (버튼만 사용)
		inputSpace.setEditable(false);
		// 배경색 설정
		inputSpace.setBackground(Color.white);
		// 정렬위치 선정
		inputSpace.setFont(new Font("Arial", Font.BOLD, 50));

		// 위치와 크기 (x:8, y:10 의 위치에 270x70의 크기)
		inputSpace.setBounds(8, 10, 270, 70);

		add(inputSpace);

		// 창의 제목, 사이즈, 보이기 여부 등을 지정해줌
		setTitle("계산기");
		setVisible(true);
		setSize(300, 370);
		// 화면 가운데에 띄
		setLocationRelativeTo(null);
		// 창을 닫을 때 실행 중인 프로그램도 같이 종료되도록함
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	public static void main(String[] args) {
		new Calculator();

	}

}
