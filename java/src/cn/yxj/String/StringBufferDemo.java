package cn.yxj.String;



public class StringBufferDemo {
 /*
  *  StringBuffer:
  *  1，是一个字符串缓冲区，其实就是一个容器。
  *  2，长度可变，任意类型都可以。注意是将任意数据都转成字符串进行存储。
  *  3，容器对象提供很多多容器中数据的操作（添加，删除，查找，修改）
  *  4，必须所有的数据最终变成一个字符串。
  * 
  * */
	public static void main(String[] args) {
	
	StringBuffer sb=new StringBuffer();
		
		sb.append(true);
		sb.append("yangxijun a");
		sb.append(1.2);
		System.out.println(sb);
		System.out.println(sb.reverse());
		
		sb.deleteCharAt(1);
		System.out.println(sb);
		


}}
