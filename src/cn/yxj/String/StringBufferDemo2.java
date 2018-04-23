package cn.yxj.String;

public class StringBufferDemo2 {

	  public static void main(String[] args) {
		
		    StringBuffer sb=  new StringBuffer();
		    sb.append("java ");
		    StringBuffer sb2=sb.append("is the  best language");
		    System.out.println(sb==sb2);  //true  表明StringBuffer 追加字符串，对象不变
		    System.out.println(sb.equals(sb2));  //true      表明 StringBuffer 类没有覆写equals方法（内部还是使用object的equals 方法来判断）
		    String s3 =sb2.toString();
		    String s4="java is the  best language";
		    System.out.println(s3==s4);  //false   表明StringBuffer 类 覆写了 toString 方法，返回了一个新的String对象
	}
}
