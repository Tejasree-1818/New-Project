package com.example.orderms.dto;

import com.example.orderms.entity.CompPrimaryEntity;

public class OrderCartDTO {
	private String prodId;
	private String buyerId;
    private Integer quantity;
    private CompPrimaryEntity compPrimaryKey;
	public String getProdId() {
		return prodId;
	}
	public void setProdId(String prodId) {
		this.prodId = prodId;
	}
	public String getBuyerId() {
		return buyerId;
	}
	public void setBuyerId(String buyerId) {
		this.buyerId = buyerId;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public CompPrimaryEntity getCompPrimaryKey() {
		return compPrimaryKey;
	}
	public void setCompPrimaryKey(CompPrimaryEntity compPrimaryKey) {
		this.compPrimaryKey = compPrimaryKey;
	}
	
}
