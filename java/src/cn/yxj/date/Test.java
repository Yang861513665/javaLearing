package cn.yxj.date;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {
public static void main(String[] args) throws Exception {
	String sql ="select  * from user  order by uid,uuid";
    Pattern p = Pattern.compile("order\\s*by[\\w|\\W|\\s|\\S]*");  
    Matcher m = p.matcher(sql);  
    StringBuffer sb = new StringBuffer(sql);  
    if(m.find()){
    	m.appendReplacement(sb, "");
    }
    System.out.println(sql+" ====> "+sb.substring(sql.length()));
//	Calendar calendar = Calendar.getInstance(new Locale("zh-cn"));
//	String  birtnday ="1996-10-12";
//	System.out.println(calendar.getTime());
//	Date  data=new SimpleDateFormat("yyyy-MM-dd").parse(birtnday);
//	calendar.setTime(data);
//	System.out.println(calendar.getFirstDayOfWeek());
//	System.out.println(calendar.get(Calendar.YEAR));
//	System.out.println(calendar.get(Calendar.MONTH)+1);
//	System.out.println(calendar.get(Calendar.DAY_OF_MONTH));
}
}
