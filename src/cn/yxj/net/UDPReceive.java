package cn.yxj.net;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;


public class UDPReceive {
public static void main(String[] args) throws IOException {
	System.out.println("UDPReceive ....................run.");
	//1,建立UDP的Socke，它具备发送或接收功能,(定义接收端端口号6666)
	DatagramSocket  ds=new DatagramSocket(6666);
	//2.接受数据之前，先将数据存储包数据包中
	//3.定义数据包
	while(true){
		
		byte[]  buf= new byte[1024];
		DatagramPacket  dp=new DatagramPacket(buf, buf.length);
		//3使用socket对象的send方法，将数据包发送出去
		ds.receive(dp);
		String data= new String(dp.getData(),0,dp.getLength());
		System.out.println(dp.getAddress()+":"+dp.getPort()+":"+data+":"+dp.getLength());

	}
	
}
}
