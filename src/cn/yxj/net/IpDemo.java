package cn.yxj.net;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class IpDemo {

	public static void main(String[] args) throws UnknownHostException {
	
	//	System.out.println(ip.getHostAddress());
		InetAddress  ip=InetAddress.getByName("www.baidu.com");
		System.out.println(ip.getHostAddress());
    	System.out.println(ip.getHostName());
    	System.out.println(ip);

		
	}

}
