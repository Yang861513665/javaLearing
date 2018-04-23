package cn.yxj.net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;


public class UDPSend {
public static void main(String[] args) throws IOException {
	System.out.println("UDPSend ....................run.");
	//1,建立UDP的Socke，它具备发送或接收功能,(自定义发送端端口号为：8888)
	DatagramSocket  ds=new DatagramSocket(8888);
	//2.将数据封装到数据包中，数据包对象是DatagramPacket(通过键盘录入数据)
  BufferedReader  br=new BufferedReader(new InputStreamReader(System.in));
  String  line=null;
  while((line=br.readLine())!=null){
	  byte[] buf=line.getBytes();
	  DatagramPacket  dp=new DatagramPacket(buf, buf.length,InetAddress.getByName("127.0.0.255"),6666);
	  //3使用socket对象的send方法，将数据包发送出去
	  ds.send(dp);
	  if("886".equals(line)){
		  break;
	  }
  }
  //4.关闭资源
  ds.close();
	
	
}
}
