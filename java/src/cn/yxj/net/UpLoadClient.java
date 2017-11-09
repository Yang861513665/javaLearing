package cn.yxj.net;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class UpLoadClient {

	public static void main(String[] args) throws UnknownHostException, IOException {
		System.out.println("上传文件客户端运行......");
		// 客户端：
		// 步骤：
		// 1，创建socket，明确地址和端口。
		Socket s = new Socket("127.0.0.1", 10006);

		// 2，源：读取文本文件。获取需要转换的数据。
		BufferedReader bufr = new BufferedReader(new InputStreamReader(new FileInputStream("f:/javaTempFiles/client.txt")));
		
		// 3，目的：网络，socket输出流。将录入的数据发送到服务端。
		PrintWriter out = new PrintWriter(s.getOutputStream(),true);

		
		// 4，频繁的读写操作。
		String line = null;
		while((line=bufr.readLine())!=null){
			
			out.println(line);
			
			
		}
		
		//给服务端发送一个结束标记。这个标记是约定标记。有点麻烦。可以更简单。使用socket对象的shutdownOutput();
//		out.println("over");
		s.shutdownOutput();//向服务端发送了结束标记。可以让服务端结束读取的动作。
		
		
		// 5，源：socket，socket读取流，读取服务端发回来的上传成功信息。
		BufferedReader bufIn = new BufferedReader(new InputStreamReader(s.getInputStream()));
		String info = bufIn.readLine();
		System.out.println(info);
		
		// 6，关闭资源。
		bufr.close();
		


	}

}
