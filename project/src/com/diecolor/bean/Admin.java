package com.diecolor.bean;

import java.sql.Date;

public class Admin {
	private Integer aid;
	private String aname;
	private String apassword;
	private String asex;
	private String atelephone;
	private String images;
	
	public Integer getAid() {
		return aid;
	}
	public void setAid(Integer aid) {
		this.aid = aid;
	}
	public String getAname() {
		return aname;
	}
	public void setAname(String aname) {
		this.aname = aname;
	}
	public String getApassword() {
		return apassword;
	}
	public void setApassword(String apassword) {
		this.apassword = apassword;
	}
	public String getAsex() {
		return asex;
	}
	public void setAsex(String asex) {
		this.asex = asex;
	}
	public String getAtelephone() {
		return atelephone;
	}
	public void setAtelephone(String atelephone) {
		this.atelephone = atelephone;
	}
	
	public String getImages() {
		return images;
	}
	public void setImages(String images) {
		this.images = images;
	}
	public Admin() {
		
	}
	public Admin(String aname, String apassword) {
		super();
		this.aname = aname;
		this.apassword = apassword;
	}
	

}
