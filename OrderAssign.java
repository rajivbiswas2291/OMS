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


/**
 * The Class OrderAssign.
 * @author vamshib.
 */
@Entity
@Table(name = "order_assign")
public class OrderAssign implements java.io.Serializable{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -5087215628818496701L;

	/** The order id. */
	private Long orderAssignToId;
	
	/** The assigned to. */
	private String assignedTo;
	
	/** The manufacturers. */
	private Manufacturers manufacturers ;

	/**
	 * Gets the order assign to id.
	 *
	 * @return the order assign to id
	 */
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "order_assign_to_id", unique = true, nullable = false)
	public Long getOrderAssignToId() {
		return orderAssignToId;
	}
	
	/**
	 * Sets the order assign to id.
	 *
	 * @param orderAssignToId the new order assign to id
	 */
	public void setOrderAssignToId(Long orderAssignToId) {
		this.orderAssignToId = orderAssignToId;
	}


	/**
	 * Gets the assigned to.
	 *
	 * @return the assigned to
	 */
	@Column(name = "assigned_to", unique = true, nullable = false)
	public String getAssignedTo() {
		return assignedTo;
	}


	/**
	 * Sets the assigned to.
	 *
	 * @param assignedTo the new assigned to
	 */
	public void setAssignedTo(String assignedTo) {
		this.assignedTo = assignedTo;
	}

	/**
	 * Gets the manufacturers.
	 *
	 * @return the manufacturers
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "manufacturer_id")	
	public Manufacturers getManufacturers() {
		return manufacturers;
	}

	/**
	 * Sets the manufacturers.
	 *
	 * @param manufacturers the new manufacturers
	 */
	public void setManufacturers(Manufacturers manufacturers) {
		this.manufacturers = manufacturers;
	}
}
