package com.msr.oms.dto;

import com.msr.oms.entity.Manufacturers;

public class ManufacturersApiCredentialsDto {

	private Long manufacturerDetailsId;

	private Long manufactureId;

	private String manufacturerName;

	private String clientId;

	private String clientSecret;

	private String grantType;

	private String userName;
	
	private boolean status;

	public Long getManufacturerDetailsId() {
		return manufacturerDetailsId;
	}

	public void setManufacturerDetailsId(Long manufacturerDetailsId) {
		this.manufacturerDetailsId = manufacturerDetailsId;
	}

	public Long getManufactureId() {
		return manufactureId;
	}

	public void setManufactureId(Long manufactureId) {
		this.manufactureId = manufactureId;
	}

	public String getManufacturerName() {
		return manufacturerName;
	}

	public void setManufacturerName(String manufacturerName) {
		this.manufacturerName = manufacturerName;
	}

	public String getClientId() {
		return clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	public String getClientSecret() {
		return clientSecret;
	}

	public void setClientSecret(String clientSecret) {
		this.clientSecret = clientSecret;
	}

	public String getGrantType() {
		return grantType;
	}

	public void setGrantType(String grantType) {
		this.grantType = grantType;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}
	
}
