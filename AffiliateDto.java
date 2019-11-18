package com.msr.oms.dto;

public class AffiliateDto {
	
	
	private Long affiliateId;

	private String name;

	private String emailAddress;
	 
	private String comapnyCode;
	
	private String phoneNumber;
	
	private String type;
	
	
	public Long getAffiliateId() {
		return affiliateId;
	}

	public void setAffiliateId(Long affiliateId) {
		this.affiliateId = affiliateId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getComapnyCode() {
		return comapnyCode;
	}

	public void setComapnyCode(String comapnyCode) {
		this.comapnyCode = comapnyCode;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	

}
