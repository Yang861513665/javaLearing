package com.diecolor.dao;

import java.util.List;
import java.util.Map;

import com.diecolor.bean.Admin;
import com.diecolor.bean.PageBean;
import com.diecolor.bean.Record;
import com.diecolor.bean.Student;
import com.diecolor.bean.Teacher;
import com.diecolor.util.RequestUtil;


public class StudentDao extends BaseDao<Student>{
	//分页查询
		public PageBean<Student> findallForpage(int index,int size,String paramname,String sortField,String sortOrder,String paramsclass,String paramsgroup){
			PageBean<Student> bean = new PageBean<Student>(index,size);
			StringBuffer sql =new StringBuffer();
			sql.append("select count(1) from student where 1=1");
			if (paramname!=null) {
				sql.append(" and sname like '%"+paramname+"%'");
			}
			if (paramsclass!=null) {
				sql.append(" and sclass like '%"+paramsclass+"%'");
			}
			if (paramsgroup!=null) {
				sql.append(" and sgroup like '%"+paramsgroup+"%'");
			}
			
			Object object = this.queryOnlyOne(sql.toString());
			bean.setTotalRows(Integer.valueOf(object.toString()));
			int start = (index-1)*size;
			StringBuffer sql2 = new StringBuffer();
			sql2.append("select * from student where 1=1");
			if (paramname!=null) {
				sql2.append(" and sname like '%"+paramname+"%' ");
			}
			if (paramsclass!=null) {
				sql2.append(" and sclass like '%"+paramsclass+"%' ");
			}
			if (paramsgroup!=null) {
				sql2.append(" and sgroup like '%"+paramsgroup+"%' ");
			}
			
			sql2.append(" order by "+sortField+" "+sortOrder+" limit "+start+","+size+"");
			List<Student> list = this.findObjectbysql(sql2.toString(), Student.class, null);
			bean.setList(list);
			return bean;
					
			
		}

		//学生登录
		public Student login(Student s){
			String sql = "select * from student where sname='"+s.getSname()+"' and spassword='"+s.getSpassword()+"'";
			List<Student> list = this.findObjectbysql(sql, Student.class, null);
			 if(list.size()>0){
				 return list.get(0);
			 }else {
				return null;
			}
		}
		//删除
		public int delete(Integer id){
			String sql = "delete from student where sid="+id;
			return this.update(sql);
		}
		//修改方法
		public int updatePlus(Student s){
			String sql=RequestUtil.createUpdateSql(s);
			return update(sql);
		}
		//新增
		public int savePlus(Student s){
			Map map = RequestUtil.createInsertSql(s);
			return update(map.get("sql").toString(), (Object[])map.get("strs"));
		}
		//查询自己的信息
		public List<Student> findall(int sid){
			String sql = "select * from student where sid="+sid;
			return this.findObjectbysql(sql, Student.class, null);
		}
		//添加 违规记录时查询学生的方法
		public List<Student> search(String search){
			StringBuffer sql = new StringBuffer();
			sql.append("select * from student ");
			if (search!=null) {
				sql.append(" where sclass like '%"+search+"%' or sname like '%"+search+"%'");
			}
			System.out.println(sql);
			return this.findObjectbysql(sql.toString(), Student.class, null);
		}
		//分班级查询数据，并导出Excel
		public List<Student> selectsclass(String sclass){
			String sql="";
			if ("".equals(sclass)) {
				sql="select * from student";
			}else {
				sql="select * from student where sclass='"+sclass+"'";
			}
			return this.findObjectbysql(sql, Student.class, null);
		}
}
