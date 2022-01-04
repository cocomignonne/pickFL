package com.pickfl.review.model.vo;

import java.sql.Date;

public class ReviewVo {
	
	private int reviewNo;
	private int bouquetNo;
	private String memberId;
	private String bouquetName;
	private String reviewTitle;
	private String reviewImage;
	private String reviewContent;
	private Date reviewDate;
	private int stars;
	private char reviewDeleted;
	
	public ReviewVo(int reviewNo, String bouquetName, String memberId, String reviewTitle, String reviewImage, Date reviewDate, int stars) {
		this.reviewNo = reviewNo;
		this.bouquetName = bouquetName;
		this.memberId = memberId;
		this.reviewTitle = reviewTitle;
		this.reviewImage = reviewImage;
		this.reviewDate = reviewDate;
		this.stars = stars;
	}
	
	public ReviewVo(int reviewNo, String bouquetName, String memberId, String reviewTitle, String reviewImage, String reviewContent,
			Date reviewDate, int stars) {
		this.reviewNo = reviewNo;
		this.bouquetName = bouquetName;
		this.memberId = memberId;
		this.reviewTitle = reviewTitle;
		this.reviewImage = reviewImage;
		this.reviewContent = reviewContent;
		this.reviewDate = reviewDate;
		this.stars = stars;
	}


	
	public String getBouquetName() {
		return bouquetName;
	}

	public void setBouquetName(String bouquetName) {
		this.bouquetName = bouquetName;
	}

	public int getReviewNo() {
		return reviewNo;
	}
	public void setReviewNo(int reviewNo) {
		this.reviewNo = reviewNo;
	}
	public int getOrderNo() {
		return bouquetNo;
	}
	public void setOrderNo(int orderNo) {
		this.bouquetNo = orderNo;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getReviewTitle() {
		return reviewTitle;
	}
	public void setReviewTitle(String reviewTitle) {
		this.reviewTitle = reviewTitle;
	}
	public String getReviewImage() {
		return reviewImage;
	}
	public void setReviewImage(String reviewImage) {
		this.reviewImage = reviewImage;
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
	public int getStars() {
		return stars;
	}
	public void setStars(int stars) {
		this.stars = stars;
	}
	public char getReviewDeleted() {
		return reviewDeleted;
	}
	public void setReviewDeleted(char reviewDeleted) {
		this.reviewDeleted = reviewDeleted;
	}
	
	
	
}
	