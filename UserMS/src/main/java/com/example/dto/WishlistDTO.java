package com.example.dto;

import com.example.entity.CompositeKey;
import com.example.entity.Wishlist;

public class WishlistDTO {
	
	private String buyerId;
	private String prodId;

	public String getBuyerId() {
		return buyerId;
	}

	public void setBuyerId(String buyerId) {
		this.buyerId = buyerId;
	}

	public String getProdId() {
		return prodId;
	}

	public void setProdId(String prodId) {
		this.prodId = prodId;
	}
	
	
	
	
//	@Override
//	public String toString()
//	{
//		return "WishlistDTO [buyerId=" + buyerId + ",prodId" + prodId + "]";
//	}
	
	public static Wishlist createE() {
		Wishlist wl=new Wishlist();
		CompositeKey v=new CompositeKey();
		v.setProdId(wl.getCompositekey().getProdId());
		wl.setCompositekey(v);
		return wl;
	}
}
