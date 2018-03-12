package com.diecolcor.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.diecolor.bean.Admin;
import com.diecolor.bean.GridBean;
import com.diecolor.bean.PageBean;
import com.diecolor.bean.Teacher;
import com.diecolor.dao.AdminDao;
import com.diecolor.dao.TeacherDao;
import com.diecolor.util.JSONUtils;
import com.diecolor.util.RequestUtil;
import com.diecolor.util.ResultBean;


public class QueryTeacherServlet extends HttpServlet {

	TeacherDao tdao = new TeacherDao();
	AdminDao adao  = new AdminDao();
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String flag = request.getParameter("flag");
		if(flag==null){
			findall(request, response);
		}else if("delete".equals(flag)){
			String id = request.getParameter("id");
			int rows=tdao.delete(Integer.valueOf(id));
			ResultBean bean = new ResultBean();
			if(rows>0){
				bean.setCode("10000");
				bean.setMsg("删除成功");
			}else {
				bean.setCode("10001");
				bean.setMsg("删除失败");
			}
			JSONUtils.printJSON(response, bean);
			
		}else if("update".equals(flag)){
			Teacher teacher=RequestUtil.getObjectRequest(request, Teacher.class);
			int rows=tdao.updatePlus(teacher);
			ResultBean bean = new ResultBean();
			if(rows>0){
				bean.setCode("10000");
				bean.setMsg("修改成功");
			}else {
				bean.setCode("10001");
				bean.setMsg("修改失败");
			}
			JSONUtils.printJSON(response, bean);
		}else if("save".equals(flag)){
			Teacher teacher=RequestUtil.getObjectRequest(request, Teacher.class);
			int rows=tdao.savePlus(teacher);
			ResultBean bean = new ResultBean();
			if(rows>0){
				bean.setCode("10000");
				bean.setMsg("新增成功");
			}else {
				bean.setCode("10001");
				bean.setMsg("新增失败");
			}
			JSONUtils.printJSON(response, bean);
		}
		
	}
	
	private void findall(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		
		String index = request.getParameter("pageIndex");
		String size =  request.getParameter("pageSize");
		String param = request.getParameter("param");
		String sortField=request.getParameter("sortField");
		String sortOrder=request.getParameter("sortOrder");
		
		if (sortField==null) {
			sortField="tid";
			
		}if (sortOrder==null) {
			sortOrder="desc";
		}
		
		int pageIndex= 1;
		int pageSize = 10;
		if(index!=null){
			pageIndex=Integer.valueOf(index);
			pageSize=Integer.valueOf(size);
		}
		PageBean<Teacher> bean = tdao.findallForpage(pageIndex, pageSize,param,sortField,sortOrder);
		GridBean<Teacher> grid =  new GridBean<Teacher>();
		grid.setData(bean.getList());//获取当前页的数据传送给前台
		grid.setItemsCount(bean.getTotalRows());//得到总记录数给前台
		JSONUtils.printJSON(response, grid);
	}

}
