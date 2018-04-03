package cn.yxj.proxy2;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class DynamicProxy implements InvocationHandler {
      public  Object target;
      public DynamicProxy(Object target){
    	  this.target = target;
      }
      @SuppressWarnings("unchecked")
	public  <T>  T getProxy(){
    	 return  (T)  Proxy.newProxyInstance(
		    		 target.getClass().getClassLoader(), 
		    		 target.getClass().getInterfaces(),
		    		 this);
      }
	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		     System.out.println("前置。。。。");
		     Object result =method.invoke(target, args);
		     System.out.println("后置。。。。");
		return result;
	}

}
