package cn.yxj.Reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class Reflect_GetMethodDemo {

	public static void main(String[] args) throws Exception {
		
		getmethod();

	}

	private static void getmethod() throws Exception {
		
		String className="cn.yxj.domain.Person";
		Class<?> clazz=Class.forName(className);
		String methodname="show";
		Method method=clazz.getMethod(methodname, String.class,int.class); //无参就写null
		Constructor<?> declaredConstructor = clazz.getDeclaredConstructor();
	declaredConstructor.setAccessible(true);
		Object obj= clazz.newInstance();
		System.out.println(obj);
		method.invoke(obj, "杨希军",12);
		
		
	}

}
