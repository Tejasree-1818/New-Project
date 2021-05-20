package com.example.orderms.dto;



public class ProdDTO {
    private String prodId;
	private String prodName;
	private Float price;
	private Integer stock;
	private String description;
	private String image;
	private String sellerId;
	private String category;
	private String subcategory;
	private Float productRating;
	public String getProdId() {
		return prodId;
	}
	public void setProdId(String prodId) {
		this.prodId = prodId;
	}
	public String getProdName() {
		return prodName;
	}
	public void setProdName(String prodName) {
		this.prodName = prodName;
	}
	
	public String getDescription() {
		return description;
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
	public void setDescription(String description) {
		this.description = description;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getSellerId() {
		return sellerId;
	}
	public void setSellerId(String sellerId) {
		this.sellerId = sellerId;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
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
		return "ProdDTO [prodId=" + prodId + ", prodName=" + prodName + ", price=" + price + ", stock=" + stock
				+ ", description=" + description + ", image=" + image + ", sellerId=" + sellerId + ", category="
				+ category + ", subcategory=" + subcategory + ", productRating=" + productRating + "]";
	}
	
	
}
