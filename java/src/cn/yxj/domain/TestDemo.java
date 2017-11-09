package cn.yxj.domain;

import java.util.HashMap;
import java.util.Set;

public class TestDemo {
	public static void main(String[] args) {
		    HashMap<Person,String> map = new HashMap<Person,String>();
		     map.put(new Person("yxj",12), "11");
		     String put=	    map.put(new Person("yxj",12), "12");  
		    System.out.println(put); //11
		    String put2 =    map.put(new Person("yxj",13), "11");   
		    System.out.println(put2);//null
	    Set<Person> keySet = map.keySet();
	    for (Person person : keySet) {
			System.out.println(person);
		}
	}

}
