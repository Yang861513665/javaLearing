package com.diecolcor.servlet;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.diecolor.bean.Student;
import com.diecolor.dao.StudentDao;
import com.diecolor.util.PoiWriteExcel;

public class ExcelDownloadServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String sclass=request.getParameter("sclass");
		//进行一次编码
		StudentDao dao = new StudentDao();
		try {
			
			List<Student> list = dao.selectsclass(sclass);
			if ("".equals(sclass)) {
				sclass="全部班级数据";
			}
			//先将数据生成到服务器上面，再给用户下载
			PoiWriteExcel.writerExcel(list, request, sclass);
			//给用户下载
			Thread.sleep(100);//睡眠100毫秒，防止电脑卡住，数据未完成生成就开始下载
			filedownload(response, request, sclass);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
	public void filedownload(HttpServletResponse response,HttpServletRequest request,String filename) throws IOException{
		filename=filename+".xls";
		response.reset();
		response.setContentType("application/x-msdownload");
		response.setHeader("content-disposition","attachment;filename="+new String(filename.getBytes("utf-8"),"ISO-8859-1"));
        FileInputStream fIn = null;
        OutputStream out = null;
	        try {
        
        	//文件路径
        	String filepath = request.getSession().getServletContext().getRealPath("temp")+"\\"+filename;
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
