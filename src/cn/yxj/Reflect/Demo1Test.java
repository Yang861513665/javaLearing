package cn.yxj.Reflect;


import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Demo1Test {

	public static void main(String[] args) throws Exception {
		
		Class<? >  clazz=Class.forName("cn.yxj.Reflect.Demo1");
		Method  method = clazz.getMethod("show2",Integer.class);
		method.setAccessible(true);
		Method  method2 = clazz.getDeclaredMethod("show1");
		method2.setAccessible(true);   //如果方法是私有的要暴力反射
		Object o = clazz.newInstance();
	    method.invoke(o, 2);
	    method2.invoke(o);
	    Field declaredField = clazz.getDeclaredField("username");
	    System.out.println(declaredField.getName());
	    declaredField.setAccessible(true);
	  declaredField.set(o, "yangxijun");
	  System.out.println(declaredField.get(o));
	  
	}
}
