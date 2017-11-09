package cn.yxj.Reflect;

import java.lang.reflect.Constructor;

import cn.yxj.domain.Person;

public class ReflectGetClassDemo {
	/*
	 * 第二种方式就是通过反射的方式获得对象的字节码文件（Person.class）并加载进内存。
	 *  
	 * */

	public static void main(String[] args) throws Exception {
		
		getClass_1();
		getClass_2();
		
	}

	private static void getClass_2() throws Exception {
		String className="cn.yxj.domain.Person";
		//1,通过给定的类名称，加载对应的字节码文件，并封装成字节码对象Class
		Class<?> clazz=Class.forName(className);
		System.out.println(clazz);
		Constructor<?> declaredConstructor = clazz.getDeclaredConstructor();
	    declaredConstructor.setAccessible(true);
		//通过 newInstance就可以创建该字节码对象所表示的类的实例
	Person p=(Person) clazz.newInstance();
		/*2.通过new创建创给定的类的实例
		 *3.调用该类的构造函数（通常被反射的类都会提供空参数的构造函数）
		 * 没有对应的构造函数，会报对象实例化异常。（InstantiationException）
		 * 若有提供但权限不够，会报IllegaAccessException.
		 * */
		p.setAge(20);
		p.setName("yxj");
      System.out.println(p);
		
	}

	private static void getClass_1() {
		Class<Person> clazz=Person.class;
		System.out.println(clazz);
		
	}

}
