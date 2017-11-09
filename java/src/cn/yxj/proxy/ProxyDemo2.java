package cn.yxj.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import org.junit.Test;

public class ProxyDemo2 {

	@Test
	public void fun1(){
	  	final Waiter waiter=new Waiter();
	Object o=	Proxy.newProxyInstance(
		  
				waiter.getClass().getClassLoader(),
				new Class[]{Server.class},
				new InvocationHandler() {
					@Override
					public Object invoke(Object proxy, Method method, Object[] args)
							throws Throwable {
					//	System.out.println(method);
						System.out.println("前置增强.............");
					  Object  result=	method.invoke(waiter, args);
					   System.out.println("后置增强.....................");
				  
						return null;
					}
				});
	
	                  Server server =(Server) o;  
	                   server.doServer();
	               //   System.out.println(server.say("hello"));
	}

}
