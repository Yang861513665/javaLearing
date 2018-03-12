package com.diecolor.util;

import org.quartz.CronScheduleBuilder;
import org.quartz.CronTrigger;
import org.quartz.Job;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerFactory;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

public class QuartzLoad {
	  private static Scheduler sched; 
	  public static void run() throws Exception { 
	    System.out.println("定时任务启动");
	    JobDetail jobDetail = JobBuilder.newJob((Class<? extends Job>) job.class)
	        .withIdentity("myjob", "group1").build();
	    CronTrigger trigger =(CronTrigger) TriggerBuilder.newTrigger()
	        .withIdentity("trigger", "group1")
	        .withSchedule(CronScheduleBuilder.cronSchedule("0 0 0 ? * *"))//秒 分 时 日 月 周 年
	        .build();
	    SchedulerFactory sfact = new StdSchedulerFactory();
	    Scheduler schedule = sfact.getScheduler();
	    schedule.start();
	    schedule.scheduleJob(jobDetail, trigger);
	  }
	  //停止 
	  public static void stop() throws Exception{ 
	      sched.shutdown(); 
	   } 
	}
