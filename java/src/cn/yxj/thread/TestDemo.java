package cn.yxj.thread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/**
 * 这里有1000个数字，交由一个线程池【一个有5个核心线程，最大允许创建10个线程】对其进行减操作。
 * */
public class TestDemo  implements Runnable{
	int  j =1000;
	Object lock= new Object();
    public static void main(String[] args) {
    	//创建一个定长线程池，可控制线程最大并发数，超出的线程会在队列中等待。示例代码如下：[对下面ThreadPoolExecutor的封装类]
//    	 ExecutorService fixedThreadPool = Executors.newFixedThreadPool(5);
    	ThreadPoolExecutor  executor =  new ThreadPoolExecutor(5, 10, 1, TimeUnit.MINUTES , new ArrayBlockingQueue<Runnable>(10));
    	TestDemo task = new TestDemo();
    	for (int i = 0; i < 10; i++) {
			executor.submit(task);
		}
    	executor.shutdown();
}

	@Override
	public void run() {
		synchronized (lock) {
			for (int i = 0; i < 100; i++) {
				j--;		
				System.out.println(Thread.currentThread().getName()+"-->"+j);
			}
		}
	}
}