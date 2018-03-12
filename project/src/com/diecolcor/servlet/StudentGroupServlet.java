package com.diecolcor.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import com.diecolor.bean.Student;
import com.diecolor.dao.StudentDao;
import com.diecolor.util.JSONUtils;

public class StudentGroupServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		doPost(request, response);
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String sid = request.getParameter("sid");
		StudentDao dao = new StudentDao();
		List<Student> list= dao.findall(Integer.parseInt(sid));
		JSONUtils.printJSON(response, list);
	}

}
