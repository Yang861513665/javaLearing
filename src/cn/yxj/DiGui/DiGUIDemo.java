package cn.yxj.DiGui;

public class DiGUIDemo {

	public static void main(String[] args) {
		Integer  a=100;
		Integer b=100;
		Integer c=200;
		Integer d=200;
	
		System.out.println(a==b);
		System.out.println(c==d);
	
	/*
	 * 递归：其实就是功能的重复使用，但是每次功能掉调用参数都变化（使用了上次的运算结果）
	 * 1：函数自身调用
	 * 2：一定要定义条件（否则可能出现栈溢出：StackOverFlowerException）
	 * */
	/*Scanner sc=new Scanner(System.in);
	int number= sc.nextInt();
	 int sum=  getsum(number);
	  System.out.println(sum);

	}

	private static int getsum(int num) {
		//计算给定的数字的递归
		if(num==1){
			return 1;
		}
		return num+getsum(num-1);
		*/
	}

}
