package com.example.repository;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.example.entity.Seller;



public interface SellerRepository extends CrudRepository<Seller,String>{

	public Optional<Seller> findByEmail(String email);
	public Optional<Seller> findById(String sellerId);

	@Query("DELETE FROM Seller s WHERE s.sellerId = :sellerId")
	@Modifying
	@Transactional
	public void deleteById(@Param("sellerId") String sellerId);


}
