package cn.yxj.File;

import java.io.File;
import java.io.IOException;

public class TestDemo {
    public static void main(String[] args) throws IOException {
    	File  dir =  new File( "D:"+File.separator+"新建Test文件夹5"+File.separator+"Test4子文件夹");
    	File  file  = new File(dir,"a.txt");
    	if(dir.mkdirs()&&file.createNewFile()){
    		System.out.println("success");
    	  } else{
    		  System.out.println("fail");
    	  }
	}
}
