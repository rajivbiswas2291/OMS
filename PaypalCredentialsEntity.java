package com.msr.oms.entity;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "paypal_credentials")
public class PaypalCredentialsEntity implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -977274579975212374L;

	private Long credentialsId;

	private String clientId;

	private String clientSecret;

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "credentials_id", unique = true)
	public Long getCredentialsId() {
		return credentialsId;
	}

	public void setCredentialsId(Long credentialsId) {
		this.credentialsId = credentialsId;
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

}
