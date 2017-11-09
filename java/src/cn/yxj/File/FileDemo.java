package cn.yxj.File;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;


public class FileDemo {

	public static void main(String[] args) throws IOException {
		
	
		/*
		 *   对文件夹(目录 Directory)和文件进行操作 
		 * */
	  File dir =new File("File文件夹\\aa"); //在当前目录下创建一个名为File文件夹的目录并创建a子目录
	if(! dir.exists()) //判断是否存在这个目录
	System.out.println(  dir.mkdir()); //创建成功
	  File file =new File(dir,"file.txt"); //在File文件夹里创建一个名为file.txt的文件
	  file.createNewFile(); //创建成功
	 // file.delete();  //删除文件
	long time=  file.lastModified();

	Date date =new Date(time);
	//System.out.println(DateFormat.getDateTimeInstance(DateFormat.LONG,DateFormat.LONG).format(date));
	  
	//创建一个用于操作文件的字节输出流对象，一创建就必须明确数据存储目的地
	//注意：输出流的目的地文件会被自动创建，如果存在则覆盖。
	  FileOutputStream fos=new FileOutputStream(file);
      byte[] b= "Hello world".getBytes();
     // int  b=20;
	//写入数据
	  fos.write(b);
	 //续写数据
	  FileOutputStream fos2=new FileOutputStream(file,true);
	  fos.write("\rHello Java".getBytes());// \r:windows里面表换行
	  //获取数据
	  FileInputStream fis=new FileInputStream(file);
	  //创建一个字节数组  长度可以定义为 1024的整数倍
	
	  byte[] buffer= new byte[1024];
	  int len=0;
	 while((len=fis.read())!=-1){
		 //System.out.println(new String(buffer,0,len));
		 System.out.print((char)len);
	 }
	//关闭流   
	fos.close();
	 
	};
	}


