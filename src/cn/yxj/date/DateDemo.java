package cn.yxj.date;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class DateDemo {

	public static void main(String[] args) throws ParseException {
		
	  getDate();
	  getDateTime();
		//getleadtime();
		//showdate();

	}

	private static void showdate() {
		/*
		 * 需求：求给定的年份的2月份有多少天。
		 * 思路：也就是看3月1号的前一天是2月几号就可以得出多少天。
		 * */
		Calendar c=Calendar.getInstance();
		Scanner sc=new Scanner(System.in);
		int year=sc.nextInt();
		c.set(year, 2, 1); //设置给定的年，3月1日（注：month从0开始）
		c.add(Calendar.DAY_OF_MONTH, -1); //c.add(field, amount):根据日历的规则，为给定的日历字段添加或减去自定的时间量
     
       int month=c.get(Calendar.MONTH)+1;
       int day=c.get(Calendar.DAY_OF_MONTH);
       System.out.println(year+":"+""+month+"月"+day+"日");

		
	}

	private static void getleadtime() throws ParseException {
		/*
		 *  需求： 计算两个时间段中间隔了多少天
		 * */
        int style=DateFormat.LONG;  //Long样式：2017年1月27日
        System.out.println("按XXXX年XX月XX日的格式输入两个时间段，我们将计算出这两个时间段相隔多少天");
		Scanner sc=new Scanner(System.in);
		String[] strs=new String[3];
		for(int i=0;i<strs.length;i++){
			strs[i]=sc.nextLine();
		}
	  DateFormat dateFormat=DateFormat.getDateInstance(style);
	   Date newdate1= dateFormat.parse(strs[1]);
	   Date newdate2= dateFormat.parse(strs[2]);
	   long leadtime =Math.abs(newdate1.getTime()-newdate2.getTime());  //毫秒数间隔
	   int leadtime2 =(int) (leadtime/1000/60/60/24);
	 //  System.out.println(leadtime2);
		
		
	}

	private static void getDateTime() {
		Date date=new Date();
		DateFormat dateFormat=DateFormat.getDateTimeInstance(DateFormat.DEFAULT,DateFormat.DEFAULT);
	System.out.println(dateFormat.format(date));  //格式化日期和时间
		
	}

	private static void getDate() {
		Date date=new Date();
		DateFormat dateFormat= DateFormat.getDateInstance(DateFormat.LONG);// 根据当前环境格式化日期
		System.out.println(dateFormat.format(date));
	}
	
	
	
	
	
	
	
	
}
