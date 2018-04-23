package cn.yxj.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Method;

 public class AnnotationDemo3{
	 public static void main(String[] args) throws Exception, SecurityException {
   Class<AnnotationDemo3>  clazz=   AnnotationDemo3.class;	//获得指定类
   Method method = clazz.getMethod("show");  //获得指定类上的方法
   Myanno4 annotation = method.getAnnotation(Myanno4.class);  //获得指定类方法上面的注解
    System.out.println(annotation.username()+"----"+annotation.password());
 	}
	 @Myanno4(username="yxj", password = "123")
	public  void show(){
		 
	 }
 }
@Retention(RetentionPolicy.RUNTIME)
 @interface  Myanno4{
	 String username();
	 String password();
 }