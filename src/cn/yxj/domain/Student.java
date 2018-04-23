package cn.yxj.domain;

public class Student implements Comparable<Object> {
	private String name;
	private int age;
	public Student(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + "]";
	}
	/*重写compareto方法，建立学生自然排序
	 * 
	 * 按照学生的年龄排序*/
	@Override
	public int compareTo(Object o) {
		if(!(o instanceof Student)){
			throw new ClassCastException();
		}
		Student stu=(Student) o;
		/*if(this.age>stu.age){
			return 1;
		}if(this.age<stu.age){
			return -1;
		}*/
		/*
		 * 注意：在比较时，必须明确主次，主要条件相同，继续比较次要条件
		 * 
		 * */
		int temp= this.age-stu.age;
		return temp==0?this.name.compareTo(stu.name):temp;
		//这里  因为 字符串具备 compareTo（按字典顺序比较两个字符串）方法。
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
			

}
