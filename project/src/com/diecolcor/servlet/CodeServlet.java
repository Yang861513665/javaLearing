package com.diecolcor.servlet;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.diecolor.util.AuthCode;

public class CodeServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String code = AuthCode.getCodeStr(4);
		BufferedImage bi = AuthCode.getImage(code);
		request.getSession().setAttribute("code", code);
		//resp.getOutputStream();//response输出流
		ImageIO.write(bi, "JPG", response.getOutputStream());
	}

}
