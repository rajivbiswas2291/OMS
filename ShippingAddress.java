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

// TODO: Auto-generated Javadoc
/**
 * The Class ShippingAddress.
 */
@Entity
@Table(name = "shipping_address")
public class ShippingAddress implements java.io.Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 6200712297460527449L;

	/** The shipping address id. */
	private Long shippingAddressId;

	/** The first name. */
	private String firstName;

	/** The last name. */
	private String lastName;

	/** The google address. */
	private String googleAddress;

	/** The street address. */
	private String streetAddress;

	/** The address. */
	private String address;

	/** The shipping address name. */
	private String shippingAddressName;

	/** The shipping address suburb. */
	private String shippingAddressSuburb;

	/** The shipping address city. */
	private String shippingAddressCity;

	/** The shipping address state. */
	private String shippingAddressState;

	/** The shipping address zipcode. */
	private Integer shippingAddressZipcode;

	/** The shipping address email. */
	private String shippingAddressEmail;

	/** The shipping address phonenumber. */
	private Long shippingAddressPhonenumber;

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

	/** The order. */
	private Orders order;
	
	/**
	 * Gets the first name.
	 *
	 * @return the first name
	 */
	@Column(name = "first_name")
	public String getFirstName() {
		return firstName;
	}

	/**
	 * Sets the first name.
	 *
	 * @param firstName the new first name
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * Gets the last name.
	 *
	 * @return the last name
	 */
	@Column(name = "last_name")
	public String getLastName() {
		return lastName;
	}

	/**
	 * Sets the last name.
	 *
	 * @param lastName the new last name
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * Gets the google address.
	 *
	 * @return the google address
	 */
	@Column(name = "google_address")
	public String getGoogleAddress() {
		return googleAddress;
	}

	/**
	 * Sets the google address.
	 *
	 * @param googleAddress the new google address
	 */
	public void setGoogleAddress(String googleAddress) {
		this.googleAddress = googleAddress;
	}

	/**
	 * Gets the street address.
	 *
	 * @return the street address
	 */
	@Column(name = "street_address")
	public String getStreetAddress() {
		return streetAddress;
	}

	/**
	 * Sets the street address.
	 *
	 * @param streetAddress the new street address
	 */
	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}

	/**
	 * Gets the address.
	 *
	 * @return the address
	 */
	@Column(name = "address")
	public String getAddress() {
		return address;
	}

	/**
	 * Sets the address.
	 *
	 * @param address the new address
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	
	  
	  
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
	 * Gets the shipping address id.
	 *
	 * @return the shipping address id
	 */
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "shipping_address_id", unique = true, nullable = false)
	public Long getShippingAddressId() {
		return shippingAddressId;
	}

	/**
	 * Sets the shipping address id.
	 *
	 * @param shippingAddressId the new shipping address id
	 */
	public void setShippingAddressId(Long shippingAddressId) {
		this.shippingAddressId = shippingAddressId;
	}

	/**
	 * Gets the shipping address name.
	 *
	 * @return the shipping address name
	 */
	@Column(name = "shipping_address_name")
	public String getShippingAddressName() {
		return shippingAddressName;
	}

	/**
	 * Sets the shipping address name.
	 *
	 * @param shippingAddressName the new shipping address name
	 */
	public void setShippingAddressName(String shippingAddressName) {
		this.shippingAddressName = shippingAddressName;
	}

	/**
	 * Gets the shipping address suburb.
	 *
	 * @return the shipping address suburb
	 */
	@Column(name = "shipping_address_suburb")
	public String getShippingAddressSuburb() {
		return shippingAddressSuburb;
	}

	/**
	 * Sets the shipping address suburb.
	 *
	 * @param shippingAddressSuburb the new shipping address suburb
	 */
	public void setShippingAddressSuburb(String shippingAddressSuburb) {
		this.shippingAddressSuburb = shippingAddressSuburb;
	}

	/**
	 * Gets the shipping address city.
	 *
	 * @return the shipping address city
	 */
	@Column(name = "shipping_address_city")
	public String getShippingAddressCity() {
		return shippingAddressCity;
	}

	/**
	 * Sets the shipping address city.
	 *
	 * @param shippingAddressCity the new shipping address city
	 */
	public void setShippingAddressCity(String shippingAddressCity) {
		this.shippingAddressCity = shippingAddressCity;
	}

	/**
	 * Gets the shipping address state.
	 *
	 * @return the shipping address state
	 */
	@Column(name = "shipping_address_state")
	public String getShippingAddressState() {
		return shippingAddressState;
	}

	/**
	 * Sets the shipping address state.
	 *
	 * @param shippingAddressState the new shipping address state
	 */
	public void setShippingAddressState(String shippingAddressState) {
		this.shippingAddressState = shippingAddressState;
	}

	/**
	 * Gets the shipping address zipcode.
	 *
	 * @return the shipping address zipcode
	 */
	@Column(name = "shipping_address_zipcode")
	public Integer getShippingAddressZipcode() {
		return shippingAddressZipcode;
	}

	/**
	 * Sets the shipping address zipcode.
	 *
	 * @param shippingAddressZipcode the new shipping address zipcode
	 */
	public void setShippingAddressZipcode(Integer shippingAddressZipcode) {
		this.shippingAddressZipcode = shippingAddressZipcode;
	}

	/**
	 * Gets the shipping address email.
	 *
	 * @return the shipping address email
	 */
	@Column(name = "shipping_address_email")
	public String getShippingAddressEmail() {
		return shippingAddressEmail;
	}

	/**
	 * Sets the shipping address email.
	 *
	 * @param shippingAddressEmail the new shipping address email
	 */
	public void setShippingAddressEmail(String shippingAddressEmail) {
		this.shippingAddressEmail = shippingAddressEmail;
	}

	/**
	 * Gets the shipping address phonenumber.
	 *
	 * @return the shipping address phonenumber
	 */
	@Column(name = "shipping_address_phonenumber")
	public Long getShippingAddressPhonenumber() {
		return shippingAddressPhonenumber;
	}

	/**
	 * Sets the shipping address phonenumber.
	 *
	 * @param shippingAddressPhonenumber the new shipping address phonenumber
	 */
	public void setShippingAddressPhonenumber(Long shippingAddressPhonenumber) {
		this.shippingAddressPhonenumber = shippingAddressPhonenumber;
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
	 * Gets the created on.
	 *
	 * @return the createdOn
	 */
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_on")
	public Date getCreatedOn() {
		return createdOn;
	}

	/**
	 * Sets the created on.
	 *
	 * @param createdOn the createdOn to set
	 */
	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	/**
	 * Gets the created by.
	 *
	 * @return the createdBy
	 */
	@Column(name = "created_by")
	public String getCreatedBy() {
		return createdBy;
	}

	/**
	 * Sets the created by.
	 *
	 * @param createdBy the createdBy to set
	 */
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	/**
	 * Gets the customer.
	 *
	 * @return the customer
	 */
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "customer_id", nullable = false)
	public Customer getCustomer() {
		return customer;
	}

	/**
	 * Sets the customer.
	 *
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
