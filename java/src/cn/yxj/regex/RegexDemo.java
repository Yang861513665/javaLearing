package cn.yxj.regex;


public class RegexDemo {
	/*
	 * 正则表达式：
	 * 专门用于操作字符串，作用于字符串的一个正确的规则的表达式，
	 * 
	 * 
	 * */

	public static void main(String[] args) {
	//需求：对qq号码进行验证
	//要求：必须5-15位，0不可作为开头，且必须全为数字
		String qq="86..1..513665";
		//boolean b=qq.matches("[1-9][0-9]{4,14}");
		boolean b=qq.matches("[1-9]\\d{4,14}");
		System.out.println(qq+"::"+b);
	    String newqq =	qq.replaceAll("\\.+", ""); //去点
	//	System.out.println(newqq);
		
	  testmail();
	}
	/*
	 *   案例：对邮箱进行校验
	 * */

	private static void testmail() {
		
		String mail="81513665@qq.com.cn";
		String mail2="81513665@qq.cn.com.com.com";
		//String regex="[a-zA-Z_0-9]+@[a-zA-Z_0-9]+(.[a-zA-Z]{2,3}){1,3}";
		String regex="\\w+@\\w+(\\.[a-zA-Z]{2,3}){1,3}";
	boolean b=	mail.matches(regex);
	
	boolean b2=	mail2.matches(regex);
		System.out.println(mail+"::"+b);
		System.out.println(mail2+"::"+b2);
/* ****************************这是一条分割线********** **** */		
	/*正则规则的复用*/
	   String str="我yyyy喜欢tttjava";
	  String regex2="(.)\\1+"; //将叠词作为分隔符	
	String[] strs= str.split(regex2);
	for (String string : strs) {
		System.out.println(string);
	}
	//  (A)(B)(c)\\1\\3\\2   :ABCACB	
	String str3="我我我要学学学学编程";// 去相同的字
	str= str3.replaceAll("(.)\\1+", "$1"); //用叠词中的一个替换叠词
	System.out.println(str);	
/* ****************************这是一条分割线********** **** */			
   String str4="17779144831" ;//需求 ：将号码变成 177****4831这种格式。
   String regex3="(\\d{3})(\\d{4})(\\d{4})";
   str4= str4.replaceAll(regex3, "$1****$3");
   System.out.println(str4);


	}	
}
