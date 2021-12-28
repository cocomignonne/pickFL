package com.pickfl.products.model.vo;

public class ProductVo {
	private int product_no;
	private String product_name;
	private int product_price;
	private int product_stock;
	private String flower_lang;
	private String product_simple;
	private String product_detail;
	private String product_color;
	private String product_size;
	private String product_image;
	
	
	public ProductVo() {
		
	}
	
	
	
	public ProductVo(int product_no, String product_name, int product_price, int product_stock, String flower_lang,
			String product_simple, String product_detail, String product_color, String product_size,
			String product_image) {
		this.product_no = product_no;
		this.product_name = product_name;
		this.product_price = product_price;
		this.product_stock = product_stock;
		this.flower_lang = flower_lang;
		this.product_simple = product_simple;
		this.product_detail = product_detail;
		this.product_color = product_color;
		this.product_size = product_size;
		this.product_image = product_image;
	}
	
	
	


	public ProductVo(int product_no, String product_name, int product_price, int product_stock, String product_image) {
		this.product_no = product_no;
		this.product_name = product_name;
		this.product_price = product_price;
		this.product_stock = product_stock;
		this.product_image = product_image;
	}



	



	public ProductVo(String product_name, int product_price, int product_stock, String flower_lang,
			String product_simple, String product_detail, String product_color, String product_size,
			String product_image) {
		super();
		this.product_name = product_name;
		this.product_price = product_price;
		this.product_stock = product_stock;
		this.flower_lang = flower_lang;
		this.product_simple = product_simple;
		this.product_detail = product_detail;
		this.product_color = product_color;
		this.product_size = product_size;
		this.product_image = product_image;
	}



	public int getProduct_no() {
		return product_no;
	}
	public void setProduct_no(int product_no) {
		this.product_no = product_no;
	}
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	public int getProduct_price() {
		return product_price;
	}
	public void setProduct_price(int product_price) {
		this.product_price = product_price;
	}
	public int getProduct_stock() {
		return product_stock;
	}
	public void setProduct_stock(int product_stock) {
		this.product_stock = product_stock;
	}
	public String getFlower_lang() {
		return flower_lang;
	}
	public void setFlower_lang(String flower_lang) {
		this.flower_lang = flower_lang;
	}
	public String getProduct_simple() {
		return product_simple;
	}
	public void setProduct_simple(String product_simple) {
		this.product_simple = product_simple;
	}
	public String getProduct_detail() {
		return product_detail;
	}
	public void setProduct_detail(String product_detail) {
		this.product_detail = product_detail;
	}
	public String getProduct_color() {
		return product_color;
	}
	public void setProduct_color(String product_color) {
		this.product_color = product_color;
	}
	public String getProduct_size() {
		return product_size;
	}
	public void setProduct_size(String product_size) {
		this.product_size = product_size;
	}
	public String getProduct_image() {
		return product_image;
	}
	public void setProduct_image(String product_image) {
		this.product_image = product_image;
	}
	
	
	
	


}
