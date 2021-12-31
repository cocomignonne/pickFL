package com.pickfl.review.model.vo;

import java.sql.Date;

public class ReviewVo {
	
	private int reviewNo;
	private int orderNo;
	private String memberId;
	private String reviewTitle;
	private String reviewContent;
	private Date reviewDate;
	private int star;
	private char reviewDeleted;
	
	public ReviewVo(int reviewNo, String reviewTitle, String memberId, Date reviewDate, int star) {
		this.reviewNo = reviewNo;
		this.memberId = memberId;
		this.reviewTitle = reviewTitle;
		this.reviewDate = reviewDate;
		this.star = star;
	}
	
	public ReviewVo(int reviewNo, String memberId, String reviewTitle, String reviewContent, Date reviewDate,
			int star) {
		this.reviewNo = reviewNo;
		this.memberId = memberId;
		this.reviewTitle = reviewTitle;
		this.reviewContent = reviewContent;
		this.reviewDate = reviewDate;
		this.star = star;
	}

	public int getReviewNo() {
		return reviewNo;
	}
	public void setReviewNo(int reviewNo) {
		this.reviewNo = reviewNo;
	}
	public int getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(int orderNo) {
		this.orderNo = orderNo;
	}
	public String getReviewTitle() {
		return reviewTitle;
	}
	public void setReviewTitle(String reviewTitle) {
		this.reviewTitle = reviewTitle;
	}
	public String getReviewContent() {
		return reviewContent;
	}
	public void setReviewContent(String reviewContent) {
		this.reviewContent = reviewContent;
	}
	public Date getReviewDate() {
		return reviewDate;
	}
	public void setReviewDate(Date reviewDate) {
		this.reviewDate = reviewDate;
	}
	public int getStar() {
		return star;
	}
	public void setStar(int star) {
		this.star = star;
	}
	public char getReviewDeleted() {
		return reviewDeleted;
	}
	public void setReviewDeleted(char reviewDeleted) {
		this.reviewDeleted = reviewDeleted;
	}

	
}
	