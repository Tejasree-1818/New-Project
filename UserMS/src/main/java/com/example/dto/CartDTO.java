package com.example.dto;



public class CartDTO {
	
	private String buyerId;
	private String prodId;
	private Integer quantity;
	private String compositeKey;
	public String getCompositeKey() {
		return compositeKey;
	}
	public void setCompositeKey(String compositeKey) {
		this.compositeKey = compositeKey;
	}
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
//	
//	@Override
//	public String toString()
//	{
//		return "CartDTO[buyerId" + buyerId +", prodId=" + prodId + ",quantity=" + quantity
//				+ "]";
//	}

}
