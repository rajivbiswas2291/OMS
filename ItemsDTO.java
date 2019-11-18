package com.msr.oms.dto;

import io.swagger.annotations.ApiModelProperty;

// TODO: Auto-generated Javadoc
/**
 * The Class ItemsDTO.
 */
public class ItemsDTO {

	/** The item id. */
	@ApiModelProperty
	private long itemId;
	
	/** The style id. */
	@ApiModelProperty
	private Long styleId;
	
	/** The color id. */
	@ApiModelProperty
	private Long colorId;
	
	/** The size id. */
	@ApiModelProperty
	private Long sizeId;
	
	/** The style name. */
	@ApiModelProperty
	private String styleName;

	/** The item name. */
	@ApiModelProperty
	private String itemName;
	
	/** The color name. */
	private String colorName;
	
	/** The size name. */
	private String sizeName;

	/** The order quantity. */
	@ApiModelProperty
	private String orderQuantity;

	/** The price. */
	@ApiModelProperty
	private String price;

	/** The discount. */
	@ApiModelProperty
	private String discount;

	/** The tax. */
	@ApiModelProperty
	private String tax;

	/** The total. */
	@ApiModelProperty
	private String total;

	/** The art image. */
	private String artImage;
	
	private String categoryName;
	
	private Long categoryId; 
	
	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public Long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

	
	
	/**
	 * Gets the color name.
	 *
	 * @return the colorName
	 */
	public String getColorName() {
		return colorName;
	}

	/**
	 * Sets the color name.
	 *
	 * @param colorName the colorName to set
	 */
	public void setColorName(String colorName) {
		this.colorName = colorName;
	}

	/**
	 * Gets the size name.
	 *
	 * @return the sizeName
	 */
	public String getSizeName() {
		return sizeName;
	}

	/**
	 * Sets the size name.
	 *
	 * @param sizeName the sizeName to set
	 */
	public void setSizeName(String sizeName) {
		this.sizeName = sizeName;
	}

	/**
	 * Gets the color id.
	 *
	 * @return the colorId
	 */
	public Long getColorId() {
		return colorId;
	}

	/**
	 * Sets the color id.
	 *
	 * @param colorId the colorId to set
	 */
	public void setColorId(Long colorId) {
		this.colorId = colorId;
	}

	/**
	 * Gets the size id.
	 *
	 * @return the sizeId
	 */
	public Long getSizeId() {
		return sizeId;
	}

	/**
	 * Sets the size id.
	 *
	 * @param sizeId the sizeId to set
	 */
	public void setSizeId(Long sizeId) {
		this.sizeId = sizeId;
	}

	/**
	 * Gets the style name.
	 *
	 * @return the styleName
	 */
	public String getStyleName() {
		return styleName;
	}

	/**
	 * Sets the style name.
	 *
	 * @param styleName the styleName to set
	 */
	public void setStyleName(String styleName) {
		this.styleName = styleName;
	}

	/**
	 * Gets the style id.
	 *
	 * @return the styleId
	 */
	public Long getStyleId() {
		return styleId;
	}

	/**
	 * Sets the style id.
	 *
	 * @param styleId the styleId to set
	 */
	public void setStyleId(Long styleId) {
		this.styleId = styleId;
	}

	/**
	 * Gets the item id.
	 *
	 * @param l the l
	 * @return the item id
	 */
	public long getItemId(long l) {
		return this.itemId;
	}

	/**
	 * Sets the item id.
	 *
	 * @param itemId the new item id
	 */
	public void setItemId(long itemId) {
		this.itemId = itemId;
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
	 * @param itemName the new item name
	 */
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	/**
	 * Gets the order quantity.
	 *
	 * @return the order quantity
	 */
	public String getOrderQuantity() {
		return orderQuantity;
	}

	/**
	 * Sets the order quantity.
	 *
	 * @param orderQuantity the new order quantity
	 */
	public void setOrderQuantity(String orderQuantity) {
		this.orderQuantity = orderQuantity;
	}

	/**
	 * Gets the item id.
	 *
	 * @return the item id
	 */
	public long getItemId() {
		return itemId;
	}

	/**
	 * Gets the price.
	 *
	 * @return the price
	 */
	public String getPrice() {
		return price;
	}

	/**
	 * Sets the price.
	 *
	 * @param price the new price
	 */
	public void setPrice(String price) {
		this.price = price;
	}

	/**
	 * Gets the discount.
	 *
	 * @return the discount
	 */
	public String getDiscount() {
		return discount;
	}

	/**
	 * Sets the discount.
	 *
	 * @param discount the new discount
	 */
	public void setDiscount(String discount) {
		this.discount = discount;
	}

	/**
	 * Gets the tax.
	 *
	 * @return the tax
	 */
	public String getTax() {
		return tax;
	}

	/**
	 * Sets the tax.
	 *
	 * @param tax the new tax
	 */
	public void setTax(String tax) {
		this.tax = tax;
	}

	/**
	 * Gets the total.
	 *
	 * @return the total
	 */
	public String getTotal() {
		return total;
	}

	/**
	 * Sets the total.
	 *
	 * @param total the new total
	 */
	public void setTotal(String total) {
		this.total = total;
	}

	/**
	 * Gets the art image.
	 *
	 * @return the artImage
	 */
	public String getArtImage() {
		return artImage;
	}

	/**
	 * Sets the art image.
	 *
	 * @param artImage the artImage to set
	 */
	public void setArtImage(String artImage) {
		this.artImage = artImage;
	}
}
