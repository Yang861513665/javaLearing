package cn.yxj.Set;

import java.util.Comparator;

public class ComparatorByUnSort implements Comparator<Integer> {

	@Override
	public int compare(Integer o1, Integer o2) {
		Integer s1=  o1;
		Integer s2=  o2;
		return s1-s2;
		
	}

}
