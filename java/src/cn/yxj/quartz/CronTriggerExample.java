package cn.yxj.quartz;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;









import org.quartz.CronScheduleBuilder;
import org.quartz.Job;
import org.quartz.JobBuilder;
import org.quartz.JobDataMap;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

public class CronTriggerExample {
		public static void main(String[] args) throws SchedulerException, Exception {
              //	JobKey jobKeyA = new JobKey("jobA", "jobGroup");
			JobDataMap  data = new JobDataMap();
			data.put("user", new User("yangxj","123"));
	    	JobDetail jobA = JobBuilder.newJob(JobA.class)
			.withIdentity("jobA","jobGroup").setJobData(data).build();  // 参数： jobName,jobGruopName

	    	//    TriggerKey triggerKey = TriggerKey.triggerKey("jobAtigger", "triggerGruopName");  
	       	Trigger trigger1 = TriggerBuilder
	       			.newTrigger()
	       			.withIdentity("jobAtigger", "triggerGruopName") //参数： triggerName,triggerGruopName
	       			.withSchedule(CronScheduleBuilder.cronSchedule("0/5 * * * * ? ")) // 参数：cronExpression
//	       		    .startAt(parse("2018-06-06 14:56:20"))
//	       			.endAt(parse("2018-06-06 14:57:00"))
	       			.build();
	       	Scheduler scheduler = new StdSchedulerFactory().getScheduler();
	    	scheduler.start();
	    	scheduler.scheduleJob(jobA, trigger1);
		}
		public  static Date parse(String dateStr) throws Exception{
	       	SimpleDateFormat datetimeformat =   new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	       	return datetimeformat.parse(dateStr);
		}
}
