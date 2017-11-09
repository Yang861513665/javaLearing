package cn.yxj.annotation;

import java.text.DateFormat;
import java.text.MessageFormat;
import java.util.Date;
import java.util.Locale;

public class Demo1 {
    
	public static void main(String[] args) {

		String p = "{1}或{0}错误";
		String text = MessageFormat.format(p,"用户名","密码");
		System.out.println(text);//用户名或密码错误
	    DateFormat d = DateFormat.getDateInstance(DateFormat.FULL, Locale.CHINA);
	   String  date= d.format(new Date());
	   System.out.println(date);
	     
	   System.out.println(p.length());
        
	}
}
