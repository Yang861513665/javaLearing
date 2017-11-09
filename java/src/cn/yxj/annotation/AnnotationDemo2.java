package cn.yxj.annotation;

public class AnnotationDemo2 {

	 public static void main(String[] args) {
		 Animal  a= new  Animal();
		 Animal  a1 = new Dog();
		 Animal  a2 = new Cat();
		 a.cry2(a1);
		 a.cry2(a2);
		 System.out.println(a1.num);
		 System.out.println(a2.num);
	}
}

class  Animal {
public int  num=10;
	void cry(){
		System.out.println("Animal cry..." +this.num);
	}
	void cry2(Animal  a){
		a.cry();
	}
}
class  Dog extends Animal{
//	private int  num=20;
	@Override
	void cry(){
		System.out.println("wang  wang  wang ..."+this.num);
	}
}
class  Cat extends Animal{
	private int  num=30;
	@Override
	void cry(){
		System.out.println("miao miao miao..."+this.num);
	}
}