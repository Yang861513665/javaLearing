package com.diecolcor.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//import sun.print.resources.serviceui;

import com.diecolor.bean.Student;
import com.diecolor.dao.StudentDao;
import com.diecolor.util.JSONUtils;
import com.diecolor.util.RequestUtil;
import com.diecolor.util.ResultBean;

public class StudentUpdateServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String sid = (String)request.getParameter("id");
		StudentDao dao = new StudentDao();
		if (sid==null) {
			Student student=RequestUtil.getObjectRequest(request, Student.class);
			int rows=dao.updatePlus(student);
			ResultBean bean = new ResultBean();
			if(rows>0){
				bean.setCode("10000");
				bean.setMsg("修改成功");
				HttpSession session =request.getSession();
				Student oldstudent=(Student)session.getAttribute("student");
				student.setSclass(oldstudent.getSclass());
				session.setAttribute("student", student);
			}else {
				bean.setCode("10001");
				bean.setMsg("修改失败");
				
			}
			JSONUtils.printJSON(response, bean);
		}else{
			List<Student> list = dao.findall(Integer.valueOf(sid));
			request.setAttribute("student", list.get(0));
			request.getRequestDispatcher("UpdateStudent.jsp").forward(request, response);
			
		}
		
		
	}

}
