package com.msr.oms.dto;

/**
 * the class OrdersDashboardDTO.
 * @author vamshib
 *
 */
public class OrdersDashboardDTO {

	/** The order id. */
	private Long orderId;
	
	/** The sale order id. */
	private String saleOrderId;
	
	/** The created on. */
	private String createdOn;
	
	/** The shipment date. */
	private String shipmentDate;
	
	/** The order status. */
	private String orderStatus;
	
	/** The total cost. */
	private Integer totalCost;
	
	/**
	 * Gets the order id.
	 *
	 * @return the orderId
	 */
	public Long getOrderId() {
		return orderId;
	}
	
	/**
	 * Sets the order id.
	 *
	 * @param orderId the orderId to set
	 */
	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}
	
	/**
	 * Gets the sale order id.
	 *
	 * @return the saleOrderId
	 */
	public String getSaleOrderId() {
		return saleOrderId;
	}
	
	/**
	 * Sets the sale order id.
	 *
	 * @param saleOrderId the saleOrderId to set
	 */
	public void setSaleOrderId(String saleOrderId) {
		this.saleOrderId = saleOrderId;
	}
	
	/**
	 * Gets the created on.
	 *
	 * @return the createdOn
	 */
	public String getCreatedOn() {
		return createdOn;
	}
	
	/**
	 * Sets the created on.
	 *
	 * @param createdOn the createdOn to set
	 */
	public void setCreatedOn(String createdOn) {
		this.createdOn = createdOn;
	}
	
	/**
	 * Gets the shipment date.
	 *
	 * @return the shipmentDate
	 */
	public String getShipmentDate() {
		return shipmentDate;
	}
	
	/**
	 * Sets the shipment date.
	 *
	 * @param shipmentDate the shipmentDate to set
	 */
	public void setShipmentDate(String shipmentDate) {
		this.shipmentDate = shipmentDate;
	}
	
	/**
	 * Gets the order status.
	 *
	 * @return the orderStatus
	 */
	public String getOrderStatus() {
		return orderStatus;
	}
	
	/**
	 * Sets the order status.
	 *
	 * @param orderStatus the orderStatus to set
	 */
	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}
	
	/**
	 * Gets the total cost.
	 *
	 * @return the totalCost
	 */
	public Integer getTotalCost() {
		return totalCost;
	}
	
	/**
	 * Sets the total cost.
	 *
	 * @param totalCost the totalCost to set
	 */
	public void setTotalCost(Integer totalCost) {
		this.totalCost = totalCost;
	}

	
}
