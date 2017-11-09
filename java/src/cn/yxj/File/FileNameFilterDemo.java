package cn.yxj.File;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * @author  :yangxijun 
 * @description : 利用递归实现文件目录文件(按后缀名)的多级过滤输出
 * */
public class FileNameFilterDemo {
 public static void main(String[] args) throws FileNotFoundException {
	
		 findFileBySuffix();
}
/**
 * 此方法是用来接受用户输入的路径目录以及过滤文件的后缀数据
 * */
public static void findFileBySuffix() throws FileNotFoundException {
	System.out.println("输入文件目录路径");
	 Scanner sc= new Scanner(System.in);
	 String filePath=sc.nextLine();
	 System.out.println("输入要过滤出来的文件后缀，例如（.txt）");
	 String suffix=sc.nextLine();
	 File  dir=  new File(filePath);
	  try{
		  showFiles( dir,suffix );   //调用查找文件方法
	  }catch( FileNotFoundException e){
			System.out.println(e.getMessage());
			 findFileBySuffix();    //发生异常，继续执行用户输入方法，即让用户重新执行输入操作
		}
	 sc.close();
}
/**
 * 此方法根据传来的数据根据指定
 * 后缀在指定目录下查找文件
 * */
public static void showFiles(File dir,String suffix) throws FileNotFoundException {
	
	if(!dir.exists()||!dir.isDirectory()){  //判断给定路径目录是否正确
		throw new FileNotFoundException("目录不存在，或不是目录,请重新输入");
	}
    File[] listFiles = dir.listFiles();
    if(listFiles!=null){
    for (File file : listFiles) {
		if(file.isFile()){
			   File[] listFiles2 = dir.listFiles(new FileNameFilterBySuffix(suffix));
			   for (File file2 : listFiles2) {
				System.out.println(file2.getName());
			}	   
		}
		else {
			showFiles(file,suffix);
		}
		
	}}

	}
	
}

			


	
	

