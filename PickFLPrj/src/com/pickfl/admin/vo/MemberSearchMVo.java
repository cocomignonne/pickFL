package com.pickfl.admin.vo;

import com.pickfl.admin.service.MemberSearchMService;

public class MemberSearchMVo {
	private int currentPage;
	private int maxCount;
	private int maxPage;
	private int startPage;
	private int endPage;
	
	public MemberSearchMVo() {
		
	}	public MemberSearchMVo(String page) {
		this.maxCount = maxCount();
		this.maxPage = maxPage(maxCount);
		this.currentPage = currentPage(page,maxPage);
		this.startPage = currentPage/10 +1;
		this.endPage = startPage+9;
	}


	public MemberSearchMVo(String page, String id) {
		this.maxCount = maxCount(id);
		this.maxPage = maxPage(maxCount);
		this.currentPage = currentPage(page,maxPage);
		this.startPage = currentPage/10 +1;
		this.endPage = startPage+9;
	}
	
	private int maxCount(String id) {
		int maxcount=0;
		maxcount = new MemberSearchMService().maxCountPage(id);
		return maxcount;
	}
	
	private int maxCount() {
		int maxcount=0;
		maxcount = new MemberSearchMService().maxCountPage();
		return maxcount;
	}
	
	private int maxPage(int maxCount) {
		int maxPage;
		if(maxCount % 10 == 0) {
			maxPage = maxCount/10;
		}
		else{
			maxPage = maxCount/10 +1;
		}
		return maxPage;
	}
	
	public int currentPage(String curr, int maxPage) {
		int currentPage;
		if(curr == null)
			curr = "1";
		
		currentPage = Integer.parseInt(curr);
		
		if(currentPage > maxPage){
			currentPage = maxPage;
		}else if(currentPage < 1) {
			currentPage = 1;
		}
		
		return currentPage;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public int getMaxCount() {
		return maxCount;
	}
	public int getMaxPage() {
		return maxPage;
	}
	public int getStartPage() {
		return startPage;
	}
	public int getEndPage() {
		return endPage;
	}
	
}
