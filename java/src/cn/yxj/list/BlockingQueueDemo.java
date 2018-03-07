package cn.yxj.list;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

public class BlockingQueueDemo implements Callable<String> {
    public BlockingQueue<Integer> queue;
     public BlockingQueueDemo(BlockingQueue<Integer> queue){
    	 this.queue =queue;
     }
	@Override
	public String call() throws Exception {
		if (Thread.currentThread().getName().endsWith("1")){
			throw new RuntimeException(Thread.currentThread().getName()+"取数据发生异常");
		}
		   Integer result = null;
		   Boolean flag = true;
		   while(flag){
			  result=queue.poll();
			  if (result!=null){
				  System.out.println(Thread.currentThread().getName()+"取出了"+result);
			  }else{
				  flag = false;
			  }
		   }
		return "取数据完成";
}}