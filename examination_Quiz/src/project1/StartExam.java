package project1;

import javax.swing.*;

import java.awt.event.*;
import java.awt.*;
import java.sql.*;

public class StartExam implements ActionListener {

	JFrame f;
	JButton b1;
	JLabel lq, lmsg, score;
	Container c;
	Connection con;
	Statement stm;
	ResultSet rs;
	ButtonGroup bg;
	JRadioButton a1, a2, a3;
	int t = 0, ca = 0;
	String y = "";

	public StartExam() {

		f = new JFrame("LOGIN");
		f.setSize(620, 700);
		f.setVisible(true);
		f.setLayout(null);
		c = f.getContentPane();
		c.setBackground(Color.cyan);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		b1 = new JButton("NEXT");
		b1.setBounds(150, 500, 160, 50);
		c.add(b1);
		b1.addActionListener(this);
		lmsg = new JLabel("");
		lmsg.setBounds(200, 420, 270, 80);
		c.add(lmsg);
		score = new JLabel("your score " + t);
		score.setBounds(380, 30, 170, 80);
		c.add(score);
		lq = new JLabel("");
		lq.setBounds(40, 50, 270, 80);
		c.add(lq);
		bg = new ButtonGroup();
		a1 = new JRadioButton();
		a2 = new JRadioButton();
		a3 = new JRadioButton();
		bg.add(a1);
		bg.add(a2);
		bg.add(a3);
		c.add(a1);
		c.add(a2);
		c.add(a3);
		a1.setBounds(25, 170, 200, 40);
		a2.setBounds(25, 280, 200, 40);
		a3.setBounds(25, 380, 200, 40);
		try {
			System.out.println("wait Registerring....");
			Class.forName("oracle.jdbc.driver.OracleDriver"); // type4 driver
			System.out.println("wait Connectng....");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "1234");
			stm = con.createStatement();
			System.out.println("connected");
			rs = stm.executeQuery("select * from questions");
			if (rs.next()) {
				lq.setText("Q. No. " + rs.getInt("qno") + " : " + rs.getString("quest"));
				a1.setText(rs.getString("ans1"));
				a2.setText(rs.getString("ans2"));
				a3.setText(rs.getString("ans3"));
			}
		} catch (Exception e) {
			System.out.println("Exception generated : " + e);
		}
	}

	public void actionPerformed(ActionEvent ae) {
		if (y.equals(b1.getText())) {
			f.dispose();
			new FinalScore(t);
		}
		try {
			ca = rs.getInt("cans");
			if ((ca == 1 && a1.isSelected()) || (ca == 2 && a2.isSelected()) || (ca == 3 && a3.isSelected()))
				t = t + 10;
			if (rs.next()) {
				lq.setText("Q. No. " + rs.getInt("qno") + " : " + rs.getString("quest"));
				a1.setText(rs.getString("ans1"));
				a2.setText(rs.getString("ans2"));
				a3.setText(rs.getString("ans3"));
				score.setText("Your score is " + t);
			} else {
				lmsg.setText("End of questions");
				b1.setText("End");
				y = "End";
			}
		} catch (Exception e) {
			System.out.println("Exception generated : " + e);
		}

	}

}
