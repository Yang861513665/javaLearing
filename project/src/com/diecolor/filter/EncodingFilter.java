package com.diecolor.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * 编码的filter
 * @author tanshuang
 *
 */
public class EncodingFilter implements Filter{
	String coding="UTF-8";
	public void init(FilterConfig arg0) throws ServletException {
		System.out.println("init");
		coding=arg0.getInitParameter("coding");
	}
	public void destroy() {
		System.out.println("destory");
	}
	public void doFilter(ServletRequest req, ServletResponse res,
			FilterChain filterChain) throws IOException, ServletException {

		req.setCharacterEncoding(coding);
		res.setCharacterEncoding(coding);
		filterChain.doFilter(req, res);
	}

}
