package cn.yxj.Sort;

public class Student implements Comparable<Student>{
	/*
	 *  1.使用list 集合进行排序 时：实体类实现 Comparable接口，
	 *  并且执行的方法中使用 Collections.sort(list)实现排序。
	 *  
	 *  2.使用set集合不用使用 Collections.sort(set)方法
	 *  
	 * */
	String name;
	int  mathScore;
	int englishScore;
	int chineseScore;
	int sum;
	
	public Student(String name, int mathScore, int englishScore,
			int chineseScore) {
		super();
		this.name = name;
		this.mathScore = mathScore;
		this.englishScore = englishScore;
		this.chineseScore = chineseScore;
	}
	public String getName() {
		return name;
	}
//获得总分
 public int getSum(int mathScore, int englishScore,int chineseScore ){		
	
	 return sum=mathScore+englishScore+chineseScore;
 }	
	@Override
public String toString() {
	return "Student [name=" + name + ", mathScore=" + mathScore
			+ ", englishScore=" + englishScore + ", chineseScore="
			+ chineseScore + ", sum=" + sum + "]";
}
	@Override
	public int compareTo(Student o) {
		Student s=o;
		int sum2=s.getSum(s.mathScore,s.englishScore, s.chineseScore);
		return sum2-this.getSum(mathScore, englishScore, chineseScore) ;
	}
	

}
