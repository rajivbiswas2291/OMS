package com.msr.oms.dto;

import java.math.BigDecimal;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.msr.admin.dto.StyleDto;
import com.msr.product.dto.ColorsDTO;
import com.msr.product.dto.SizesDTO;

import io.swagger.annotations.ApiModelProperty;

/**
 * The Class OrderPreviewDto.
 */
@JsonIgnoreProperties(ignoreUnknown=true)
@JsonInclude(Include.NON_DEFAULT)
public class OrderPreviewDto {
	/** The order id. */
	@ApiModelProperty
	private Long orderId;

	/** The currency code. */
	@ApiModelProperty
	private String currencyCode;

	/** The sales order id. */
	@ApiModelProperty
	private String saleOrderId;

	/** The customer id. */
	@ApiModelProperty
	private Long customerId;

	/** The order id. */
	@ApiModelProperty
	private Long assignToId;

	/** The assigned to. */

	@ApiModelProperty
	private String assignedTo;

	/** The status. */
	@ApiModelProperty
	private boolean status;

	/** The order status. */
	@ApiModelProperty
	private String orderStatus;

	/** The customer name. */
	@ApiModelProperty
	private String customerName;

	/** The customer status. */
	@ApiModelProperty
	private boolean customerStatus;

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

	/** The currency name. */
	@ApiModelProperty
	private String currencyName;

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
	private long assignTo;

	/** The coupon. */
	@ApiModelProperty
	private String coupon;

	/** The item name. */
	@ApiModelProperty
	private String itemName;

	/** The quantity. */
	@ApiModelProperty
	private Integer quantity;

	/** The items price. */
	@ApiModelProperty
	private Integer itemsPrice;

	/** The discount. */
	@ApiModelProperty
	private BigDecimal discount;

	/** The tax. */
	@ApiModelProperty
	private BigDecimal tax;

	/** The message to customer. */
	@ApiModelProperty
	private String messageToCustomer;

	/** The total units. */
	@ApiModelProperty
	private Integer totalUnits;

	/** The sub total. */
	@ApiModelProperty
	private Integer subTotal;

	/** The total cost. */
	@ApiModelProperty
	private Integer totalCost;

	/** The cloned parent id. */
	@ApiModelProperty
	private String clonedParentId;

	/** The items dto. */
	@ApiModelProperty
	private List<ItemsDTO> items;
	
	@ApiModelProperty
	private List<List<ColorsDTO>> colorDTO;
	
	/** The size DTO. */
	private List<List<SizesDTO>> sizeDTO;

	private List<StyleDto> styleDTO;
	
	public List<List<ColorsDTO>> getColorDTO() {
		return colorDTO;
	}

	public void setColorDTO(List<List<ColorsDTO>> colorDTO) {
		this.colorDTO = colorDTO;
	}

	public List<List<SizesDTO>> getSizeDTO() {
		return sizeDTO;
	}

	public void setSizeDTO(List<List<SizesDTO>> sizeDTO) {
		this.sizeDTO = sizeDTO;
	}

	public List<StyleDto> getStyleDTO() {
		return styleDTO;
	}

	public void setStyleDTO(List<StyleDto> styleDTO) {
		this.styleDTO = styleDTO;
	}

	/** The manufacturerid. */
	@ApiModelProperty
	private Long manufacturerId;
	
	/** The manufacturer name. */
	@ApiModelProperty
	private String manufacturerName;
	
	/** The total tax. */
	@ApiModelProperty
	private BigDecimal totalTax;
	
	/** The total discount. */
	private String totalDiscount;

	/**
	 * Gets the bill to address name.
	 *
	 * @return the bill to address name
	 */
	public String getBillToAddressName() {
		return billToAddressName;
	}

	/**
	 * Sets the bill to address name.
	 *
	 * @param billToAddressName the new bill to address name
	 */
	public void setBillToAddressName(String billToAddressName) {
		this.billToAddressName = billToAddressName;
	}

	/**
	 * Gets the ship to address name.
	 *
	 * @return the ship to address name
	 */
	public String getShipToAddressName() {
		return shipToAddressName;
	}

	/**
	 * Sets the ship to address name.
	 *
	 * @param shipToAddressName the new ship to address name
	 */
	public void setShipToAddressName(String shipToAddressName) {
		this.shipToAddressName = shipToAddressName;
	}

	/**
	 * Gets the ship from address name.
	 *
	 * @return the ship from address name
	 */
	public String getShipFromAddressName() {
		return shipFromAddressName;
	}

	/**
	 * Sets the ship from address name.
	 *
	 * @param shipFromAddressName the new ship from address name
	 */
	public void setShipFromAddressName(String shipFromAddressName) {
		this.shipFromAddressName = shipFromAddressName;
	}

	/**
	 * Gets the bill to address.
	 *
	 * @return the bill to address
	 */
	public String getBillToAddress() {
		return billToAddress;
	}

	/**
	 * Sets the bill to address.
	 *
	 * @param billToAddress the new bill to address
	 */
	public void setBillToAddress(String billToAddress) {
		this.billToAddress = billToAddress;
	}

	/**
	 * Gets the ship to address.
	 *
	 * @return the ship to address
	 */
	public String getShipToAddress() {
		return shipToAddress;
	}

	/**
	 * Sets the ship to address.
	 *
	 * @param shipToAddress the new ship to address
	 */
	public void setShipToAddress(String shipToAddress) {
		this.shipToAddress = shipToAddress;
	}

	/**
	 * Gets the ship from address.
	 *
	 * @return the ship from address
	 */
	public String getShipFromAddress() {
		return shipFromAddress;
	}

	/**
	 * Sets the ship from address.
	 *
	 * @param shipFromAddress the new ship from address
	 */
	public void setShipFromAddress(String shipFromAddress) {
		this.shipFromAddress = shipFromAddress;
	}

	/** The bill to address name. */
	private String billToAddressName;
	/** The ship to address name. */
	private String shipToAddressName;
	/** The ship from address name. */
	private String shipFromAddressName;
	/** The billing address. */
	private String billToAddress;
	/** The ship to address. */
	private String shipToAddress;
	/** The ship from address. */
	private String shipFromAddress;
	
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
	 * @param orderId
	 *            the new order id
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
	 * @param customerId
	 *            the new customer id
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
	 * @param customerName
	 *            the new customer name
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
	 * @param issueDate
	 *            the new issue date
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
	 * @param shipmentDate
	 *            the new shipment date
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
	 * @param references
	 *            the new references
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
	 * @param email
	 *            the new email
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
	 * @param phone
	 *            the new phone
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
	 * @param currencyId
	 *            the new currency id
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
	 * @param priceListId
	 *            the new price list id
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
	 * @param totalAreId
	 *            the new total are id
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
	 * @param shipplingCostId
	 *            the new shippling cost id
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
	 * @param shippingCostName
	 *            the new shipping cost name
	 */
	public void setShippingCostName(String shippingCostName) {
		this.shippingCostName = shippingCostName;
	}

	/**
	 * Gets the assign to.
	 *
	 * @return the assign to
	 */
	public long getAssignTo() {
		return assignTo;
	}

	/**
	 * Sets the assign to.
	 *
	 * @param assignTo
	 *            the new assign to
	 */
	public void setAssignTo(long assignTo) {
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
	 * @param coupon
	 *            the new coupon
	 */
	public void setCoupon(String coupon) {
		this.coupon = coupon;
	}

	/**
	 * Gets the item name.
	 *
	 * @return the item name
	 */
	public String getItemName() {
		return itemName;
	}

	/**
	 * Sets the item name.
	 *
	 * @param itemName
	 *            the new item name
	 */
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	/**
	 * Gets the quantity.
	 *
	 * @return the quantity
	 */
	public Integer getQuantity() {
		return quantity;
	}

	/**
	 * Sets the quantity.
	 *
	 * @param quantity
	 *            the new quantity
	 */
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	/**
	 * Gets the items price.
	 *
	 * @return the items price
	 */
	public Integer getItemsPrice() {
		return itemsPrice;
	}

	/**
	 * Sets the items price.
	 *
	 * @param itemsPrice
	 *            the new items price
	 */
	public void setItemsPrice(Integer itemsPrice) {
		this.itemsPrice = itemsPrice;
	}

	/**
	 * Gets the discount.
	 *
	 * @return the discount
	 */
	public BigDecimal getDiscount() {
		return discount;
	}

	/**
	 * Sets the discount.
	 *
	 * @param discount
	 *            the new discount
	 */
	public void setDiscount(BigDecimal discount) {
		this.discount = discount;
	}

	/**
	 * Gets the tax.
	 *
	 * @return the tax
	 */
	public BigDecimal getTax() {
		return tax;
	}

	/**
	 * Sets the tax.
	 *
	 * @param tax
	 *            the new tax
	 */
	public void setTax(BigDecimal tax) {
		this.tax = tax;
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
	 * @param messageToCustomer
	 *            the new message to customer
	 */
	public void setMessageToCustomer(String messageToCustomer) {
		this.messageToCustomer = messageToCustomer;
	}

	/**
	 * Gets the total units.
	 *
	 * @return the total units
	 */
	public Integer getTotalUnits() {
		return totalUnits;
	}

	/**
	 * Sets the total units.
	 *
	 * @param totalUnits
	 *            the new total units
	 */
	public void setTotalUnits(Integer totalUnits) {
		this.totalUnits = totalUnits;
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
	 * @param clonedParentId
	 *            the new cloned parent id
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
	 * @param currencyName
	 *            the new currency name
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
	 * @param priceListName
	 *            the new price list name
	 */
	public void setPriceListName(String priceListName) {
		this.priceListName = priceListName;
	}

	/**
	 * Checks if is status.
	 *
	 * @return true, if is status
	 */
	public boolean isStatus() {
		return status;
	}

	/**
	 * Sets the status.
	 *
	 * @param status
	 *            the new status
	 */
	public void setStatus(boolean status) {
		this.status = status;
	}

	/**
	 * Gets the order status.
	 *
	 * @return the order status
	 */
	public String getOrderStatus() {
		return orderStatus;
	}

	/**
	 * Sets the order status.
	 *
	 * @param orderStatus
	 *            the new order status
	 */
	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	/**
	 * Checks if is customer status.
	 *
	 * @return true, if is customer status
	 */
	public boolean isCustomerStatus() {
		return customerStatus;
	}

	/**
	 * Sets the customer status.
	 *
	 * @param customerStatus
	 *            the new customer status
	 */
	public void setCustomerStatus(boolean customerStatus) {
		this.customerStatus = customerStatus;
	}

	/**
	 * Gets the currency code.
	 *
	 * @return the currency code
	 */
	public String getCurrencyCode() {
		return currencyCode;
	}

	/**
	 * Sets the currency code.
	 *
	 * @param currencyCode the new currency code
	 */
	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
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
	 * Gets the sub total.
	 *
	 * @return the subTotal
	 */
	public Integer getSubTotal() {
		return subTotal;
	}

	/**
	 * Sets the sub total.
	 *
	 * @param subTotal the subTotal to set
	 */
	public void setSubTotal(Integer subTotal) {
		this.subTotal = subTotal;
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
	 * Gets the total discount.
	 *
	 * @return the totalDiscount
	 */
	public String getTotalDiscount() {
		return totalDiscount;
	}

	/**
	 * Sets the total discount.
	 *
	 * @param totalDiscount the totalDiscount to set
	 */
	public void setTotalDiscount(String totalDiscount) {
		this.totalDiscount = totalDiscount;
	}

	/**
	 * Gets the assign to id.
	 *
	 * @return the assignToId
	 */
	public Long getAssignToId() {
		return assignToId;
	}

	/**
	 * Sets the assign to id.
	 *
	 * @param assignToId the assignToId to set
	 */
	public void setAssignToId(Long assignToId) {
		this.assignToId = assignToId;
	}
}
