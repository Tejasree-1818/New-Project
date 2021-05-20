package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.dto.BuyerDTO;
import com.example.dto.CartDTO;
import com.example.dto.ProductDTO;
import com.example.dto.SellerDTO;
import com.example.dto.WishlistDTO;
import com.example.exception.UserException;
import com.example.service.UserService;

@CrossOrigin
@RestController
@RequestMapping
public class UserController {
	
	
	@Autowired
	private UserService userImpl;
	
	@Autowired
	private Environment environment;
	
	
	@RequestMapping(value="/buyerRegister",method=RequestMethod.POST)
	public ResponseEntity<String> registerBuyer(@RequestBody BuyerDTO buyer) throws Exception
	{
		String s;
		try {
			s=userImpl.registerBuyer(buyer);
			return new ResponseEntity<String>(s+"Registered as a buyer successfully",HttpStatus.OK);
		}
		catch(Exception e) {
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.NOT_FOUND);
		}
		
	}
	
	@RequestMapping(value="/sellerRegister",method=RequestMethod.POST)
	public ResponseEntity<String> registerSeller(@RequestBody SellerDTO seller) throws Exception
	{
		String s;
		try {
			s=userImpl.registerSeller(seller);
			return new ResponseEntity<String>(s+"Registered as a buyer successfully",HttpStatus.OK);
		}
		catch(Exception e) {
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.NOT_FOUND);
		}
			
	}
	
	@GetMapping(value="/seller/login/{email}/{password}")
	public ResponseEntity<String> loginSeller(@PathVariable String email,@PathVariable String password) {
		String msg;
		try {
		msg= userImpl.sellerLogin(email,password);
		return new ResponseEntity<String>(msg,HttpStatus.OK);
 
		}catch(Exception e) {
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping(value="/buyer/login/{email}/{password}")
	public ResponseEntity<String> loginBuyer(@PathVariable String email,@PathVariable String password) {
		String msg;
		try {
		msg= userImpl.buyerLogin(email, password);
		return new ResponseEntity<String>(msg,HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping(value="/buyer/{buyerId}")
	public ResponseEntity<String> DeleteBuyer(@PathVariable String buyerId) {
		String msg;
		try {
		msg= userImpl.deleteBuyer(buyerId);
		return new ResponseEntity<String>(msg,HttpStatus.OK);
 
		}catch(Exception e) {
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping(value="/seller/{sellerId}")
	public ResponseEntity<String> DeleteSeller(@PathVariable String sellerId) {
		String msg;
		try {
		msg= userImpl.deleteSeller(sellerId);
		return new ResponseEntity<String>(msg,HttpStatus.OK);
 
		}catch(Exception e) {
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping(value="/cart")
	public ResponseEntity<String> DemoCart() {	
		try {
		userImpl.cart();
		return new ResponseEntity<String>("Successly added in cart",HttpStatus.OK);
 
		}catch(Exception e) {
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping(value="/buyer/wishlist/{buyerId}/{productName}")
	public WishlistDTO getWishlistProduct(@PathVariable String buyerId,@PathVariable String productName) {
	ProductDTO productId = new RestTemplate().getForObject("http://localhost:8400/product/wishlist/"+productName, ProductDTO.class);
	System.out.println(productId.getProdId());
	
	//	WishlistDTO value=new WishlistDTO();
		WishlistDTO value = userImpl.wishlistData(buyerId,productId.getProdId());
		return value;		
	
	}

	@PostMapping(value="/buyer/wish-cart")
	public ResponseEntity<String> getWishlistToCart(@RequestBody CartDTO cartDTO) {
		try {
		userImpl.addToCart(cartDTO);
		return new ResponseEntity<String>("Successfully added product from wishlist to cart",HttpStatus.OK);
 
		}catch(Exception e) {
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.UNAUTHORIZED);
		}
	}
	
	@PostMapping(value="/buyer/cart/{buyerId}/{productName}/{quantity}")
	public CartDTO addCartProduct(@PathVariable String buyerId,@PathVariable String productName,@PathVariable int quantity) {
	ProductDTO productId = new RestTemplate().getForObject("http://localhost:8400/product/wishlist/"+productName, ProductDTO.class);
	System.out.println(productId.getProdId());
	
		CartDTO value = userImpl.cartData(buyerId,productId.getProdId(),quantity);
		return value;		
	
	}
	
   
	
	
	

}
