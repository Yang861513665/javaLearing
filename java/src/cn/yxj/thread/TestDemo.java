package cn.yxj.thread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class TestDemo  implements Runnable{
	int  j =1000;
	Object lock= new Object();
    public static void main(String[] args) {
    	ThreadPoolExecutor  executor =  new ThreadPoolExecutor(5, 10, 1, TimeUnit.MINUTES , new ArrayBlockingQueue<Runnable>(100));
    	TestDemo task = new TestDemo();
    	for (int i = 0; i < 100; i++) {
			executor.submit(task);
		}
    	executor.shutdown();
}

	@Override
	public void run() {
		synchronized (lock) {
			for (int i = 0; i < 10; i++) {
				j--;		
				System.out.println(Thread.currentThread().getName()+"-->"+j);
			}
		}
	}
}