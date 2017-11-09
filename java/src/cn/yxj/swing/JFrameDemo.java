package cn.yxj.swing;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java.io.File;

import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class JFrameDemo extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 * 
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFrameDemo frame = new JFrameDemo();
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
	public JFrameDemo() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 778, 485);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton button = new JButton("确定");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
		}});
		button.setBounds(591, 26, 74, 37);
		contentPane.add(button);
		
		textField = new JTextField();
		
		textField.setBounds(10, 26, 581, 37);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 73, 658, 364);
		contentPane.add(scrollPane);
		
		final JTextArea textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		textField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//通过文本区域获得路径
				String dir1=textField.getText();
				//将字符路径封装成文本对象
				File dir2=new File(dir1);
				if (dir2.exists()&&dir2.isDirectory())
				{
					String[] names=dir2.list();
			
			for (String name : names) {
				//将目录名字显示在文本域
			textArea.append(name+"\n");
			}
			}
		}
		});
	}
}
