package cn.yxj.cglibProxy;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;


/**
 *  使用cglicb代理
 * */

public class HelloCglib implements MethodInterceptor  {
   
	private Object target;
	
	/**  
     * 创建代理对象  
     *   
     */    
    @SuppressWarnings("unchecked")
	public <T>  T createProxy(Object target) {    
    	// 要代理的类
        this.target = target;    
        //创建Enhancer对象
        Enhancer enhancer = new Enhancer();
        //设置要代理的目标类，以扩展功能
        enhancer.setSuperclass(this.target.getClass());
        //设置单一回调对象，在回调中拦截对目标方法的调用
        enhancer.setCallback(this);
        //设置类加载器
        enhancer.setClassLoader(target.getClass().getClassLoader());
        //创建代理对象
        return (T)enhancer.create();
    }    
    
    /**
     * 回调方法:在代理实例上拦截并处理目标方法的调用，返回结果
     */ 
    @Override    
    public Object intercept(Object obj, Method method, Object[]  params,    
            MethodProxy methodProxy) throws Throwable {    
        System.out.println("前置......");    
//        methodProxy.invokeSuper(obj, params);
           methodProxy.invoke(target, params);
        System.out.println("后置.....");    
        return null;    
    }
}
