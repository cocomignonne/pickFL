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


	private int maxCount() {
		int maxcount=1;
		maxcount = new MemberSearchMService().maxCountPage();
		System.out.println("inquery maxcount : " + maxcount);
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
