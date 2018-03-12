package com.diecolor.util;

import java.io.File;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;



import com.diecolor.dao.StudentDao;


public class PoiReadExcel {

	public static int insertSql(String path, String filename) {
		int totalnum=0;
		StudentDao dao = new StudentDao();
		try {
			//创建workbook
			Workbook workbook = Workbook.getWorkbook(new File(path+"\\"+filename));
			//获取第一个工作表sheet
			Sheet sheet = workbook.getSheet(0);
			//获取数据
			System.out.println(sheet.getRows());
			for (int i = 2; i < sheet.getRows(); i++) {
				String sql = "insert into student(sname,spassword,ssex,stelephone,sclass,sgroup,proname,cteacher) values(";
				
				
				for (int j = 0; j < sheet.getColumns(); j++) {
					Cell cell = sheet.getCell(j,i);
					//System.out.print(cell.getContents() + "  ");
					if ("".equals(cell.getContents())) {
						return totalnum;
					}
					sql=sql+"'"+cell.getContents()+"',";
				}
				totalnum++;
				sql=sql.substring(0, sql.length()-1)+")";
				dao.update(sql);
				System.out.println(sql);
			}
			workbook.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return totalnum;
		
	}
}
