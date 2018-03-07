package cn.yxj.list;

import java.util.ArrayList;
import java.util.List;

public class ListDemo {
 public static void main(String[] args) {
	       List<Integer>  list = new ArrayList<Integer>(20);
	       for(int i =0;i<2;i++){
	    	   list.add(i);
	       }
	       for(int i=0;i<list.size();i++){
	    	   if(i%5==0){
	    		   System.out.println(list.subList(i, list.size()-i>5?i+5:list.size()));
	    	   }
	       }
}
}
