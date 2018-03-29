package cn.yxj.scheduler;
import java.util.Date;
import java.util.HashMap;  
import java.util.List;  
import java.util.Map;  
  
  
  
/** 
 * 加载定时任务 
 * @Description 
 * @author qgw 
 * 2016 下午2:24:58 ^_^ 
 */  
@SuppressWarnings("unchecked")  
public class LoadTask {  
    /** 
     * @param sendTime 发送时间  
     * @return 
     * @author qgw  
     * @date 2016年1月26日 下午3:39:13 ^_^ 
     */  
	public static void main(String[] args) {
		timerTask("task001");
	}
    public static boolean timerTask(String msgId) {  
        ActvScheduleJob job = new ActvScheduleJob();  
        String cron="0/10 * * * * ?";    //十秒执行一次
        String jobName = msgId+"_job";  
        job.setJobId(msgId);  
        job.setJobName(jobName);  
        job.setCreateTime(new Date());  
        job.setCronExpression(cron);
        job.setJobGroup("MY_JOBGROUP_NAME");  
        job.setDescription("测试定时任务....");
        try {  
            //删除已有的定时任务  
            QuartzManager.removeJob(jobName);  
            //添加定时任务  
            QuartzManager.addJob(jobName, QuartzJobFactory.class, cron,job);  
            return true;  
        } catch (Exception e) {  
            System.out.println("加载定时器错误："+e);  
            return false;  
        }  
    }  
}  