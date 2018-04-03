package cn.yxj.proxy2;

public class HelloImpl  implements Hello {
	@Override
	public void say(String name) {
          System.out.println(" hello" + name);
	}

	@Override
	public void say2() {
           System.out.println(" hello2....");		
	}

}
