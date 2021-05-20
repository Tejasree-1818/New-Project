package com.example.dto;



public class SellerDTO {
	private String sellerId;
	private String name;
	private String emailId;
	private String phoneNumber;
	private String password;
	//private Integer rewardPoints;
	private String isActive;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	public String getSellerId() {
		return sellerId;
	}
	public void setSellerId(String sellerId) {
		this.sellerId = sellerId;
	}
	public String getIsActive() {
		return isActive;
	}
	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}
//	@Override
//	public int hashCode()
//	{
//	final int prime=31;
//	int result=1;
//	result=prime * result +((sellerId==null) ? 0: sellerId.hashCode());
//	return result;
//	}
//	
//	
//	@Override
//	  public boolean equals(Object obj)
//	  {
//	      if(this ==obj)
//	         return true;
//	      if(obj==null)
//	         return false;
//	      if(getClass()!=obj.getClass())
//	         return false;
//	      SellerDTO sDTO= (SellerDTO) obj;
//	      if(sellerId==null){
//	         if(sDTO.sellerId != null)
//	              return false;
//	      }
//	      else if (!sellerId.equals(sDTO.sellerId))
//	               return false;
//	      return true;
//
//	}


}
