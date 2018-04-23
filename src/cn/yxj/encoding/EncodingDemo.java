package cn.yxj.encoding;

import java.io.UnsupportedEncodingException;

public class EncodingDemo {

	public static void main(String[] args) throws UnsupportedEncodingException {
		 /*
		   *   字符串---->字节数组  （编码） （getBytes()）
		   *   字节数组---->字符串 （解码） ( new String(byte[] ) )
		   * 
		   * */
		  
	String str="杨希军";
	byte[] byt=	 str.getBytes();
	for (byte b : byt) {
		System.out.print(b);
	}
	String s=new String (byt);
   System.out.println(s);
  
	}

}
