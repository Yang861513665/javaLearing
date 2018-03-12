package com.diecolor.bean;

import java.util.Date;



public class Record {
	private int rid;
	private String rtype;
	private Date rtime;
	private int recorderid;
	private String remarks;
	private Student student;
	
	public int getRid() {
		return rid;
	}
	public void setRid(int rid) {
		this.rid = rid;
	}
	public String getRtype() {
		return rtype;
	}
	public void setRtype(String rtype) {
		this.rtype = rtype;
	}
	public Date getRtime() {
		return rtime;
	}
	public void setRtime(Date rtime) {
		this.rtime = rtime;
	}
	
	public int getRecorderid() {
		return recorderid;
	}
	public void setRecorderid(int recorderid) {
		this.recorderid = recorderid;
	}
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public Record() {
		super();
	}
	

}
