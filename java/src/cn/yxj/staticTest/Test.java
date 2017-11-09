package cn.yxj.staticTest;


public class Test {

	
			public static void main(String[]args)throws Exception {
			 
				String s =new String("aa");
				change(s);
				System.out.println(s);
	}

			private static void change(String s) {
                 s="bb";				
			}
}
