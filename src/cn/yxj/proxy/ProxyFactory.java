package cn.yxj.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 代理工厂，动态生成代理。
 * */
public class ProxyFactory {
  private  Object targetObject;
  private  BeforeAdvice beforeAdvice;
  private  AfterAdvice  afterAdvice;

public Object getTargetObject() {
	return targetObject;
}

public void setTargetObject(Object targetObject) {
	this.targetObject = targetObject;
}

public Object getBeforeAdvice() {
	return beforeAdvice;
}

public void setBeforeAdvice(BeforeAdvice beforeAdvice) {
	this.beforeAdvice = beforeAdvice;
}

public Object getAfterAdvice() {
	return afterAdvice;
}

public void setAfterAdvice(AfterAdvice afterAdvice) {
	this.afterAdvice = afterAdvice;
}

public Object  createProxy(){
	Object proxy=Proxy.newProxyInstance(
    		targetObject.getClass().getClassLoader(),
    		targetObject.getClass().getInterfaces(),
    		new InvocationHandler() {	
				@Override
				public Object invoke(Object proxy, Method method, Object[] args)
						throws Throwable {
					if( beforeAdvice!=null){
						beforeAdvice.before();
					}
					Object  result=method.invoke(targetObject, args);
					
					if(afterAdvice!=null){
						afterAdvice.after();
					}
					return result;
				}
			});
   
	return proxy;
	
}
	
}
