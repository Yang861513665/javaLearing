package cn.yxj.net;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.SocketException;

import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Client2 extends JFrame implements Runnable {
	/**
	 * 实现广播通信
	 * */

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private  static   JTextArea  textArea;
	private static 	InetAddress localHost;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
			     	DatagramSocket sendSocket;
					try {
						//指定发送端端口
						sendSocket = new DatagramSocket(2222);
						Client2 frame = new Client2( sendSocket);
						frame.setTitle("来啊，快活啊");
						frame.setVisible(true);
						new Thread(frame).start();	
					} catch (SocketException e) {
						e.printStackTrace();
					}
				} 
		});
	}

	/**
	 * Create the frame.
	 */
	public Client2( final DatagramSocket  sendSocket) {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				byte[]  buf=("系统提示退出").getBytes();
				try {
					DatagramPacket dp = new DatagramPacket(buf, buf.length, InetAddress.getByName("230.0.0.1"),1010);
					sendSocket.send(dp);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			    System.exit(0);
			}
		});
		setBounds(100, 100, 361, 467);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 10, 325, 362);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 325, 362);
		panel.add(scrollPane);
		
		 textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		
		textField = new JTextField();
		textField.setBounds(10, 382, 242, 36);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton button = new JButton("发送");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("action---------------");
				  try {
				
						System.out.println("click------------"+textField.getText());
					
						byte[]  buf=  textField.getText().getBytes();
						textField.setText("");
						//将数据包发送到多播组端口 1010
						DatagramPacket dp = new DatagramPacket(buf, buf.length, InetAddress.getByName("230.0.0.1"),1010);
						sendSocket.send(dp);
					} catch ( IOException e1) {
						e1.printStackTrace();
					}
			}
		});
		button.setBounds(252, 382, 83, 36);
		contentPane.add(button);
	}

	

	@Override
	/**
	 * 接收数据包
	 * */
	public void run() {
		System.out.println("run------------");
	try {
	      @SuppressWarnings("resource")
			MulticastSocket socket = new MulticastSocket(1010);    //指定多播组端口号
			InetAddress address = InetAddress.getByName("230.0.0.1");   //多播组的ip
			socket.joinGroup(address);   //加入多播组
			localHost = InetAddress.getLocalHost();
			byte[]  buf=("用户"+ localHost +"进入聊天室").getBytes();
		     DatagramPacket dp2 = new DatagramPacket(buf, buf.length, InetAddress.getByName("230.0.0.1"),1010);
			socket.send(dp2);
			
			DatagramPacket dp = new DatagramPacket(buf, buf.length);
		while(true){
			socket.receive(dp);
			String data= new String(dp.getData(),0,dp.getLength());
			if(data.contains("进入聊天室")){
				textArea.append(data+"\r\n");
			}else if(data.contains("系统提示退出")){
				textArea.append("系统提示:"+localHost+"端口："+dp.getPort()+"退出聊天室"+"\r\n");
			}
			else{
			textArea.append(localHost+",端口"+ dp.getPort()+"："+data+"\r\n");}
			Thread.sleep(1000);
		}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
