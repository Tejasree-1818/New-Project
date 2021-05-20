package com.example.orderms.service;

import java.util.List;



import com.example.orderms.dto.OrderCartDTO;
import com.example.orderms.dto.OrderDTO;
import com.example.orderms.dto.ProdDTO;


public interface OrderService {
      public String addProductsToCart(OrderDTO orderDTO) throws Exception;
      public String removeProductsFromCart(String prodId) throws Exception;
      public List<String> placeAnOrder(List<OrderCartDTO> prodId) throws Exception;
      public OrderDTO viewTheOrders(String orderId) throws Exception;
      public String doneWithOrder(String buyerId,String prodId,String value);
  	  public List<OrderDTO> viewAllTheOrders() throws Exception;
  	  public ProdDTO getTheSpecificProduct();
  	

}
