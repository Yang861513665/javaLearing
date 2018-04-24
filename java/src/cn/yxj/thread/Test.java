package cn.yxj.thread;

import java.io.File;
import java.io.FileFilter;



public class Test implements  Runnable {
   public  volatile  boolean flag;
	@Override
	public void run() {
        	   System.out.println(Thread.currentThread().getName()+" start.......");
        	   while(!flag){
        		   System.out.println(Thread.currentThread().getName()+"------run......");
        	   }
        	   System.out.println(Thread.currentThread().getName()+"stop.......");
	}
	public   void stop(){
		flag = true;
	}
	static void showFiles(File dir){
		 for(File  file :dir.listFiles())
	    	   if (file.isDirectory()){
	    		     showFiles(file);
	    	   }else{
	    		   if(file.toString().endsWith(".txt")){
	    			   System.out.println(file);
	    		   }
	    	   }
	       }
	public static void main(String[] args) throws Exception {
		    File  dir  = new File("d://");
		      showFiles(dir);
//	          long   startTime = System.currentTimeMillis();
//	          System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(startTime)));
//		      Test test =new Test();
//		      new Thread(test).start();
//		      new Thread(test).start();
//		      Thread.sleep(1000);
//		      System.out.println(" try  to stop.....");
//		      test.stop();
//		      Thread.sleep(1000);
//		      System.out.println(System.currentTimeMillis() - startTime);
	}
}
