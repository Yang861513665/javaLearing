package com.diecolcor.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.diecolor.bean.Admin;
import com.diecolor.bean.Teacher;
import com.diecolor.dao.AdminDao;
import com.diecolor.dao.TeacherDao;
import com.diecolor.util.JSONUtils;
import com.diecolor.util.RequestUtil;
import com.diecolor.util.ResultBean;

public class TeacherUpdateServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

			doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String tid = request.getParameter("id");
		TeacherDao dao = new TeacherDao();
		if (tid==null) {
			Teacher teacher = RequestUtil.getObjectRequest(request, Teacher.class);
			int rows=dao.updatePlus(teacher);
			ResultBean bean = new ResultBean();
			if(rows>0){
				bean.setCode("10000");
				bean.setMsg("修改成功");
				HttpSession session =request.getSession();
				session.setAttribute("teacher", teacher);
			}else {
				bean.setCode("10001");
				bean.setMsg("修改失败");
			}
			
			JSONUtils.printJSON(response, bean);
		}else {
			Teacher teacher = dao.findbyid(Integer.valueOf(tid));
			request.setAttribute("teacher", teacher);
			request.getRequestDispatcher("UpdateTeacher.jsp").forward(request, response);
		}
		
	}

}
