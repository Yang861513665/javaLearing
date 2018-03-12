package com.diecolor.util;

import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;



public class RequestUtil {
	
	public static<T> T getObjectRequest(HttpServletRequest request,Class<T> class1){
		Enumeration enumeration=request.getParameterNames();
		Field [] fields = class1.getDeclaredFields();
		T user=null;
		try {
			 user= class1.newInstance();
			while(enumeration.hasMoreElements()){
				Object object=enumeration.nextElement();
				if (object instanceof java.util.Date) {
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
					object=sdf.format(object);
				}
				String value = request.getParameter(object.toString());
				for (Field field : fields) {
					String name = field.getName();
					//判断是否相同
					if(name.equals(object.toString())){
						field.setAccessible(true);
						setValues(field, value, user);
						
						break;
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}
	/**
	 * 根据对象动态添加数据
	 * @param u
	 * @return
	 */
	
	public static<T> Map  createInsertSql(T u){
		Map map = new HashMap();
		Class class1 = u.getClass();
		String className = class1.getName().substring(class1.getName().lastIndexOf(".")+1);//得到pojo 的名字
		
		
		Field [] fields = class1.getDeclaredFields();//得到class中所有的属性
		StringBuffer sb = new StringBuffer();
		sb.append("insert into "+className+"(");
		int fieldNum=0;
		List list = new ArrayList();
		try {
			for (Field field : fields) {
					field.setAccessible(true);
					Object object= field.get(u);//得到属性 的值
					if(object!=null){
						String fieldName = field.getName();
						sb.append(fieldName+",");
						fieldNum++;
						if(object instanceof Date){
							SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
							
							list.add(sdf.format(object));
						}else {
							
							list.add(object);
						}
					}
				
			}
			String temp=sb.toString().substring(0,sb.length()-1);
			temp+=") values(";
			StringBuffer sql = new StringBuffer(temp);
			for (int i = 0; i < fieldNum; i++) {
				sql.append("?,");
			}
			temp=sql.toString();
			temp=temp.substring(0,sql.toString().lastIndexOf(","));
			temp+=")";
			Object [] strs = list.toArray();
			
			map.put("sql", temp);
			map.put("strs", strs);
			
			
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		
		return map;
	}
	
	/**
	 * 动态修改数据的SQL语句
	 * @param t
	 * @return
	 */
	public static<T> String createUpdateSql(T t){
		
		Class class1 = t.getClass();//得到对象的class文件
		String className=class1.getName().substring(class1.getName().lastIndexOf(".")+1);
		Field [] fields=class1.getDeclaredFields();
		StringBuffer sb = new StringBuffer();
		sb.append("update "+className+" set ");
		int id=0;
		try {
			for (Field field : fields) {
				field.setAccessible(true);
				id = (Integer) fields[0].get(t);
				Object object = field.get(t);//得到属性的值
				
				if (object!=null) {
					String fieldName = field.getName();//得到字段名
					if(object instanceof Integer||object instanceof Double||object instanceof Float){
						
						sb.append(fieldName+"="+object.toString()+",");
					}else if(object instanceof java.util.Date) {
						SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd");
						String dates = sdf.format(object);
						sb.append(fieldName+"='"+dates+"',");
					}
					
					else {
						sb.append(fieldName+"='"+object.toString()+"',");
					}
					
				}
			}
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		String temp =sb.toString().substring(0,sb.toString().length()-1);
		temp =temp+" where "+fields[0].getName()+"="+id;
		return temp.toString();
		
	}
	
	
	private static <T>  void setValues(Field field, Object object, T t) {
		String typeName = field.getType().getName();

		try {
			if (typeName.equals("int")) {
				field.set(t, Integer.valueOf(object.toString()));
			}else if (typeName.equals("double")) {
				field.set(t, Double.valueOf(object.toString()).doubleValue());
			}else if(typeName.equals("long")){
				field.set(t, Long.valueOf(object.toString()).longValue());
			}else if (typeName.equals("boolean")) {
				field.set(t, Boolean.valueOf(object.toString()));
			}else if(typeName.equals("byte")){
				field.set(t, Byte.valueOf(object.toString()));
			}else if (typeName.equals("short")) {
				field.set(t, Short.valueOf(object.toString()));
			}else if(typeName.equals("char")){
				field.set(t, Character.valueOf((Character)object));
			}else if (typeName.equals("float")) {
				field.set(t, Float.valueOf(object.toString()).floatValue());
			}else if (typeName.equals("java.lang.Integer")) {
				field.set(t, Integer.valueOf(object.toString()));
			}else if (typeName.equals("java.util.Date")) {
				
				SimpleDateFormat[] sdf = new SimpleDateFormat[]{
						
						new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"),
						new SimpleDateFormat("yyyy-MM-dd"),
						new SimpleDateFormat("MM/dd/yyyy"),
						new SimpleDateFormat("MM/dd/yyyy HH:mm:ss"),
						
				};
				Date date = null;
				for (SimpleDateFormat simpleDateFormat : sdf) {
					try {
						
						date = simpleDateFormat.parse(object.toString());
					} catch (Exception e) {
						continue;
					}
				}
				field.set(t, date);
				
			}else {
				
				field.set(t, object);
			}
		} catch (Exception e) {
			e.printStackTrace();

		}
	}

}
