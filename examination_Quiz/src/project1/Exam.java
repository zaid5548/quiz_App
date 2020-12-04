package project1;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class Exam implements ActionListener {
	JLabel l1;
	JButton b1;
	Container c;
	JFrame f;

	public Exam() {
		f = new JFrame("Welcome for Exam");
		c = f.getContentPane();
		c.setBackground(Color.LIGHT_GRAY);
		l1 = new JLabel("click on START EXAM Button to start Examination ");
		l1.setBounds(180, 10, 380, 150);
		b1 = new JButton("START EXAM ");
		b1.setBounds(200, 200, 180, 50);
		c.add(l1);
		c.add(b1);
		b1.addActionListener(this);
		f.setLayout(null);
		f.setSize(600, 600);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void actionPerformed(ActionEvent ae) {
		f.dispose();
		new StartExam();

	}

}
