package cn.yxj.String;

public class StringDemo {

	public static void main(String[] args) {
		String s1 ="java  is the best language";
		//System.out.println(s1.length());
		//System.out.println(s1.lastIndexOf("a",3));   //从第三个位置反向查找a 的位置（下标）
		String  s2=  new String("aaa");
		String s3 = s1.concat(s2);
		String s7= s1+s2;
		System.out.println(s3);
		String s4="java  is the best languageaaa";
		String s5=  new String("java  is the best language");
		System.out.println(s3==s4);   //false
		System.out.println(s3==s7);  //false
		System.out.println(s1==s5);   //false
	}
}
