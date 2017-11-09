package cn.yxj.map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class HashMapDemo {

	public static void main(String[] args) {
	
		HashMap<String,String> map=new HashMap<String,String>();
	
		map.put("username", "杨希军"); //添加
		map.put("age", null);
		map.put("password", "123");
//		System.out.println(map.get("username"));
//		System.out.println(map.get("age"));
 
//	map.remove("username");     //删除
//		System.out.println(map.get("username"));
//		System.out.println(map.containsKey("age"));
		System.out.println(map.keySet()); //返回所有的键
		//System.out.println(entrySet);//返回所有的键值对
//		使用 键
	Set<String>	 set=map.keySet();
	Set<Entry<String, String>> entrySet = map.entrySet();
	Iterator<Entry<String, String>> iterator = entrySet.iterator();
	while(iterator.hasNext()){
		System.out.println(iterator.next());
	}
	Iterator<String> iterator2 = set.iterator();
	while(iterator2.hasNext()){
		System.out.println(map.get(iterator2.next()));
	}
	/*for (String key : set) {
		 String value=map.get(key);
		System.out.println(key +":"+ value);
	}*/
		/*使用键值对*/
		for(Map.Entry<String,String>   me:entrySet){
			String key= me.getKey();
			String value=me.getValue();
		//	System.out.println(key+":"+value);
		}
	}

}
