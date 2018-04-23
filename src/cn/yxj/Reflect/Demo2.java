package cn.yxj.Reflect;

import java.lang.reflect.Method;
import java.util.HashMap;

public class Demo2 {

	public static void main(String[] args) throws Exception {

	 HashMap<String, String> hashMap = new HashMap<String , String>();
	 hashMap.put("username", "zhangsan");
	 hashMap.put("password", "123");
	 Class<?> clazz  =Class.forName("org.apache.commons.beanutils.BeanUtils");
	 Object beanUtils = clazz.newInstance();
	 
	
	 Method[] methods = clazz.getMethods();
	 for (Method method : methods) {
		 if(method.getName().equals("populate")){
			 System.out.println(method);	
	         User user = new User();
		   method.invoke(beanUtils,user, hashMap);
		 
		System.out.println(user.getUsername());
		 }
	 }

}}
