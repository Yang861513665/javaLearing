package com.diecolcor.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.diecolor.bean.Record;
import com.diecolor.bean.Student;
import com.diecolor.dao.RecordDao;
import com.diecolor.dao.StudentDao;
import com.diecolor.util.JSONUtils;
import com.diecolor.util.ResultBean;

public class SearchStudentNameServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
			try {
				String search = req.getParameter("search");
				StudentDao dao = new StudentDao();
				List<Student> list = dao.search(search);
				ResultBean bean = new ResultBean();
				bean.setCode("10000");
				bean.setObj(list);
				JSONUtils.printJSON(resp, bean);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
	}

}
