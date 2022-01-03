package com.pickfl.cart.model.vo;

public class CartVo {
    private int cartNo;
    private int memberNo;
    private int bouquetNo;
    private String bouquetDetail;
    private String bouquetName;
    private String wrapColor;
    private int bouquetPrice;
    private int buyNumBQ;
    private int bouquetTotalPrice;

    public int getCartNo() {
        return cartNo;
    }
    public void setCartNo(int cartNo) {
        this.cartNo = cartNo;
    }
    public int getMemberNo() {
        return memberNo;
    }
    public void setMemberNo(int memberNo) {
        this.memberNo = memberNo;
    }
    public int getBouquetNo() {
        return bouquetNo;
    }
    public void setBouquetNo(int bouquetNo) {
        this.bouquetNo = bouquetNo;
    }
    public String getBouquetDetail() {
        return bouquetDetail;
    }


    public void setBouquetDetail(String bouquetDetail) {
        this.bouquetDetail = bouquetDetail;
    }


    public String getBouquetName() {
        return bouquetName;
    }


    public void setBouquetName(String bouquetName) {
        this.bouquetName = bouquetName;
    }


    public String getWrapColor() {
        return wrapColor;
    }


    public void setWrapColor(String wrapColor) {
        this.wrapColor = wrapColor;
    }


    public int getBouquetPrice() {
        return bouquetPrice;
    }


    public void setBouquetPrice(int bouquetPrice) {
        this.bouquetPrice = bouquetPrice;
    }


    public int getBuyNumBQ() {
        return buyNumBQ;
    }
    public void setBuyNumBQ(int buyNumBQ) {
        this.buyNumBQ = buyNumBQ;
    }
    public int getBouquetTotalPrice() {
        return bouquetTotalPrice;
    }

    public void setBouquetTotalPrice(int bouquetTotalPrice) {
        this.bouquetTotalPrice = bouquetTotalPrice;
    }

    public CartVo(int memberNo, int bouquetNo, String bouquetDetail) {
        this.memberNo = memberNo;
        this.bouquetNo = bouquetNo;
        this.bouquetDetail = bouquetDetail;
    }
	public CartVo() {

	}
    

}