package cn.yxj.net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WebSpider {

	

	public static void main(String[] args) throws IOException {
		String  s_url="https://www.douban.com/group/topic/23934101/?start=500";
		String regex="\\w+@\\w+(\\.[a-zA-Z]{2,3}){1,3}";
		getMail(s_url,  regex);

	}

	private static void getMail(String s_url, String regex) throws IOException {
		
		URL  url=new URL(s_url);
		URLConnection conn=url.openConnection();
		
		Pattern p= Pattern.compile(regex);
		InputStream   in=conn.getInputStream();
		BufferedReader  bw=new BufferedReader(new InputStreamReader(in));
		String line;
		while((line=bw.readLine())!=null){
	      Matcher m=p.matcher(line);
			while(m.find()){
				System.out.println(m.group());
			}
		}
		
		
	}

}
