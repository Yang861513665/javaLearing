package cn.yxj.net;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.SocketException;

public class Demo2Server {

	public static void main(String[] args) throws IOException {
	  try {
	//	DatagramSocket sendSocket = new DatagramSocket();
		  MulticastSocket sendSocket  = new MulticastSocket(1111);
		byte[]  buf=  "我是通过广播发来的数据".getBytes();
		DatagramPacket dp = new DatagramPacket(buf, buf.length, InetAddress.getByName("230.0.0.1"),1111);
		sendSocket.send(dp);
		sendSocket.close();
	} catch (SocketException e) {
		e.printStackTrace();
	}
	}
}
