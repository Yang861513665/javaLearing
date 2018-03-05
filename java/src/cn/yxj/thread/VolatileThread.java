package cn.yxj.thread;

public class VolatileThread extends  Thread {
    private   /* volatile  */int  count  = 1;
 
    public void setCount(int count){
        this.count = count;
    }
 
    public void run() {
        System.out.println("进入run方法");
        while(count >0){
            count++;
          System.out.println(Thread.currentThread().getName() + " count= " + count);
            System.out.println("123");
        }
        System.out.println("线程停止");
    }
 
    public static void main(String[] args) throws InterruptedException {
        VolatileThread  vt1 = new VolatileThread();
        vt1.start();
        Thread.sleep(1000);
        vt1.setCount(-1);
    }
}
