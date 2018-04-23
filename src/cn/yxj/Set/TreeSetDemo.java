package cn.yxj.Set;

import java.util.Iterator;
import java.util.TreeSet;

import cn.yxj.domain.Student;

public class TreeSetDemo {
	public static void main(String[] args) {
		//TreeSet set=new TreeSet();//第一种按年龄排序，在实例对象中实现comparable接口，重写compare方法
		TreeSet<Student> set=new TreeSet<Student>(/*new ComparetorByName()*/);				
		/*TreeSet<Student> set=new TreeSet<Student>(new Comparator<Student>() {	 //匿名类	
			public int compare(Student o1, Student o2) {
				int temp=o1.getName().compareTo(o2.getName());
				return temp==0?o1.getAge()-o2.getAge():temp;
			}
		});
		
		
		 * */
		/*第二种按姓名排序。使用比较器（其实就是在创建Treeset集合时，
		 * 在构造函数指定具体的比较方式。
		 * 需要创建一个类，实现comparator接口
		 * */	
		/*
		 * TreeSet的add方法内部最终实现:
		 * 需要将元素转成comparable类型，为什么？ 因为这个类型具备排序的能力。
		 * 这个类型中有一个专门为排序提供了一个compareto 方法。
		 * 如果要让学生具备比较排序的功能，需要让学生扩展功能，实现comparable接口。
		 * 
		 * */
	
		set.add(new Student("lisi1",21));
		set.add(new Student("lisi3",20));
		set.add(new Student("lisi2",23));
		set.add(new Student("lisi4",23));
	
		//使用迭代器
	/*	for (Iterator<Student> iterator = set.iterator(); iterator.hasNext();) {
			System.out.println( iterator.next());
			
		}*/
		for (Student student : set) {
			System.out.println(student);
		}
		System.out.println(set.size());
/* *********************************这是一条分割线************** */
		TreeSet<Integer> set1=new TreeSet<Integer>(new ComparatorByUnSort());
		set1.add(10);
		set1.add(7);
		set1.add(9);

		
		
		for (Integer integer : set1) {
			System.out.println(integer);
		}
		
		/* *********************************这是一条分割线************** */	
		/* 练习：对字符串的长度(由短到长)排序
		 * 思路：1,。字符串之所以能排序，是因为已经实现了comparator接口，重写了compare方法，
		 * 建立了字符串的自然排序。
		 * 2.但是自然排序不是需求中所需要的。咋办？
		 * 只能使用比较器，所以需要自定义一个比较器。
		 * 
		 * */
		TreeSet<String> set2=new TreeSet<String>(new ComparetorByLength());
	
		set2.add("abc");
		set2.add("sjfas");
		set2.add("aaaaaaaa");
		set2.add("sjah");
		set2.add("sjahdsf");
		/*
		for (String String : set2) {
			System.out.println(set2);
		}*/
		for (Iterator<String> iterator = set2.iterator(); iterator.hasNext();) {
			String string =  iterator.next();
			System.out.println("["+string+"]");
		}
	}}
	

	
