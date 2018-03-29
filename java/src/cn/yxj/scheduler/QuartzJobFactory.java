package cn.yxj.scheduler;

import java.lang.reflect.Method;
import java.util.ArrayList;  
import java.util.HashMap;  
import java.util.List;  
import java.util.Map;  
  
  



import org.quartz.DisallowConcurrentExecution;  
import org.quartz.Job;  
import org.quartz.JobExecutionContext;  
import org.quartz.JobExecutionException;  
  
/** 
 * 定时任务运行（反射出来的类） 
 * @Description 
 * @author qgw 
 * 2016 下午2:39:37 ^_^ 
 */  
@DisallowConcurrentExecution  
public class QuartzJobFactory implements Job {  
      
    @Override  
    public void execute(JobExecutionContext context) throws JobExecutionException {  
          
       System.out.println("任务运行开始-------- start --------");   
	Class<?> clazz = null;
        try {  
            //ScheduleJob任务运行时具体参数，可自定义  
            ActvScheduleJob scheduleJob =(ActvScheduleJob) context.getMergedJobDataMap().get(  
                    "scheduleJob");
                clazz = Class.forName(scheduleJob.getBeanClass());
                Method method=clazz.getDeclaredMethod(scheduleJob.getMethodName(), String.class)	;	
                method.invoke(clazz.newInstance(), scheduleJob.getMsgId());
        }catch (Exception e) {  
            System.out.println("捕获异常==="+e);  
        }  
        System.out.println("任务运行结束-------- end --------");   
    }  
}  