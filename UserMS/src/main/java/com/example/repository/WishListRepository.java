package com.example.repository;

//import java.util.Optional;

import org.springframework.data.repository.CrudRepository;


import com.example.entity.CompositeKey;
import com.example.entity.Wishlist;

public interface WishListRepository extends CrudRepository<Wishlist,CompositeKey >{
	
	//public Optional<Wishlist> findByBuyerIdAndProdId(String buyerId,String prodId);

}


