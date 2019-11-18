package com.msr.oms.entity;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "manufacturer_api_details")
public class ManufacturersApiCredentials implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6864110736592289326L;

	private Long manufacturerDetailsId;

	private Manufacturers manufacturers;

	private String manufacturerName;

	private String clientId;

	private String clientSecret;

	private String grantType;

	private String userName;
	
	private boolean status;

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "manufacturer_details_id", unique = true)
	public Long getManufacturerDetailsId() {
		return manufacturerDetailsId;
	}

	public void setManufacturerDetailsId(Long manufacturerDetailsId) {
		this.manufacturerDetailsId = manufacturerDetailsId;
	}
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "manufacturer_id" )
	public Manufacturers getManufacturers() {
		return manufacturers;
	}

	public void setManufacturers(Manufacturers manufacturers) {
		this.manufacturers = manufacturers;
	}
	@Column(name = "manufacturer_name")
	public String getManufacturerName() {
		return manufacturerName;
	}

	public void setManufacturerName(String manufacturerName) {
		this.manufacturerName = manufacturerName;
	}
	@Column(name = "client_id")
	public String getClientId() {
		return clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}
	@Column(name = "client_secret")
	public String getClientSecret() {
		return clientSecret;
	}

	public void setClientSecret(String clientSecret) {
		this.clientSecret = clientSecret;
	}
	@Column(name = "grant_type")
	public String getGrantType() {
		return grantType;
	}

	public void setGrantType(String grantType) {
		this.grantType = grantType;
	}
	@Column(name = "username")
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	

	private String password;

	@Column(name = "password")
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	@Column(name = "status")
	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}
	
	

}
