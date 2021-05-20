package com.example.dto;


public class ProductDTO {
	
	private String prodId;
	private String productName;
	private Float price;
	private Integer stock;
	private String description;
	private String category;
	private String sellerId;
	private String subcategory;
	private Float productRating;
	public String getProdId() {
		return prodId;
	}
	public void setProdId(String prodId) {
		this.prodId = prodId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public Float getPrice() {
		return price;
	}
	public void setPrice(Float price) {
		this.price = price;
	}
	public Integer getStock() {
		return stock;
	}
	public void setStock(Integer stock) {
		this.stock = stock;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getSellerId() {
		return sellerId;
	}
	public void setSellerId(String sellerId) {
		this.sellerId = sellerId;
	}
	public String getSubcategory() {
		return subcategory;
	}
	public void setSubcategory(String subcategory) {
		this.subcategory = subcategory;
	}
	public Float getProductRating() {
		return productRating;
	}
	public void setProductRating(Float productRating) {
		this.productRating = productRating;
	}
	@Override
	public String toString() {
		return "ProductDTO [prodId=" + prodId + ", productName=" + productName + ", price=" + price + ", stock=" + stock
				+ ", description=" + description + ", category=" + category + ", sellerId=" + sellerId
				+ ", subcategory=" + subcategory + ", productRating=" + productRating + "]";
	}

}
