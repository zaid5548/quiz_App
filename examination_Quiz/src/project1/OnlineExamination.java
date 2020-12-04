package project1;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.io.*;

public class OnlineExamination extends JFrame implements ActionListener{
	JLabel l1;
	JButton b1,b2,b3;
	Container c;
	public OnlineExamination()
	{
	super("OnlineExamination");
	c=getContentPane();
	c.setBackground(Color.LIGHT_GRAY);
	l1=new JLabel("WELCOME to Online Exam..");
	l1.setBounds(180,10,380,150);
	b1=new JButton("new user");
	b1.setBounds(10,200,180,50);
	b2=new JButton("Existing user");
	b2.setBounds(200,200,180,50);
	b3=new JButton("forgot password");
	b3.setBounds(400,200,180,50);
	c.add(l1);
	c.add(b2);
	c.add(b1);
	c.add(b3);
	b1.addActionListener(this);
	b2.addActionListener(this);
	b3.addActionListener(this);
	setLayout(null);
	setSize(600,600);
	setVisible(true);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		System.out.println("welcome....");
		new OnlineExamination();
	}
	public void actionPerformed(ActionEvent ae)
	{
		dispose();
		if(b1==ae.getSource())
			new Registration("");
		else if(b2==ae.getSource())
			new Login("");
		else
			new ForgetPassword("");
	}
}
