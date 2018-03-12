package com.diecolcor.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.diecolor.bean.GridBean;
import com.diecolor.bean.PageBean;
import com.diecolor.bean.Record;
import com.diecolor.dao.RecordDao;
import com.diecolor.util.JSONUtils;
import com.diecolor.util.RequestUtil;
import com.diecolor.util.ResultBean;

public class RecordServlet extends HttpServlet {

	RecordDao dao = new RecordDao();
	
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String flag=request.getParameter("flag");
		if(flag==null){
			findall(request,response);
		}else if("delete".equals(flag)){
			String id = request.getParameter("id");
			int rows=dao.delete(Integer.valueOf(id));
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
			Record record=RequestUtil.getObjectRequest(request, Record.class);
			int rows=dao.updatePlus(record);
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
			Record record=RequestUtil.getObjectRequest(request, Record.class);
			int rows=dao.savePlus(record);
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

	private void findall(HttpServletRequest request, HttpServletResponse response){
		String index = request.getParameter("pageIndex");
		String size =  request.getParameter("pageSize");
		String paramname = request.getParameter("paramname");
		String sortField=request.getParameter("sortField");
		String sortOrder = request.getParameter("sortOrder");
		String paramrtype = request.getParameter("paramrtype");
		int pageIndex= 1;
		int pageSize = 10;
		if(index!=null){
			pageIndex=Integer.valueOf(index);
			pageSize=Integer.valueOf(size);
		}
		if (sortField==null) {
			sortField="rid";
		}
		if (sortOrder==null) {
			sortOrder="desc";
		}
		PageBean<Record> bean = dao.findallForpage(pageIndex, pageSize,paramname,paramrtype,sortField,sortOrder);
		GridBean<Record> grid =  new GridBean<Record>();
		grid.setData(bean.getList());//获取当前页的数据传送给前台
		grid.setItemsCount(bean.getTotalRows());//得到总记录数给前台
		JSONUtils.printJSON(response, grid);
	}

}
