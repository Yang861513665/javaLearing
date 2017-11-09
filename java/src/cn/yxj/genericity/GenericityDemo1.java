package cn.yxj.genericity;

import java.util.ArrayList;
import java.util.Collection;

public class GenericityDemo1 {
   public static void main(String[] args) { 
	      ArrayList<Number> arrayList = new ArrayList<Number>();
	      arrayList.add(20);
	      arrayList.add(21.0);
	      ArrayList<Integer> arrayList2= new ArrayList<Integer>();
	      arrayList.add(20);
	      arrayList.add(22.0);
	      ArrayList<String> arrayList3= new ArrayList<String>();
	      add(arrayList);
	      add(arrayList2);	     
	    //  add(arrayList3);	     报错，编译不通过
}
 
public static void add(Collection<? extends Number>  c){
	   for (Number number : c) {
		System.out.println(number);
	}
   }
}
