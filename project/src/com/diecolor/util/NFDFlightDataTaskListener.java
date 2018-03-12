package com.diecolor.util;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class NFDFlightDataTaskListener implements  ServletContextListener {
	 

	// 服务器启动时执行该事件
	  public void contextInitialized(ServletContextEvent arg0) {
	    try {
	     QuartzLoad.run();
	    } catch (Exception e) {
	      e.printStackTrace();
	    }
	  }
	  // 服务器停止时执行该事件
	  public void contextDestroyed(ServletContextEvent arg0) {
	    try {
	      QuartzLoad.stop();
	    } catch (Exception e) {
	      e.printStackTrace();
	    }
	  }

 
}
