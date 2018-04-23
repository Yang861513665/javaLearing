package cn.yxj.DiGui;


public class Demo1 {

	public static void main(String[] args) {
   show(0);
	
	}
  static void show(int  i){
	  if(i<3){
		  i++;
	    System.out.println("******"+i);
		show(i);
	  }
	  System.out.println("-------"+i);
  }
}


/**
 *  程序流程：
 *  1. show(0) -> 进栈    输出：**********1 ，  压栈，待输出： --------1
 * 2. show(1) -> 进栈       输出：**********2 ，压栈，待输出： --------2
 * 3. show(2) -> 进栈       输出：**********3 ，压栈， 待输出： --------3
 * 4. show(3) -> 进栈        输出：不满足，输出 ------3
 * 4：show(2),show(1),show(0)依次出栈，输出 ----3，-----2，-------1
 * */
