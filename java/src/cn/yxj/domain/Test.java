package cn.yxj.domain;

import java.util.HashSet;

public class Test {

	public static void main(String[] args) {

		   HashSet<Person> hashSet = new HashSet<Person>();
		   Person p1 = new Person("ycj",21);
		   System.out.println(p1.hashCode());
		//  Person p2=p1;
           Person p2  = new Person("ycj",22);
		   System.out.println(p2.hashCode());
		   hashSet.add(p1);
		   hashSet.add(p2);
		   System.out.println(p1.equals(p2));
		   System.out.println(p1==p2);
		   System.out.println(hashSet.size());
	}

}
