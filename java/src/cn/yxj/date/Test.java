package cn.yxj.date;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class Test {
public static void main(String[] args) throws Exception {
	Calendar calendar = Calendar.getInstance(new Locale("zh-cn"));
	String  birtnday ="1996-10-12";
	System.out.println(calendar.getTime());
	Date  data=new SimpleDateFormat("yyyy-MM-dd").parse(birtnday);
	calendar.setTime(data);
	System.out.println(calendar.getFirstDayOfWeek());
	System.out.println(calendar.get(Calendar.YEAR));
	System.out.println(calendar.get(Calendar.MONTH)+1);
	System.out.println(calendar.get(Calendar.DAY_OF_MONTH));
}
}
