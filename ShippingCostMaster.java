package com.msr.oms.entity;
// Generated Jul 11, 2019 5:20:20 PM by Hibernate Tools 5.1.6.Final

import static javax.persistence.GenerationType.IDENTITY;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * ShippingCostMaster generated by hbm2java.
 */
@Entity
@Table(name = "shipping_cost_master")
public class ShippingCostMaster implements java.io.Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -6300899781572921022L;
	
	/** The shippling cost id. */
	private Long shipplingCostId;
	
	/** The shipping cost name. */
	private String shippingCostName;
	
	/** The status. */
	private boolean status;
	
	/** The created on. */
	private Date createdOn;
	
	/** The created by. */
	private String createdBy;
	
	/** The orderses. */
	private Set<Orders> orderses = new HashSet<Orders>(0);

	/**
	 * Gets the shippling cost id.
	 *
	 * @return the shippling cost id
	 */
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "shippling_cost_id", unique = true, nullable = false)
	public Long getShipplingCostId() {
		return this.shipplingCostId;
	}

	/**
	 * Sets the shippling cost id.
	 *
	 * @param shipplingCostId the new shippling cost id
	 */
	public void setShipplingCostId(Long shipplingCostId) {
		this.shipplingCostId = shipplingCostId;
	}

	/**
	 * Gets the shipping cost name.
	 *
	 * @return the shipping cost name
	 */
	@Column(name = "shipping_cost_name", nullable = false, length = 80)
	public String getShippingCostName() {
		return this.shippingCostName;
	}

	/**
	 * Sets the shipping cost name.
	 *
	 * @param shippingCostName the new shipping cost name
	 */
	public void setShippingCostName(String shippingCostName) {
		this.shippingCostName = shippingCostName;
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

	/**
	 * Gets the orderses.
	 *
	 * @return the orderses
	 */
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "shippingCostMaster")
	public Set<Orders> getOrderses() {
		return this.orderses;
	}

	/**
	 * Sets the orderses.
	 *
	 * @param orderses the new orderses
	 */
	public void setOrderses(Set<Orders> orderses) {
		this.orderses = orderses;
	}

}
