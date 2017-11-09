package cn.yxj.Set;

import java.util.Comparator;

public class ComparetorByLength implements Comparator<String> {

	@Override
	public int compare(String o1, String o2) {
		String s1= o1;
		String s2=  o2;
		
		int temp= s1.length()-s2.length();
		return temp==0?s1.compareTo(s2):temp;
		
	}

	

}
