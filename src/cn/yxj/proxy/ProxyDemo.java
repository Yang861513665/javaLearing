package cn.yxj.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import org.junit.Test;
/**
 * 动态代理的初步认识
 * */
public class ProxyDemo {
   @Test
	public void fun1(){
	        
	       ClassLoader classLoader = this.getClass().getClassLoader();
	       Server waiter = new Waiter();
	       
	         MyInvocationHandler h = new MyInvocationHandler(waiter);   // waiter 代表目标对象
	 
		/*
		 * 使用三大参数创建代理对象，得到增强后的 serverProxy代理对象
		 * */
	     
	 Server  serverProxy=    (Server) Proxy.newProxyInstance(classLoader, new Class[]{Server.class}, h); 
      serverProxy.doServer();
	
	 /***
	  * 方法作用：动态创建实现了interfaces数组中所有接口方法的实现类
	  * 参数：1，classLoader：类加载器，把.class 文件加载到内存，形成Class对象！
	  *             2，interfaces：指定要实现的接口
	  *             3， InvocationHandler ：代理对象的所有方法都会调用  InvocationHandler 的invoke方法
	  */
	   
   }
   }
   class   MyInvocationHandler   implements  InvocationHandler{
	   private Server server;
	   MyInvocationHandler(Server  server){
		   this.server=server;
	   }
     
	public Server getServer() {
		return server;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		System.out.println("前置增强.......");
		this.getServer().doServer(); 
		System.out.println("后置增强........"); 
	  return null;
	}
	   
   }


