package cn.yxj.staticTest;
/*   单例模式代码体现（饿汉模式）*/
public class Singleton {
	//创建一个本类的对象
	private static Singleton s=new Singleton();
	
	  //私有化构造函数（外部类不能new）
	private Singleton(){
      System.out.println("单例模式代码实现。。。。。。。。。。。。。。。");
	}
	//对外部提供一个获得该对象的静态方法
 public static Singleton getInstance(){
	 return s;
 }	    
}

/*
 *          单例的延迟加载（懒汉模式）
 *  public class Singleton2{
 * 
 *  private static Sington2 s2=null;
 *   private Sington2(){
 *   } 
 *    public static Singleton getInstance(){
 *    if(s2==null){
 *    s2=new Sington2();}
	   return s2;
 }	    
 * 
 * 
 * 
 * 
 *
	}
*/

