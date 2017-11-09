package cn.yxj.thread;

class ThreadDemo {

	public static void main(String[] args) {
		Demo d1= new Demo("lisi");
		//System.out.println(d1.getName());输出当前thread的名称
		
		
		Demo d2= new Demo("wangwu");
	//	System.out.println(d2.getId());
		d2.start(); //将d2这个线程开启
		d1.run(); //由主线程执行
	}
	
	
}
class Demo extends Thread{
	private String name;

	 Demo(String name) {
		
		this.name = name;
	}
	 @Override
	public void run(){
		for(int i=0;i<20;i++){
			System.out.println(Thread.currentThread().getName()+"....."+"name="+name+"......"+i);
		}
	}
}

 


