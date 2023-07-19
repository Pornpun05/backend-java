package com.example.demo.model;

public class Product {

	private Integer productId;
	private String productName;
	private Integer productAmount;
	private String productDetail;
	private Integer productPrice;
	public Integer getProductId() {
		return productId;
	}
	public void setProductId(Integer productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public Integer getProductAmount() {
		return productAmount;
	}
	public void setProductAmount(Integer productAmount) {
		this.productAmount = productAmount;
	}
	public String getProductDetail() {
		return productDetail;
	}
	public void setProductDetail(String productDetail) {
		this.productDetail = productDetail;
	}
	public Integer getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(Integer productPrice) {
		this.productPrice = productPrice;
	}
	public Product(Integer productId, String productName, Integer productAmount, String productDetail,
			Integer productPrice) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productAmount = productAmount;
		this.productDetail = productDetail;
		this.productPrice = productPrice;
	}
	
	
	
}
