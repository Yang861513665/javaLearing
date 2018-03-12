package com.diecolcor.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.diecolor.bean.Admin;
import com.diecolor.bean.Student;
import com.diecolor.bean.Teacher;
import com.diecolor.dao.AdminDao;
import com.diecolor.dao.StudentDao;
import com.diecolor.dao.TeacherDao;
import com.diecolor.util.UtilMD5;
//import com.sun.xml.internal.messaging.saaj.util.TeeInputStream;

public class LoginServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

			doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String type=request.getParameter("type");
		String code=request.getParameter("code");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		Object codes = session.getAttribute("code");
		System.out.println(type);
		if(code.equalsIgnoreCase(codes.toString())){
			if ("admin".equals(type)) {
				AdminDao dao = new AdminDao();
				password=UtilMD5.md5(password);
				Admin admin  = new Admin(username,password);
				Admin a = dao.login(admin);
				if(a!=null){
					session.setAttribute("admin", a);
					
					out.print("ok");
				}else {
					out.print("fail");
				}
			}else if(type.equals("学生登录")){
				Student student = new Student(username,password);
				StudentDao dao = new StudentDao();
				Student s = dao.login(student);
				if(s!=null){
					session.setAttribute("student", s);
					out.print("ok");
				}else{
					out.print("fail");
				}
				
				
				
			}else if(type.equals("老师登录")){
				Teacher teacher = new Teacher(username,password);
				TeacherDao dao =new TeacherDao();
				Teacher t =dao.login(teacher);
				if(t!=null){
					session.setAttribute("teacher", t);
					out.print("ok");
				}else {
					out.print("fail");
				}
				
			}
		}else {
			out.print("codeerror");
		}
		out.flush();
		out.close();
	}

}
