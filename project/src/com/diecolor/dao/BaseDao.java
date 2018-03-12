package com.diecolor.dao;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import com.diecolor.util.ReadProperties;
//import com.sun.org.apache.bcel.internal.util.Class2HTML;

public class BaseDao<T> {
	ResultSet rs = null;
	PreparedStatement pstm = null;
	Connection con = null;
	ReadProperties rp = ReadProperties.instance();
	
	
	//连接数据库
	public Connection getConnection(){
		try {
			Class.forName(rp.DBDRIVER);
			con=DriverManager.getConnection(rp.DBURL,rp.USERNAME,rp.PASSWORD);
//			System.out.println("数据库连接成功");
			return con;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	/*
	 * 查询SQL 的方法
	 */
	public ResultSet quary(String sql, Object... object) {

		if (getConnection() == null) {
			return null;
		}
		try {
			pstm = con.prepareStatement(sql);
			if (object!=null) {
				int i=1;
				for (Object object2 : object) {
					pstm.setObject(i, object2);
					i++;
				}
			}
			rs = pstm.executeQuery();
			return rs;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;

	}

	/*
	 * 更新的方法
	 */
	public int update(String sql) {
		if (getConnection() == null) {
			return -1;
		}
		try {
			pstm = con.prepareStatement(sql);
			return pstm.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return -1;
	}
	
	/**
	 * 带参数的更新方法
	 * @param sql
	 * @param objects
	 * @return
	 */
	public int update(String sql,Object...objects) {
		if (getConnection() == null) {
			return -1;
		}
		try {
			pstm = con.prepareStatement(sql);
			if (objects!=null) {
				for (int i = 0; i < objects.length; i++) {
					pstm.setObject(i+1, objects[i]);
				}
			}
			return pstm.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return -1;
	}

	/**
	 * 查询一行一列
	 */
	public Object queryOnlyOne(String sql) {
		if (getConnection() == null) {
			return null;
		}
		Object obj = null;
		ResultSet rs = null;
		try {
			pstm = con.prepareStatement(sql);
			rs = pstm.executeQuery();
			if (rs.next()) {
				obj = rs.getObject(1);
			}
			return obj;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
					close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return null;
	}
	/**
	 * 利用反射得到表中所有字段的值
	 * @param sql
	 * @param class1
	 * @param objects
	 * @return
	 */
	
	public List<T> findObjectbysql(String sql,Class<T> class1, Object...objects) {
		List<T> list = new ArrayList<T>();
		ResultSet rs = this.quary(sql, objects);
		try {
			Field fields[] = class1.getDeclaredFields();//得到pojo中所有的属性
			while(rs.next()){
				T t = class1.newInstance();
				for (Field field : fields) {
					String name = field.getName();//得到属性名
					Object value = rs.getObject(name);//得到指针那一列中对应字段的值
					field.setAccessible(true);//设置field中私有属性可以访问
					//field.set(t, value);//相当于t.setId(value);
					setValues(field, value, t);
				}
				list.add(t);
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if (rs!=null) {
				try {
					rs.close();
					close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
		
		return list;
	}
	
	
	
	public List<T> findObjectbysql(String sql,Class<T> class1, Class class2,Object...objects) {
		List<T> list = new ArrayList<T>();
		ResultSet rs = this.quary(sql, objects);
		try {
			Field fields[] = class1.getDeclaredFields();//得到pojo中所有的属性
			while(rs.next()){
				T t = class1.newInstance();
				Object obj=class2.newInstance();
				Field objfields[]=class2.getDeclaredFields();
				for (Field field : fields) {
					if(field.getType().equals(class2))
					{
						for (Field fd : objfields) {
							String name = fd.getName();//得到属性名
							Object value = rs.getObject(name);//得到指针那一列中对应字段的值
							fd.setAccessible(true);//设置field中私有属性可以访问
							//field.set(t, value);//相当于t.setId(value);
							setValues(fd, value, obj);
						}
						field.setAccessible(true);
						setValues(field, obj, t);
					}
					else {
						String name = field.getName();//得到属性名
						Object value = rs.getObject(name);//得到指针那一列中对应字段的值
						field.setAccessible(true);//设置field中私有属性可以访问
						//field.set(t, value);//相当于t.setId(value);
						setValues(field, value, t);
					}
				}
				
				list.add(t);
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if (rs!=null) {
				try {
					rs.close();
					close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
		
		return list;
	}
	/**
	 * 判断具体的类型，将值放入集合中
	 * @param field
	 * @param object
	 * @param t
	 */
	
	private void setValues(Field field, Object object, Object t) {
		String typeName = field.getType().getName();

		try {
			if (typeName.equals("int")) {
				field.set(t, Integer.valueOf(object.toString()));
			}else if (typeName.equals("double")) {
				field.setDouble(t, Double.valueOf(object.toString()).doubleValue());
			}else if(typeName.equals("long")){
				field.setLong(t, Long.valueOf(object.toString()).longValue());
			}else if (typeName.equals("boolean")) {
				field.setBoolean(t, Boolean.valueOf(object.toString()));
			}else if(typeName.equals("byte")){
				field.setByte(t, Byte.valueOf(object.toString()));
			}else if (typeName.equals("short")) {
				field.setShort(t, Short.valueOf(object.toString()));
			}else if(typeName.equals("char")){
				field.setChar(t, Character.valueOf((Character)object));
			}else if (typeName.equals("float")) {
				field.setFloat(t, Float.valueOf(object.toString()).floatValue());
			}else {
				field.set(t, object);
			}
		} catch (Exception e) {
			e.printStackTrace();

		}
	}
	
	
	
	
	
	
	// �ر����ķ���
		public void close() {
			if (pstm != null) {
				try {
					pstm.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
}
