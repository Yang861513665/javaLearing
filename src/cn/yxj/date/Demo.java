package cn.yxj.date;

import java.util.Calendar;
import java.util.Date;


public class Demo {

	public static void main(String[] args) {

	/*	2017年8月16日   DateFormat.LONG
	 * 
	*	2017-8-16      DateFormat.DEFAULT
	*
	*  2017年8月16日 星期三     DateFormat.FULL
	*  
	*	2017年8月16日 下午03时04分14秒  DateTimeFomat.LONG,DateTimeFomat.LONG
	*/
		Date date=new   Date();//取时间
		System.out.println(date.toString());
	      Calendar calendar =Calendar.getInstance();
		    calendar.setTime(date); 
		    calendar.add(calendar.YEAR, 1);//把日期往后增加一年.整数往后推,负数往前移动
		    calendar.add(calendar.DAY_OF_MONTH, 1);//把日期往后增加一个月.整数往后推,负数往前移动
		    calendar.add(calendar.DATE,1);//把日期往后增加一天.整数往后推,负数往前移动 
		    calendar.add(calendar.WEEK_OF_MONTH, 1);//把日期往后增加一个月.整数往后推,负数往前移动
		    date=calendar.getTime();   //这个时间就是日期往后推一天的结果 
		    System.out.println(date.toString());
	}

}
