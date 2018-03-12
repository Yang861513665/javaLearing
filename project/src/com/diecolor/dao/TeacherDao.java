package com.diecolor.dao;

import java.util.List;
import java.util.Map;

import com.diecolor.bean.PageBean;
import com.diecolor.bean.Student;
import com.diecolor.bean.Teacher;
import com.diecolor.util.RequestUtil;
//import com.sun.org.apache.regexp.internal.recompile;

public class TeacherDao extends BaseDao<Teacher> {
	
	//分页查询
	public PageBean<Teacher> findallForpage(int index,int size,String param,String sortField ,String sortOrder){
		PageBean<Teacher> bean = new PageBean<Teacher>(index,size);
		String sql ="select count(1) from teacher";
		if (param!=null) {
			sql="select count(1) from teacher where tname like'%"+param+"%'";
		}
		Object object = this.queryOnlyOne(sql);
		
		bean.setTotalRows(Integer.valueOf(object.toString()));
		int start = (index-1)*size;
		String sql2 ="select * from teacher  order by "+sortField+" "+sortOrder+" limit "+start+","+size+"";
		if (param!=null) {
			
			sql2="select * from teacher where tname like'%"+param+"%' order by "+sortField+" "+sortOrder+" limit "+start+","+size+"";
		}
		List<Teacher> list = this.findObjectbysql(sql2, Teacher.class, null);
		bean.setList(list);
		return bean;
				
		
	}
	//老师登录
	public Teacher login(Teacher t){
		String sql = "select * from teacher where tname='"+t.getTname()+"' and tpassword='"+t.getTpassword()+"'";
		List<Teacher> list = this.findObjectbysql(sql, Teacher.class, null);
		 if(list.size()>0){
			 return list.get(0);
		 }else {
			return null;
		}
	}
	//教师信息查询
	public Teacher findbyid(Integer id){
		String sql = "select * from teacher where tid="+id;
		List<Teacher> list = this.findObjectbysql(sql, Teacher.class, null);
		 if(list.size()>0){
			 return list.get(0);
		 }else {
			return null;
		}
	}
		
	//删除
	public int delete(Integer id){
		String sql = "delete from teacher where tid="+id;
		return this.update(sql);
	}
	//修改方法
	public int updatePlus(Teacher t){
		String sql=RequestUtil.createUpdateSql(t);
		return update(sql);
	}
	//新增
	public int savePlus(Teacher t){
		Map map = RequestUtil.createInsertSql(t);
		return update(map.get("sql").toString(), (Object[])map.get("strs"));
	}

}
