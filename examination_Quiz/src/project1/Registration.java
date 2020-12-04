package project1;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;

public class Registration implements ActionListener {
	JFrame f;
	JButton b1;
	JTextField tf1, tf2, tf3, tf4, tf5, tf6, tf7;
	JLabel l1, l2, l3, l4, l5, l6, l7, idmsg;
	Container c;
	Connection con;
	PreparedStatement psm1;

	public Registration(String msg) {
		f = new JFrame("REGISTRATION");
		f.setSize(900, 700);
		f.setVisible(true);
		f.setLayout(null);
		c = f.getContentPane();
		b1 = new JButton("GO");
		b1.setBounds(370, 570, 80, 50);
		c.add(b1);
		b1.addActionListener(this);
		l1 = new JLabel("USER ID");
		l1.setBounds(50, 20, 100, 50);
		c.add(l1);
		idmsg = new JLabel(msg);
		idmsg.setBounds(380, 20, 380, 50);
		c.add(idmsg);
		l2 = new JLabel("PASSWORD");
		l2.setBounds(50, 100, 100, 50);
		c.add(l2);
		l3 = new JLabel("NAME");
		l3.setBounds(50, 180, 100, 50);
		c.add(l3);
		l4 = new JLabel("age");
		l4.setBounds(50, 260, 100, 50);
		c.add(l4);
		l5 = new JLabel("QUANTITY");
		l5.setBounds(50, 340, 100, 50);
		c.add(l5);
		l6 = new JLabel("SECRET QUES");
		l6.setBounds(50, 420, 100, 50);
		c.add(l6);
		l7 = new JLabel("SECRET ANS");
		l7.setBounds(50, 500, 100, 50);
		c.add(l7);
		tf1 = new JTextField();
		tf1.setBounds(200, 20, 100, 50);
		c.add(tf1);
		tf2 = new JTextField();
		tf2.setBounds(200, 100, 100, 50);
		c.add(tf2);
		tf3 = new JTextField();
		tf3.setBounds(200, 180, 100, 50);
		c.add(tf3);
		tf4 = new JTextField();
		tf4.setBounds(200, 260, 100, 50);
		c.add(tf4);
		tf5 = new JTextField();
		tf5.setBounds(200, 340, 100, 50);
		c.add(tf5);
		tf6 = new JTextField();
		tf6.setBounds(200, 420, 100, 50);
		c.add(tf6);
		tf7 = new JTextField();
		tf7.setBounds(200, 500, 100, 50);
		c.add(tf7);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
		String ename = tf3.getText();
		int age = Integer.parseInt(tf4.getText());
		int qty = Integer.parseInt(tf5.getText());
		String ques = tf6.getText();
		String ans = tf7.getText();
		try {
			psm1 = con.prepareStatement("select * from reg where U_ID=?");
			psm1.setString(1, uid);
			ResultSet rs = psm1.executeQuery();
			if (rs.next()) {
				idmsg.setText("sorry uid already exist try again");
				tf1.setText("");
			} else {
				psm1 = con.prepareStatement("insert into reg values(?,?,?,?,?,?,?)");
				psm1.setString(1, uid);
				psm1.setString(2, pass);
				psm1.setString(3, ename);
				psm1.setInt(4, age);
				psm1.setInt(5, qty);
				psm1.setString(6, ques);
				psm1.setString(7, ans);
				int i = psm1.executeUpdate();
				System.out.println("row inserted:" + i);
				if (i == 1) {
					new Login("Congratulations " + ename + " you can login now");
					f.dispose();
					con.close();
				}
			}

		} catch (Exception e) {
			idmsg.setText("Exception generated ");
			e.printStackTrace();
		}
	}

}
