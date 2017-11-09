package cn.yxj.staticTest;

public class Demo {
	int x=1;
	//静态代码块，随着类的加载而执行加载，仅执行一次
       static{
    	   System.out.println("类加载就执行的部分");
       }
       static void show(){
    	   System.out.println("静态方法执行run........");
       }
       Demo(){
    	   System.out.println("构造无参函数..............."+x);
       }
       //构造代码块（对象创建就执行）
       {
    	   System.out.println("构造代码块.........对象创建就执行");
       }
}
