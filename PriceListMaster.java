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
 * PriceListMaster generated by hbm2java.
 */
@Entity
@Table(name = "price_list_master")
public class PriceListMaster implements java.io.Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -7002026382921354914L;
	
	/** The price list id. */
	private Long priceListId;
	
	/** The price list name. */
	private String priceListName;
	
	/** The status. */
	private boolean status;
	
	/** The created on. */
	private Date createdOn;
	
	/** The created by. */
	private String createdBy;
	
	/**
	 * Gets the price list id.
	 *
	 * @return the price list id
	 */
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "price_list_id", unique = true, nullable = false)
	public Long getPriceListId() {
		return this.priceListId;
	}

	/**
	 * Sets the price list id.
	 *
	 * @param priceListId the new price list id
	 */
	public void setPriceListId(Long priceListId) {
		this.priceListId = priceListId;
	}

	/**
	 * Gets the price list name.
	 *
	 * @return the price list name
	 */
	@Column(name = "price_list_name", nullable = false, length = 80)
	public String getPriceListName() {
		return this.priceListName;
	}

	/**
	 * Sets the price list name.
	 *
	 * @param priceListName the new price list name
	 */
	public void setPriceListName(String priceListName) {
		this.priceListName = priceListName;
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