package com.example.productms.entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.example.productms.entity.CompPrimaryEntity;

@Entity
@Table(name="subscribedProduct")
public class SubscribedProdEntity {
	@EmbeddedId
    private CompPrimaryEntity compPrimaryKey;
	private Integer quantity;
	public SubscribedProdEntity(CompPrimaryEntity compPrimaryKey, Integer quantity) {
		super();
		this.compPrimaryKey = compPrimaryKey;
		this.quantity = quantity;
	}
	public SubscribedProdEntity() {
		super();
		
	}
	public CompPrimaryEntity getCompPrimaryKey() {
		return compPrimaryKey;
	}
	public void setCompPrimaryKey(CompPrimaryEntity compPrimaryKey) {
		this.compPrimaryKey = compPrimaryKey;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	
	

}
