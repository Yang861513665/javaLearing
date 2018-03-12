package com.diecolor.dao;

import java.util.List;
import java.util.Map;

import com.diecolor.bean.Admin;
import com.diecolor.util.RequestUtil;

public class AdminDao extends BaseDao<Admin>{
	
	public Admin login(Admin a){
		String sql = "select * from admin where aname='"+a.getAname()+"' and apassword='"+a.getApassword()+"'";
		List<Admin> list = this.findObjectbysql(sql, Admin.class, null);
		 if(list.size()>0){
			 return list.get(0);
		 }else {
			return null;
		}
	}
	public Admin findbyid(Integer id){
		String sql = "select * from admin where aid='"+id+"'";
		List<Admin> list = this.findObjectbysql(sql, Admin.class, null);
		if (list.size()>0) {
			return list.get(0);
		}else{
			return null;
		}
	}

	public int updatePlus(Admin a){
		String sql=RequestUtil.createUpdateSql(a);
		return update(sql);
	}
}
