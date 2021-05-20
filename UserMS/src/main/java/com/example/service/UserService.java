package com.example.service;

import com.example.dto.BuyerDTO;
import com.example.dto.CartDTO;
import com.example.dto.SellerDTO;
import com.example.dto.WishlistDTO;
import com.example.exception.UserException;

public interface UserService {
	public String registerBuyer(BuyerDTO buyer);
	public String registerSeller(SellerDTO seller);
	public String buyerLogin(String emailId,String password) throws UserException;
	public String sellerLogin(String emailId,String password) throws UserException;
	public String deleteBuyer(String buyerId) throws UserException;
	public String deleteSeller(String sellerId) throws UserException;
	void cart();
    public void addProductToWishList(WishlistDTO wishlistdto);
    public String addToCart(CartDTO cartDTO) throws UserException;
    public WishlistDTO wishlistData(String buyerId,String productId);
    public CartDTO cartData(String buyerId,String prodId,int quantity); 
	

}
