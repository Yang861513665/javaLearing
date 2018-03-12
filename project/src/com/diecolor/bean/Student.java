package com.diecolor.bean;

public class Student {
	private Integer sid; 
	private String sname;
	private String spassword;
	private String ssex;
	private String stelephone;
	private String sgrade;
	private String sclass;
	private String sgroup;
	private String proname;
	private String cteacher;
	public Integer getSid() {
		return sid;
	}
	public void setSid(Integer sid) {
		this.sid = sid;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getSpassword() {
		return spassword;
	}
	public void setSpassword(String spassword) {
		this.spassword = spassword;
	}
	public String getSsex() {
		return ssex;
	}
	public void setSsex(String ssex) {
		this.ssex = ssex;
	}
	public String getStelephone() {
		return stelephone;
	}
	public void setStelephone(String stelephone) {
		this.stelephone = stelephone;
	}
	public String getSgrade() {
		return sgrade;
	}
	public void setSgrade(String sgrade) {
		this.sgrade = sgrade;
	}
	public String getSclass() {
		return sclass;
	}
	public void setSclass(String sclass) {
		this.sclass = sclass;
	}
	public String getSgroup() {
		return sgroup;
	}
	public void setSgroup(String sgroup) {
		this.sgroup = sgroup;
	}
	
	public String getProname() {
		return proname;
	}
	public void setProname(String proname) {
		this.proname = proname;
	}
	public String getCteacher() {
		return cteacher;
	}
	public void setCteacher(String cteacher) {
		this.cteacher = cteacher;
	}
	
	public Student(String sname, String spassword) {
		super();
		this.sname = sname;
		this.spassword = spassword;
	}
	public Student() {
		super();
	}
	
	
	

}
