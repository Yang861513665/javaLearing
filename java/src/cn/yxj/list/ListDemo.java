package cn.yxj.list;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;



public class ListDemo {
 public static void main(String[] args) {
	  ArrayList<Integer>   list1 =new ArrayList<Integer>();  
	  LinkedList<Integer>   list2 =new LinkedList<Integer>();  
	  Deque<Integer> stack = new ArrayDeque<Integer>();  
	   for(int i=0;i<10;i++){
		   list1.add(i);
		   stack.push(i);
		   list2.push(i);
	   }
	   System.out.println(list1);
	   System.out.println(list2);
	   System.out.println(stack);
}
}
