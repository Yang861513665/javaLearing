package cn.yxj.String;

import java.util.Arrays;

public class StringSort {

	public static void main(String[] args) {
		
	String[] strs={"fbc","bec","mfd","agd"};
	//Arrays.sort(strs);//对字符串数组进行排序
	

	for (String str : strs) {
		//System.out.println(str);
		
	}
	/* ***********************  这是一条分割线*********************************** */
	int[] numbers={78,23,46,38};
	Arrays.sort(numbers);//对整形数组进行排序
	//Arrays.sort(numbers, 0, 1);//只对第一个和第二个数字进行排序
	for (int number : numbers) {
		//System.out.println(number);
	}
	/* ***********************  这是一条分割线*********************************** */
  String str1="1h2hh3hh4h5ha"; //统计hh出现的次数（字符串出现的次数）

  String[] strs1=new String[str1.length()];
   for(int i=0;i<str1.length();i++){
	   strs1= str1.split("hh");  
	   
   }
   if(str1.endsWith("hh")){
	//   System.out.println(strs1.length);
   }else{
	  // System.out.println(strs1.length-1);
   }
   /* ***********************  这是一条分割线*********************************** */
   String str2="aa bb c";  //判断空格出现的次数，（判断某个字母出现的次数）
   int x=0;
   for (int i = 0; i < str2.length(); i++) {
	String getstr= str2.substring(i,i+1);
	if(getstr.equals(" ")){
		x++;
		
	}
	
}
   //System.out.println(x);
   /* ***********************  这是一条分割线*********************************** */  
   
   String str3="20  45  -5 100";  //将字符型数组转成整形数组并进行排序
      String[] strs11= str3.split(" +"); //按空格切割
      int[] nums= new int[strs11.length];
   for(int i=0;i<strs11.length;i++) {	  
	   nums[i]= Integer.parseInt(strs11[i]);
   }
     Arrays.sort(nums);
     for (int i1 : nums) {
	//  System.out.println(i1);
   }
 
   
	}}
