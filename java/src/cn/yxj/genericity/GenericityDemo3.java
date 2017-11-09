package cn.yxj.genericity;
/**
 * 泛型的使用3
 * */
public class GenericityDemo3<T> {

	private  T  t;
	public static void main(String[] args) {
		 GenericityDemo3<String> genericityDemo3 = new GenericityDemo3<String>("aaa");
		 GenericityDemo3<Integer> genericityDemo4= new GenericityDemo3<Integer>(20142177);
		 System.out.println(genericityDemo3.getT());
		 System.out.println(genericityDemo4.getT()+1);
	}

	public GenericityDemo3(T t) {
		super();
		this.t = t;
	}

	public T getT() {
		return t;
	}
}
