package cn.yxj.map;

import java.util.Comparator;

import cn.yxj.domain.Student;

public class ComparatorByName implements Comparator {

	public static void main(String[] args) {
	

	}

	@Override
	public int compare(Object o1, Object o2) {
		Student stu1= (Student) o1;
		Student stu2= (Student) o2;
		int temp=stu1.getName().compareTo(stu2.getName());
		
		return temp;
	}

}
