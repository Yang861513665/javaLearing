package cn.yxj.proxy;

public class TestProxyFactory {

	public static void main(String[] args) {
    
		 ProxyFactory proxyFactory = new ProxyFactory();
		 proxyFactory.setTargetObject(new Waiter());   //设置目标对象
		 proxyFactory.setBeforeAdvice(new BeforeAdvice(){   //设置前置增强
			 @Override
			 public void  before(){
				 System.out.println("你好------");
			 }
		 });
		 proxyFactory.setAfterAdvice(new AfterAdvice(){//设置后置增强
			 @Override
			 public void after(){
				 System.out.println("再见-------");
			 }
		 });	 
	
		 Server serverProxy = (Server) proxyFactory.createProxy();
		 serverProxy.doServer();
	}

}
