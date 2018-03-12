package com.diecolor.bean;

import java.util.Date;



public class Myfile {
	private int mid;
	private String mfilename;
	private String mfilepath;
	private String mclass;
	private int muploadnameid;
	private Date mtime;
	private String mcomment;
	
	private Student student;
	
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	public int getMid() {
		return mid;
	}
	public void setMid(int mid) {
		this.mid = mid;
	}
	public String getMfilename() {
		return mfilename;
	}
	public void setMfilename(String mfilename) {
		this.mfilename = mfilename;
	}
	public String getMfilepath() {
		return mfilepath;
	}
	public void setMfilepath(String mfilepath) {
		this.mfilepath = mfilepath;
	}
	public String getMclass() {
		return mclass;
	}
	public void setMclass(String mclass) {
		this.mclass = mclass;
	}
	
	public int getMuploadnameid() {
		return muploadnameid;
	}
	public void setMuploadnameid(int muploadnameid) {
		this.muploadnameid = muploadnameid;
	}
	public Date getMtime() {
		return mtime;
	}
	public void setMtime(Date mtime) {
		this.mtime = mtime;
	}
	public String getMcomment() {
		return mcomment;
	}
	public void setMcomment(String mcomment) {
		this.mcomment = mcomment;
	}
	public Myfile() {
		super();
	}
	
	
	

}
