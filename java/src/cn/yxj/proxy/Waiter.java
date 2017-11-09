package cn.yxj.proxy;

public class Waiter implements Server {

	@Override
	public void doServer() {
		
		System.out.println("开始服务！");
	
		
	}

	@Override
	public String say(String s) {
		
		return s;
	}



}
