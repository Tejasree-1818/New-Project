package com.example.productms.service;

import java.util.List;

import com.example.productms.dto.ProdDTO;

public interface ProdService {
	public String addProductsToWhishlist(ProdDTO prodDTO) throws Exception;
	public String removeProductsFromWhishlist(String prodId) throws Exception;
	public List<ProdDTO> getProductByCategory(String category) throws Exception;
	public ProdDTO getProductByName(String prodName) throws Exception;
}
