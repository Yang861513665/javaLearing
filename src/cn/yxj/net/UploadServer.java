package cn.yxj.net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class UploadServer {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {


		System.out.println("上传文本服务端运行....");
		// 服务端：
		// 思路：
		// 1，创建服务端socket 明确端口。
		ServerSocket ss = new ServerSocket(10006);
		while (true) {
			// 获取客户端对象。
			Socket s = ss.accept();
			System.out.println(s.getInetAddress().getHostAddress()+".....connected");

			// 2，源：socket输入流。读取客户端的发过来的数据。
			BufferedReader bufIn = new BufferedReader(new InputStreamReader(s.getInputStream()));
					

			// 3，目的：文件。
			//PrintWriter pw = new PrintWriter(new FileWriter("f:/javaTempFiles/server.txt"),true);
			PrintWriter printWriter = new PrintWriter("f:/javaTempFiles/server.txt");  
			// 4，频繁的读写操作。
			String line = null;
			while ((line = bufIn.readLine()) != null) {
//				if("over".equals(line)){
//					break;
//				}
				printWriter.println(line);
				printWriter.flush();
			}
			 printWriter.close();
			// 5，发回给客户端上传成功字样。
			PrintWriter out = new PrintWriter(s.getOutputStream(),true);
			out.println("上传成功");
			
			// 6，关闭客户端。
			s.close();
		//	ss.close();
		}


	}

}
