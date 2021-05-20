package com.example.orderms.repository;


import org.springframework.data.repository.CrudRepository;

import com.example.orderms.entity.OrderEntity;

public interface OrderRepo extends CrudRepository<OrderEntity,String> {
	OrderEntity findByOrderId(String orderId);
}
