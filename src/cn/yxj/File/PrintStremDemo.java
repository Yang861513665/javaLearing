package cn.yxj.File;

import java.io.FileNotFoundException;
import java.io.PrintStream;

public class PrintStremDemo {
	public static void main(String[] args) throws FileNotFoundException {
		PrintStream ps = new PrintStream("f:\\tempfile\\int.txt");
		ps.print(97);
		ps.close();
	}
}
