package com.msr.oms.entity;
// Generated Jul 11, 2019 5:20:20 PM by Hibernate Tools 5.1.6.Final

import static javax.persistence.GenerationType.IDENTITY;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * CustomerAddressTypeMaster generated by hbm2java.
 */
@Entity
@Table(name = "customer_address_type_master")
public class CustomerAddressTypeMaster implements java.io.Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 8274130892336000492L;
	
	/** The customer address type id. */
	private Long customerAddressTypeId;
	
	/** The customer address type name. */
	private String customerAddressTypeName;
	
	/** The status. */
	private boolean status;
	
	/** The created on. */
	private Date createdOn;
	
	/** The created by. */
	private String createdBy;
	
	/**
	 * Gets the customer address type id.
	 *
	 * @return the customer address type id
	 */
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "customer_address_type_id", unique = true, nullable = false)
	public Long getCustomerAddressTypeId() {
		return this.customerAddressTypeId;
	}

	/**
	 * Sets the customer address type id.
	 *
	 * @param customerAddressTypeId the new customer address type id
	 */
	public void setCustomerAddressTypeId(Long customerAddressTypeId) {
		this.customerAddressTypeId = customerAddressTypeId;
	}

	/**
	 * Gets the customer address type name.
	 *
	 * @return the customer address type name
	 */
	@Column(name = "customer_address_type_name", nullable = false, length = 100)
	public String getCustomerAddressTypeName() {
		return this.customerAddressTypeName;
	}

	/**
	 * Sets the customer address type name.
	 *
	 * @param customerAddressTypeName the new customer address type name
	 */
	public void setCustomerAddressTypeName(String customerAddressTypeName) {
		this.customerAddressTypeName = customerAddressTypeName;
	}

	/**
	 * Checks if is status.
	 *
	 * @return true, if is status
	 */
	@Column(name = "status", nullable = false)
	public boolean isStatus() {
		return this.status;
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
	@Column(name = "created_on", nullable = false, length = 19)
	public Date getCreatedOn() {
		return this.createdOn;
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
	@Column(name = "created_by", nullable = false, length = 80)
	public String getCreatedBy() {
		return this.createdBy;
	}

	/**
	 * Sets the created by.
	 *
	 * @param createdBy the new created by
	 */
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
}
