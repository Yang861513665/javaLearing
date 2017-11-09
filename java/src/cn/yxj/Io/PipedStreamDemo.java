package cn.yxj.Io;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

public class PipedStreamDemo {
	 public static void main(String args[]) throws IOException
	  {
	     byte aByteData1 =(byte)218, aByteData2 = 111;
	     int    i=130;
	     int    j=20;
	     PipedInputStream pis = new PipedInputStream();
	     PipedOutputStream pos = new  PipedOutputStream(pis);
	     System.out.println("PipedInputStream");
	     try
	     { 
	         pos.write(aByteData1);
	         pos.write(aByteData2);
	         pos.write(i);
	         pos.write(j);
	         System.out.println((byte)pis.read());   //从 pis 所指的管道读取一个字节数据
	         System.out.println(pis.read());
	         System.out.println(pis.read());
	         System.out.println(pis.read());
	   //      System.out.println(pis.read());    //当数据不存在了，程序不会结束，处于等待状态。
	     }
	     finally
	     { 
	        pis.close();	
	        pos.close();
	     }
	  }

}
