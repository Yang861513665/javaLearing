package com.diecolor.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.diecolor.bean.Student;

public class PoiWriteExcel {

	/**
	 * @param args
	 */
	public static void writerExcel(List<Student> list,HttpServletRequest request,String filename){
		String title[] ={"序号","姓名","密码","性别","联系电话","实训成绩","班级","小组","实训项目名称","指导老师"};//利用数据创建表头
		
		
		//创建Excel工作簿
		HSSFWorkbook workbook = new HSSFWorkbook();
		//创建一个工作表sheet
		HSSFSheet sheet = workbook.createSheet();
		//创建一个样式
		HSSFCellStyle setBorder = workbook.createCellStyle();
		//创建第一行
		HSSFRow row = sheet.createRow(0);
		HSSFCell cell = null;
		//设置字体大小
		HSSFFont font =workbook.createFont();
		font.setFontHeightInPoints((short)20);
		//插入第一行数据，ID，name,sex
		for (int i = 0; i < title.length; i++) {
			//设置行高
			row.setHeight((short) 450);
			setBorder.setFont(font);
			//设置列宽
			sheet.setColumnWidth(i, 4500);
			cell=row.createCell(i);
			cell.setCellValue(title[i]);
			
		}
		//追加数据
		for (int i = 0; i <list.size(); i++) {
			
			
			HSSFRow nextRow=sheet.createRow(i+1);
			setBorder.setFont(font);
			//设置行高
			nextRow.setHeight((short) 450);
			//第一列
			HSSFCell cell2 = nextRow.createCell(0);
			cell2.setCellValue(i+1);
			//第二列
			cell2=nextRow.createCell(1);
			cell2.setCellValue(list.get(i).getSname());
			//第三列
			cell2=nextRow.createCell(2);
			cell2.setCellValue(list.get(i).getSpassword());
			//第四列
			cell2 = nextRow.createCell(3);
			cell2.setCellValue(list.get(i).getSsex());
			//第五列
			cell2=nextRow.createCell(4);
			cell2.setCellValue(list.get(i).getStelephone());
			//第六列
			cell2=nextRow.createCell(5);
			cell2.setCellValue(list.get(i).getSgrade());
			//第七列
			cell2 = nextRow.createCell(6);
			cell2.setCellValue(list.get(i).getSclass());
			//第八列
			cell2=nextRow.createCell(7);
			cell2.setCellValue(list.get(i).getSgroup());
			//第九列
			cell2=nextRow.createCell(8);
			cell2.setCellValue(list.get(i).getProname());
			//第十列
			cell2=nextRow.createCell(9);
			cell2.setCellValue(list.get(i).getCteacher());
		}
		//创建一个文件
		String filepath = request.getSession().getServletContext().getRealPath("temp");
		File file = new File(filepath+"\\"+filename+".xls");
		try {
			file.createNewFile();
			FileOutputStream stream = FileUtils.openOutputStream(file);
			workbook.write(stream);
			stream.close();
			workbook.close();
			stream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
		}

	}

}
