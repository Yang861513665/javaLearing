package com.diecolcor.servlet;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import sun.net.util.URLUtil;

public class FileDownloadServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.reset();
		String filepath=request.getParameter("filename");
		String filename =filepath.substring(filepath.lastIndexOf("\\")+1,filepath.length());
		response.setContentType("application/x-msdownload");
		response.setHeader("content-disposition","attachment;filename="+new String(filename.getBytes("utf-8"),"ISO-8859-1"));
        FileInputStream fIn = null;
        OutputStream out = null;
        try {
            File file = new File(filepath);
            //读取下载文件
            fIn = new FileInputStream(file);
            //输出流
            out = response.getOutputStream();
            //缓冲区
            byte[] buffer = new byte[1024];
            int len = 0;
            while ((len = fIn.read(buffer,0,buffer.length))!=-1){
                //将缓冲区的数据输出到浏览器，实现文件下载
                out.write(buffer,0,len);
            }
            out.flush();
        }catch (FileNotFoundException fnfe){
            fnfe.printStackTrace();
        }catch (IOException ioe) {
            ioe.printStackTrace();
        }finally {
            if (fIn!=null) {
				fIn.close();
			}
            if (out!=null) {
				out.close();
			}
        }
	       
	       
	}

}
