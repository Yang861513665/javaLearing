package cn.yxj.File;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

public class PropertiesDemo {

	public static void main(String[] args) throws IOException {
	
         //  setProperties();
   getProperties();
	}
	public static void setProperties() throws IOException {
		Properties prop= new Properties();
		prop.setProperty("name", "张三");
		prop.setProperty("age", "10");
		File  file =new File("f:\\tempfile\\info1.properties");
		file.createNewFile();
		 FileOutputStream fos = new FileOutputStream(file);
		 prop.store(fos, "studentinfo");
		 fos.close();
		/*FileWriter fw=new FileWriter( file);
		prop.store(fw, "studentinfo");
		fw.close();*/
	}
      public static void getProperties() throws IOException{
    	  
/*	 FileReader fr=new FileReader("f:\\tempfile\\info1.properties");
	 Properties prop= new Properties();
	 prop.load(fr);*/
    	  FileInputStream fis = new FileInputStream("f:\\tempfile\\info1.properties");
    	  Properties prop= new Properties();
    	  prop.load(fis);
	 System.out.println(prop.getProperty("age"));
	 System.out.println(prop);
 }
}
