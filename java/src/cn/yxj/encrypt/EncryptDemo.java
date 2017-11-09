package cn.yxj.encrypt;

public class EncryptDemo {
	/**
	 * 
	 * 利用二进制的异或规律（异或同一数字两次得到原来的数字）,实现数据的加密和解密
	 * */
	public static void main(String[] args) {
		  String  password="yang123456";
		String  encodedPassword= decode(password);
		System.out.println(encodedPassword);
	      String  password2=encode( encodedPassword);
	      System.out.println(password2);
	}
	/**
	 * 解密
	 * */
	private static String encode(String encodedPassword) {
	
		 char[]  arr=encodedPassword.toCharArray();
		 for (int i = 0; i < arr.length; i++) {
			int  temp=arr[i];
			arr[i]=(char) (temp^1^6^3);
		}
		return new String(arr);
	}
	/**
	 * 加密
	 * */
	private static String  decode(String password) {
		
		 char[]  arr= password.toCharArray();
		 for (int i = 0; i < arr.length; i++) {
			int  temp=arr[i];
			arr[i]=(char) (temp^1^6^3);
		}
		return new String(arr);
     	
	}
}
