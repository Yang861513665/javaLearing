package cn.yxj.File;

import java.io.IOException;
import java.io.RandomAccessFile;

public class RandomAccessFileDemo {

	public static void main(String[] args) throws IOException {

		int  data_arr[]={12,14,25,9,58,1,5,2};
		RandomAccessFile randomAccessFile = new RandomAccessFile("f:\\tempfile\\ranodmAccessFile.dat", "rw");
	
		for (int i : data_arr) {
			 randomAccessFile.writeInt(i);
		}
		for (int i = data_arr.length-1; i>=0; i--) {
		    randomAccessFile.seek(i*4);
		    if(i>0)
		    System.out.print(randomAccessFile.readInt()+",");
		    else{
		    	 System.out.print(randomAccessFile.readInt());
		    }
		}
		randomAccessFile.close();
	}

}
