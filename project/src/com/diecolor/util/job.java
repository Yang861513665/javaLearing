package com.diecolor.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.io.IOUtils;
import org.apache.commons.net.ftp.FTPClient;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class job implements Job {
	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		/*
		 * Date date=new Date(); SimpleDateFormat sf = new
		 * SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		 * System.out.println("Time:"+sf.format(date));
		 * System.out.println("Hello");
		 */
		try {
			ReadProperties rp = ReadProperties.instance();
			InputStream in = null;
			InputStreamReader isr = null;
			BufferedReader br = null;
			FileOutputStream fout = null;
			OutputStreamWriter writer = null;
			try {
				Runtime rt = Runtime.getRuntime();
				// 调用mysql的安装目录的命令
				System.out.println("---------数据库开始备份----------");
				String filename=rp.MYSQLPATH+"project.sql";
				System.out.println(filename);
				Process process = rt.exec(filename);
				// 设置导出编码为utf-8。这里必须是utf-8
				in = process.getInputStream();// 控制台的输出信息作为输入流
				ErrorStreamThread errStream = new ErrorStreamThread(
						process.getErrorStream()); // 错误流另开线程，不然会阻塞
				errStream.start();
				System.out.println("---------数据库备份完成----------");
				
				try {
					//线程睡眠5秒后把备份好的sql上传至ftp
					Thread.sleep(5000);
					File file = new File(rp.sqlfilepath+"project.sql");
					upload(rp.ftpurl, rp.ftpusername, Integer.valueOf(rp.ftpport), rp.ftppassword, file);
				} catch (Exception e) {
					e.printStackTrace();
				}
				

			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					if (writer != null) {
						writer.close();
					}
					if (fout != null) {
						fout.close();
					}
					if (br != null) {
						br.close();
					}
					if (isr != null) {
						isr.close();
					}
					if (in != null) {
						in.close();
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		} catch (Exception e) {
			System.out.println("-------------解析信息发生异常--------------");
		}
	}
	
	//上传ftp
	public  boolean upload(String ftpUrl,String userName,int port,
			String password,File srcFile) throws IOException {
			FTPClient ftpClient = new FTPClient();
			FileInputStream fis = null;
			boolean result = false;
			try {
			ftpClient.connect(ftpUrl,port);
			ftpClient.login(userName, password);
			ftpClient.enterLocalPassiveMode();
			
			fis = new FileInputStream(srcFile);
			// 设置上传目录
			//ftpClient.changeWorkingDirectory(directory);
			ftpClient.setBufferSize(1024);
			ftpClient.setControlEncoding("gbk");
			// 设置文件类型（二进制）
			ftpClient.setFileType(FTPClient.BINARY_FILE_TYPE);
			result = ftpClient.storeFile(srcFile.getName(), fis);
			System.out.println("数据库备份ftp服务器完成");
			return result;
			} catch(NumberFormatException e){
			System.out.println("FTP端口配置错误:不是数字:" );
			throw e;
			} catch(FileNotFoundException e){
			throw new FileNotFoundException();
			} catch (IOException e) {
			throw new IOException(e);
			} finally {
				IOUtils.closeQuietly(fis);
				try {
					ftpClient.disconnect();
				} catch (IOException e) {
					throw new RuntimeException("关闭FTP连接发生异常！", e);
					}
			 }
	}

}


class ErrorStreamThread extends Thread {

    private InputStream input; // 控制台errorStream

    public ErrorStreamThread(InputStream input) {
        this.input = input;
    }

    @Override
    public void run() {
        InputStreamReader isr = null;
        BufferedReader buff = null;

        try {
            isr = new InputStreamReader(input);
            buff = new BufferedReader(isr);
            String line;
            while ((line = buff.readLine()) != null) {
                if (line.indexOf("Warning") != 0) {
                    throw new Exception(line);
                }
            }
           
            
        } catch (Exception e) {
            try {
				throw new Exception("错误流线程方法异常", e);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
        } finally {
            try {
                if (buff != null) {
                    buff.close();
                }
                if (isr != null) {
                    isr.close();
                }
            } catch (IOException e) {
                try {
					throw new Exception("错误流线程方法异常", e);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
            }
        }
    }
}

