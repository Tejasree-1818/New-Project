package com.example.productms.dto;

import java.util.Optional;

import com.example.productms.entity.ProdEntity;

public class ProdDTO {
    private String prodId;

	private String productName;

	

	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
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
	public static ProdDTO valueOf(Optional<ProdEntity> prodEntity) {
		ProdDTO pD=new ProdDTO();
		pD.setProdId(prodEntity.get().getprodId());
		pD.setCategory(prodEntity.get().getCategory());
		pD.setDescription(prodEntity.get().getDescription());
		pD.setImage(prodEntity.get().getImage());
		pD.setPrice(prodEntity.get().getPrice());
		pD.setSubcategory(prodEntity.get().getSubcategory());
		pD.setStock(prodEntity.get().getStock());
		pD.setProductRating(prodEntity.get().getProductRating());
		pD.setSellerId(prodEntity.get().getSellerId());
		pD.setProductName(prodEntity.get().getProductName());
		return pD;
	}
}
