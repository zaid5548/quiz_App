package project1;

import javax.swing.*;

import java.awt.event.*;
import java.awt.*;
import java.sql.*;

public class FinalScore implements ActionListener {
	int score;

	JFrame f;
	JButton b1;
	JLabel l1;
	Font fnt;
	Container c;

	public FinalScore(int score) {
		this.score = score;
		f = new JFrame("Final Score");
		f.setSize(620, 700);
		f.setVisible(true);
		f.setLayout(null);
		c = f.getContentPane();
		c.setBackground(Color.cyan);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		b1 = new JButton("CLOSE");
		b1.setBounds(150, 500, 160, 50);
		c.add(b1);
		b1.addActionListener(this);
		l1 = new JLabel("YOUR SCORE IS " + score);
		l1.setBounds(20, 80, 270, 80);
		c.add(l1);
		// fnt=new Font(Font.MONOSPACED,Font.BOLD,Font.PLAIN);
		// l1.setFont(fnt);
	}

	public void actionPerformed(ActionEvent ae) {
		System.exit(0);

	}
}
