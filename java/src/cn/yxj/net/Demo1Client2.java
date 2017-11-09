package cn.yxj.net;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class Demo1Client2 {

	public static void main(String[] args) {

		try {
			MulticastSocket socket = new MulticastSocket(1111);    //指定广播端口，用来接收服务器端的广播数据
			InetAddress address = InetAddress.getByName("230.0.0.1");
			socket.joinGroup(address);
			byte[]  buf= new byte[1024];
			DatagramPacket dp = new DatagramPacket(buf, buf.length);
			socket.receive(dp);
			System.out.println(dp.getAddress());
			socket.close();
			String data = new String(dp.getData(),0,dp.getLength());
			System.out.println(data);
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}

}
