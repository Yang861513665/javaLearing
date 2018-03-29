/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package cn.yxj.scheduler;


import java.util.Date;


/**
 * 定时任务Entity
 * 
 * @author lijj
 * @version 2017-10-09
 */
public class ActvScheduleJob  {

	private String id; // 任务ID
	private Date createTime; // 创建时间
	private Date updateTime; // 修改时间
	private String jobName; // 任务名称
	private String jobGroup; // 任务分组
	private String jobStatus; // 任务状态 是否启动任务
	private String cronExpression; // cron表达式
	private String description; // 描述
	private String beanClass; // 任务执行时调用哪个类的方法 包名+类名
	private String methodName; // 任务调用的方法名
	private String actvId; // 任务Id

	private Date jobExecTime; // 任务开始时间
	private Date jobStopTime; // 预定结束时间

	private String crcMod;// 循环模式
	private String crcPrd;// 循环周期
	public String getMsgId() {
		return msgId;
	}

	public void setMsgId(String msgId) {
		this.msgId = msgId;
	}

	private String msgId;

	public void resetActvScheduleJobId(String oldActId, String newActvId) {
		if (id != null)
			this.id = this.id.replaceAll(oldActId, newActvId);
		if (actvId != null) {
			this.actvId = newActvId;
		}
	}

	public Long getJobExecTimeLong() {
		return jobExecTime != null ? jobExecTime.getTime() : null;
	}

	public void setJobExecTimeLong(Long jobExecTimeLong) {
		this.jobExecTime = new Date(jobExecTimeLong);
	}

	public Long getJobStopTimeLong() {
		return jobStopTime != null ? jobStopTime.getTime() : null;
	}

	public void setJobStopTimeLong(Long jobStopTimeLong) {
		this.jobStopTime = new Date(jobStopTimeLong);
	}

	/**
	 * @return 开始执行时间
	 */
	public Date getJobStopTime() {
		return jobStopTime;
	}

	public void setJobStopTime(Date jobStopTime) {
		this.jobStopTime = jobStopTime;
	}

	public String getCrcMod() {
		return crcMod;
	}

	public void setCrcMod(String crcMod) {
		this.crcMod = crcMod;
	}

	public String getCrcPrd() {
		return crcPrd;
	}

	public void setCrcPrd(String crcPrd) {
		this.crcPrd = crcPrd;
	}

	public ActvScheduleJob() {
		super();
	}


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public String getJobName() {
		return jobName;
	}

	public void setJobName(String jobName) {
		this.jobName = jobName;
	}

	public String getJobGroup() {
		return jobGroup;
	}

	public void setJobGroup(String jobGroup) {
		this.jobGroup = jobGroup;
	}

	public String getJobStatus() {
		return jobStatus;
	}

	public void setJobStatus(String jobStatus) {
		this.jobStatus = jobStatus;
	}

	public String getCronExpression() {
		return cronExpression;
	}

	public void setCronExpression(String cronExpression) {
		this.cronExpression = cronExpression;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getBeanClass() {
		return beanClass;
	}

	public void setBeanClass(String beanClass) {
		this.beanClass = beanClass;
	}

	public String getMethodName() {
		return methodName;
	}

	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}

	public Date getJobExecTime() {
		return jobExecTime;
	}

	public void setJobExecTime(Date jobExecTime) {
		this.jobExecTime = jobExecTime;
	}

	public String getActvId() {
		return actvId;
	}

	public void setActvId(String actv_id) {
		this.actvId = actv_id;
	}

	public void setJobId(String msgId) {
    this.msgId = msgId;		
	}


}