package cn.yxj.File;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Scanner;

public class FileDemo2 {

	public static void main(String[] args) {
		
	  /*
	   *  需求： 输出指定类型的文件。
	   *  思路：实现filenamefilter接口
	   * */
	  File dir2=new File("f:\\tempfile"); //相对于项目根目录之下的路径
	 Scanner sc=new Scanner(System.in);
	 while(true){
	 System.out.println("输入文件后缀");
	 // sc.nextLine();
	  final String suffix= sc.nextLine();// 查询后缀为.txt的文件	
	 // File[] files=dir2.listFiles(new FileNameFilterBySuffix(suffix));// 另一种方式：创建一个类实现FilenameFilter接口（降低耦合性）
	  File[] files=dir2.listFiles(new FilenameFilter() {
		@Override
		public boolean accept(File dir2, String name) {	
			return name.endsWith(suffix);
		}
	});
	  //  File[] files= dir.listFiles((File f)->f.getName().endsWith(“.Java”));   //java8的写法
	if(files.length>0){
	 for (File file : files) {
		System.out.println(file.getName());
	}
	 }else{
		 System.out.println("后缀名为"+ suffix+"的文件不存在.");
	 }
	 }	
}
}