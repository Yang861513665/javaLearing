package cn.yxj.thread;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class NewScheduledThreadPoolDemo {
      public static void main(String[] args) {
//    	  表示延迟1秒后每3秒执行一次。
//    	  ScheduledExecutorService比Timer更安全，功能更强大，后面会有一篇单独进行对比。
    	  ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(5);
//    	  scheduledThreadPool.scheduleWithFixedDelay(command, initialDelay, delay, unit)
//    	  scheduledThreadPool.scheduleAtFixedRate(command, initialDelay, period, unit)
//    	  ScheduleAtFixedRate 是基于固定时间间隔进行任务调度，ScheduleWithFixedDelay 取决于每次任务执行的时间长短，
//    	  是基于不固定时间间隔进行任务调
    	  scheduledThreadPool.scheduleAtFixedRate(new Runnable() {
    		  @Override
    		  public void run() {
    		  System.out.println("delay 1 seconds, and excute every 3 seconds");
    		  }
    		  }, 1, 3, TimeUnit.SECONDS);
	}
}
