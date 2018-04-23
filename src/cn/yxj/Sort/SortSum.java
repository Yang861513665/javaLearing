package cn.yxj.Sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class SortSum {
	public static void main(String[] args) {

	/*	Treelist<Student> list = new Treelist<Student>(new Comparator<Student>() {
		
			@Override
			public int compare(Student o1, Student o2) {
			 Student s1=o1;
			 Student s2=o2;
			 int sum1=s1.getSum(s1.mathScore, s1.englishScore, s1.chineseScore);
			 int sum2=s2.getSum(s2.mathScore, s2.englishScore, s2.chineseScore);
			 int temp=sum2-sum1;
				return  temp==0?s2.getName().compareTo(s1.getName()):temp;
			}
		});*/
		ArrayList<Student> list = new ArrayList<Student>();

		Scanner sc = new Scanner(System.in);
		while (list.size() <3) {
			System.out.println("输入姓名，数学成绩，英语成绩，中文成绩");
			String studentInfos = sc.nextLine();
			String[] sInfo = studentInfos.split(",");
			String name = sInfo[0];
			int mathScore = Integer.parseInt(sInfo[1]);
			int englishScore = Integer.parseInt(sInfo[2]);
			int chineseScore = Integer.parseInt(sInfo[3]);
			Student s = new Student(name, mathScore, englishScore, chineseScore);
			list.add(s);
		}
		 Collections.sort(list);   //list 集合使用这个实现排序
		 for (Student student : list) { System.out.println(student); }
		//关闭输入流 
		sc.close(); 
	}
  
}
