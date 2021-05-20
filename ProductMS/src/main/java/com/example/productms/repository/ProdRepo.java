package com.example.productms.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.example.productms.entity.ProdEntity;

public interface ProdRepo extends CrudRepository<ProdEntity,String> {
	
    Optional<ProdEntity> findByProductName(String productName);
    
    Optional<ProdEntity> findById(String prodId);
	

	List<ProdEntity> findByCategory(String category);
}
