package cn.yxj.thread;

/*
 *      这个实验证明了 StringBuffer支持并发操作，适合多线程，线程是安全的
 *      而StringBuilder不支持并发操作，线程不安全，不适合多线程，但其在单线程中的
 *      性能比前者好。
 * 
 * */
public class StringThreadDemo {
	public static void main(String[] args) {
        StringThread st=new StringThread();
		Thread t1=new Thread(st);
		Thread t2=new Thread(st);
		t1.start();
		t2.start();

	}
	/*
	 *   同步函数 （synchronized+函数名）使用的是锁匙是固定的this，当线程任务只需要一个同步时完全可以使用同步函数
	 *   同步代码块使用的锁可以是任意对象，当线程任务需要多个同步时，必须用锁来区分，这是必须使用同步代码块
	 * 
	 * */

}
class StringThread implements Runnable{
	int i =10;
	//StringBuffer sb=new StringBuffer();
		StringBuilder sb=new StringBuilder();
	@Override
  	public  void  run() {
		while(i>0){
		synchronized (sb) {		//加个同步代码块（这里也可以用this,this代表当前线程操作的对象st）
	    sb.append("a");
	  System.out.println(Thread.currentThread().getName()+":"+ sb+"..."+i--);
		}
		}
            	}
	
}