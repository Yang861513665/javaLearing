package cn.yxj.File;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class FileEncodingChange {

	 // 源文件夹    

//    static String url1 = "D:\\JavaData";   //相当于 d:/JavaData ,         windows系统采用“\”分隔路径(因为需要转义 所以用\\   (其中\\可以用/来表示))
//
//    // 目标文件夹    
//
//    static String url2 = "D:\\newjavadata4";   


    public static void main(String args[]) throws IOException {   
    	Scanner sc=new Scanner(System.in);
    	System.out.println("此程序用于将已知编码的文件转成另一种编码方式");
    	System.out.println("请输入需要转换编码的文件路径(格式： xx:/xx/xx),回车结束");
    	String url1=sc.nextLine();
    	System.out.println("输入源文件的编码格式！ 很重要不能错误");
    	String souceCharset=sc.nextLine();
    	System.out.println("请输入想要转换后的编码格式！");
    	String targetCharset=sc.nextLine();
    	System.out.println("请输入需要转换编码后的文件路径,(格式： xx:/xx/xx),回车结束");
    	String url2=sc.nextLine();
     sc.close();
        // 创建目标文件夹    
    	File  dir=new File(url2);
    	dir.mkdirs();

//        (new File(url2)).mkdirs();   

        // 获取源文件夹当前下的文件或目录    

        File[] file = (new File(url1)).listFiles();   

        for (int i = 0; i < file.length; i++) {   

            if (file[i].isFile()) {   
       

           /*     // 复制文件    

                copyFile(file[i],new File(url2+file[i].getName()),souceCharset,targetCharset);   */

                    // 源文件    

                    File souceFile=file[i];   

                    // 目标文件    

//                 File targetFile=new File(dir.getAbsolutePath()+"\\"+sourceFile.getName());
                    File targetFile=new File(url2+"\\"+file[i].getName());   
                    System.out.println(targetFile);
                   copyFile(souceFile,targetFile,souceCharset,targetCharset);   
            }   

            if (file[i].isDirectory()) {   
     

                // 复制子目录    

                String sourceDir=url1+File.separator+file[i].getName();   //File.separator 在windows里相当于“\”

                String targetDir=url2+"\\"+file[i].getName();   

                
                copyDirectiory(sourceDir, targetDir,souceCharset,targetCharset);   

            }   

        }   

    }   

// 复制文件    

public static void copyFile(File sourceFile,File targetFile,String souceCharset,String targetCharset)    

throws IOException{   
//	System.out.println(targetFile);
	//需要复制的文件
	//inputStreamReader: 字节流到字符流的桥梁
	BufferedReader br=new BufferedReader(new InputStreamReader(new FileInputStream(sourceFile),souceCharset));
	//复制文件的地址
	//outputStreamWriter:字符流到字节流的桥梁
	BufferedWriter bw=new BufferedWriter(new  OutputStreamWriter(new FileOutputStream(targetFile),targetCharset));
//循环读写一行数据
	String line=null;
	while((line=br.readLine())!=null){
		bw.write(line);
		bw.newLine();
	}
	br.close();
	bw.close();	
}

    // 复制文件夹    

    public static void copyDirectiory(String sourceDir, String targetDir,String souceCharset,String targetCharset)   

        throws IOException {   

        // 新建目标目录    

        (new File(targetDir)).mkdirs();   

        // 获取源文件夹当前下的文件或目录    

        File[] file = (new File(sourceDir)).listFiles();   

        for (int i = 0; i < file.length; i++) {   

            if (file[i].isFile()) {   

                // 源文件    

                File sourceFile=file[i];   

                // 目标文件    

               File targetFile=new File(new File(targetDir).getAbsolutePath()+"\\"+file[i].getName());   

               copyFile(sourceFile,targetFile,souceCharset,targetCharset);   

            }   

            if (file[i].isDirectory()) {   

                // 准备复制的源文件夹    

                String dir1=sourceDir + "\\" + file[i].getName();    //  ： \\可以用/来表示

                // 准备复制的目标文件夹    

                String dir2=targetDir + "\\"+ file[i].getName();   
          

                copyDirectiory(dir1, dir2, souceCharset, targetCharset);   

            }   

        }   

    }}
	
