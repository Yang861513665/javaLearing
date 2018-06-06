package cn.yxj.list;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;



public class ListDemo {
 public static void main(String[] args) {
//	  ArrayList<Integer>   list1 =new ArrayList<Integer>();  
//	  LinkedList<Integer>   list2 =new LinkedList<Integer>();  
//	  Deque<Integer> stack = new ArrayDeque<Integer>();  
	 ArrayList<String> list = new ArrayList<String>() {
		private static final long serialVersionUID = 1L;
	{
		    add("A");
		    add("B");
		    add("C");
		}};
		list.add("D");
		System.out.println(list);
//	   for(int i=0;i<10;i++){
//		   list1.add(i);
//		   stack.push(i);
//		   list2.push(i);
//	   }
//	   System.out.println(list1);
//	   System.out.println(list2);
//	   System.out.println(stack);
}
}
