package cn.yxj.exception;




/**
 * @author : yangxijun
 *@data : 2017年6月18日下午4:09:00
 *@description : 结论： 继承运行时的异常当方法发生异常不需要声明，而继承编译时的异常必须声明或者进行捕获处理；异常一旦发生程序就会终止。
 *@version : v1.0
 */
public class ExceptionDemo {

	 /*
	  * 继承编译时异常
	  * */
	class  Exception1 extends Exception{

		private static final long serialVersionUID = 1L;

		public Exception1() {
			super();
		}
		public Exception1(String message) {
			super(message);
		}
		
	}
 /*
  * 继承运行时异常
  * */
	class  Exception2 extends RuntimeException{

		private static final long serialVersionUID = 1L;

		public Exception2() {
			super();
		}
		
		public Exception2(String message) {
			super(message);
		}
		
	}
	public static void main(String[] args)  {
		ExceptionDemo  demo= new ExceptionDemo();
		try{
			demo.show(-1);
		}catch(Exception1 e){
			System.out.println(e.getMessage());   //获得异常信息
		}finally{
			System.out.println("我不管发不发生异常都执行");
		}

	}
/**
 * 
 *@description:声明编译时的异常
 * @param x
 * @throws Exception1
 */
	void show(int x) throws Exception1{
		if(x<0){
			throw  new Exception1(x+"非法!");
		}
		else{
			System.out.println("x为"+x);
		}
		System.out.println("发生异常我就不会出现！");
	}
/**
 *@description:抛出运行时的异常不需要声明
 * @param x
 */
	void  show2(int x) {
		if(x<0){
			throw  new Exception2(x+"非法!");
		}
		else{
			System.out.println("x为"+x);
		}
		System.out.println("发生异常我就不会出现！");
	}

}
