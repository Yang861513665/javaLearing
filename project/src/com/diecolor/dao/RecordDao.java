package com.diecolor.dao;

import java.util.List;
import java.util.Map;

import com.diecolor.bean.PageBean;
import com.diecolor.bean.Record;
import com.diecolor.bean.Student;
import com.diecolor.util.RequestUtil;

public class RecordDao extends BaseDao<Record>{
	
	//分页查询
		public PageBean<Record> findallForpage(int index,int size,String paramname,String paramrtype,String sortField,String sortOrder){
			PageBean<Record> bean = new PageBean<Record>(index,size);
			StringBuffer sql = new StringBuffer();
			sql.append("select count(1) from Record inner join student on record.recorderid=student.sid where 1=1");
			if (paramname!=null) {
				sql.append(" and student.sname like '%"+paramname+"%'");
			}
			if (paramrtype!=null) {
				sql.append(" and record.rtype like '%"+paramrtype+"%'");
			}
			Object object = this.queryOnlyOne(sql.toString());
			bean.setTotalRows(Integer.valueOf(object.toString()));
			int start = (index-1)*size;
			StringBuffer sql2 = new StringBuffer();
			sql2.append("select * from Record inner join student on record.recorderid=student.sid where 1=1" );
			if (paramname!=null) {
				sql2.append(" and student.sname like '%"+paramname+"%'");
			}
			if (paramrtype!=null) {
				sql2.append(" and record.rtype like '%"+paramrtype+"%'");
			}
			sql2.append(" order by "+sortField+" "+sortOrder+" limit "+start+","+size+"");
			List<Record> list = this.findObjectbysql(sql2.toString(), Record.class,Student.class, null);
			bean.setList(list);
			return bean;
					
			
		}

		
		//删除
		public int delete(Integer id){
			String sql = "delete from Record where rid="+id;
			return this.update(sql);
		}
		//修改方法
		public int updatePlus(Record r){
			String sql=RequestUtil.createUpdateSql(r);
			return update(sql);
		}
		//新增
		public int savePlus(Record r){
			Map map = RequestUtil.createInsertSql(r);
			return update(map.get("sql").toString(), (Object[])map.get("strs"));
		}
		/*//查询自己的违规记录
		public List<Record> findRecordall(String sname){
			String sql = "select * from record where recorder='"+sname+"'";
			return this.findObjectbysql(sql, Record.class, null);
		}*/
		//查询自己的违规记录
		public List<Record> findRecordall(int sid){
			String sql = "select * from record inner join student on record.recorderid=student.sid where recorderid="+sid;
			return this.findObjectbysql(sql, Record.class,Student.class, null);
		}
		

}
