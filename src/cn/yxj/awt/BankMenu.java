package cn.yxj.awt;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;


public class BankMenu extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	@Override
	public void actionPerformed(ActionEvent e) {
		
	}
	public BankMenu(){
		
		this.setTitle("欢迎登陆***银行");
		this.setSize(500, 500);
		Panel  p1=new  Panel();
		Label l1= new Label("username");
		 JTextField t1 = new JTextField(20);
	
		 t1.setBounds(50, 50, 10, 50);
		p1.setLayout(new  FlowLayout());
		p1.add(l1);
		p1.add(t1);
		
		Panel  p2=new  Panel();
		Label l2= new Label("password");
		JTextField t2 = new JTextField(20);
         
		 t2.setBounds(50, 70, 10, 50);
		p2.setLayout(new  FlowLayout());
		p2.add(l2);
		p2.add(t2);
		
		Panel  p5=new  Panel();
		p5.setLayout(new GridLayout());
		p5.add(p1);
		p5.add(p2);
		
		Panel  p3=new  Panel();
		JButton b1= new JButton("登陆");
		JButton b2= new JButton("注册");
		p3.setLayout(new  GridLayout(1,2,10,10));
		p3.add(b1);
		p3.add(b2);
		
	
		   getContentPane().setLayout(new BorderLayout(3,3));
		   getContentPane().add("Center",p5);
		   getContentPane().add("South",p3);	
	}
	public static void main(String[] args) {
		BankMenu bankMenu = new BankMenu();
		bankMenu.setVisible(true);
        bankMenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
	}
}
