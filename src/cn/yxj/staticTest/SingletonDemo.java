package cn.yxj.staticTest;

public class SingletonDemo {

	public static void main(String[] args) {
		//单例代码实现
		
	Singleton s1=	Singleton.getInstance();
	Singleton s2=	Singleton.getInstance();
	System.out.println(s1==s2);    //true  表明是同一个对象
	
	
	

	}

}
