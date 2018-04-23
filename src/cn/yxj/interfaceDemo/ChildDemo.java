package cn.yxj.interfaceDemo;


/**
 *   super不是超类的引用，而是表示在子类中调用父类的方法或属性而已
 * */
public class ChildDemo extends FatherDemo {
	public  String username="children";
  
	public static void main(String[] args) {
	 FatherDemo c = new ChildDemo();
	 FatherDemo f = new FatherDemo();
	/*  c.show();
	  f.show();*/
	 System.out.println(c.username);
	 c.show2();
}
   void show2(){
 System.out.println(super.show(1));
	   System.out.println("zilei show2--》"+username);
   }
 
}

