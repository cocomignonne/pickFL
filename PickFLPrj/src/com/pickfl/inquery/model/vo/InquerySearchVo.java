package com.pickfl.inquery.model.vo;

import java.sql.Timestamp;

import com.pickfl.inquery.model.service.InquerySearchService;

public class InquerySearchVo {
	private String user;
	private String type;
	private int currentPage;
	private int maxCount;
	private int maxPage;
	private int endPage;
	
	private int qNum;
	private Timestamp createDate;
	private String qTitle;
	private String qContent;
	private String qDeleted;
	private String qResponse;
	
	public InquerySearchVo(String user, String type, String page) {
		this.user = user;
		this.type = type;
		this.maxCount = maxCount(user, type);
		this.maxPage = maxPage(maxCount);
		this.currentPage = currentPage(page,maxPage);
		this.endPage = currentPage+6;
		
	}

	public InquerySearchVo() {
		
	}

	private int maxCount(String user, String type) {
		int maxcount;
		if(user.equals("admin"))
			maxcount = new InquerySearchService().maxCountPage(type);
		else 
			maxcount = new InquerySearchService().memberCountPage(user, type);
		
		System.out.println("maxcount : " + maxcount);
		return maxcount;
	}
	
	private int maxPage(int maxCount) {
		int maxPage;
		if(maxCount % 7 == 0) {
			maxPage = maxCount/7;
		}
		else{
			maxPage = maxCount/7 +1;
		}
		return maxPage;
	}
	
	private int currentPage(String curr, int maxPage) {
		int currentPage;
		if(curr == null)
			curr = "1";
		
		currentPage = Integer.parseInt(curr);
		
		if(currentPage > maxPage){
			currentPage = maxPage;
		}
		
		return currentPage;
	}

	public String getUser() {
		return user;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public int getMaxPage() {
		return maxPage;
	}

	public int getEndPage() {
		return endPage;
	}
	
	public int getMaxCount() {
		return maxCount;
	}
	
	public String getType() {
		return type;
	}
	
	public int getqNum() {
		return qNum;
	}
	public void setqNum(int qNum) {
		this.qNum = qNum;
	}
	public Timestamp getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}
	public String getqTitle() {
		return qTitle;
	}
	public void setqTitle(String qTitle) {
		this.qTitle = qTitle;
	}
	public String getqContent() {
		return qContent;
	}
	public void setqContent(String qContent) {
		this.qContent = qContent;
	}
	public String getqDeleted() {
		return qDeleted;
	}
	public void setqDeleted(String qDeleted) {
		this.qDeleted = qDeleted;
	}
	public String getqResponse() {
		return qResponse;
	}
	public void setqResponse(String qResponse) {
		this.qResponse = qResponse;
	}
}
