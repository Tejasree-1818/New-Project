package com.example.orderms.service;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.orderms.dto.OrderCartDTO;
import com.example.orderms.dto.OrderDTO;
import com.example.orderms.dto.ProdDTO;
import com.example.orderms.entity.CompPrimaryEntity;
import com.example.orderms.entity.OrderEntity;
import com.example.orderms.entity.ProductOrderedEntity;
import com.example.orderms.repository.OrderRepo;
import com.example.orderms.repository.ProdOrdRepo;
@Service
public class OrderServiceImpl implements OrderService
{
	 static int v=1000;
	@Autowired
    OrderRepo orderRepo;
	@Autowired
    ProdOrdRepo prodRepo;
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
	  @Override
	  public String removeProductsFromCart(String prodId) throws Exception{
    	  Optional<OrderEntity> ordEntity=orderRepo.findById(prodId);
    	  if(ordEntity.isEmpty()) {
    		  throw new Exception("The ProdcutID which you provide to remove from cart is not available");
    	  }
    	  orderRepo.deleteById(prodId);
    	  String msg="The Product is removed successfully from the cart";
    	  return msg;
      }
	  @Override
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
	  @Override
	  public List<String> placeAnOrder(List<OrderCartDTO> prodId) throws Exception{	  
    	  String s;
    	  List<String> l=new ArrayList<>();
    	  List<OrderCartDTO> bD=new ArrayList<>();
    	  for(OrderCartDTO o : prodId){
    		  OrderCartDTO o1=new OrderCartDTO();
    		  o1.setBuyerId(o.getBuyerId());
    		  o1.setProdId(o.getProdId());
    		  o1.setQuantity(o.getQuantity());
    		  s="O"+(v++);
    		  String orderedDate=this.doneWithOrder(o1.getBuyerId(), o1.getProdId(),s);
    		  CompPrimaryEntity c=new CompPrimaryEntity();
    		  c.setBuyerId(o1.getBuyerId());
    		  c.setProdId(o1.getProdId());
    		  ProductOrderedEntity p=new ProductOrderedEntity();
    		  p.setcompPrimaryKey(c);
    		  p.setQuantity(o.getQuantity());
    		  p.setSellerId(s);
    		  prodRepo.save(p);
    		  l.add(orderedDate);
    		  bD.add(o);
    	  }
    	  
    	  return l;
    	  
      }
	  @Override
	  public String doneWithOrder(String buyerId,String prodId,String value) {
		  OrderEntity o=new OrderEntity();
		  o.setOrderId(value);
		  o.setOrderId(value);
			o.setAmount(1000);
			Date date=new Date();
			o.setBuyerId(buyerId);
			o.setStatus("Order Placed");
		    o.setAddress("Kalyan");
			o.setDate(date);
			orderRepo.save(o);
			return o.getOrderId();
		  
	  }
	  @Override
	  public ProdDTO getTheSpecificProduct(){
		  return null;
		
	  }
	  @Override
	  public List<OrderDTO> viewAllTheOrders() throws Exception{
			
			Iterable<OrderEntity> orders = orderRepo.findAll();
			
			if(orders==null) {
				throw new Exception("orders are empty");
			}
			
			List<OrderDTO> dto = new ArrayList<>();
			
			for(OrderEntity o : orders) {
				OrderDTO val = new OrderDTO();
				val.setBuyerId(o.getBuyerId());
				val.setAddress(o.getAddress());
				val.setAmount(o.getAmount());
				val.setDate(o.getDate());
				val.setStatus(o.getStatus());
				val.setOrderId(o.getOrderId());
				
				dto.add(val);			
			}
			return dto;
			
		}

	  
}
