package cn.yxj.Set;

import java.util.Comparator;

import cn.yxj.domain.Student;

public class ComparetorByName implements Comparator<Student> {

	@Override
	public int compare(Student o1, Student o2) {
		//因为比较的是学生对象的姓名，所以要先向下转型成student对象。
		Student stu1=  o1;
		Student stu2=  o2;
		//先比较姓名
		int temp= stu1.getName().compareTo(stu2.getName());
		//如果姓名相同（也就是结果为0），再比较年龄
		return temp==0?stu1.getAge()-stu2.getAge():temp;
	}

}
