package com.pickfl.products.model.vo;

import java.sql.Timestamp;

public class ProductVo {
	private int productNo;
	private String productName;
	private int productPrice;
	private int productStock;
	private String flowerLang;
	private String productSimple;
	private String productDetail;
	private String productColor;
	private String productSize;
	private String productImage;
	private Timestamp registerTime;
	
	
	public ProductVo() {
		
	}
	
	public ProductVo(int productNo, String productName, int productPrice, int productStock, String flowerLang,
			String productSimple, String productDetail, String productColor, String productSize, String productImage,
			Timestamp registerTime) {
		this.productNo = productNo;
		this.productName = productName;
		this.productPrice = productPrice;
		this.productStock = productStock;
		this.flowerLang = flowerLang;
		this.productSimple = productSimple;
		this.productDetail = productDetail;
		this.productColor = productColor;
		this.productSize = productSize;
		this.productImage = productImage;
		this.registerTime = registerTime;
	}	


	public ProductVo(int productNo, String productName, int productPrice, int productStock, String productImage) {
		this.productNo = productNo;
		this.productName = productName;
		this.productPrice = productPrice;
		this.productStock = productStock;
		this.productImage = productImage;
	}
	

	public ProductVo(int productNo, String productName, String flowerLang, String productSimple, String productImage) {
		this.productNo = productNo;
		this.productName = productName;
		this.flowerLang = flowerLang;
		this.productSimple = productSimple;
		this.productImage = productImage;
	}


	public ProductVo(String productName, int productPrice, int productStock, String flowerLang, String productSimple,
			String productDetail, String productColor, String productSize, String productImage) {
		this.productName = productName;
		this.productPrice = productPrice;
		this.productStock = productStock;
		this.flowerLang = flowerLang;
		this.productSimple = productSimple;
		this.productDetail = productDetail;
		this.productColor = productColor;
		this.productSize = productSize;
		this.productImage = productImage;
	}
	


	public ProductVo(int productNo, String productName, int productPrice, int productStock, String flowerLang,
			String productSimple, String productDetail, String productColor, String productSize, String productImage) {
		this.productNo = productNo;
		this.productName = productName;
		this.productPrice = productPrice;
		this.productStock = productStock;
		this.flowerLang = flowerLang;
		this.productSimple = productSimple;
		this.productDetail = productDetail;
		this.productColor = productColor;
		this.productSize = productSize;
		this.productImage = productImage;
	}

	public int getProductNo() {
		return productNo;
	}



	public void setProductNo(int productNo) {
		this.productNo = productNo;
	}



	public String getProductName() {
		return productName;
	}



	public void setProductName(String productName) {
		this.productName = productName;
	}



	public int getProductPrice() {
		return productPrice;
	}



	public void setProductPrice(int productPrice) {
		this.productPrice = productPrice;
	}



	public int getProductStock() {
		return productStock;
	}



	public void setProductStock(int productStock) {
		this.productStock = productStock;
	}



	public String getFlowerLang() {
		return flowerLang;
	}



	public void setFlowerLang(String flowerLang) {
		this.flowerLang = flowerLang;
	}



	public String getProductSimple() {
		return productSimple;
	}



	public void setProductSimple(String productSimple) {
		this.productSimple = productSimple;
	}



	public String getProductDetail() {
		return productDetail;
	}



	public void setProductDetail(String productDetail) {
		this.productDetail = productDetail;
	}



	public String getProductColor() {
		return productColor;
	}



	public void setProductColor(String productColor) {
		this.productColor = productColor;
	}



	public String getProductSize() {
		return productSize;
	}



	public void setProductSize(String productSize) {
		this.productSize = productSize;
	}



	public String getProductImage() {
		return productImage;
	}



	public void setProductImage(String productImage) {
		this.productImage = productImage;
	}



	public Timestamp getRegisterTime() {
		return registerTime;
	}



	public void setRegisterTime(Timestamp registerTime) {
		this.registerTime = registerTime;
	}



}
