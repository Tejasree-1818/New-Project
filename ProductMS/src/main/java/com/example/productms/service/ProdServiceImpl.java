package com.example.productms.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.productms.dto.ProdDTO;
import com.example.productms.entity.ProdEntity;
import com.example.productms.repository.ProdRepo;
import com.example.productms.validator.ProdValidator;

@Service
@Transactional
public class ProdServiceImpl implements ProdService{
   @Autowired
   ProdRepo prodRepo;
    @Override
    @Transactional
    public String addProductsToWhishlist(ProdDTO prodDTO) throws Exception{
    	try {
    		if(ProdValidator.ValidateProd(prodDTO)) {
    			ProdEntity p=new ProdEntity();
    			p.setProdId(prodDTO.getProdId());
    			p.setProductName(prodDTO.getProductName());
    			p.setDescription(prodDTO.getDescription());
    			p.setImage(prodDTO.getImage());
    			p.setCategory(prodDTO.getCategory());
    			p.setSubcategory(prodDTO.getSubcategory());
    			p.setPrice(prodDTO.getPrice());
    			p.setStock(prodDTO.getStock());
    			p.setProductRating(prodDTO.getProductRating());
    			p.setSellerId(prodDTO.getSellerId());
    			System.out.println(prodRepo.save(p));
    			return p.getprodId();
    		}
    	}
    	catch(Exception e) {
    		System.out.println(e.getMessage());
    		return e.getMessage();
    	}
    	return null;
    }
    @Override
    @Modifying
    @Transactional
	public String removeProductsFromWhishlist(String prodId) throws Exception{
		Optional<ProdEntity> p=prodRepo.findById(prodId);
		if(p.isEmpty())
			throw new Exception("You are not able to delete the product because product is unavailable");
		prodRepo.deleteById(prodId);
		String msg="You the deleted the product Successfully";
		return msg;
	}
    @Override
	public List<ProdDTO> getProductByCategory(String category) throws Exception{
        List<ProdEntity> c=prodRepo.findByCategory(category);
        List<ProdDTO> pD=new ArrayList<>();
        if(c.isEmpty())
			throw new Exception("Product is unavailable for Such Category");
        for(ProdEntity pE:c) {
        	ProdDTO pD1=new ProdDTO();
        	pD1.setProdId(pE.getprodId());
        	pD1.setProductName(pE.getProductName());
        	pD1.setCategory(pE.getCategory());
        	pD1.setSubcategory(pE.getSubcategory());
        	pD1.setProductRating(pE.getProductRating());
        	pD1.setPrice(pE.getPrice());
        	pD1.setImage(pE.getImage());
        	pD1.setStock(pE.getStock());
        	pD1.setSellerId(pE.getSellerId());
        	pD.add(pD1);
        	System.out.println(pD);
        }
        return pD;
        

    }
	public ProdDTO getProductByName(String prodName) throws Exception{
		Optional<ProdEntity> c=prodRepo.findByProductName(prodName);
        if(c.isEmpty())
			throw new Exception("Product is unavailable with that name");
       
        ProdDTO pD=new ProdDTO();
		pD.setProdId(c.get().getprodId());
		pD.setCategory(c.get().getCategory());
		pD.setDescription(c.get().getDescription());
		pD.setImage(c.get().getImage());
		pD.setPrice(c.get().getPrice());
		pD.setSubcategory(c.get().getSubcategory());
		pD.setStock(c.get().getStock());
		pD.setProductRating(c.get().getProductRating());
		pD.setSellerId(c.get().getSellerId());
		pD.setProductName(c.get().getProductName());
		return pD;
        	
   
    }
}
	


