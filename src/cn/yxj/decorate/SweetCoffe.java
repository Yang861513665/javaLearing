package cn.yxj.decorate;

public class SweetCoffe {
   private   Coffe c;
	SweetCoffe(Coffe c){
		this.c=c;
	}
	 void show(){
		 c.show();
		 System.out.println("开始加糖。。生成加糖咖啡");
	 }
	 public static void main(String[] args) {
		  SweetCoffe sw = new SweetCoffe(new Coffe());
		  sw.show();
	}
}
