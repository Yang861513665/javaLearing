package cn.yxj.swing;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
class MyActionListener implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		System.exit(0);
		
	}
	
}

public class SwingDemo1 extends JFrame implements ItemListener {
	private static final long serialVersionUID = 1L;
      static  JCheckBoxMenuItem m;
	SwingDemo1(){
	//菜单条	
	JMenuBar mb = new JMenuBar();
	//一级菜单
	JMenu m1 = new  JMenu("文件");  
	JMenu m2 = new  JMenu("编辑");
	JMenu m3 = new  JMenu("帮助");

	//一级菜单项
	JMenuItem   mi1= new  JMenuItem("新建");
	JMenuItem   mi2= new  JMenuItem("打开");
	JMenuItem   mi3= new  JMenuItem("退出");
	mi3.addActionListener(new MyActionListener());
	
	
	//二级菜单
	JMenu m31 = new  JMenu("问好");
	//二级菜单项

	  JCheckBoxMenuItem cmi1=new JCheckBoxMenuItem("早上好！");
	  JCheckBoxMenuItem cmi2=new JCheckBoxMenuItem("下午好！");
	  JCheckBoxMenuItem cmi3=new JCheckBoxMenuItem("晚安！再见！");
	  
	  cmi1.addItemListener(this);
	  cmi2.addItemListener(this);
	  cmi3.addItemListener(this);
	m31.add(cmi1);
	m31.add(cmi2);
	m31.add(cmi3);
	m3.add(m31);
	
	
	m1.add(mi1);
	m1.add(mi2);
	m1.add(mi3);
	

	
	
	mb.add(m1);
	mb.add(m2);
	mb.add(m3);
     this.setJMenuBar(mb);
	}
	public static void main(String[] args) {
		SwingDemo1 s1 = new SwingDemo1();
		s1.setSize(500, 400);
		s1.setVisible(true);
		s1.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
	
		JCheckBoxMenuItem  item=	 (JCheckBoxMenuItem) e.getSource();
		System.out.println(item.getText());
		
	}

	
}
