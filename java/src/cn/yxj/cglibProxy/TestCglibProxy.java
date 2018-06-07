package cn.yxj.cglibProxy;

public class TestCglibProxy {
		public static void main(String[] args) {
		HelloCglib  helloCglib  =	 new HelloCglib();
		HelloImpl helloImplCglibProxy =  helloCglib.createProxy(new HelloImpl());
		helloImplCglibProxy.say("lala");
		}
}
