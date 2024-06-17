package pack;

import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

// Connection 객체는 필요할 때만 연결하고 끊는 것이 원칙이나 그렇지 않은 경우도 있다
public class DbTest5RecMove extends JFrame implements ActionListener {
	JButton btnF = new JButton("|<<");
	JButton btnP = new JButton("<");
	JButton btnN = new JButton(">");
	JButton btnL = new JButton(">>|");

	JTextField txtNo = new JTextField("", 5);
	JTextField txtName = new JTextField("", 10);

	Connection conn;
	Statement stmt;
	ResultSet rs;

	public DbTest5RecMove() {
		super("레코드 이동");

		layInit();
		dbConnect();

		setBounds(200, 200, 300, 250);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			if (e.getSource() == btnF)
				rs.first();
			else if (e.getSource() == btnP)
				rs.previous();
			else if (e.getSource() == btnN)
				rs.next();
			else if (e.getSource() == btnL)
				rs.last();

			display();
		} catch (Exception e2) {
			
			
		}
	}

	private void display() {
		try {
			txtNo.setText(rs.getString("jikwon_no"));
			txtName.setText(rs.getString("jikwon_name"));
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	private void layInit() {
		JPanel panel = new JPanel(); // FlowLayout
		panel.add(new JLabel("직원자료 :"));
		txtNo.setEditable(false);
		txtName.setEnabled(false);
		panel.add(txtNo);
		panel.add(txtName);
		add("North", panel);

		JPanel panel2 = new JPanel(); // FlowLayout
		panel2.add(btnF);
		panel2.add(btnP);
		panel2.add(btnN);
		panel2.add(btnL);
		add("Center", panel2);

		btnF.addActionListener(this);
		btnP.addActionListener(this);
		btnN.addActionListener(this);
		btnL.addActionListener(this);

	}

	private void dbConnect() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			String url = "jdbc:mysql://localhost:3306/MyDB";
			conn = DriverManager.getConnection(url, "root", "rsefaqt25!");
			
			stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			
			rs = stmt.executeQuery("select jikwon_no,jikwon_name from jikwon");
			
			//processDb();
		} catch (Exception e) {
			System.out.println("accDb err :" + e);
			
		}
	}
		
		private void processDb() {
			try {
				String url = "jdbc:mysql://localhost:3306/MyDB";
				conn = DriverManager.getConnection(url, "root", "rsefaqt25!");
				
				stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
				
				rs = stmt.executeQuery("select jikwon_no,jikwon_name from jikwon");
			} catch (Exception e) {
				System.out.println("processDb err" + e);
			}
		
		}
	


	public static void main(String[] args) {
		new DbTest5RecMove();

	}

}
