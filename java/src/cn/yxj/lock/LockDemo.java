package cn.yxj.lock;

import java.util.concurrent.locks.ReentrantLock;

public class LockDemo implements Runnable {
	  int j=100;
	  ReentrantLock  lock = new ReentrantLock();
		public static void main(String[] args) {
			 LockDemo lockdemo = new LockDemo();
			 for(int i=0;i<5;i++){
				 new Thread(lockdemo).start();
			 }
		}
		@Override
		public  void  run() {
			lock.lock();
			for(int i=0;i<20;i++){
				j--;
				System.out.println(Thread.currentThread().getName()+"---->"+j);
			}
			lock.unlock();
		}
}
