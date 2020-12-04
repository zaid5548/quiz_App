package project1;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;

public class InvalidLogin implements ActionListener {

	JFrame f;
	JButton b1;
	JTextField tf1, tf2;
	JLabel l1, l2, lmsg;
	Container c;
	Connection con;
	PreparedStatement psm;

	public InvalidLogin() {

		f = new JFrame("LOGIN");
		f.setSize(600, 600);
		f.setVisible(true);
		f.setLayout(null);
		c = f.getContentPane();
		c.setBackground(Color.cyan);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		b1 = new JButton("GO");
		b1.setBounds(150, 480, 80, 50);
		c.add(b1);
		b1.addActionListener(this);
		lmsg = new JLabel("INVALID User Name or Password");
		lmsg.setBounds(20, 50, 200, 50);
		c.add(lmsg);
		l1 = new JLabel("USERNAME");
		l1.setBounds(50, 150, 100, 50);
		c.add(l1);
		l2 = new JLabel("PASSWORD");
		l2.setBounds(50, 200, 100, 50);
		c.add(l2);
		tf1 = new JTextField();
		tf1.setBounds(200, 150, 100, 50);
		c.add(tf1);
		tf2 = new JTextField();
		tf2.setBounds(200, 200, 100, 50);
		c.add(tf2);
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
		String pass = tf2.getText();
		try {
			psm = con.prepareStatement("select * from reg where U_ID=?and PWD=?");
			psm.setString(1, uid);
			psm.setString(2, pass);
			ResultSet rs = psm.executeQuery();
			if (rs.next()) {
				f.dispose();
				new Exam();
			} else {
				f.dispose();
				new InvalidLogin();
			}
		} catch (Exception e) {
			System.out.println("Exception generated : " + e);
		}
	}
}
