package cn.yxj.domain;

import java.util.ArrayList;
import java.util.LinkedList;

public class TestDemo2 {
  public static void main(String[] args) {
	    LinkedList<String> list = new LinkedList<String>();
	    ArrayList<String> list2 = new ArrayList<String>();
	    list2.add("b");
	    list2.add("2a");
	    list2.add("30a");
	    list.addLast("1");
	    list.addLast("2");
	    list.addLast("3");
	    for (String string : list) {
			System.out.println(string);
		}
}
}
