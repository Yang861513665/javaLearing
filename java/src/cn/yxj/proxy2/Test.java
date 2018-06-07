package cn.yxj.proxy2;

import java.util.HashMap;

public class Test {
		public static void main(String[] args) {
//			     Hello  hello = new HelloImpl();
//			     Hello   helloProxy = (Hello)Proxy.newProxyInstance(
//			    		 hello.getClass().getClassLoader(), 
//			    		 hello.getClass().getInterfaces(),
//			    		 new DynamicProxy(hello));
			DynamicProxy  dynamicProxy =new DynamicProxy(new HelloImpl());
			     Hello  helloProxy =    dynamicProxy.getProxy();
			     helloProxy.say2();
		}
		
}
