package com.diecolor.dao;

import java.util.List;
import java.util.Map;

import com.diecolor.bean.Myfile;
import com.diecolor.bean.PageBean;
import com.diecolor.bean.Student;
import com.diecolor.bean.Teacher;
import com.diecolor.util.RequestUtil;

public class MyfileDao extends BaseDao<Myfile>{
	
	
	/*//查询自己所传文件
	public List<Myfile> findallMyfile(String sname){
		
		String sql = "select * from myfile where muploadname='"+sname+"' ORDER BY MID DESC";
		return this.findObjectbysql(sql, Myfile.class, null);
		
	}*/
	
	public static void main(String[] args) {
		 List<Myfile> list=	new MyfileDao().findallMyfile(2);
		 for (Myfile myfile : list) {
			System.out.println(myfile.getStudent().getSname());
		}
	}
	/*
	 * 查询自己所传文件
	 * 
	 */
	public List<Myfile> findallMyfile(Integer id){
		
		String sql = "select * from myfile inner join student on myfile.muploadnameid=student.sid where muploadnameid="+id+" ORDER BY MID DESC";
		return this.findObjectbysql(sql, Myfile.class,Student.class, null);
		
	}
		//分页查询
		public PageBean<Myfile> findallForpage(int index,int size,String paramname,String paramsclass,String sortField,String sortOrder){
			PageBean<Myfile> bean = new PageBean<Myfile>(index,size);
			StringBuffer sql = new StringBuffer();
			sql.append("select count(1) from myfile inner join student on myfile.muploadnameid=student.sid where 1=1");
			if (paramname!=null) {
				sql.append(" and student.sname like '%"+paramname+"%'");
			}
			if (paramsclass!=null) {
				sql.append(" and myfile.mclass like '%"+paramsclass+"%'");
			}
			Object object = this.queryOnlyOne(sql.toString());
			
			bean.setTotalRows(Integer.valueOf(object.toString()));
			int start = (index-1)*size;
			StringBuffer sql2 = new StringBuffer();
			sql2.append("select * from myfile inner join student on myfile.muploadnameid=student.sid where 1=1 ");
			if (paramname!=null) {
				sql2.append(" and student.sname like '%"+paramname+"%'");
			}
			if (paramsclass!=null) {
				sql2.append(" and myfile.mclass like '%"+paramsclass+"%'");
			}
			sql2.append(" order by "+sortField+" "+sortOrder+" limit "+start+","+size+" ");
			List<Myfile> list = this.findObjectbysql(sql2.toString(), Myfile.class,Student.class, null);
			bean.setList(list);
			return bean;
					
			
	}
	//删除
	public int deletefile(int id){
		String sql= "delete from myfile where mid="+id;
		return this.update(sql);
	}
	//新增
	public int savePlus(Myfile myfile){
		Map map =RequestUtil.createInsertSql(myfile);
		return update(map.get("sql").toString(), (Object[])map.get("strs"));
	}

}
