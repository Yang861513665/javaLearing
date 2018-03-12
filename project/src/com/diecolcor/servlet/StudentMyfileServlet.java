package com.diecolcor.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.diecolor.bean.Myfile;
import com.diecolor.bean.Student;
import com.diecolor.dao.MyfileDao;
import com.diecolor.util.JSONUtils;
import com.diecolor.util.RequestUtil;
import com.diecolor.util.ResultBean;

public class StudentMyfileServlet extends HttpServlet {

	MyfileDao dao = new MyfileDao();
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			
		doPost(request, response);
		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String flag = request.getParameter("flag");
		if (flag==null) {
			
			findall(request, response);
		}else if("delete".equals(flag)){
			String id = request.getParameter("id");
			int rows=dao.deletefile(Integer.valueOf(id));
			ResultBean bean = new ResultBean();
			if(rows>0){
				bean.setCode("10000");
				bean.setMsg("删除成功");
			}else {
				bean.setCode("10001");
				bean.setMsg("删除失败");
			}
			JSONUtils.printJSON(response, bean);
		}else if("save".equals(flag)){
			Myfile myfile =RequestUtil.getObjectRequest(request, Myfile.class);
			int rows=dao.savePlus(myfile);
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


	private void findall(HttpServletRequest request,
			HttpServletResponse response) {
		Student student  = (Student)request.getSession().getAttribute("student");
		Integer id = student.getSid();
		
		List<Myfile> list = dao.findallMyfile(id);
		JSONUtils.printJSON(response, list);
	}

}
