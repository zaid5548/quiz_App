package project1;

import javax.swing.*;

import java.awt.event.*;
import java.awt.*;

public class Password implements ActionListener {

	JFrame f;
	JButton b1;
	JLabel l1;
	Container c;

	public Password(String msg) {
		f = new JFrame("LOGIN");
		f.setSize(400, 400);
		f.setVisible(true);
		f.setLayout(null);
		c = f.getContentPane();
		c.setBackground(Color.cyan);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		b1 = new JButton("LOGIN ");
		b1.setBounds(150, 180, 80, 50);
		c.add(b1);
		b1.addActionListener(this);
		l1 = new JLabel(msg);
		l1.setBounds(50, 50, 300, 50);
		c.add(l1);

	}

	public void actionPerformed(ActionEvent ae) {
		f.dispose();
		new Login("");
	}
}
