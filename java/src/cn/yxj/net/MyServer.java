package cn.yxj.net;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class MyServer {

	public static void main(String[] args) throws IOException {
		
		System.out.println("自定义服务器启动");
		//创建tcp服务端socket，明确端口
		ServerSocket ss =new ServerSocket(10100);
		//获取客户端socket对象
		Socket s =ss.accept();
		System.out.println(s.getInetAddress().getHostAddress()+".....connection..");
		InputStream  in=s.getInputStream();
		byte[] buf=  new byte[1024];
		int len=in.read(buf);
		String data=new String(buf,0,len);
		System.out.println(data);
		
		
	OutputStream out =	s.getOutputStream();
	//out.write("欢迎访问我的微型服务器".getBytes());
	PrintWriter pw= new PrintWriter(out,true);
	pw.println("<h1>hello  welcome to  my   server</h1>");
	
	s.close();
	ss.close();

	}

}
