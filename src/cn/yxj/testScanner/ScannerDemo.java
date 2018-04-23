package cn.yxj.testScanner;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class ScannerDemo {

	public static void main(String[] args) throws IOException {
		
		testDemo();
		//testDemo2();
//        testDemo3();
   
//		testDemo4();
	}

	private static void testDemo4() throws IOException {
	
/*		//读取键盘录入的字节输入流
		InputStream in=System.in;
	 //通过桥梁，将字节输入流转为字符输入流
		InputStreamReader isr=new InputStreamReader(in);
		//对字符流进行效率提高，使用缓冲区的特有方法 readline（）；
		BufferedReader br=new BufferedReader(isr);*/
		//文件录入
	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	//录入地址
	BufferedWriter bw=new BufferedWriter(new FileWriter("f:\\tempfile\\file3.txt"));
		String line=null;
		while((line=br.readLine())!=null){
			if(line.equals("over")){
				System.out.println("输入结束");	
				break;
			}
			System.out.println(line);
		
	
		bw.write(line);
		bw.newLine();   //分行存储
     	bw.flush();
		
		}
	bw.close();
	}

	private static void testDemo3() {
		Scanner sc3=new Scanner(System.in);
		String str3=sc3.nextLine(); 
	      String[] strs11= str3.split(","); //按空格切割
	      int[] nums= new int[strs11.length];
	   for(int i=0;i<strs11.length;i++) {	  
		   nums[i]= Integer.parseInt(strs11[i]);
	   }
	     Arrays.sort(nums);
	     for (int i1 : nums) {
		  System.out.println(i1);
		
	   }
	     sc3.close();
		
	}

	private static void testDemo2() {
		Scanner sc2=new Scanner(System.in);
		int[] arr=new int[10];
	 for (int i = 0; i < arr.length; i++) {
		arr[i]=sc2.nextInt();
   }
	Arrays.sort(arr);
	for (int i : arr) {
		System.out.println(i);
	}
	sc2.close();


	}

	public static void testDemo() {
		System.out.println("请输入11位电话号码，结束请输入“over”");
		Scanner sc=new Scanner(System.in);
		//scanner里面封装了 字节流通向字符流的桥梁（inpustreamReader）
		String str=null;
	while(	( str=sc.nextLine())!=null&&!(str.endsWith("over"))){
		   String regex3="(\\d{3})(\\d{4})(\\d{4})";
		   str= str.replaceAll(regex3, "$1****$3");
		   System.out.println(str);
	}
	 System.out.println("程序结束");
	 sc.close();
	}

 }
