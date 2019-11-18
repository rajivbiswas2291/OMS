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

// TODO: Auto-generated Javadoc
/**
 * The Class Manufacturers.
 */
@Entity
@Table(name = "manufacturers")
public class Manufacturers implements java.io.Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -8879923102743812804L;

	/** The manufacture id. */
	private Long manufactureId;

	/** The manufacturer name. */
	private String manufacturerName;

	/** The manufacturer code. */
	private String manufacturerCode;

	/** The manufacturer phone. */
	private Long manufacturerPhone;

	/** The manufacturer tax number. */
	private String manufacturerTaxNnumber;

	/** The manufacturer fax number. */
	private String manufacturerFaxNumber;

	/** The manufacturer website. */
	private String manufacturerWebsite;

	/** The manufacturer email. */
	private String manufacturerEmail;

	/** The address name. */
	private String addressName;

	/** The address line 1. */
	private String addressLine1;

	/** The address line 2. */
	private String addressLine2;

	/** The suburb. */
	private String suburb;

	/** The city. */
	private String city;

	/** The zipcode. */
	private Integer zipcode;

	/** The state. */
	private String state;

	/** The address email. */
	private String addressEmail;

	/** The address phone number. */
	private Long addressPhoneNumber;
	
	/** The tags. */
	private String tags;
	
	/** The description. */
	private String description; 

	/** The price list master. */
	private PriceListMaster priceListMaster;

	/** The total are master. */
	private TotalAreMaster totalAreMaster;

	/** The created on. */
	private Date createdOn;

	/** The created by. */
	private String createdBy;

	/** The status. */
	private boolean status;
	
	/** The term. */
	private boolean term;

	/** The billing shipping flag. */
	private boolean billingShippingFlag;

	/**
	 * Checks if is term.
	 *
	 * @return the term
	 */
	@Column(name = "term")
	public boolean isTerm() {
		return term;
	}

	/**
	 * Checks if is billing shipping flag.
	 *
	 * @return the billingShippingFlag
	 */
	@Column(name = "billing_shipping_flag")
	public boolean isBillingShippingFlag() {
		return billingShippingFlag;
	}

	/**
	 * Sets the term.
	 *
	 * @param term the term to set
	 */
	public void setTerm(boolean term) {
		this.term = term;
	}

	/**
	 * Sets the billing shipping flag.
	 *
	 * @param billingShippingFlag the billingShippingFlag to set
	 */
	public void setBillingShippingFlag(boolean billingShippingFlag) {
		this.billingShippingFlag = billingShippingFlag;
	}
	
	/**
	 * Gets the manufacture id.
	 *
	 * @return the manufacture id
	 */
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "manufacturer_id", unique = true, nullable = false)
	public Long getManufactureId() {
		return manufactureId;
	}

	/**
	 * Sets the manufacture id.
	 *
	 * @param manufactureId
	 *            the new manufacture id
	 */
	public void setManufactureId(Long manufactureId) {
		this.manufactureId = manufactureId;
	}

	/**
	 * Gets the manufacturer name.
	 *
	 * @return the manufacturer name
	 */
	@Column(name = "manufacturer_name")
	public String getManufacturerName() {
		return manufacturerName;
	}

	/**
	 * Sets the manufacturer name.
	 *
	 * @param manufacturerName
	 *            the new manufacturer name
	 */
	public void setManufacturerName(String manufacturerName) {
		this.manufacturerName = manufacturerName;
	}

	/**
	 * Gets the manufacturer tax nnumber.
	 *
	 * @return the manufacturer tax nnumber
	 */
	@Column(name = "manufacturer_tax_number")
	public String getManufacturerTaxNnumber() {
		return manufacturerTaxNnumber;
	}

	/**
	 * Sets the manufacturer tax nnumber.
	 *
	 * @param manufacturerTaxNnumber
	 *            the new manufacturer tax nnumber
	 */
	public void setManufacturerTaxNnumber(String manufacturerTaxNnumber) {
		this.manufacturerTaxNnumber = manufacturerTaxNnumber;
	}

	/**
	 * Gets the manufacturer fax number.
	 *
	 * @return the manufacturer fax number
	 */
	@Column(name = "manufacturer_fax_number")
	public String getManufacturerFaxNumber() {
		return manufacturerFaxNumber;
	}

	/**
	 * Sets the manufacturer fax number.
	 *
	 * @param manufacturerFaxNumber
	 *            the new manufacturer fax number
	 */
	public void setManufacturerFaxNumber(String manufacturerFaxNumber) {
		this.manufacturerFaxNumber = manufacturerFaxNumber;
	}

	/**
	 * Gets the manufacturer website.
	 *
	 * @return the manufacturer website
	 */
	@Column(name = "manufacturer_website")
	public String getManufacturerWebsite() {
		return manufacturerWebsite;
	}

	/**
	 * Sets the manufacturer website.
	 *
	 * @param manufacturerWebsite
	 *            the new manufacturer website
	 */
	public void setManufacturerWebsite(String manufacturerWebsite) {
		this.manufacturerWebsite = manufacturerWebsite;
	}

	/**
	 * Gets the manufacturer email.
	 *
	 * @return the manufacturer email
	 */
	@Column(name = "manufacturer_email")
	public String getManufacturerEmail() {
		return manufacturerEmail;
	}

	/**
	 * Sets the manufacturer email.
	 *
	 * @param manufacturerEmail
	 *            the new manufacturer email
	 */
	public void setManufacturerEmail(String manufacturerEmail) {
		this.manufacturerEmail = manufacturerEmail;
	}

	/**
	 * Gets the created on.
	 *
	 * @return the created on
	 */
	@Column(name = "created_on")
	public Date getCreatedOn() {
		return createdOn;
	}

	/**
	 * Sets the created on.
	 *
	 * @param createdOn
	 *            the new created on
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
	 * @param createdBy
	 *            the new created by
	 */
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	/**
	 * Gets the manufacturer code.
	 *
	 * @return the manufacturer code
	 */
	@Column(name = "manufacturer_code")
	public String getManufacturerCode() {
		return manufacturerCode;
	}

	/**
	 * Sets the manufacturer code.
	 *
	 * @param manufacturerCode
	 *            the new manufacturer code
	 */
	public void setManufacturerCode(String manufacturerCode) {
		this.manufacturerCode = manufacturerCode;
	}

	/**
	 * Gets the manufacturer phone.
	 *
	 * @return the manufacturer phone
	 */
	@Column(name = "manufacturer_phone")
	public Long getManufacturerPhone() {
		return manufacturerPhone;
	}

	/**
	 * Sets the manufacturer phone.
	 *
	 * @param manufacturerPhone
	 *            the new manufacturer phone
	 */
	public void setManufacturerPhone(Long manufacturerPhone) {
		this.manufacturerPhone = manufacturerPhone;
	}

	/**
	 * Gets the price list master.
	 *
	 * @return the priceListMaster
	 */
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "price_list_id", nullable = false)
	public PriceListMaster getPriceListMaster() {
		return priceListMaster;
	}

	/**
	 * Sets the price list master.
	 *
	 * @param priceListMaster            the priceListMaster to set
	 */
	public void setPriceListMaster(PriceListMaster priceListMaster) {
		this.priceListMaster = priceListMaster;
	}

	/**
	 * Gets the total are master.
	 *
	 * @return the totalAreMaster
	 */
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "total_are_id", nullable = false)
	public TotalAreMaster getTotalAreMaster() {
		return totalAreMaster;
	}

	/**
	 * Sets the total are master.
	 *
	 * @param totalAreMaster            the totalAreMaster to set
	 */
	public void setTotalAreMaster(TotalAreMaster totalAreMaster) {
		this.totalAreMaster = totalAreMaster;
	}

	/**
	 * Gets the address name.
	 *
	 * @return the address name
	 */
	@Column(name = "address_name")
	public String getAddressName() {
		return addressName;
	}

	/**
	 * Sets the address name.
	 *
	 * @param addressName the new address name
	 */
	public void setAddressName(String addressName) {
		this.addressName = addressName;
	}

	/**
	 * Gets the address line 1.
	 *
	 * @return the address line 1
	 */
	@Column(name = "address_line_1")
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
	@Column(name = "address_line_2")
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
	 * Gets the zipcode.
	 *
	 * @return the zipcode
	 */
	@Column(name = "zipcode")
	public Integer getZipcode() {
		return zipcode;
	}

	/**
	 * Sets the zipcode.
	 *
	 * @param zipcode the new zipcode
	 */
	public void setZipcode(Integer zipcode) {
		this.zipcode = zipcode;
	}

	/**
	 * Gets the address email.
	 *
	 * @return the address email
	 */
	@Column(name = "address_email")
	public String getAddressEmail() {
		return addressEmail;
	}

	/**
	 * Sets the address email.
	 *
	 * @param addressEmail the new address email
	 */
	public void setAddressEmail(String addressEmail) {
		this.addressEmail = addressEmail;
	}

	/**
	 * Gets the address phone number.
	 *
	 * @return the address phone number
	 */
	@Column(name = "address_phone_number")
	public Long getAddressPhoneNumber() {
		return addressPhoneNumber;
	}

	/**
	 * Sets the address phone number.
	 *
	 * @param addressPhoneNumber the new address phone number
	 */
	public void setAddressPhoneNumber(Long addressPhoneNumber) {
		this.addressPhoneNumber = addressPhoneNumber;
	}

	/**
	 * Gets the tags.
	 *
	 * @return the tags
	 */
	@Column(name = "tags")
	public String getTags() {
		return tags;
	}

	/**
	 * Sets the tags.
	 *
	 * @param tags the tags to set
	 */
	public void setTags(String tags) {
		this.tags = tags;
	}

	/**
	 * Gets the description.
	 *
	 * @return the description
	 */
	@Column(name = "description")
	public String getDescription() {
		return description;
	}

	/**
	 * Sets the description.
	 *
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * Checks if is status.
	 *
	 * @return the status
	 */
	@Column(name = "status")
	public boolean isStatus() {
		return status;
	}

	/**
	 * Sets the status.
	 *
	 * @param status the status to set
	 */
	public void setStatus(boolean status) {
		this.status = status;
	}
}
