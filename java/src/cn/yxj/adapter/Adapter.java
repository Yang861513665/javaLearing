package cn.yxj.adapter;

//定义一个适配器实现将 PS2接口转成USB接口
public class Adapter  extends Usbr  implements PS2 {

	@Override
	public void isPS2() {
              isUSB();		
	}
            public static void main(String[] args) {
            	 PS2  ps2= new Adapter(); 	 
                 ps2.isPS2();
			}
}
