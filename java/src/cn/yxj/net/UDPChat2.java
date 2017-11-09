package cn.yxj.net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class UDPChat2 {

	public static void main(String[] args) throws SocketException {
		
		DatagramSocket  sendds=new DatagramSocket();
		DatagramSocket  recds=new DatagramSocket(2222);
		Send2 send=new Send2(sendds);
		Receive2  rec=new Receive2(recds);
		
		Thread t1=new Thread(send);
		Thread t2=new Thread(rec);
		
		t1.start();
		t2.start();
  

	}}
  class Send2 implements Runnable{
	  private 	DatagramSocket  ds;

		@Override
		public void run() {
			System.out.println("UDPSend ....................run.");
			try{
			//1,建立UDP的Socke，它具备发送或接收功能,(自定义发送端端口号为：8888)
			
			//2.将数据封装到数据包中，数据包对象是DatagramPacket(通过键盘录入数据)
		  BufferedReader  br=new BufferedReader(new InputStreamReader(System.in));
		  String  line=null;
		  while((line=br.readLine())!=null){
			  byte[] buf=line.getBytes();
			  DatagramPacket  dp=new DatagramPacket(buf, buf.length,InetAddress.getByName("127.0.0.1"),1111);
			  //3使用socket对象的send方法，将数据包发送出去
			  ds.send(dp);
			  if("886".equals(line)){
				  break;
			  }
		  }
		  //4.关闭资源
		  ds.close();
			}catch(IOException e){
				
			}	
		}

	
		public Send2(DatagramSocket ds) {
			super();
			this.ds = ds;
		}
		}
 class Receive2 implements Runnable{
	 private 	DatagramSocket  ds;
		
	public Receive2(DatagramSocket ds) {
		super();
		this.ds = ds;
	}
			@Override
			public void run() {
			
				System.out.println("UDPReceive ....................run.");
				//1,建立UDP的Socke，它具备发送或接收功能,(定义接收端端口号6666)
			try{
		
				//2.接受数据之前，先将数据存储包数据包中
				//3.定义数据包
				byte[]  buf= new byte[1024];
				DatagramPacket  dp=new DatagramPacket(buf, buf.length);
				while(true){
					//3使用socket对象的send方法，将数据包发送出去
					ds.receive(dp);
					String data= new String(dp.getData(),0,dp.getLength());
					System.out.println(dp.getAddress()+":"+dp.getPort()+":"+data);
				}}catch (Exception e) {
					e.printStackTrace();
				}	
			}
			}




