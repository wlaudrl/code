package pack;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class DbTest7 extends JFrame implements ActionListener{
	JButton btn = new JButton("추가");
	
	JTextField txtCode = new JTextField();
	
	
	
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	
	public DbTest7() {
		try {
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
