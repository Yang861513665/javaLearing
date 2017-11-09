package cn.yxj.interfaceDemo;

public class InterfaceDemoImp extends FatherDemo implements InterfaceDemo {

	@Override
	/*
	 * 问题： 接口中没有声明异常，而覆盖接口的方法的子类发生了异常怎么办？
	 * 解决：无法通过throws声明，只能catch捕获处理。如果不能处理就继续throw抛出，
	 * 但要将异常转变成RuntimeException子类抛出..(RuntimeException 是可以声明的)
	 */
	public void show1(int x) throws RuntimeException {
		
		try {
			if (x < 0) {
				throw new Exception();
			}
		} catch (Exception e) {
			//这里不对异常进行处理，直接将异常（Exception）转成RuntimeException  抛出
			throw new RuntimeException(x + "参数错误");
		}
		System.out.println("我是实现接口的方法啊");
	}

	public void show() {
		// super.show(); //调用父类的show方法
		// System.out.println(" 我是子类的show方法"); //如子类和父类方法一致，则调用子类方法
	}

	public static void main(String[] args) {
		InterfaceDemoImp  imp = new InterfaceDemoImp();
		   if (imp instanceof 	InterfaceDemo) {
			System.out.println(true);		
		}
		   
	//	imp.show1(-1);
		// System.out.println(InterfaceDemo.id); //静态的变量和方法 直接 类. 得到
	}

	
}
