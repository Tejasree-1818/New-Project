package com.example.orderms.service;

import org.springframework.stereotype.Service;

import com.example.orderms.dto.OrderDTO;

@Service
public interface OrderService {
      public String addProductsToCart(OrderDTO orderDTO) throws Exception;
      public String removeProductsFromCart(String prodId) throws Exception;
      public String placeAnOrder(String prodId) throws Exception;
      public OrderDTO viewTheOrders(String orderId) throws Exception;

}
