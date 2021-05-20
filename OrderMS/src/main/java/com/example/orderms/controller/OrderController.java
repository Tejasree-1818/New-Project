package com.example.orderms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.orderms.dto.OrderDTO;

import com.example.orderms.service.OrderService;

@RestController
@RequestMapping(value="/cart")
public class OrderController {
   @Autowired
   OrderService ordService;
   @Autowired
   Environment envi;
   @PostMapping(value="/add/product")
   public ResponseEntity<String> addProductsToCart(@RequestBody OrderDTO orderDTO) throws Exception{
	   try {
		   String m=ordService.addProductsToCart(orderDTO);
		   return new ResponseEntity<String>(m+"Product Added Prosperously",HttpStatus.OK);
	   }
	   catch(Exception ex){
		   return new ResponseEntity<String>(ex.getMessage(),HttpStatus.NOT_FOUND);
	   }
   }
   @PostMapping(value="/remove/product/{prodId}")
   public ResponseEntity<String>  removeProductsFromCart(@PathVariable String prodId) throws Exception{
	   try {
		   String m=ordService.removeProductsFromCart(prodId);
		   return new ResponseEntity<String>(m+"Product Removed Prosperously",HttpStatus.OK);

	   }
	   catch(Exception ex){
		   return new ResponseEntity<String>(ex.getMessage(),HttpStatus.NOT_FOUND);
	   }
   }
   @PostMapping(value="/place/product/{prodId}")
   public ResponseEntity<String>  placeAnOrder(@PathVariable String prodId) throws Exception{
	   try {
	       String m=ordService.placeAnOrder(prodId);
		   return new ResponseEntity<String>(m+"Product Placed Prosperously",HttpStatus.OK);

	   }
	   catch(Exception ex){
		   return new ResponseEntity<String>(ex.getMessage(),HttpStatus.NOT_FOUND);
	   }
	   
	   
   }
 @SuppressWarnings("serial")
 @ResponseStatus(value=HttpStatus.NOT_FOUND, reason="No such Order")  
   public class OrderNotFoundException extends RuntimeException {
       // ...
   }
  @GetMapping(value="/view/order/{orderId}")
  public ResponseEntity<OrderDTO> viewTheOrders(@PathVariable String orderId){

        OrderDTO order=null;
        
        try {
			order =ordService.viewTheOrders(orderId);
		} catch (Exception e) {
			
			e.printStackTrace();
			 throw new OrderNotFoundException();
		}
       
        return new ResponseEntity<OrderDTO>(order,HttpStatus.OK);
        }
}


   

