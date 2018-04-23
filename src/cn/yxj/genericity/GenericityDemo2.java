package cn.yxj.genericity;

public class GenericityDemo2 {
	public static void main(String[] args) {
		AA<String>  a =new AA<String>();
		a.fun1();
		AA<Integer> a1= new AA<Integer>();
		a1.fun1();
	}
}
	class   A<T>{
		void fun1(){
			System.out.println("aaaa");
		}
	}
	class  AA <E> extends A <E>{
		void fun1(){
			System.out.println("bbbb");
		}
	}
	
