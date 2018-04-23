package cn.yxj.thread;

public class Demo1 {

	public static void main(String[] args) {
       Resouce r = new Resouce("面包",100);    //指定要生产的物品和数量
    
       Producer2 producer2 = new Producer2(r);
       Consumer2 consumer2 = new Consumer2(r);
       
       Thread thread1= new Thread(producer2);
       Thread thread2= new Thread(consumer2 );
       
       thread1.start();
       thread2.start();
	}

}

class  Resouce{
	private String  name;  //商品名称
	private  int  count;      //商品生产数量
	private int  num;     //商品编号
	private  boolean  flag=false;   // false 表示没有面包
	
	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}
    
	public Resouce(String name,int count) {    //商品初始化（被生产） 带着名称,和指定的生产数量
		super();
		this.name = name;
		this.count=count;
	}
   
	public String getName() {
		return name;
	}

	public int getCount() {
		return count;
	}


	public void setCount(int count) {
		this.count = count;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}
}
  //生产者类
class  Producer2 implements Runnable{
	private Resouce  r;
	Producer2(Resouce  r){
		this.r =r;
	}

	@Override
	public void run() {
		int count=r.getCount();
		int num=r.getNum();
		while(r.getCount()>0){
		synchronized (r) {		
			if(!r.isFlag()){   //没有面包开始生产
				r.setNum(++num);
				r.setCount(--count);
				System.out.println(Thread.currentThread().getName()+"生产了"+r.getName()+r.getNum());
				r.setFlag(true);
				r.notify();   //唤醒消费者
			}try {	
					r.wait();  //生产线程等待
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}}

	
	
}
//消费者类
class Consumer2 implements Runnable {
	private Resouce r;

	Consumer2(Resouce r) {
		this.r = r;
	}

	@Override
	public void run() {
		while (r.getCount() >=0) {
			synchronized (r) {
				if (r.isFlag()) {
					System.out.println(Thread.currentThread().getName() + "消费了"+ r.getName() + r.getNum());							
					r.setFlag(false);
					r.notify();    //唤醒生产者
				}try {				
					r.wait();    //消费者等待
				} catch (InterruptedException e) {
					e.printStackTrace();
				}		
			}
		}
	}
	
	
}