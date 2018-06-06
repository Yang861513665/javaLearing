package cn.yxj.quartz;

import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class JobA implements Job {

	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		JobDataMap  data  =	context.getMergedJobDataMap();
		System.out.println("data[user]--->"+(User)data.get("user"));
		System.out.println("jobDetail--->"+context.getJobDetail());
		System.out.println("triger-->"+context.getTrigger());
	}

}
