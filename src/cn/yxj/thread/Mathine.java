package cn.yxj.thread;
  public class Mathine extends Thread{
   public void run(){
   	   
     for ( int a=0;a<10;a++){
       
		System.out.println(currentThread().getName()+":"+a);
        try {
             sleep(100);
            }catch (InterruptedException e) {throw new RuntimeException(e);
            }
          }
         }
   
       public static void main(String[] args) {
         Mathine mathine1 = new Mathine();   //调用的是父类Thread的方法.传递的对象还是子类对象
         Mathine mathine2 = new Mathine();
          mathine1.setName("m1");
          mathine2.setName("m2");
		  mathine1.setPriority(Thread.MAX_PRIORITY);
		  
          mathine2.setPriority(Thread.MIN_PRIORITY);
		  System.out.println("Priority of m1:"+mathine1.getPriority());
          System.out.println("Priority of m2:"+mathine2.getPriority());
		   mathine1.start();
           mathine2.start();
           mathine1.run();
           
          
    }
   }