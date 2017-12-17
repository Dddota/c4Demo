package com.bdqn.utils;

public class Page {
	
	private int currentPageNum;//当前页码
	
	private int pageSize=5;//页大小
	
	private int totalPageNum;//总页数
	
	private int totalCount;//总记录数

	private int startIndex;//开始下标

	public int getCurrentPageNum() {
		return currentPageNum;
	}


	public void setCurrentPageNum(int currentPageNum) { //设置当前页面
		if (currentPageNum<=0) {
			this.currentPageNum=1;
		}else{
			this.currentPageNum = currentPageNum;
		}	
		
		//设置访问的开始下标  =（当前页-1）*size;
		this.startIndex=(this.currentPageNum-1)*this.pageSize;
	}


	public int getPageSize() {
		return pageSize;
	}


	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
		
	}


	public int getTotalPageNum() {
		return totalPageNum;
	}


	public void setTotalPageNum(int totalPageNum) {
		this.totalPageNum = totalPageNum;
	}


	public int getTotalCount() {
		return totalCount;
	}


	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
		//设置总记录数   确定总页数=
		this.totalPageNum=(totalCount%pageSize)==0?
				totalCount/pageSize:(totalCount/pageSize)+1;	
	}


	public int getStartIndex() {
		return startIndex;
	}


	public void setStartIndex(int startIndex) {
		this.startIndex = startIndex;
	}
	
	
	
	
	
	

}
