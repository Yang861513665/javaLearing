package com.diecolor.bean;

import java.util.List;
/**
 * 分页类
 * @author tanshuang
 *
 * @param <T>
 */


public class PageBean<T> {
	private Integer pageIndex;
	private Integer pageSize;
	private Integer totalRows;
	private Integer totalPages;
	private boolean isnext;
	private boolean isprev;
	private List<T> list;
	
	
	
	
	
	public PageBean() {
		
	}
	public PageBean(int index,int size) {
		this.pageIndex=index;
		this.pageSize = size;
	}
	public Integer getPageIndex() {
		return pageIndex;
	}
	public void setPageIndex(Integer pageIndex) {
		this.pageIndex = pageIndex;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	public Integer getTotalRows() {
		return totalRows;
	}
	public void setTotalRows(Integer totalRows) {
		this.totalRows = totalRows;
		//获取总行数   计算总页数
		
		totalPages = totalRows%pageSize==0?totalRows/pageSize:totalRows/pageSize+1;
		
		if(pageIndex!=1&&pageIndex!=totalPages){
			isnext=true;
			isprev=true;
		}else if(pageIndex==1&&pageIndex!=totalPages){
			isnext=true;
			isprev=false;
		}else if(pageIndex!=1&&pageIndex==totalPages){
			isnext=false;
			isprev=true;
		}
		
	}
	public Integer getTotalPages() {
		return totalPages;
	}
	public void setTotalPages(Integer totalPages) {
		this.totalPages = totalPages;
	}
	public boolean isIsnext() {
		return isnext;
	}
	public void setIsnext(boolean isnext) {
		this.isnext = isnext;
	}
	public boolean isIsprev() {
		return isprev;
	}
	public void setIsprev(boolean isprev) {
		this.isprev = isprev;
	}
	public List<T> getList() {
		return list;
	}
	public void setList(List<T> list) {
		this.list = list;
	}

}
