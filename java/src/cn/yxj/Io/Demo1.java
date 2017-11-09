package cn.yxj.Io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class Demo1 {

	 public static void main(String[] args) throws Exception {
		
		 File   file= new File("F:\\tempfile\\info.txt");
		  File   fileTo= new File("F:\\tempfile\\info3.txt");
		 BufferedReader br = new BufferedReader(new FileReader(file));
		 BufferedWriter bw = new BufferedWriter(new FileWriter(fileTo));
		
		 String  line=null;
		 while((line=br.readLine())!=null){
			 bw.write(line);
			 bw.newLine();
		 }
		 br.close();
		 bw.close();
	}
	  
	  
}
