package com.example.orderms.service;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.orderms.dto.OrderDTO;
import com.example.orderms.entity.OrderEntity;
import com.example.orderms.repository.OrderRepo;

public class OrderServiceImpl implements OrderService{
	  
	@Autowired
      OrderRepo orderRepo;
	  @Override
      public String addProductsToCart(OrderDTO orderDTO) throws Exception{
		  OrderEntity ordEntity=new OrderEntity();
		  ordEntity.setBuyerId(orderDTO.getBuyerId());
		  ordEntity.setOrderId(orderDTO.getOrderId());
		  ordEntity.setAmount(orderDTO.getAmount());
		  ordEntity.setDate(orderDTO.getDate());
		  ordEntity.setAddress(orderDTO.getAddress());
		  ordEntity.setStatus(orderDTO.getStatus());
		  orderRepo.save(ordEntity);
		  return ordEntity.getOrderId();
		  
	  }
      public String removeProductsFromCart(String prodId) throws Exception{
    	  Optional<OrderEntity> ordEntity=orderRepo.findById(prodId);
    	  if(ordEntity.isEmpty()) {
    		  throw new Exception("The ProdcutID which you provide to remove from cart is not available");
    	  }
    	  orderRepo.deleteById(prodId);
    	  String msg="The Product is removed successfully from the cart";
    	  return msg;
      }
      public OrderDTO viewTheOrders(String orderId) throws Exception{
    	  OrderEntity ordEntity=orderRepo.findByOrderId(orderId);
    	  if(ordEntity==null) {
    		  throw new Exception("The OrderID which you provide to view the orders is not available");
    	  }
    	  OrderDTO ordDTO=new OrderDTO();
    	  ordDTO.setOrderId(ordEntity.getOrderId());
    	  ordDTO.setBuyerId(ordEntity.getBuyerId());
    	  ordDTO.setDate(ordEntity.getDate());
    	  ordDTO.setAmount(ordEntity.getAmount());
    	  ordDTO.setAddress(ordEntity.getAddress());
    	  ordDTO.setStatus(ordEntity.getStatus());
    	  return ordDTO;
      }
      public String placeAnOrder(String prodId) throws Exception{
    	  
    	  return null;
      }

	  
}
