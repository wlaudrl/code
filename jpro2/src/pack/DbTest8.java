package pack;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class DbTest8 extends JFrame implements ActionListener {
	private JButton btn = new JButton("확인");

	private JTextField txtName = new JTextField();
	private JTextField txtJu = new JTextField();
	private JTextField txtJu2 = new JTextField();
	private JLabel laName = new JLabel("고객명 : ");
	private JLabel laJu = new JLabel("주민번호 : ");
	private JPanel jpanel = new JPanel();
//	private JTextField txt1 = new JTextField("",3);
//	private JTextField txt2 = new JTextField(" ", 3);
//	private JTextField txt3 = new JTextField(" ", 3);
//	private JTextField txt4 = new JTextField(" ", 3);
//	private JTextField txt5 = new JTextField(" ", 3);
//	
	private JTextArea ta = new JTextArea(7,13);

	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;

	public DbTest8() {
		// btn = new JButton("확인");

		layInit();
		
		btn.addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			if (e.getSource() == btn) {
				dbConnect();
			}
				

//			 display();
		} catch (Exception e2) {

		}
	}

	private void layInit() {
		
		
		
		setTitle("담당직원 정보");
		setBounds(50, 50, 500, 330);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setLayout(null);
		jpanel.setBounds(0, 0, 500, 330);
		add(jpanel);
		
		txtName.setBounds(90, 25, 70, 25);
		jpanel.add(txtName);
		txtJu.setBounds(90, 60, 70, 25);
		jpanel.add(txtJu); 
		txtJu2.setBounds(175, 60, 70, 25);
		jpanel.add(txtJu2); 
		
		laName.setBounds(0, 0, 50, 30);
		jpanel.add(laName);
		laJu.setBounds(0, 21, 70, 30);
		jpanel.add(laJu);
		
		JScrollPane jsp = new JScrollPane(ta);
		jsp.setBounds(20, 100, 300, 200);
		jpanel.add(jsp);
		
		jpanel.add(btn=new JButton("확인"));
		btn.setBounds(350, 70, 100, 30);
		/*
		 * JPanel panel = new JPanel(); // FlowLayout panel.add(new JLabel("고객명 :"));
		 * txtName.setEditable(false); txtJu.setEnabled(false); panel.add(txtName);
		 * add("North", panel);
		 * 
		 * JPanel panel2 = new JPanel(); panel2.add(new JLabel("주민번호 :"));
		 * txtName.setEditable(false); txtJu.setEnabled(false);
		 * 
		 * panel2.add(txtJu); panel2.add(txtJu2); panel2.add(btn); add(panel2);
		 */

//		JPanel panel = new JPanel();
//		panel.add(new JLabel("고객명 :"));
//		panel.add(txtName);
//		panel.setBounds(90, 25, 70, 25);
//		add(panel);
////		add("North", panel);
//
//		JPanel panel2 = new JPanel();
//		panel2.add(new JLabel("주민번호 :"));
//		panel2.add(txtJu);
//		panel2.add(txtJu2);

//		JPanel panel3 = new JPanel();
//		panel3.add(txt1);
//		panel3.add(txt2);
//		panel3.add(txt3);
//		panel3.add(txt4);
//		panel3.add(txt5);
//		add("South", panel3);
//
//		panel2.add(btn);
//
//		panel2.setBounds(215, 25, 70, 25);
//		add(panel2);
//		
////		add("Center", panel2);
//
//		btn.addActionListener(this);
//		
//		JPanel panel3 = new JPanel();
//		
////		panel3.setSize(300, 300);
//		
//		panel3.setLayout(new BorderLayout());
//	
//		JScrollPane jsp = new JScrollPane(ta);
//		panel3.add(ta);
//		
//		panel3.setBounds(215, 25, 70, 25);
//		add(panel3);
////		add("South", panel3);
//		
		
	}

	private void dbConnect() {
		String st = "";
		String gogek_name = "";
		String gogek_jumin = "";
		try {
			// and g.gogek_jumin = '880323-2558777'
			gogek_name = txtName.getText(); // 고객명.
			gogek_jumin = txtJu.getText() + "-" + txtJu2.getText();
//			System.out.println(txtJu.getText());
//			System.out.println(txtJu2.getText());
			System.out.println("이름 : " + gogek_name);
			System.out.println("주민번호 : " + gogek_jumin.trim());
			// String query = "select * from emp where deptno=?";

			st = "select j.jikwon_no as '사번'\n" + "      ,j.jikwon_name as '이름'  \n" + "      ,b.buser_name as '부서명'\n"
					+ "      ,b.buser_tel as '전화'\n" + "       ,j.jikwon_jik as '직급'\n" + "  from jikwon j\n"
					+ "        left outer join gogek g\n" + "                     on g.gogek_damsano  = j.jikwon_no \n"
					+ "        left outer join buser b \n" + "                    on b.buser_no = j.buser_num \n"
					+ "        \n" + " where 1 = 1\n" + "    and g.gogek_name = ? \n" + "    and g.gogek_jumin = ?";

			Class.forName("com.mysql.cj.jdbc.Driver");

			String url = "jdbc:mysql://localhost:3306/MyDB";
			conn = DriverManager.getConnection(url, "root", "rsefaqt25!");

			pstmt = conn.prepareStatement(st);

			pstmt.setString(1, gogek_name);
			pstmt.setString(2, gogek_jumin);

//			rs = pstmt.executeQuery("select jikwon_no,jikwon_name from jikwon");
			rs = pstmt.executeQuery();
			while(rs.next()) {
				
				System.out.println(rs.getString(1) + " " +
			rs.getString(2) + " " + rs.getString(3) + " " + rs.getString(4) + " " + rs.getString(5));
			}

			// processDb();
		} catch (Exception e) {
			System.out.println("accDb err :" + e);

		}
	}

	private void display() {
		try {
			txtName.setText(rs.getString("gogek_name"));
			txtJu.setText(rs.getString("gogek_jumin"));
			txtJu2.setText(rs.getString("gogek_jumin"));
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	public static void main(String[] args) {
		DbTest8 db = new DbTest8();

	}

}

//int number = 1;
//String name = "라떼";
//
//stmt = con.createStatement();
//stmt.executeQuery("select * from Example where c_no = "+ number +" and c_name = '"+ name +"'");
//
//pstmt = con.prepareStatement("select * from Example where c_no = ? and c_name = ?");
//pstmt.setInt(1, number);
//pstmt.setString(2, name);

//
//String query = "select * from emp where deptno=?";
//                       pstmt = conn.prepareStatement(query);
//                       
//                       pstmt.setInt(1, 30);
//                       rs = pstmt.executeQuery();

