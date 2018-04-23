package cn.yxj.Io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.TreeSet;

import cn.yxj.domain.Student;

public class TestIo {

	private static final String LINE_SEPARATOR = System.getProperty("line.separator");

	public static void main(String[] args) throws IOException {
		TreeSet<Student>set=new TreeSet<Student>();
		set.add(new Student("张三",20));
		set.add(new Student("李四",30));
		set.add(new Student("王五",10));
		set.add(new Student("赵六",40));
	
		File dir =new File("F:\\tempfile");
		if(!dir.exists()){
			dir.mkdir();
		}
		 File file =new File(dir,"file2.txt"); //在tempfile文件夹里创建一个名为file.txt的文件
		 file.createNewFile(); //创建成功
		 //调用write2file 方法
//		 write2File(file,set);
       //删除目录
//		 deleteDir(dir);
		 Read(file);
	}
	public static void write2File(File file,	TreeSet<Student>set) throws IOException		 {
	FileWriter fw=null;
		String info=null;
     try {
		 fw=new FileWriter(file);
		 for(Student stu:set){
		info=stu.getName()+"\t"+stu.getAge()+LINE_SEPARATOR;
		fw.write(info);
		}
		 System.out.println("写入成功");
	} catch (FileNotFoundException e) {
		e.printStackTrace();
	}finally{
		try {
			fw.close();
		} catch (IOException e) {
		throw  new RuntimeException("系统关闭资源错误");
		}
	}}
  public static void deleteDir(File dir){ 
	 if(dir.exists()&&dir.isDirectory()){
	 File[]	 file= dir.listFiles();
	for (File file2 : file) {
		if(file2.isDirectory()){
		deleteDir(file2);//使用递归删除子目录	
	}	else{
		System.out.println(file2+" "+file2.delete());
	
	}
		}
	 }else{
		 System.out.println("目录不存在或不是目录");
	 }
	System.out.println(dir+" "+dir.delete());
	 }
   public static void Read(File file) throws IOException{
		BufferedReader br=null;
	    String line=null;
	   try {
		   //获取数据
		br=new BufferedReader(new FileReader(file));
  while((line=br.readLine())!=null){
	  System.out.println(line);
  }		
			
	} catch (FileNotFoundException e) {	
		e.printStackTrace();}
		finally{
			try {
				br.close();
			} catch (IOException e) {
			throw  new RuntimeException("系统关闭资源错误");
			}
   }
  
  
 }	}

