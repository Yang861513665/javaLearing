package cn.yxj.annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Method;

import org.junit.Test;

/**
 * 注解的使用1（注解属性的赋值，及通过反射注解获得属性值）
 * */
@MyAnno1(username="类上的注解",password="123")    //使用注解给注解属性赋值
@MyAnno2(password="123")    //使用注解给注解属性赋值(有默认值就不需要赋值)
public class AnnotationDemo1 {
	
	@Test
	public void fun1() throws NoSuchFieldException, SecurityException{	
		/*
		 * 1.获得作用目标
		 * */
		Class <AnnotationDemo1>  clazz= AnnotationDemo1.class;
		/*
		 * 2.获得指定类型上的注解
		 * */	
	    MyAnno1  myAnno1 =clazz.getAnnotation(MyAnno1.class);
		System.out.println(myAnno1.username()+"--"+myAnno1.password());
			
	}
	@Test
	@MyAnno1(username="方法上的注解",password="123") 
	public  void fun2() throws NoSuchMethodException, SecurityException{
		Class <AnnotationDemo1>  clazz= AnnotationDemo1.class;
		Method method = clazz.getMethod("fun2");  //获得类中的fun2方法
		
		MyAnno1  myAnno1=method.getAnnotation(MyAnno1.class);  //获得方法上的注解
		System.out.println(myAnno1.username()+"--"+myAnno1.password());
		
	}
}

@Retention(RetentionPolicy.RUNTIME)  //使用该注解定义注解的存储策略为 JVM中（反射必须如此）
@interface   MyAnno1{
	/**
	 * 定义注解属性格式  ：  类型  属性名();
	 * */
	String username();
	String  password();
}	

@interface   MyAnno2{
	
	String username()  default  "yxj";    //属性默认值
	String  password();
}	

