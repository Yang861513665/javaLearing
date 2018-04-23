package cn.yxj.awt;

import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class FrameDemo2 {


	public static void main(String[] args) {

		Frame frame = new Frame("my second awt");
		frame.addWindowListener(new  WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
			    System.exit(0);
			}
		});
		
		JLabel l1 = new JLabel("username");
		JLabel l2 = new JLabel("password");
		JLabel l3 = new JLabel("erorMessage");
		l3.setVisible(false);
		
		final JTextField t1 = new JTextField("please input  username");
		final JTextField t2 = new JTextField("please input  password");
		final JTextField t3 = new JTextField();
		
		t3.setVisible(false);
	    
		JButton b1 = new JButton("login");
		JButton b2 = new JButton("register");

		t1.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if(t1.getText().matches("\\w+")&&t1.getText()!=""){
					t3.setVisible(false);
				}else{
					t3.setVisible(true);
					t3.setText("用户名不能为空或输入格式错误");
					t1.requestFocus();		
			}	
			}
		});
		t1.addMouseListener(new  MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(t1.getText().equals("please input  username"))
					t1.setText("");
			}
		});
		t2.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if(t2.getText()!=""){
					t3.setVisible(false);
				}else{
					t3.setVisible(true);
					t3.setText("密码不能为空");
					t2.requestFocus();		
			}	
			}
		});
		t2.addMouseListener(new  MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(t2.getText().equals("please input  password"))
					t2.setText("");
			}
		});
		b1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			if(!t2.getText().equals("123")){
				t3.setVisible(true);
				t3.setText("密码错误");
			}else{t3.setText("登陆成功");
			t3.setVisible(true);}
			}
		});
		
		frame.setLayout(new  GridLayout(4,2,1,1));
		frame.add(l3);
		frame.add(t3);
		frame.add(l1);
		frame.add(t1);
		frame.add(l2);
		frame.add(t2);
		frame.add(b1);
		frame.add(b2);
		
		frame.setSize(300, 120);
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
		
	}

}
