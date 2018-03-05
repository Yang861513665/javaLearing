package cn.yxj.thread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolDemo {
	  public static void main(String[] args) {
		
		ThreadPoolExecutor  threadPoolExecutor =  new ThreadPoolExecutor(3, 10, 1, TimeUnit.MINUTES , new ArrayBlockingQueue<Runnable>(10));
		 threadPoolExecutor.execute(new ThreadDemo1());
		 threadPoolExecutor.execute(new ThreadDemo1());
		 threadPoolExecutor.execute(new ThreadDemo1());
		 threadPoolExecutor.execute(new ThreadDemo1());
	}
}
class  ThreadDemo1 implements Runnable{
	@Override
	public void run() {
       System.out.println("我是通过线程池启动的线程哦");
	}
}