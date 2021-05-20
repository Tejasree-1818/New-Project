package com.example.entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Buyer {

@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
@Column(name = "buyer_id")
private String buyerId;
public String getBuyerId() {
	return buyerId;
}
public void setBuyerId(String buyerId) {
	this.buyerId = buyerId;
}
private String name;
@Column(name = "email_id")
private String emailId;
@Column(name = "phone_number")
private String phoneNumber;
private String password;
@Column(name = "is_piviledged")
private String isPrivilaged;
public String getIsPrivilaged() {
	return isPrivilaged;
}
public void setIsPrivilaged(String isPrivilaged) {
	this.isPrivilaged = isPrivilaged;
}
public Integer getRewardPoints() {
	return rewardPoints;
}
public void setRewardPoints(Integer rewardPoints) {
	this.rewardPoints = rewardPoints;
}
public String getIsActive() {
	return isActive;
}
public void setIsActive(String isActive) {
	this.isActive = isActive;
}
@Column(name = "reward_points")
private Integer rewardPoints;

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

//@Override
//public int hashCode()
//{
//final int prime=31;
//int result=1;
//result=prime * result +((buyerId==null) ? 0: buyerId.hashCode());
//return result;
//}
//  @Override
//  public boolean equals(Object obj)
//  {
//      if(this ==obj)
//         return true;
//      if(obj==null)
//         return false;
//      if(getClass()!=obj.getClass())
//         return false;
//      Buyer buyer= (Buyer) obj;
//      if(buyerId==null){
//         if(buyer.buyerId != null)
//              return false;
//      }
//      else if (!buyerId.equals(buyer.buyerId))
//               return false;
//      return true;
//
//}

}
