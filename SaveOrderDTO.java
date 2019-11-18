package com.msr.oms.dto;

import java.math.BigDecimal;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.msr.admin.dto.StyleDto;
import com.msr.product.dto.ColorsDTO;
import com.msr.product.dto.SizeMasterDTO;
import com.msr.product.dto.SizesDTO;

import io.swagger.annotations.ApiModelProperty;

// TODO: Auto-generated Javadoc
/**
 * The Class SaveOrderDTO.
 * 
 * @author vamshib.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(Include.NON_DEFAULT)
public class SaveOrderDTO {

	/** The order id. */
	@ApiModelProperty
	private Long orderId;
	/** The customer id. */
	@ApiModelProperty
	private Long customerId;
	/** The manufacturerid. */
	@ApiModelProperty
	private Long manufacturerId;
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
	/** The price list id. */
	@ApiModelProperty
	private Long priceListId;
	/** The total are id. */
	@ApiModelProperty
	private Long totalAreId;
	/** The shippling cost id. */
	@ApiModelProperty
	private Long shipplingCostId;
	/** The order assign to id. */
	@ApiModelProperty
	private Long assignToId;
	/** The assigned to. */
	@ApiModelProperty
	private String assignedTo;
	/** The coupon. */
	@ApiModelProperty
	private String coupon;
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
	private Long clonedParentId;
	/** The items. */
	@ApiModelProperty
	private List<ItemsDTO> items;

	/** The color DTO. */
	@ApiModelProperty
	private List<List<ColorsDTO>> colorDTO;
	
	/** The size DTO. */
	private List<List<SizesDTO>> sizeDTO;

	/** The style DTO. */
	private List<StyleDto> styleDTO;
	
	/**
	 * Gets the size DTO.
	 *
	 * @return the size DTO
	 */
	public List<List<SizesDTO>> getSizeDTO() {
		return sizeDTO;
	}

	public List<List<ColorsDTO>> getColorDTO() {
		return colorDTO;
	}

	/**
	 * Sets the size DTO.
	 *
	 * @param sizeDTO the new size DTO
	 */
	public void setSizeDTO(List<List<SizesDTO>> sizeDTO) {
		this.sizeDTO = sizeDTO;
	}

	/**
	 * Sets the color DTO.
	 *
	 * @param colorDTO the new color DTO
	 */
	public void setColorDTO(List<List<ColorsDTO>> colorDTO) {
		this.colorDTO = colorDTO;
	}

	/**
	 * Gets the style DTO.
	 *
	 * @return the style DTO
	 */
	public List<StyleDto> getStyleDTO() {
		return styleDTO;
	}

	/**
	 * Sets the style DTO.
	 *
	 * @param styleDTO the new style DTO
	 */
	public void setStyleDTO(List<StyleDto> styleDTO) {
		this.styleDTO = styleDTO;
	}

	

	

	

	/** The currency name. */
	@ApiModelProperty
	private String currencyName;
	/** The total are. */
	@ApiModelProperty
	private String totalAre;
	/** The customer name. */
	@ApiModelProperty
	private String customerName;
	/** The sale order id. */
	@ApiModelProperty
	private String saleOrderId;
	/** The total tax. */
	@ApiModelProperty
	private BigDecimal totalTax;
	/** The currency code. */
	@ApiModelProperty
	private String currencyCode;
	/** The total discount. */
	@ApiModelProperty
	private String totalDiscount;
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
	/** The color id. */
	private String colorId;
	/** The style id. */
	private String styleId;
	/** The size id. */
	private String sizeId;

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
	 * @param totalDiscount
	 *            the totalDiscount to set
	 */
	public void setTotalDiscount(String totalDiscount) {
		this.totalDiscount = totalDiscount;
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
	 * @param saleOrderId
	 *            the saleOrderId to set
	 */
	public void setSaleOrderId(String saleOrderId) {
		this.saleOrderId = saleOrderId;
	}

	/**
	 * Gets the currency name.
	 *
	 * @return the currencyName
	 */
	public String getCurrencyName() {
		return currencyName;
	}

	/**
	 * Sets the currency name.
	 *
	 * @param currencyName
	 *            the currencyName to set
	 */
	public void setCurrencyName(String currencyName) {
		this.currencyName = currencyName;
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
	 * @param totalAre
	 *            the totalAre to set
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
	 * @param items
	 *            the items to set
	 */
	public void setItems(List<ItemsDTO> items) {
		this.items = items;
	}

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
	 * @param orderId
	 *            the orderId to set
	 */
	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	/**
	 * Gets the customer id.
	 *
	 * @return the customerId
	 */
	public Long getCustomerId() {
		return customerId;
	}

	/**
	 * Sets the customer id.
	 *
	 * @param customerId
	 *            the customerId to set
	 */
	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	/**
	 * Gets the issue date.
	 *
	 * @return the issueDate
	 */
	public String getIssueDate() {
		return issueDate;
	}

	/**
	 * Sets the issue date.
	 *
	 * @param issueDate
	 *            the issueDate to set
	 */
	public void setIssueDate(String issueDate) {
		this.issueDate = issueDate;
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
	 * @param shipmentDate
	 *            the shipmentDate to set
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
	 *            the references to set
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
	 *            the email to set
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
	 *            the phone to set
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}

	/**
	 * Gets the currency id.
	 *
	 * @return the currencyId
	 */
	public Long getCurrencyId() {
		return currencyId;
	}

	/**
	 * Sets the currency id.
	 *
	 * @param currencyId
	 *            the currencyId to set
	 */
	public void setCurrencyId(Long currencyId) {
		this.currencyId = currencyId;
	}

	/**
	 * Gets the price list id.
	 *
	 * @return the priceListId
	 */
	public Long getPriceListId() {
		return priceListId;
	}

	/**
	 * Sets the price list id.
	 *
	 * @param priceListId
	 *            the priceListId to set
	 */
	public void setPriceListId(Long priceListId) {
		this.priceListId = priceListId;
	}

	/**
	 * Gets the total are id.
	 *
	 * @return the totalAreId
	 */
	public Long getTotalAreId() {
		return totalAreId;
	}

	/**
	 * Sets the total are id.
	 *
	 * @param totalAreId
	 *            the totalAreId to set
	 */
	public void setTotalAreId(Long totalAreId) {
		this.totalAreId = totalAreId;
	}

	/**
	 * Gets the shippling cost id.
	 *
	 * @return the shipplingCostId
	 */
	public Long getShipplingCostId() {
		return shipplingCostId;
	}

	/**
	 * Sets the shippling cost id.
	 *
	 * @param shipplingCostId
	 *            the shipplingCostId to set
	 */
	public void setShipplingCostId(Long shipplingCostId) {
		this.shipplingCostId = shipplingCostId;
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
	 *            the coupon to set
	 */
	public void setCoupon(String coupon) {
		this.coupon = coupon;
	}

	/**
	 * Gets the message to customer.
	 *
	 * @return the messageToCustomer
	 */
	public String getMessageToCustomer() {
		return messageToCustomer;
	}

	/**
	 * Sets the message to customer.
	 *
	 * @param messageToCustomer
	 *            the messageToCustomer to set
	 */
	public void setMessageToCustomer(String messageToCustomer) {
		this.messageToCustomer = messageToCustomer;
	}

	/**
	 * Gets the cloned parent id.
	 *
	 * @return the cloned parent id
	 */
	public Long getClonedParentId() {
		return clonedParentId;
	}

	/**
	 * Sets the cloned parent id.
	 *
	 * @param clonedParentId
	 *            the new cloned parent id
	 */
	public void setClonedParentId(Long clonedParentId) {
		this.clonedParentId = clonedParentId;
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
	 * Gets the sub total.
	 *
	 * @return the sub total
	 */
	public Integer getSubTotal() {
		return subTotal;
	}

	/**
	 * Sets the sub total.
	 *
	 * @param subTotal
	 *            the new sub total
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
	 * @param totalCost
	 *            the totalCost to set
	 */
	public void setTotalCost(Integer totalCost) {
		this.totalCost = totalCost;
	}

	/**
	 * Gets the assigned to.
	 *
	 * @return the assignedTo
	 */
	public String getAssignedTo() {
		return assignedTo;
	}

	/**
	 * Sets the assigned to.
	 *
	 * @param assignedTo
	 *            the assignedTo to set
	 */
	public void setAssignedTo(String assignedTo) {
		this.assignedTo = assignedTo;
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
	 * @param assignToId
	 *            the assignToId to set
	 */
	public void setAssignToId(Long assignToId) {
		this.assignToId = assignToId;
	}

	/**
	 * Gets the customer name.
	 *
	 * @return the customerName
	 */
	public String getCustomerName() {
		return customerName;
	}

	/**
	 * Sets the customer name.
	 *
	 * @param customerName
	 *            the customerName to set
	 */
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
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
	 * @param totalTax
	 *            the totalTax to set
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
	 * @param manufacturerId
	 *            the manufacturerId to set
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
	 * @param currencyCode
	 *            the currencyCode to set
	 */
	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}

	/**
	 * Gets the bill to address name.
	 *
	 * @return the billToAddressName
	 */
	public String getBillToAddressName() {
		return billToAddressName;
	}

	/**
	 * Sets the bill to address name.
	 *
	 * @param billToAddressName
	 *            the billToAddressName to set
	 */
	public void setBillToAddressName(String billToAddressName) {
		this.billToAddressName = billToAddressName;
	}

	/**
	 * Gets the ship to address name.
	 *
	 * @return the shipToAddressName
	 */
	public String getShipToAddressName() {
		return shipToAddressName;
	}

	/**
	 * Sets the ship to address name.
	 *
	 * @param shipToAddressName
	 *            the shipToAddressName to set
	 */
	public void setShipToAddressName(String shipToAddressName) {
		this.shipToAddressName = shipToAddressName;
	}

	/**
	 * Gets the ship from address name.
	 *
	 * @return the shipFromAddressName
	 */
	public String getShipFromAddressName() {
		return shipFromAddressName;
	}

	/**
	 * Sets the ship from address name.
	 *
	 * @param shipFromAddressName
	 *            the shipFromAddressName to set
	 */
	public void setShipFromAddressName(String shipFromAddressName) {
		this.shipFromAddressName = shipFromAddressName;
	}

	/**
	 * Gets the bill to address.
	 *
	 * @return the billToAddress
	 */
	public String getBillToAddress() {
		return billToAddress;
	}

	/**
	 * Sets the bill to address.
	 *
	 * @param billToAddress
	 *            the billToAddress to set
	 */
	public void setBillToAddress(String billToAddress) {
		this.billToAddress = billToAddress;
	}

	/**
	 * Gets the ship to address.
	 *
	 * @return the shipToAddress
	 */
	public String getShipToAddress() {
		return shipToAddress;
	}

	/**
	 * Sets the ship to address.
	 *
	 * @param shipToAddress
	 *            the shipToAddress to set
	 */
	public void setShipToAddress(String shipToAddress) {
		this.shipToAddress = shipToAddress;
	}

	/**
	 * Gets the ship from address.
	 *
	 * @return the shipFromAddress
	 */
	public String getShipFromAddress() {
		return shipFromAddress;
	}

	/**
	 * Sets the ship from address.
	 *
	 * @param shipFromAddress
	 *            the shipFromAddress to set
	 */
	public void setShipFromAddress(String shipFromAddress) {
		this.shipFromAddress = shipFromAddress;
	}

	/**
	 * Gets the color id.
	 *
	 * @return the colorId
	 */
	public String getColorId() {
		return colorId;
	}

	/**
	 * Sets the color id.
	 *
	 * @param colorId            the colorId to set
	 */
	public void setColorId(String colorId) {
		this.colorId = colorId;
	}

	/**
	 * Gets the style id.
	 *
	 * @return the styleId
	 */
	public String getStyleId() {
		return styleId;
	}

	/**
	 * Sets the style id.
	 *
	 * @param styleId            the styleId to set
	 */
	public void setStyleId(String styleId) {
		this.styleId = styleId;
	}

	/**
	 * Gets the size id.
	 *
	 * @return the sizeId
	 */
	public String getSizeId() {
		return sizeId;
	}

	/**
	 * Sets the size id.
	 *
	 * @param sizeId            the sizeId to set
	 */
	public void setSizeId(String sizeId) {
		this.sizeId = sizeId;
	}
}
