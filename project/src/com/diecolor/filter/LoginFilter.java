package com.diecolor.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginFilter implements Filter{

	public void init(FilterConfig arg0) throws ServletException {
		
	}
	public void destroy() {
		
	}
	public void doFilter(ServletRequest arg0, ServletResponse arg1,
			FilterChain arg2) throws IOException, ServletException {

		//获取session
				HttpServletRequest request = (HttpServletRequest)arg0;
				HttpServletResponse response = (HttpServletResponse)arg1;
				
				String urlPath=request.getRequestURI();//获取请求的路径
				if(urlPath.endsWith("Login.jsp")||urlPath.endsWith("login")||urlPath.endsWith("querystudent")||urlPath.endsWith("querystudent?flag=save")||urlPath.endsWith("upload.jsp")){
					//去登录界面，不拦截
					
					arg2.doFilter(arg0, arg1);
					return;
				}
				
				HttpSession session = request.getSession();
				Object obj = session.getAttribute("admin");
				if (obj==null) {//没有登录，跳转至login页面
					String path = request.getContextPath();
					String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
					//System.out.println(basePath+"admin/Login.jsp");
					response.sendRedirect(basePath+"admin/Login.jsp");
				}else{
					//登录过了，请继续
					arg2.doFilter(arg0, arg1);
				}
				
				
				
		
		
		
		
		
		
		
	
	
	}
}
