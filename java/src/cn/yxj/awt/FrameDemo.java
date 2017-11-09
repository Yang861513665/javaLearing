package cn.yxj.awt;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


public class FrameDemo  {


	public static void main(String[] args) {
         
         Frame frame = new Frame("my  first awt");
         Button b = new Button("click");
         b.addActionListener(new ActionListener() {	    //给按钮加上事件监听
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("clicked----"+e);			
			}
		});
         frame.addWindowListener(new WindowAdapter() {   //接收窗口事件的抽象适配器类。
        	 @Override
        	public void windowClosing(WindowEvent e) {
        		System.exit(0);
        	}
		});
         
         frame.setLayout(new FlowLayout());
         frame.add(b);
         frame.setSize(200, 200);
         frame.setVisible(true);
	}

}
