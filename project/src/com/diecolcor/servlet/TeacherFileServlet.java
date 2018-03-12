package com.diecolcor.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.diecolor.bean.GridBean;
import com.diecolor.bean.Myfile;
import com.diecolor.bean.PageBean;
import com.diecolor.dao.MyfileDao;
import com.diecolor.util.JSONUtils;

public class TeacherFileServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
String flag = request.getParameter("flag");
		
		if (flag == null) {

			findall(request, response);
		}

	}

	private void findall(HttpServletRequest request,
			HttpServletResponse response) {
		String pageIndex = request.getParameter("pageIndex");
		String pagesize = request.getParameter("pageSize");
		String paramname = request.getParameter("paramname");
		String paramsclass = request.getParameter("paramsclass");
		String sortField = request.getParameter("sortField");
		String sortOrder = request.getParameter("sortOrder");
		int index = 1;
		int size=10;
		MyfileDao dao = new MyfileDao();
		if(pageIndex!=null){
			index=Integer.valueOf(pageIndex);
			size=Integer.valueOf(pagesize);
		}
		if (sortField==null) {
			sortField="mid";
		}
		if (sortOrder==null) {
			sortOrder="desc";
		}
			
		PageBean<Myfile> bean = dao.findallForpage(index, size,paramname,paramsclass,sortField,sortOrder);
		GridBean<Myfile> grid =  new GridBean<Myfile>();
		grid.setData(bean.getList());//获取当前页的数据传送给前台
		grid.setItemsCount(bean.getTotalRows());//得到总记录数给前台
		JSONUtils.printJSON(response, grid);
	}

}