package com.example.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dto.BuyerDTO;
import com.example.dto.CartDTO;
import com.example.dto.SellerDTO;
import com.example.dto.WishlistDTO;
import com.example.entity.Buyer;
import com.example.entity.Cart;
import com.example.entity.CompositeKey;
import com.example.entity.Seller;
import com.example.entity.Wishlist;
import com.example.exception.UserException;
import com.example.productms.validator.UserValidator;
import com.example.repository.BuyerRepository;
import com.example.repository.CartRepositoty;
import com.example.repository.SellerRepository;
import com.example.repository.WishListRepository;


@Service(value="userImpl")
@Transactional
public class UserServiceImpl implements UserService{
	
	@Autowired
	UserValidator v;
	
	@Autowired
	BuyerRepository BuyerRepository;

	@Autowired
	SellerRepository sellerRepository;
	
	@Autowired
	WishListRepository wishlistRepository;

	@Autowired
	CartRepositoty cartRepository;
	@Override
	public String registerBuyer(BuyerDTO buyerdto) {
		
		if(v.validateBuyer(buyerdto)) {
		Buyer buyer=new Buyer();
		buyer.setBuyerId(buyerdto.getBuyerId());
		buyer.setEmailId(buyerdto.getEmailId());
		buyer.setName(buyerdto.getName());
		buyer.setPassword(buyerdto.getPassword());
		buyer.setIsActive(buyerdto.getIsActive());
		buyer.setPhoneNumber(buyerdto.getPhoneNumber());
		buyer.setIsPrivilaged( buyerdto.getIsPrivilaged());
		buyer.setRewardPoints(buyerdto.getRewardPoints());
		System.out.println(BuyerRepository.save(buyer));
		return buyer.getBuyerId();
		}	
		else return null;
	
		}

	@Override
	public String registerSeller(SellerDTO sellerdto) {
		// TODO Auto-generated method stub
		if(v.validateSeller(sellerdto))
		{
		Seller seller= new Seller();
		seller.setSellerId(sellerdto.getSellerId());
		seller.setEmailId(sellerdto.getEmailId());
		seller.setName(sellerdto.getName());
		seller.setIsActive(sellerdto.getIsActive());
		seller.setPassword(sellerdto.getPassword());
		seller.setPhoneNumber(sellerdto.getPhoneNumber());
		sellerRepository.save(seller);
		return seller.getSellerId();
		}
		else 
			return null;
	}

	@Override
	public String buyerLogin(String emailId,String password) throws UserException{
		//System.out.println(emailId);
		Optional<Buyer> email=BuyerRepository.findByEmailId(emailId);
		if(email.isEmpty()){
			throw new UserException("Service.INVALID_CREDENTIALS");
		}
		if(email.get().getPassword().equals(password)) {
			BuyerDTO b=new BuyerDTO();
			b.setEmailId(emailId);
			b.setPassword(password);
			b.setIsActive("Yes");
			return "Successfully logged in";
		   
		}
	    else
			return "login unsuccessful";
			
	}

	@Override
	public String sellerLogin(String emailId,String password) throws UserException{
		// TODO Auto-generated method stub
		System.out.println(emailId);
		Optional<Seller> emailSeller = sellerRepository.findByEmail(emailId);
		if(emailSeller.isEmpty())
			throw new UserException("Service.INVALID_CREDENTIALS"); 
		if(emailSeller.get().getPassword().equals(password)) {
		SellerDTO sellerdto=new SellerDTO();
		sellerdto.setEmailId(emailId);
		sellerdto.setPassword(password);
		sellerdto.setIsActive("yes");
		return "Successfully logged in";}else
			return "login unsuccessful";

	}

	@Override
	public String deleteBuyer(String buyerId) throws UserException{
		// TODO Auto-generated method stub
		Optional<Buyer> buyerDelete = BuyerRepository.findById(buyerId);
		if(buyerDelete.isEmpty())
			throw new UserException("Service.USER_NOT_FOUND"); 
		BuyerRepository.deleteById(buyerId);
		
		return "Deleted successfully";
	}

	@Override
	public String deleteSeller(String selId) throws UserException{
		
		Optional<Seller> dltSeller = sellerRepository.findById(selId);
		if(dltSeller.isEmpty())
			throw new UserException("Service.USER_NOT_FOUND"); 
		sellerRepository.deleteById(selId);
		return "Deleted successfully";
	}
	
	
	@Override
	public void cart() {
		Cart cart=new Cart();
		CompositeKey ct=new CompositeKey();
		ct.setProdId("P102");
		cart.setCompositekey(ct);
		cart.setQuantity(100);
		cartRepository.save(cart);
	}

	@Override
	public WishlistDTO wishlistData(String buyerId,String productId) {
		
		Wishlist wish=new Wishlist();
		CompositeKey ct=new CompositeKey();
		ct.setBuyerId(buyerId);
		ct.setProdId(productId);
		wish.setCompositekey(ct);;
		wishlistRepository.save(wish);
		WishlistDTO wishDTO=new WishlistDTO();
		wishDTO.setBuyerId(wish.getCompositekey().getBuyerId());
		wishDTO.setProdId(wish.getCompositekey().getProdId());
		return wishDTO;
	}
	

	@Override
    public void addProductToWishList(WishlistDTO wishlistdto) {
		Wishlist wishlist =wishlistdto.createE();
		wishlistRepository.save(wishlist);
	}

	@Override
	public String addToCart(CartDTO cartDTO) throws UserException{
		
		CompositeKey c=new CompositeKey();
		c.setBuyerId(cartDTO.getBuyerId());
		c.setProdId(cartDTO.getProdId());
		Optional<Wishlist> dataProduct = wishlistRepository.findById(c);
		try {
			if(dataProduct.isEmpty())
				throw new UserException("Service.USER_NOT_FOUND");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		Cart cart=new Cart();
		cart.setCompositekey(c);
		cart.setQuantity(cartDTO.getQuantity());
		cartRepository.save(cart);
		wishlistRepository.deleteById(c);
		return "successfully added idem to cart from wishlist";
	}

	@Override
	public CartDTO cartData(String buyerId, String prodId,int quantity) {
		Cart c=new Cart();
		CompositeKey ct=new CompositeKey();
		ct.setBuyerId(buyerId);
		ct.setProdId(prodId);
		c.setCompositekey(ct);
		c.setQuantity(quantity);
		cartRepository.save(c);
		CartDTO cDTO=new CartDTO();
		cDTO.setBuyerId(c.getCompositekey().getBuyerId());
		cDTO.setProdId(c.getCompositekey().getProdId());
		cDTO.setQuantity(c.getQuantity());
		return cDTO;
	}

	
	

}
