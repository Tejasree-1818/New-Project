package com.example.productms.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.productms.entity.CompPrimaryEntity;

import com.example.productms.entity.SubscribedProdEntity;

public interface SubscribedProdRepo extends CrudRepository<SubscribedProdEntity,CompPrimaryEntity>{
    
}
