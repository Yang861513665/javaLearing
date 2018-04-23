package cn.yxj.Io;

class  ExtendsDemo
{
	public static void main(String[] args) 
	{
		Zi zi=new Zi();
	    zi.show();
	}
}
class  Fun
{
	int num=3;
}

class  Zi extends Fun
{
	int num=4;
	void show(){
	System.out.println(this.num);
    System.out.println(super.num);
	}
}