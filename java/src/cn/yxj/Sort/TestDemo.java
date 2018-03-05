package cn.yxj.Sort;

import java.util.Date;

public class TestDemo extends Date {
	private static final long serialVersionUID = 1L;
	{
		System.out.println("gou zao  kuai ......");
	}
 static	{
		System.out.println(" jin tai gou zao  kuai ......");
	}
public static void main(String[] args) {
	 new TestDemo().test(); 
}
    public   void test(){
    	System.out.println(super.getClass());
    	 System.out.println(super.getClass().getName()); 
    }
}
