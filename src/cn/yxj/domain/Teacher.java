package cn.yxj.domain;

public class Teacher {
	private String name;
	private int age;

	public Teacher(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public Teacher() {

	}

	public void show() {
		System.out.println(name + "....." + age);
	    
	}

}
