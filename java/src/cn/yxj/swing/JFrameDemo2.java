package cn.yxj.swing;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import java.awt.Insets;
import java.awt.Component;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JFrameDemo2 extends JFrame {
	private static final long serialVersionUID = 1L;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFrameDemo2 frame = new JFrameDemo2();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public JFrameDemo2() {
		getContentPane().setFont(new Font("SimSun", Font.PLAIN, 12));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 763, 453);
		
		JMenuBar MenuBar = new JMenuBar();
		MenuBar.setMargin(new Insets(100, 0, 0, 0));
		MenuBar.setFont(new Font("宋体", Font.PLAIN, 90));
		MenuBar.setAlignmentX(Component.RIGHT_ALIGNMENT);
		MenuBar.setToolTipText("");
		setJMenuBar(MenuBar);
		
		JMenu menu = new JMenu("文件");
		MenuBar.add(menu);
		
		JMenuItem menuItem_1 = new JMenuItem("退出");
		menu.add(menuItem_1);
		
		JMenuItem menuItem = new JMenuItem("打开");
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		menu.add(menuItem);
		
		JMenu menu_1 = new JMenu("编辑");
		MenuBar.add(menu_1);
		
		JMenuItem menuItem_3 = new JMenuItem("退出");
		menu_1.add(menuItem_3);
		
		JMenuItem menuItem_4 = new JMenuItem("复制");
		menu_1.add(menuItem_4);
		
		JMenuItem menuItem_2 = new JMenuItem("粘贴");
		menu_1.add(menuItem_2);
	}
}
