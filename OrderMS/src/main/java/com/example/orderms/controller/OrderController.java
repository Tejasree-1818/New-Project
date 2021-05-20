package com.example.orderms.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;

import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

import com.example.orderms.dto.OrderCartDTO;
import com.example.orderms.dto.OrderDTO;
import com.example.orderms.dto.ProdDTO;
import com.example.orderms.service.OrderService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;

@CrossOrigin
@RestController
@RequestMapping(value="/cart")
public class OrderController {
   @Autowired
   OrderService ordService;
   @Autowired
   Environment envi;
   @RequestMapping(value="/add/product")
   public ResponseEntity<String> addProductsToCart(@RequestBody OrderDTO orderDTO) throws Exception{
	   try {
		   String m=ordService.addProductsToCart(orderDTO);
		   return new ResponseEntity<String>(m+"Product Added Prosperously",HttpStatus.OK);
	   }
	   catch(Exception ex){
		   return new ResponseEntity<String>(ex.getMessage(),HttpStatus.NOT_FOUND);
	   }
   }
   @RequestMapping(value="/remove/product/{prodId}")
   public ResponseEntity<String>  removeProductsFromCart(@PathVariable String prodId) throws Exception{
	   try {
		   String m=ordService.removeProductsFromCart(prodId);
		   return new ResponseEntity<String>(m+"Product Removed Prosperously",HttpStatus.OK);

	   }
	   catch(Exception ex){
		   return new ResponseEntity<String>(ex.getMessage(),HttpStatus.NOT_FOUND);
	   }
   }
   @RequestMapping(value="/placeOrder")
	public ResponseEntity<String> placeOrder() {

		try {
		List cartItem = new RestTemplate().getForObject("http://localhost:8200/user/cart",List.class);
		ObjectMapper mapper = new ObjectMapper();
		if(!cartItem.isEmpty())
		{
		 CollectionType listType = mapper.getTypeFactory().constructCollectionType(ArrayList.class, OrderCartDTO.class);

		List<OrderCartDTO> item= mapper.convertValue(cartItem,listType);
		
		List<String> val = ordService.placeAnOrder(item);
		
		return new ResponseEntity<String>(val+" placed successfully",HttpStatus.OK);
		}
		return new ResponseEntity<String>("no items to place",HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.NOT_FOUND);
		}
		
	}
 @SuppressWarnings("serial")
 @ResponseStatus(value=HttpStatus.NOT_FOUND, reason="No such Order")  
   public class OrderNotFoundException extends RuntimeException {
       // ...
   }
 @RequestMapping(value="/view/order/{orderId}")
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
 @RequestMapping(value="/{prodId}")
	public ResponseEntity<ProdDTO> viewOrders(@PathVariable String prodId) throws Exception{

		 ProdDTO d=null;
		try {
			d = ordService.getTheSpecificProduct();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
				throw new ResponseStatusException(HttpStatus.NOT_FOUND, envi.getProperty(e.getMessage()), e);
		}
		return new ResponseEntity<ProdDTO>(d,HttpStatus.OK);

	}
}


   

