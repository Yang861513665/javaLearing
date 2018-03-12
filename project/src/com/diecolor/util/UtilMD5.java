package com.diecolor.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class UtilMD5 {
	
	public static String md5(String password) {
		
		try {
			MessageDigest md = MessageDigest.getInstance("md5");
			byte m5[] = md.digest(password.getBytes());
			StringBuffer sb = new  StringBuffer();
			for (int i = 0; i < m5.length; i++) {
				String s = Integer.toHexString(0xff&m5[i]);
				sb.append(s);
			}
			return sb.toString();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return null;
	}

}
