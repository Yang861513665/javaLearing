package com.diecolcor.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.diecolor.bean.Admin;
import com.diecolor.dao.AdminDao;
import com.diecolor.util.JSONUtils;
import com.diecolor.util.RequestUtil;
import com.diecolor.util.ResultBean;

public class AdminUpdateServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			
		doPost(request, response);
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		AdminDao dao = new AdminDao();
		String aid = request.getParameter("id");
		if (aid==null) {
			Admin admin = RequestUtil.getObjectRequest(request, Admin.class);
			int rows=dao.updatePlus(admin);
			ResultBean bean = new ResultBean();
			if(rows>0){
				bean.setCode("10000");
				bean.setMsg("修改成功");
				HttpSession session =request.getSession();
				session.setAttribute("admin", admin);
			}else {
				bean.setCode("10001");
				bean.setMsg("修改失败");
			}
			
			JSONUtils.printJSON(response, bean);
		}else {
			
			Admin admin = dao.findbyid(Integer.valueOf(aid));
			request.setAttribute("admin", admin);
			request.getRequestDispatcher("UpdateAdmin.jsp").forward(request, response);
		}
		

	
	}

}
