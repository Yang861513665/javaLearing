package cn.yxj.thread;

import java.util.ArrayList;
import java.util.Collections;


public class Test {
          public static void main(String[] args) {
        	   ArrayList<String> list = new ArrayList<String>();
        	   list.add("aa");
        	   list.add("bb");
        	   ArrayList<String> list2 = new ArrayList<String>();
        	   list2.add("cc");
        	   list2.add("dd");
        	   list2.add("nn");
        	   Collections.copy(list2, list);
        	   for (String string : list2) {
				System.out.println(string);
			}
		}
}
