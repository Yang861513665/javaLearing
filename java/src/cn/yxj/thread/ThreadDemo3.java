package cn.yxj.thread;
/*
多线程中最为常见的应用案例：
生产者消费者问题。
生产和消费同时执行，需要多线程。
但是执行的任务却不相同，处理的资源确实相同的：线程间的通信。

1，描述一下资源。
2，描述生产者，因为具备着自己的任务。
3，描述消费者，因为具备着自己的任务。


问题1：数据错误：已经被生产很早期的商品，才被消费到。
出现线程安全问题，加入了同步解决。使用同步函数。
问题已解决：不会在消费到之前很早期的商品。

问题2：发现了连续生产却没有消费，同时对同一个商品进行多次消费。
希望的结果应该是生产一个商品，就被消费掉。生产下一个商品。
搞清楚几个问题？
生产者什么时候生产呢？消费者什么时候应该消费呢？
当盘子中没有面包时，就生产，如果有了面包，就不要生产。
当盘子中已有面包时，就消费，如果没有面包，就不要消费。

生产者生产了商品后应该告诉消费者来消费。这时的生产者应该处于等待状态。
消费者消费了商品后，应该告诉生产者，这时消费者处于等待状态。

等待：wait();
告诉：notify();//唤醒

问题解决：实现生产一个消费一个。

=====================
等待/唤醒机制。
wait(): 会让线程处于等待状态，其实就是将线程临时存储到了线程池中。
notify():会唤醒线程池中任意一个等待的线程。
notifyAll():会唤醒线程池中所有的等待线程。

记住：这些方法必须使用在同步中，因为必须要标识wait，notify等方法所属的锁。
同一个锁上的notify，只能唤醒该锁上的被wait的线程。

为什么这些方法定义在Object类中呢？
因为这些方法必须标识所属的锁，而锁可以是任意对象，任意对象可以调用的方法必然是Object类中的方法。


*/

//1,描述资源。属性：商品名称和编号，  行为：对商品名称赋值，获取商品。
class Resource
{
	private String name;
	private int i;     //i 表示生产多少资源(这里表示生产多少面包)
	public int getI() {
		return i;
	}
	public void setI(int i) {
		this.i = i;
	}
	private int count = 1;

	//定义标记。
	private boolean flag = false;//表示当前没有面包 
	
	//1,提供设置的方法。
	public synchronized void set(String name)
	{

		if(!flag){
			//给成员变量赋值并加上编号。
			this.name = name + count;
		//编号自增。
		count++;
		//打印生产了哪个商品。
		System.out.println(Thread.currentThread().getName()+"......生产者...."+this.name);	
		//将标记改为true。
		flag = true;
		//唤醒消费者。
		this.notify();
		}
		try{this.wait();}catch(InterruptedException e){}  
	}
	public synchronized void out()
	{
		if(!flag)
	try{this.wait();}catch(InterruptedException e){}
		System.out.println(Thread.currentThread().getName()+"....消费者...."+this.name);
		//将标记该为false。
		flag = false;
		//唤醒生产者。
		this.notify();
	}
}

//2,描述生产者。
class Producer implements Runnable
{
	private Resource r ;
	// 生产者一初始化就要有资源，需要将资源传递到构造函数中。
	Producer(Resource r)
	{
		this.r = r;
	}
	public void run()
	{
		int i=r.getI();
		while(i>0)
		{
			r.set("面包");
			i--;
		}
	}
}

//3,描述消费者。
class Consumer implements Runnable
{
	private Resource r ;
	// 消费者一初始化就要有资源，需要将资源传递到构造函数中。
	Consumer(Resource r)
	{
		this.r = r;
	}
	public void run()
	{
		int i=r.getI();
		while(i>0)
		{
			r.out();
	     	i--;
		}
	}
}


class ThreadDemo3
{
	public static void main(String[] args) 
	{
		//1,创建资源对象。
		Resource r = new Resource();
		r.setI(100);

		//2,创建线程任务。
		Producer pro = new Producer(r);
		Consumer con = new Consumer(r);

		//3,创建线程。
		Thread t1 = new Thread(pro);
		Thread t2 = new Thread(con);

		t1.start();
		t2.start();
	}
}
