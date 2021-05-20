package com.example.entity;


import javax.persistence.EmbeddedId;
import javax.persistence.Entity;


//import javax.persistence.Table;

@Entity

public class Cart{
	@EmbeddedId
	private CompositeKey compositekey;
	
	private Integer quantity;

	public CompositeKey getCompositekey() {
		return compositekey;
	}

	public void setCompositekey(CompositeKey compositekey) {
		this.compositekey = compositekey;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	
}

	
	


