package cn.yxj.swing;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class BankMenu extends JFrame {

	private JPanel contentPane;
	private JPasswordField passwordField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BankMenu frame = new BankMenu();
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
	public BankMenu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 438, 451);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("用户名");
		label.setEnabled(false);
		label.setBackground(Color.GREEN);
		label.setBounds(74, 135, 55, 27);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("密 码");
		label_1.setEnabled(false);
		label_1.setBackground(Color.GREEN);
		label_1.setBounds(75, 188, 54, 27);
		contentPane.add(label_1);
		
		final JTextField textField = new JTextField();
		textField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if(textField.getText().length()==0){
					textField_1.setVisible(true);
					textField_1.setText("用户名不能为空");
					textField_1.requestFocus();
				}
			}
		});
		textField.setBounds(136, 138, 161, 33);
		contentPane.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if(passwordField.getPassword().length==0){
					textField_2.setVisible(true);
					textField_2.setText("密码不能为空");
					textField_2.requestFocus();
				}
			}
		});
		passwordField.setBounds(136, 181, 161, 34);
		contentPane.add(passwordField);
		
		JButton button = new JButton("登陆");
		button.setBounds(136, 242, 63, 23);
		contentPane.add(button);
		
		JButton button_1 = new JButton("登陆");
		button_1.setBounds(216, 242, 63, 23);
		contentPane.add(button_1);
		
		JLabel label_2 = DefaultComponentFactory.getInstance().createTitle("欢迎使用***银行客户端");
		label_2.setBounds(145, 52, 174, 33);
		contentPane.add(label_2);
		
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setVisible(false);
		textField_1.setColumns(10);
		textField_1.setBounds(304, 138, 161, 33);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setEditable(false);
		textField_2.setVisible(false);
		textField_2.setColumns(10);
		textField_2.setBounds(304, 181, 161, 33);
		contentPane.add(textField_2);
	}
}
