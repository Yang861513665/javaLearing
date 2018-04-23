package cn.yxj.interfaceDemo;

public class FatherDemo {
	public  String username="father";

	public static void main(String[] args) {
      FatherDemo fd = new FatherDemo();
      System.out.println(fd.username);
}
	void show2(){
		System.out.println("父类show......"+username);
	}
	int  show(int i){
		return i;
	}
	public FatherDemo(){
		this("yxj");
		System.out.println("wucan。。。");
	}
	public  FatherDemo(String username){
		System.out.println("you can。。。。");
		this.username=username;
	}
	}
