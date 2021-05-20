package com.example.productms.validator;

import com.example.productms.dto.ProdDTO;

public class ProdValidator {
   public static boolean ValidateProd(ProdDTO prodDTO) throws Exception{
	   if(!isValidName(prodDTO.getProductName()))
		   throw new Exception("ProductName is not valid ");
	   else if(!isValidDescr(prodDTO.getDescription()))
		   throw new Exception("Description Should be of atleast 500 characters");
	   else if(!isValidPrice(prodDTO.getPrice()))
		   throw new Exception("Price of the Product should be of atleast 200");
	   else if(!isValidStock(prodDTO.getStock()))
		   throw new Exception("Stock of the Product should be of atleast 10");
	   else if(!isValidImage(prodDTO.getImage()))
		   throw new Exception("Image of the Product is not in the proper format");
	   return true;
   }
   public static boolean isValidName(String prodName) {
	   String reg="^([A-Za-z]+([][A-Za-z]+)*){1,100}$";
	   if(prodName.matches(reg)) return true;
	   else return false;
   }
   public static boolean isValidDescr(String descr) {
	   String reg="^([A-Za-z]+){1,500}$";
	   if(descr.matches(reg)) return true;
	   else return false;
   }
   public static boolean isValidPrice(float p) {
	   if(p<=199) return false;
	   else return true;
   }
   public static boolean isValidStock(float s) {
	   if(s<=9) return false;
	   else return true;
   }
   public static boolean isValidImage(String img) {
	   String reg="^[A-Za-z0-9]+(.jpeg|.png)$";
	   if(img.matches(reg)) return true;
	   else return false;
   }
   
}
