package cn.yxj.net;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import java.io.OutputStream;
import java.net.Socket;

public class TCPClient {

	public static void main(String[] args) throws IOException {

		/*
		 * 案例2：实现客户端和服务端的收发过程 客户端：上传图片
		 */
		System.out.println("上传图片客户端启动......");
		// 创建客户端socket对象，明确服务端地址和端口
		Socket s = new Socket("127.0.0.1", 10000);
		// 发送数据，通过socket输出流完成（注：如果通道建立成功就会出现socket io流，客户端要做的就是获取socket流中的输出流）
		File  file  =new   File("f:/javaTempFiles/client.jpg");
		
		FileInputStream  fis=new FileInputStream(file);
		
		OutputStream out = s.getOutputStream();
		
		byte[] buf = new byte[1024];
		int len;
		while(( len=fis.read(buf))!=-1){
			out.write(buf,0,len);
		}
		fis.close();
		s.shutdownOutput();
		

		// 读取服务端返回的数据，通过socket输入流
		InputStream inputStream = s.getInputStream();
		byte[] buf2= new byte[1024];
		int len2 = inputStream.read(buf2);
		String text = new String(buf2, 0, len2);
		System.out.println(text);
		// 关闭资源
		s.close();

	}

}
