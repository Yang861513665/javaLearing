package cn.yxj.File;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class PrintWriterDemo {

	public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw= new PrintWriter(new FileOutputStream("f:\\tempfile\\int2.txt",true),true);
        String line=null;
        while((line=br.readLine())!=null){
        	if(line.equals("over")){
        		break;}
        	pw.println(line.toUpperCase());
        }
        	pw.close();
	}

}
