package cn.yxj.net;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer implements  Runnable{
     private  Socket s;
	public TCPServer(Socket s2) {
     this.s=s2;
	}
	public static void main(String[] args) throws IOException {      //利用多线程，解决并发问题
		/*
		 * 案例2：实现客户端和服务端的收发过程
		 * 服务器端：
		 * */
		System.out.println("上传图片服务端启动......");
		//创建tcp服务端socket，明确端口
		ServerSocket ss=new ServerSocket(10000);
	   while(true){	
		//获取客户端对象
		Socket s=ss.accept();
		System.out.println(s.getInetAddress().getHostAddress()+".......connceted");
		//每次不同用户发出请求开启新的线程进行处理
		 new Thread(new  TCPServer(s)).start();
	     }
	}
 /**
  *  获得上传服务方法
  * */
	public static void getUploadServer(Socket s) throws IOException,     
			FileNotFoundException {
		InputStream in=s.getInputStream();
	
		int count=0;
		File  file=new File("f:/javaTempFiles/server.jpg");
		while(file.exists()){
		 count++;
		  file=new File("f:/javaTempFiles/server"+"("+count+")"+".jpg");
		}
		
		FileOutputStream fos=new FileOutputStream(file);
		byte[] buf=new byte[1024];
		int len;
		while((len=in.read(buf))!=-1){
			fos.write(buf, 0, len);
		}	
			fos.close();

		//给客户端回馈数据
		OutputStream out=s.getOutputStream();
		out.write("上传图片成功..".getBytes());
		//关闭客户端
		s.close();
		//关闭服务端,这里服务端就不关闭了
		//ss.close();
	}

	@Override
	public void run() {

		 try {
			getUploadServer(s);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	}


