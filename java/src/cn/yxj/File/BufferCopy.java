package cn.yxj.File;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
/*
 * 字符流缓冲区对象的文本文件复制
 * 
 * */
public class BufferCopy {

	public static void main(String[] args) throws IOException {
	String  file="F:\\tempfile\\file.txt";
	String fileto="F:\\tempfile\\file2.txt";
	
 BufferedCopy(file,fileto);
 bufferedRead(file);
	}

	private static void bufferedRead(String file) throws IOException {
		BufferedReader br=new BufferedReader(new FileReader(file));
		String line=null;
		while((line=br.readLine())!=null){
			System.out.println(line);
		}
		
		
	}

	private static void BufferedCopy(String file,String fileto) throws IOException {
		//需要复制的文件
		BufferedReader br=new BufferedReader(new InputStreamReader(new FileInputStream(file),"utf-8"));
		//复制文件的地址
		BufferedWriter bw=new BufferedWriter(new  OutputStreamWriter(new FileOutputStream(fileto),"gbk"));
	//循环读写一行数据
		String line=null;
		while((line=br.readLine())!=null){
			line=line.replace("张三", "zhansan");
			bw.write(line);
			bw.newLine();
		}
		br.close();
		bw.close();	
	}
	

}
