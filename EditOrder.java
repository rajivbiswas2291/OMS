package com.msr.oms.dto;

import java.math.BigDecimal;
import java.util.List;

import io.swagger.annotations.ApiModelProperty;

/**
 * The Class EditOrder.
 *
 * @author rajiv.biswas
 */
public class EditOrder {
	/** The order id. */
	@ApiModelProperty
	private Long orderId;
	
	/** The sale order id. */
	@ApiModelProperty
	private String saleOrderId;

	/** The customer id. */
	@ApiModelProperty
	private Long customerId;

	/** The customer name. */
	@ApiModelProperty
	private String customerName;

	/** The manufacturer id. */
	@ApiModelProperty
	private Long manufacturerId;

	/** The manufacture name. */
	@ApiModelProperty
	private String manufacturerName;

	/** The issue date. */
	@ApiModelProperty
	private String issueDate;

	/** The shipment date. */
	@ApiModelProperty
	private String shipmentDate;

	/** The references. */
	@ApiModelProperty
	private String references;

	/** The email. */
	@ApiModelProperty
	private String email;

	/** The phone. */
	@ApiModelProperty
	private String phone;

	/** The currency id. */
	@ApiModelProperty
	private Long currencyId;

	/** The currency code. */
	private String currencyCode;

	/** The orderAssignTo Id . */
	@ApiModelProperty
	private Long orderAssignToId;

	/** The currency name. */
	@ApiModelProperty
	private String currencyName;

	/** The assigned to. */
	private String assignedTo;

	/** The price list id. */
	@ApiModelProperty
	private Long priceListId;

	/** The price list name. */
	@ApiModelProperty
	private String priceListName;

	/** The total are id. */
	@ApiModelProperty
	private Long totalAreId;

	/** The total are name. */
	@ApiModelProperty
	private String totalAre;

	/** The shippling cost id. */
	@ApiModelProperty
	private Long shipplingCostId;

	/** The shipping cost name. */
	@ApiModelProperty
	private String shippingCostName;

	/** The assign to. */
	@ApiModelProperty
	private String assignTo;

	/** The coupon. */
	@ApiModelProperty
	private String coupon;

	/** The message to customer. */
	@ApiModelProperty
	private String messageToCustomer;

	/** The total units. */
	@ApiModelProperty
	private String totalUnits;

	/** The sub total. */
	@ApiModelProperty
	private String subTotal;

	/** The total cost. */
	@ApiModelProperty
	private String totalCost;

	/** The cloned parent id. */
	@ApiModelProperty
	private String clonedParentId;

	/** The items. */
	@ApiModelProperty
	private List<ItemsDTO> items;

	/** The total tax. */
	@ApiModelProperty
	private BigDecimal totalTax;

	@ApiModelProperty
	private String totalDiscount;
	
	/**
	 * Gets the items.
	 *
	 * @return the items
	 */
	public List<ItemsDTO> getItems() {
		return items;
	}

	/**
	 * Sets the items.
	 *
	 * @param items the items to set
	 */
	public void setItems(List<ItemsDTO> items) {
		this.items = items;
	}

	/**
	 * Gets the order id.
	 *
	 * @return the order id
	 */
	public Long getOrderId() {
		return orderId;
	}

	/**
	 * Sets the order id.
	 *
	 * @param orderId the new order id
	 */
	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	/**
	 * Gets the customer id.
	 *
	 * @return the customer id
	 */
	public Long getCustomerId() {
		return customerId;
	}

	/**
	 * Sets the customer id.
	 *
	 * @param customerId the new customer id
	 */
	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	/**
	 * Gets the customer name.
	 *
	 * @return the customer name
	 */
	public String getCustomerName() {
		return customerName;
	}

	/**
	 * Sets the customer name.
	 *
	 * @param customerName the new customer name
	 */
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}





	/**
	 * Gets the issue date.
	 *
	 * @return the issue date
	 */
	public String getIssueDate() {
		return issueDate;
	}

	/**
	 * Sets the issue date.
	 *
	 * @param issueDate the new issue date
	 */
	public void setIssueDate(String issueDate) {
		this.issueDate = issueDate;
	}

	/**
	 * Gets the shipment date.
	 *
	 * @return the shipment date
	 */
	public String getShipmentDate() {
		return shipmentDate;
	}

	/**
	 * Sets the shipment date.
	 *
	 * @param shipmentDate the new shipment date
	 */
	public void setShipmentDate(String shipmentDate) {
		this.shipmentDate = shipmentDate;
	}

	/**
	 * Gets the references.
	 *
	 * @return the references
	 */
	public String getReferences() {
		return references;
	}

	/**
	 * Sets the references.
	 *
	 * @param references the new references
	 */
	public void setReferences(String references) {
		this.references = references;
	}

	/**
	 * Gets the email.
	 *
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Sets the email.
	 *
	 * @param email the new email
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Gets the phone.
	 *
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * Sets the phone.
	 *
	 * @param phone the new phone
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}

	/**
	 * Gets the currency id.
	 *
	 * @return the currency id
	 */
	public Long getCurrencyId() {
		return currencyId;
	}

	/**
	 * Sets the currency id.
	 *
	 * @param currencyId the new currency id
	 */
	public void setCurrencyId(Long currencyId) {
		this.currencyId = currencyId;
	}

	/**
	 * Gets the price list id.
	 *
	 * @return the price list id
	 */
	public Long getPriceListId() {
		return priceListId;
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
	 * Gets the total are id.
	 *
	 * @return the total are id
	 */
	public Long getTotalAreId() {
		return totalAreId;
	}

	/**
	 * Sets the total are id.
	 *
	 * @param totalAreId the new total are id
	 */
	public void setTotalAreId(Long totalAreId) {
		this.totalAreId = totalAreId;
	}

	/**
	 * Gets the shippling cost id.
	 *
	 * @return the shippling cost id
	 */
	public Long getShipplingCostId() {
		return shipplingCostId;
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
	public String getShippingCostName() {
		return shippingCostName;
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
	 * Gets the assign to.
	 *
	 * @return the assign to
	 */
	public String getAssignTo() {
		return assignTo;
	}

	/**
	 * Sets the assign to.
	 *
	 * @param assignTo the new assign to
	 */
	public void setAssignTo(String assignTo) {
		this.assignTo = assignTo;
	}

	/**
	 * Gets the coupon.
	 *
	 * @return the coupon
	 */
	public String getCoupon() {
		return coupon;
	}

	/**
	 * Sets the coupon.
	 *
	 * @param coupon the new coupon
	 */
	public void setCoupon(String coupon) {
		this.coupon = coupon;
	}

	/**
	 * Gets the message to customer.
	 *
	 * @return the message to customer
	 */
	public String getMessageToCustomer() {
		return messageToCustomer;
	}

	/**
	 * Sets the message to customer.
	 *
	 * @param messageToCustomer the new message to customer
	 */
	public void setMessageToCustomer(String messageToCustomer) {
		this.messageToCustomer = messageToCustomer;
	}

	/**
	 * Gets the total units.
	 *
	 * @return the total units
	 */
	public String getTotalUnits() {
		return totalUnits;
	}

	/**
	 * Sets the total units.
	 *
	 * @param totalUnits the new total units
	 */
	public void setTotalUnits(String totalUnits) {
		this.totalUnits = totalUnits;
	}

	/**
	 * Gets the sub total.
	 *
	 * @return the sub total
	 */
	public String getSubTotal() {
		return subTotal;
	}

	/**
	 * Sets the sub total.
	 *
	 * @param subTotal the new sub total
	 */
	public void setSubTotal(String subTotal) {
		this.subTotal = subTotal;
	}

	/**
	 * Gets the total cost.
	 *
	 * @return the total cost
	 */
	public String getTotalCost() {
		return totalCost;
	}

	/**
	 * Sets the total cost.
	 *
	 * @param totalCost the new total cost
	 */
	public void setTotalCost(String totalCost) {
		this.totalCost = totalCost;
	}

	/**
	 * Gets the cloned parent id.
	 *
	 * @return the cloned parent id
	 */
	public String getClonedParentId() {
		return clonedParentId;
	}

	/**
	 * Sets the cloned parent id.
	 *
	 * @param clonedParentId the new cloned parent id
	 */
	public void setClonedParentId(String clonedParentId) {
		this.clonedParentId = clonedParentId;
	}

	/**
	 * Gets the currency name.
	 *
	 * @return the currency name
	 */
	public String getCurrencyName() {
		return currencyName;
	}

	/**
	 * Sets the currency name.
	 *
	 * @param currencyName the new currency name
	 */
	public void setCurrencyName(String currencyName) {
		this.currencyName = currencyName;
	}

	/**
	 * Gets the price list name.
	 *
	 * @return the price list name
	 */
	public String getPriceListName() {
		return priceListName;
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
	 * Gets the order assign to id.
	 *
	 * @return the order assign to id
	 */
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
	 * Gets the manufacturer name.
	 *
	 * @return the manufacturer name
	 */
	public String getManufacturerName() {
		return manufacturerName;
	}

	/**
	 * Sets the manufacturer name.
	 *
	 * @param manufacturerName the new manufacturer name
	 */
	public void setManufacturerName(String manufacturerName) {
		this.manufacturerName = manufacturerName;
	}

	/**
	 * Gets the total are.
	 *
	 * @return the totalAre
	 */
	public String getTotalAre() {
		return totalAre;
	}

	/**
	 * Sets the total are.
	 *
	 * @param totalAre the totalAre to set
	 */
	public void setTotalAre(String totalAre) {
		this.totalAre = totalAre;
	}

	/**
	 * Gets the total tax.
	 *
	 * @return the totalTax
	 */
	public BigDecimal getTotalTax() {
		return totalTax;
	}

	/**
	 * Sets the total tax.
	 *
	 * @param totalTax the totalTax to set
	 */
	public void setTotalTax(BigDecimal totalTax) {
		this.totalTax = totalTax;
	}

	/**
	 * Gets the manufacturer id.
	 *
	 * @return the manufacturerId
	 */
	public Long getManufacturerId() {
		return manufacturerId;
	}

	/**
	 * Sets the manufacturer id.
	 *
	 * @param manufacturerId the manufacturerId to set
	 */
	public void setManufacturerId(Long manufacturerId) {
		this.manufacturerId = manufacturerId;
	}

	/**
	 * Gets the currency code.
	 *
	 * @return the currencyCode
	 */
	public String getCurrencyCode() {
		return currencyCode;
	}

	/**
	 * Sets the currency code.
	 *
	 * @param currencyCode the currencyCode to set
	 */
	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}

	/**
	 * @return the saleOrderId
	 */
	public String getSaleOrderId() {
		return saleOrderId;
	}

	/**
	 * @param saleOrderId the saleOrderId to set
	 */
	public void setSaleOrderId(String saleOrderId) {
		this.saleOrderId = saleOrderId;
	}

	/**
	 * @return the totalDiscount
	 */
	public String getTotalDiscount() {
		return totalDiscount;
	}

	/**
	 * @param totalDiscount the totalDiscount to set
	 */
	public void setTotalDiscount(String totalDiscount) {
		this.totalDiscount = totalDiscount;
	}
}
