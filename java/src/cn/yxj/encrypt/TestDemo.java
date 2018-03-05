package cn.yxj.encrypt;

/**
 *    判断两个字符串是否互为异序
 * */
public class TestDemo {
		public static void main(String[] args) {
			System.out.println(anagrams("123","321"));
		}
		static boolean anagrams(String str1, String str2) {
			if (str1 == null || str2 == null || (str1.length() != str2.length())) {
				return false;
			}
			String string = str1 + str2; 
			byte[] chars = string.getBytes();
			int x = 0;
			for (int i = 0; i < chars.length; i++) {
				x ^= chars[i];
			}
			return (x == 0) ? true : false;
		}
}
