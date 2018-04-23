package cn.yxj.map;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import cn.yxj.domain.Student;

public class HashMapTest {

	public static void main(String[] args) {
		
		HashMap<Student,String> map=new HashMap<Student,String>();
		map.put(new Student("杨希军",21),"江西");
		map.put(new Student("小红",22),"北京");
		map.put(new Student("小李",20),"深圳");
		
		for (Student key : map.keySet()) {
			
//			System.out.println(key+"-----"+map.get(key));
		}
		for(Map.Entry<Student, String> me:map.entrySet()){
			Student key=me.getKey();
			String value=me.getValue();
			System.out.println(key+"----"+value);
			
		}
	System.out.println("--------------------------这是一条分割线--------------------------------");	
	/*  需求：按学生的年龄排序
	 * 思路：实现comparable接口
	 * */	

	Map<Student,String> map2=new TreeMap<Student,String>();
	map2.put(new Student("张三",27),"江西");
	map2.put(new Student("李四",22),"北京");
	map2.put(new Student("王二",20),"深圳");
	map2.put(new Student("赵六",26),"上海");
	for (Student key : map2.keySet()) {
		
//		System.out.println(key+"-----"+map2.get(key));
	}
	System.out.println("--------------------------这是一条分割线--------------------------------");	
	/*  需求：按学生的姓名排序
	 * 思路： 使用比较器
	 * */	

	Map<Student,String> map3=new TreeMap<Student,String>(new ComparatorByName());
	map3.put(new Student("mn",27),"江西");
	map3.put(new Student("qw",22),"北京");
	map3.put(new Student("aa",20),"深圳");
	map3.put(new Student("ff",26),"上海");
	for (Student key : map3.keySet()) {
		
//		System.out.println(key+"-----"+map.get(key));
	}

}}
