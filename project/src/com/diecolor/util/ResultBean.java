package com.diecolor.util;

import java.io.Serializable;

public class ResultBean implements Serializable{
	private String code;//标识码
	private String msg;//提示信息
	private Object obj;//发往前段的自定义对象
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public Object getObj() {
		return obj;
	}
	public void setObj(Object obj) {
		this.obj = obj;
	}
	

}
