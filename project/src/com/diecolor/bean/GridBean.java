package com.diecolor.bean;

import java.util.List;

public class GridBean<T> {

	private List<T> data;
	private Integer itemsCount;
	public List<T> getData() {
		return data;
	}
	public void setData(List<T> data) {
		this.data = data;
	}
	public Integer getItemsCount() {
		return itemsCount;
	}
	public void setItemsCount(Integer itemsCount) {
		this.itemsCount = itemsCount;
	}
	
}
