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

import com.msr.oms.entity.Customer;
import com.msr.oms.entity.Manufacturers;

/**
 * The Class BillingAddress.
 */
@Entity
@Table(name = "billing_address")
public class BillingAddress implements java.io.Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 6200712297460527449L;

	/** The billing address id. */
	private Long billingAddressId;

	/** The billing address name. */
	private String billingAddressName;

	/** The billing address line 1. */
	private String address;

	private String firstName;

	private String lastName;

	private String googleAddress;

	private String streetAddress;

	/** The billing address suburb. */
	private String billingAddressSuburb;

	/** The billing address city. */
	private String billingAddressCity;

	/** The billing address state. */
	private String billingAddressState;

	/** The billing address zipcode. */
	private Integer billingAddressZipcode;

	/** The billing address email. */
	private String billingAddressEmail;

	/** The billing address phonenumber. */
	private Long billingAddressPhonenumber;

	/** The manufacturers. */
	private Manufacturers manufacturers;

	/** The customer. */
	private Customer customer;
	
	/** The customer. */
	private InfluencerEntity influencer;

	/** The created on. */
	private Date createdOn;

	/** The created by. */
	private String createdBy;

	//** The order. */
	private Orders order;
	  
	  
	 /** The order. */
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "order_id", nullable = false)
	public Orders getOrder() {
		return order;
	}

	 /**
		 * Sets the order.
		 *
		 * @param order the new order
		 */
	public void setOrder(Orders order) {
		this.order = order;
	}
			 

	/**
	 * Gets the billing address id.
	 *
	 * @return the billing address id
	 */
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "billing_address_id", unique = true, nullable = false)
	public Long getBillingAddressId() {
		return billingAddressId;
	}

	/**
	 * Sets the billing address id.
	 *
	 * @param billingAddressId the new billing address id
	 */
	public void setBillingAddressId(Long billingAddressId) {
		this.billingAddressId = billingAddressId;
	}

	/**
	 * Gets the billing address name.
	 *
	 * @return the billing address name
	 */
	@Column(name = "billing_address_name")
	public String getBillingAddressName() {
		return billingAddressName;
	}

	/**
	 * Sets the billing address name.
	 *
	 * @param billingAddressName the new billing address name
	 */
	public void setBillingAddressName(String billingAddressName) {
		this.billingAddressName = billingAddressName;
	}

	/**
	 * Gets the billing address line 1.
	 *
	 * @return the billing address line 1
	 */
	@Column(name = "address")
	public String getAddress() {
		return address;
	}

	/**
	 * Sets the billing address line 1.
	 *
	 * @param billingAddressLine1 the new billing address line 1
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * @return the firstName
	 */
	@Column(name = "first_name")
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	@Column(name = "last_name")
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the googleAddress
	 */
	@Column(name = "google_address")
	public String getGoogleAddress() {
		return googleAddress;
	}

	/**
	 * @param googleAddress the googleAddress to set
	 */
	public void setGoogleAddress(String googleAddress) {
		this.googleAddress = googleAddress;
	}

	/**
	 * @return the streetAddress
	 */
	@Column(name = "street_address")
	public String getStreetAddress() {
		return streetAddress;
	}

	/**
	 * @param streetAddress the streetAddress to set
	 */
	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}

	/**
	 * Gets the billing address suburb.
	 *
	 * @return the billing address suburb
	 */
	@Column(name = "billing_address_suburb")
	public String getBillingAddressSuburb() {
		return billingAddressSuburb;
	}

	/**
	 * Sets the billing address suburb.
	 *
	 * @param billingAddressSuburb the new billing address suburb
	 */
	public void setBillingAddressSuburb(String billingAddressSuburb) {
		this.billingAddressSuburb = billingAddressSuburb;
	}

	/**
	 * Gets the billing address city.
	 *
	 * @return the billing address city
	 */
	@Column(name = "billing_address_city")
	public String getBillingAddressCity() {
		return billingAddressCity;
	}

	/**
	 * Sets the billing address city.
	 *
	 * @param billingAddressCity the new billing address city
	 */
	public void setBillingAddressCity(String billingAddressCity) {
		this.billingAddressCity = billingAddressCity;
	}

	/**
	 * Gets the billing address state.
	 *
	 * @return the billing address state
	 */
	@Column(name = "billing_address_state")
	public String getBillingAddressState() {
		return billingAddressState;
	}

	/**
	 * Sets the billing address state.
	 *
	 * @param billingAddressState the new billing address state
	 */
	public void setBillingAddressState(String billingAddressState) {
		this.billingAddressState = billingAddressState;
	}

	/**
	 * Gets the billing address zipcode.
	 *
	 * @return the billing address zipcode
	 */
	@Column(name = "billing_address_zipcode")
	public Integer getBillingAddressZipcode() {
		return billingAddressZipcode;
	}

	/**
	 * Sets the billing address zipcode.
	 *
	 * @param billingAddressZipcode the new billing address zipcode
	 */
	public void setBillingAddressZipcode(Integer billingAddressZipcode) {
		this.billingAddressZipcode = billingAddressZipcode;
	}

	/**
	 * Gets the billing address email.
	 *
	 * @return the billing address email
	 */
	@Column(name = "billing_address_email")
	public String getBillingAddressEmail() {
		return billingAddressEmail;
	}

	/**
	 * Sets the billing address email.
	 *
	 * @param billingAddressEmail the new billing address email
	 */
	public void setBillingAddressEmail(String billingAddressEmail) {
		this.billingAddressEmail = billingAddressEmail;
	}

	/**
	 * Gets the billing address phonenumber.
	 *
	 * @return the billing address phonenumber
	 */
	@Column(name = "billing_address_phonenumber")
	public Long getBillingAddressPhonenumber() {
		return billingAddressPhonenumber;
	}

	/**
	 * Sets the billing address phonenumber.
	 *
	 * @param billingAddressPhonenumber the new billing address phonenumber
	 */
	public void setBillingAddressPhonenumber(Long billingAddressPhonenumber) {
		this.billingAddressPhonenumber = billingAddressPhonenumber;
	}

	/**
	 * Gets the manufacturers.
	 *
	 * @return the manufacturers
	 */
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "manufacturer_id", nullable = false)
	public Manufacturers getManufacturers() {
		return manufacturers;
	}

	/**
	 * Sets the manufacturers.
	 *
	 * @param manufacturers the manufacturers to set
	 */
	public void setManufacturers(Manufacturers manufacturers) {
		this.manufacturers = manufacturers;
	}

	/**
	 * @return the createdOn
	 */
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_on")
	public Date getCreatedOn() {
		return createdOn;
	}

	/**
	 * @param createdOn the createdOn to set
	 */
	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	/**
	 * @return the createdBy
	 */
	@Column(name = "created_by")
	public String getCreatedBy() {
		return createdBy;
	}

	/**
	 * @param createdBy the createdBy to set
	 */
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	/**
	 * @return the customer
	 */
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "customer_id", nullable = false)
	public Customer getCustomer() {
		return customer;
	}

	/**
	 * @param customer the customer to set
	 */
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	/**
	 * @return the influencer
	 */
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "influencer_id", nullable = false)
	public InfluencerEntity getInfluencer() {
		return influencer;
	}

	/**
	 * @param influencer the influencer to set
	 */
	public void setInfluencer(InfluencerEntity influencer) {
		this.influencer = influencer;
	}

}
