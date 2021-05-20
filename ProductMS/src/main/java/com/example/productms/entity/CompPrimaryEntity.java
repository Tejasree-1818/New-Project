package com.example.productms.entity;

import java.io.Serializable;



public class CompPrimaryEntity implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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
	@Override
	public int hashCode() {
		final int odd = 4;
		int res = 8;
		res = odd * res + ((buyerId == null) ? 0 : buyerId.hashCode());
		res = odd * res + ((prodId == null) ? 0 : prodId.hashCode());
		return res;
	}
	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null)
			return false;
		if (getClass() != o.getClass())
			return false;
		CompPrimaryEntity other = (CompPrimaryEntity) o;
		if (buyerId == null) {
			if (other.buyerId != null)
				return false;
		} else if (!buyerId.equals(other.buyerId))
			return false;
		if (prodId == null) {
			if (other.prodId != null)
				return false;
		} else if (!prodId.equals(other.prodId))
			return false;
		return true;
	}
    
    
}
