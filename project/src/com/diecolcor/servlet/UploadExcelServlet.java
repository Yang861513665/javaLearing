package com.diecolcor.servlet;



import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.diecolor.util.JSONUtils;
import com.diecolor.util.PoiReadExcel;
import com.diecolor.util.ResultBean;




public class UploadExcelServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			doPost(request, response);
	
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		DiskFileItemFactory itemFactory = new DiskFileItemFactory();
		//设置缓冲大小  可以不用设，选择默认
		//itemFactory.setSizeThreshold(1000);
		//设置临时存储的位置，不设置时存在项目的根目录
		String pathname = request.getSession().getServletContext().getRealPath("temp");
		String excel = request.getSession().getServletContext().getRealPath("excel");
		File file = new File(pathname);
		itemFactory.setRepository(file);
		ResultBean bean = new ResultBean();
		 
		ServletFileUpload fileUpload = new ServletFileUpload(itemFactory);
		try {
			
			List<FileItem> list =fileUpload.parseRequest(request);
			for (FileItem item : list) {
				if(!item.isFormField()){
					
					String fileName=item.getName().substring(item.getName().lastIndexOf("\\")+1);
					try {
						item.write(new File(excel,fileName));
						int totalnum=PoiReadExcel.insertSql(excel, fileName);
						bean.setCode("10000");
						bean.setMsg("上传成功");
						bean.setObj(totalnum);
						JSONUtils.printJSON(response, bean);
					} catch (Exception e) {
						e.printStackTrace();
						bean.setCode("10001");
						bean.setMsg("上传异常");
						JSONUtils.printJSON(response, bean);
					}
				
				}
			}
		
		
		} catch (FileUploadException e) {
			e.printStackTrace();
		}
    }
 

}
