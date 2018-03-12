package com.diecolor.util;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class JSONUtils {
	public static void printJSON(HttpServletResponse response,Object object){
		try {
			Gson gson =new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
			String json = gson.toJson(object);
			PrintWriter out = response.getWriter();
			out.print(json);
			out.flush();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
