package cn.yxj.File;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;


public class RunCountDemo {

	public static void main(String[] args) throws IOException {
	
		if(countIsExhaust()){
			System.out.println("试用次数已结束，请注册登录");
		
			return;
		}
		run();

	}

	private static boolean countIsExhaust() throws IOException {
		 File  file=new File("f:\\javaTempFiles\\runcount.properties");
		 if(!file.exists()){
			 file.createNewFile();
		 }
		 Properties prop=new Properties();
		 FileReader fr=new FileReader(file);
		 prop.load(fr);
		 String value=prop.getProperty("count");
		 int count=0;
		 if(value!=null){
			 count=Integer.parseInt(value);
		 }
		 if(count>=3){
			 return true;
		 }
		 count++;
		 System.out.println(count);
		 FileWriter fw=new FileWriter(file);
		 prop.setProperty("count", Integer.toString(count));
		 prop.setProperty("name", "杨希军");
		 System.out.println(prop.getProperty("name"));
		 prop.store(fw, "AppRunCount");
		 fr.close();
		 fw.close();
		return false;
	}

	private static void run() {
		
		System.out.println("程序--------------play");
		
	}

}
