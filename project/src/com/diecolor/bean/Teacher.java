package com.diecolor.bean;

public class Teacher {
	private Integer tid;
	private String tname;
	private String tpassword;
	private String tsex;
	private String ttelephone;
	private Integer trank;
	public Integer getTid() {
		return tid;
	}
	public void setTid(Integer tid) {
		this.tid = tid;
	}
	public String getTname() {
		return tname;
	}
	public void setTname(String tname) {
		this.tname = tname;
	}
	public String getTsex() {
		return tsex;
	}
	public void setTsex(String tsex) {
		this.tsex = tsex;
	}
	public String getTtelephone() {
		return ttelephone;
	}
	public void setTtelephone(String ttelephone) {
		this.ttelephone = ttelephone;
	}
	public Integer getTrank() {
		return trank;
	}
	public void setTrank(Integer trank) {
		this.trank = trank;
	}
	public Teacher() {
		super();
	}
	public String getTpassword() {
		return tpassword;
	}
	public void setTpassword(String tpassword) {
		this.tpassword = tpassword;
	}
	public Teacher(String tname, String tpassword) {
		super();
		this.tname = tname;
		this.tpassword = tpassword;
	}
	
	

}
