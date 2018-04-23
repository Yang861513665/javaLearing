package cn.yxj.Sort;

import java.util.Comparator;

public class CompatorBySumScore implements Comparator<Student> {

	@Override
	public int compare(Student o1, Student o2) {
		Student s1=o1;
		Student s2=o2;
		int sum1=s1.getSum(o1.chineseScore, o1.englishScore, o1.chineseScore);
		int sum2=s2.getSum(o1.chineseScore, o1.englishScore, o1.chineseScore);
		return sum1-sum2;
	}

}
