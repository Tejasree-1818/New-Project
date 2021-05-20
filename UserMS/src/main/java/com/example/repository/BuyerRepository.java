package com.example.repository;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.example.entity.Buyer;

public interface BuyerRepository  extends CrudRepository<Buyer,String>{
	public Optional<Buyer> findById(String buyerId);
	public Optional<Buyer> findByEmailId(String emailId);
	@Query("DELETE FROM Buyer b WHERE b.buyerId = :buyerId")
	@Modifying
	@Transactional
	public void deleteById(@Param("buyerId") String buyerId);

}
