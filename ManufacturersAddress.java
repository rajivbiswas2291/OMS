package com.msr.oms.entity;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * The Class ManufacturersAddress.
 */
@Entity
@Table(name = "manufacturers_address")
public class ManufacturersAddress implements java.io.Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -5018974745152237073L;

	/** The manufacturers address id. */
	private Long manufacturersAddressId;
	
	/** The manufacturers address name. */
	private String manufacturersAddressName;
	
	/** The address line 1. */
	private String addressLine1;

	/** The address line 2. */
	private String addressLine2;

	/** The suburb. */
	private String suburb;

	/** The city. */
	private String city;

	/** The state. */
	private String state;

	/** The zipcode. */
	private Integer zipCode;

	/** The email. */
	private String emailAddress;

	/** The phone. */
	private Long phone;

	/** The status. */
	private boolean status;

	/** The created on. */
	private Date createdOn;

	/** The created by. */
	private String createdBy;
	
	/** The manufacturers. */
	private Manufacturers manufacturers ;
	/**
	 * Gets the manufacturers address id.
	 *
	 * @return the manufacturers address id
	 */
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "manufacturers_address_id", unique = true, nullable = false)
	public Long getManufacturersAddressId() {
		return manufacturersAddressId;
	}

	public void setManufacturersAddressId(Long manufacturersAddressId) {
		this.manufacturersAddressId = manufacturersAddressId;
	}

	/**
	 * Gets the manufacturers address name.
	 *
	 * @return the manufacturers address name
	 */
	@Column(name = "manufacturers_address_name")
	public String getManufacturersAddressName() {
		return manufacturersAddressName;
	}

	public void setManufacturersAddressName(String manufacturersAddressName) {
		this.manufacturersAddressName = manufacturersAddressName;
	}

	/**
	 * Gets the address line 1.
	 *
	 * @return the address line 1
	 */
	@Column(name = "address_line1")
	public String getAddressLine1() {
		return addressLine1;
	}

	/**
	 * Sets the address line 1.
	 *
	 * @param addressLine1 the new address line 1
	 */
	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	/**
	 * Gets the address line 2.
	 *
	 * @return the address line 2
	 */
	@Column(name = "address_line2")
	public String getAddressLine2() {
		return addressLine2;
	}

	/**
	 * Sets the address line 2.
	 *
	 * @param addressLine2 the new address line 2
	 */
	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

	/**
	 * Gets the suburb.
	 *
	 * @return the suburb
	 */
	@Column(name = "suburb")
	public String getSuburb() {
		return suburb;
	}

	/**
	 * Sets the suburb.
	 *
	 * @param suburb the new suburb
	 */
	public void setSuburb(String suburb) {
		this.suburb = suburb;
	}

	/**
	 * Gets the city.
	 *
	 * @return the city
	 */
	@Column(name = "city")
	public String getCity() {
		return city;
	}

	/**
	 * Sets the city.
	 *
	 * @param city the new city
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * Gets the state.
	 *
	 * @return the state
	 */
	@Column(name = "state")
	public String getState() {
		return state;
	}

	/**
	 * Sets the state.
	 *
	 * @param state the new state
	 */
	public void setState(String state) {
		this.state = state;
	}

	/**
	 * Gets the zip code.
	 *
	 * @return the zip code
	 */
	@Column(name = "zipcode")
	public Integer getZipCode() {
		return zipCode;
	}

	/**
	 * Sets the zip code.
	 *
	 * @param zipCode the new zip code
	 */
	public void setZipCode(Integer zipCode) {
		this.zipCode = zipCode;
	}

	/**
	 * Gets the email.
	 *
	 * @return the email
	 */
	@Column(name = "email_address")
	public String getEmailAddress() {
		return emailAddress;
	}

	/**
	 * Sets the email.
	 *
	 * @param email the new email
	 */
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	/**
	 * Gets the phone.
	 *
	 * @return the phone
	 */
	@Column(name = "phone_number")
	public Long getPhone() {
		return phone;
	}

	/**
	 * Sets the phone.
	 *
	 * @param phone the new phone
	 */
	public void setPhone(Long phone) {
		this.phone = phone;
	}

	/**
	 * Checks if is status.
	 *
	 * @return true, if is status
	 */
	@Column(name = "status")
	public boolean isStatus() {
		return status;
	}

	/**
	 * Sets the status.
	 *
	 * @param status the new status
	 */
	public void setStatus(boolean status) {
		this.status = status;
	}

	/**
	 * Gets the created on.
	 *
	 * @return the created on
	 */
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_on")
	public Date getCreatedOn() {
		return createdOn;
	}

	/**
	 * Sets the created on.
	 *
	 * @param createdOn the new created on
	 */
	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	/**
	 * Gets the created by.
	 *
	 * @return the created by
	 */
	@Column(name = "created_by")
	public String getCreatedBy() {
		return createdBy;
	}

	/**
	 * Sets the created by.
	 *
	 * @param createdBy the new created by
	 */
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "manufacturer_id")
	public Manufacturers getManufacturers() {
		return manufacturers;
	}

	public void setManufacturers(Manufacturers manufacturers) {
		this.manufacturers = manufacturers;
	}
}
