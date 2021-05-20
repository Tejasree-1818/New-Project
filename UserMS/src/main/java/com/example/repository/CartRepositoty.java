package com.example.repository;

//import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.example.entity.Cart;
import com.example.entity.CompositeKey;

public interface CartRepositoty  extends CrudRepository<Cart,CompositeKey >{
	
	//public Optional<Cart> findByBuyerIdAndProdId(String buyerId,String prodId);

}
