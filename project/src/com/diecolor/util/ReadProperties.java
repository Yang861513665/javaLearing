package com.diecolor.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ReadProperties {
	
	private static ReadProperties properties;
	public String DBURL;
	public String USERNAME;
	public String PASSWORD;
	public String DBDRIVER;
	public String DBTYPE;
	public String MYSQLPATH;
	public String ftpurl;
	public String sqlfilepath;
	public String ftpusername;
	public String ftppassword;
	public String ftpport;
	
	
	private  ReadProperties() {
		loadProperties();
		
	}
	
	public static synchronized ReadProperties instance(){
		if (properties==null) {
			properties = new ReadProperties();
		}
		return properties;
	}
	
	
	public void loadProperties(){
		InputStream is = getClass().getResourceAsStream("/db.properties");//读取配置文件
		Properties properties = new Properties();//初始化property对象
		try {
			properties.load(is);
			DBDRIVER=properties.getProperty("dbdriver");
			DBURL=properties.getProperty("url");
			USERNAME=properties.getProperty("username");
			PASSWORD=properties.getProperty("password");
			DBTYPE=properties.getProperty("dbtype");
			MYSQLPATH=properties.getProperty("mysqlPath");
			ftpurl=properties.getProperty("ftp.url");
			sqlfilepath=properties.getProperty("sqlfilepath");
			ftpusername=properties.getProperty("ftp.username");
			ftppassword=properties.getProperty("ftp.password");
			ftpport=properties.getProperty("ftp.port");
			
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			if (is!=null) {
				try {
					is.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
		
		
		
		
		
	}

}
