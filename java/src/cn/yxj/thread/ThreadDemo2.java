package cn.yxj.thread;
/*
 *  创建线程的第二种方式，实现runnable接口。
 *  1.定义类实现runnable接口：避免了继承Thread类的单继承局限性
 *  2.覆盖接口的run方法，将线程任务代码定义在run方法中。
 *  3.创建Thread类的对象（new Thread()）:只有创建Thread类的对象才能创建线程
 *  4.将runnable接口的子类对象作为参数传递给Thread类的构造函数。
 *  5.调用Thread类的start方法开启线程。
 * 
 * 第二种方式的好处：避免了单继承的局限
 * */

class Ticket implements Runnable{
	//描述票的数量
	private int  tickets=100;
	//售票的动作，这个动作需要被多线程执行，那就是线程任务代码，需要定义在run方法中
	
  public  void run(){
	
			while(tickets>0){
				synchronized (this) {    //this  cn.yxj.thread.Ticket@4614ac54
			//		System.out.println(this);
					try{
						Thread.sleep(10);   //模拟线程停一段时间
					}catch(InterruptedException e){
						e.printStackTrace();
					}if(tickets>0)
					System.out.println(Thread.currentThread().getName()+"..........."+tickets--);
				}
			}
		}}
	  
  
	

	

 public class ThreadDemo2 {

	public static void main(String[] args) throws InterruptedException {
		     //创建runnable接口的子类对象
				Ticket t=new Ticket();
				System.out.println("a---"+t);
				//创建四个线程对象，并将实现runnbale接口的子类对象作为参数传递给Thread的构造函数
				Thread t1=new Thread(t);// Thread类里面有个run方法判断是否传递了runnable接口的子类对象（target)有则调用子类对象的run方法，没有则调用自身的run（起个判断作用，什么都不做）
				Thread t2=new Thread(t);
				Thread t3=new Thread(t);
				Thread t4=new Thread(t);
			
			
		    //开启四个线程
				t1.start();
				t2.start();
				t3.start();
				t4.start();
			
				
		
	}
	
	}


