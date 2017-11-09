package cn.yxj.File;

import java.io.File;
import java.io.FilenameFilter;



public class FileNameFilterBySuffix implements FilenameFilter {

	private String suffix;
	
	public FileNameFilterBySuffix(String suffix) {
		super();
		this.suffix = suffix;
	}
	@Override
	public boolean accept(File dir, String name) {
		
		
		return name.endsWith(suffix);
	}

	
}
