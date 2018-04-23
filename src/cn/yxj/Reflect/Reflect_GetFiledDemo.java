package cn.yxj.Reflect;

import java.lang.reflect.Field;

public class Reflect_GetFiledDemo {

	public static void main(String[] args) throws Exception {
		
		getFiled();

	}

	private static void getFiled() throws Exception {
		String className="cn.yxj.domain.Person";
		Class<?> clazz=Class.forName(className);
		
		//获得age字段对象
	   String name="age";
		//Field field=clazz.getField(name); //获得的是公共的字段（所有的getXXX都是这样）
		Field field=clazz.getDeclaredField(name); //只要声明了就能获得，同上
		//System.out.println(field);
		
		//对其进行值的设置，必须现有对象
		Object obj=clazz.newInstance();
		//通过查找父类AccessiableObject的方法。 setAccessiable(true)
		field.setAccessible(true); //取消java语言的权限检查(暴力访问)
		
		field.set(obj, 30); //IllegalAccessException:age字段是私有的
		System.out.println(field.get(obj)); //30
		System.out.println(obj);
		
	}

}
