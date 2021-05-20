package com.example.productms.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.example.productms.dto.ProdDTO;
import com.example.productms.service.ProdService;

@RestController
@RequestMapping(value="whishlist")
public class ProdController {
    @Autowired
    ProdService prodService;
    @Autowired
    Environment envi;
    @PostMapping(value="/add/product")
    public ResponseEntity<String> addProductToWishlist(@RequestBody ProdDTO prodDTO){
    	try {
    		String m=prodService.addProductsToWhishlist(prodDTO);
    		return new ResponseEntity<String>(m+"Prosperously added",HttpStatus.OK);
    		
    	}
    	catch(Exception ex) {
    		return new ResponseEntity<String>(ex.getMessage(),HttpStatus.NOT_FOUND);
    	}
    }
    @PostMapping(value="/remove/product/{prodId}")
    public ResponseEntity<String> removeProductFromWishlist(@PathVariable String prodId){
    	try {
    		String m=prodService.removeProductsFromWhishlist(prodId);
    		return new ResponseEntity<String>(m+"Prosperously deleted",HttpStatus.OK);
    		
    	}
    	catch(Exception ex) {
    		return new ResponseEntity<String>(ex.getMessage(),HttpStatus.NOT_FOUND);
    	}
    }
    @GetMapping(value="/searchby/category/{category}")
    public ResponseEntity<List<ProdDTO>> getProductByCategory(@PathVariable String category) {
    	List<ProdDTO> pD=new ArrayList<>();
    	try {
    		pD=prodService.getProductByCategory(category);
    		return new ResponseEntity<>(pD,HttpStatus.OK);

    	}
    	catch(Exception ex) {
    		throw new ResponseStatusException(HttpStatus.NOT_FOUND,envi.getProperty(ex.getMessage()));
    	}
    	
    }
    @GetMapping(value="/searchby/productname/{category}")
    public ResponseEntity<ProdDTO> getProductByName(@PathVariable String name){
    	ProdDTO pD=null;
    	try {
    		pD=prodService.getProductByName(name);
    	}
    	catch(Exception ex) {
    		ex.printStackTrace();
    		throw new ResponseStatusException(HttpStatus.NOT_FOUND,envi.getProperty(ex.getLocalizedMessage()),ex);
    	}
    	return new ResponseEntity<ProdDTO>(pD,HttpStatus.OK);
    }
    
    
    
}
