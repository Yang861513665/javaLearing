package cn.yxj.quartz;

import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class JobFactory  implements Job{
	
	@Override
	public void execute(JobExecutionContext context)
			throws JobExecutionException {
	    	JobDataMap  data  =	context.getMergedJobDataMap();
	}

}
