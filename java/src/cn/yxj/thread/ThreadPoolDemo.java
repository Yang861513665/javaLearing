package cn.yxj.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import com.sun.org.apache.xalan.internal.xsltc.compiler.util.ErrorMsg;
/**
 * ● 等待队列：顾名思义，就是你调用线程池对象的submit()方法或者execute()方法，要求线程池运行的任务（这些任务必须实现Runnable接口或者Callable接口）。但是出于某些原因线程池并没有马上运行这些任务，而是送入一个队列等待执行。

● 核心线程：线程池主要用于执行任务的是“核心线程”，“核心线程”的数量是你创建线程时所设置的corePoolSize参数决定的。如果不进行特别的设定，线程池中始终会保持corePoolSize数量的线程数（不包括创建阶段）。

● 非核心线程：一旦任务数量过多（由等待队列的特性决定），线程池将创建“非核心线程”临时帮助运行任务。你设置的大于corePoolSize参数小于maximumPoolSize参数的部分，就是线程池可以临时创建的“非核心线程”的最大数量。这种情况下如果某个线程没有运行任何任务，在等待keepAliveTime时间后，这个线程将会被销毁，直到线程池的线程数量重新达到corePoolSize。

● maximumPoolSize参数也是当前线程池允许创建的最大线程数量。那么如果设置的corePoolSize参数和设置的maximumPoolSize参数一致时，线程池在任何情况下都不会回收空闲线程。keepAliveTime和timeUnit也就失去了意义。

● keepAliveTime参数和timeUnit参数也是配合使用的。keepAliveTime参数指明等待时间的量化值，timeUnit指明量化值单位。例如keepAliveTime=1，timeUnit为TimeUnit.MINUTES，代表空闲线程的回收阀值为1分钟。
 * */
public class ThreadPoolDemo {
	public static  int j;
	public  static List<String> errorMsg = new ArrayList<String>();
	  public static void main(String[] args) {
		ThreadPoolExecutor  threadPoolExecutor =  new ThreadPoolExecutor(5, 10, 1, TimeUnit.MINUTES , new ArrayBlockingQueue<Runnable>(4));
		 List<Integer>  list = new ArrayList<Integer>(201);
		 for(int i=0 ;i<201;i++){
			 list.add(i);
		 }
		 for(int i=0;i<list.size();i++){
			 if(i%5==0){
					Future<String>  result=threadPoolExecutor.submit(new ThreadDemo1(list.subList(i, i+5>list.size()?list.size():i+5)));
//					 threadPoolExecutor.execute(new ThreadDemo1(list.subList(i, i+5>list.size()?list.size():i+5)));
					try{
						System.out.println(result.get());
					}catch(Exception e){
						System.out.println(e.getMessage());
					}
			 }
		 }
		 threadPoolExecutor.shutdown();
	}
}
class  ThreadDemo1 implements Callable<String>{
	private  List<Integer>  list;
   ThreadDemo1(List<Integer>  list){
	   this.list= list;
   }
//	@Override
//	public void run(){
//		if(list.contains(13)||list.contains(16)){
//			throw new RuntimeException("不可包含12或16");
//		}
//		System.out.println("我是通过线程池启动的线程---"+ Thread.currentThread().getName()+"我执行的list为："+this.list);
//	}
	@Override
	public String call() throws Exception {
		if(Thread.currentThread().getName().endsWith("2"))
			throw new RuntimeException("线程2不能执行数据，交由其他线程完成执行..");
//		if(list.contains(13)||list.contains(16)){
//			throw new RuntimeException("不可包含12或16");
//		}
		System.out.println(ThreadPoolDemo.j++);
		System.out.println("我是通过线程池启动的线程---"+ Thread.currentThread().getName()+"我执行的list为："+this.list);
		return "成功导入";
	}
}