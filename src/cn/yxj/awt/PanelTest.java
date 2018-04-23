package cn.yxj.awt;

import java.awt.*;


public class PanelTest  extends  Panel {

	private static final long serialVersionUID = 1L;

	public static void main(String args[]) {
	      	PanelTest p= new PanelTest();                 //创建一个面板
		  	Frame f=new Frame("正在测试面板！");   //创建一个带标题的窗口
		  	f.add(p);      
		  	f.setSize(300,200);
		  	f.setVisible(true);
		}	
	 } 

