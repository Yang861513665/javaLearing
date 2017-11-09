package cn.yxj.date;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;



public class TestDemo {

	public static void main(String[] args) throws Exception {
		String dates="2017-8-16  15:22:12 ";
		DateFormat instance=	DateFormat.getDateTimeInstance();
		Date parseDate = instance.parse(dates);
		System.out.println(parseDate);
		DateFormat instance2=	DateFormat.getDateInstance(DateFormat.LONG);
		String format = instance2.format(parseDate);
		System.out.println(format);
		
	}

}
