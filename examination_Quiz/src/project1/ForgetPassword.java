package project1;

import javax.swing.*;

import java.awt.event.*;
import java.awt.*;
import java.sql.*;

public class ForgetPassword implements ActionListener {

	JFrame f;
	JButton b1;
	JTextField tf1;
	JLabel l1, lmsg;
	Container c;
	Connection con;
	PreparedStatement psm;

	public ForgetPassword(String msg) {
		f = new JFrame("ForgetPassword");
		f.setSize(500, 500);
		f.setVisible(true);
		f.setLayout(null);
		c = f.getContentPane();
		c.setBackground(Color.cyan);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		b1 = new JButton("GO");
		b1.setBounds(150, 380, 80, 50);
		c.add(b1);
		b1.addActionListener(this);
		lmsg = new JLabel(msg);
		lmsg.setBounds(50, 50, 100, 50);
		c.add(lmsg);
		l1 = new JLabel("Enter USER ID");
		l1.setBounds(50, 250, 100, 50);
		c.add(l1);
		tf1 = new JTextField();
		tf1.setBounds(200, 250, 100, 50);
		c.add(tf1);
		try {
			System.out.println("wait Registerring....");
			Class.forName("oracle.jdbc.driver.OracleDriver"); // type4 driver
			System.out.println("wait Connectng....");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "1234");
			System.out.println("Connected....");
		} catch (Exception e) {
			System.out.println("Exception generated : " + e);
		}

	}

	public void actionPerformed(ActionEvent ae) {
		String uid = tf1.getText();
		try {
			psm = con.prepareStatement("select SQUS from reg where U_ID=?");
			psm.setString(1, uid);
			ResultSet rs = psm.executeQuery();
			if (rs.next()) {
				f.dispose();
				new SecretQuestion("Your secret Question is " + rs.getString("sq"));
			} else {
				f.dispose();
				new ForgetPassword("Invalid USer ID ");
			}
		} catch (Exception e) {
			System.out.println("Exception generated : " + e);
		}
	}
}
