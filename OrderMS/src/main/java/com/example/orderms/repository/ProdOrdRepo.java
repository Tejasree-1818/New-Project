package com.example.orderms.repository;
import org.springframework.data.repository.CrudRepository;
import com.example.orderms.entity.ProductOrderedEntity;
import com.example.orderms.entity.CompPrimaryEntity;
public interface ProdOrdRepo extends CrudRepository<ProductOrderedEntity,CompPrimaryEntity>{

}

