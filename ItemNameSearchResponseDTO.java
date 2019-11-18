package com.msr.oms.dto;

/**
 * The Class ItemNameSearchResponseDTO.
 * @author vamshib
 */
public class ItemNameSearchResponseDTO {

	/** The product id. */
	private Long productId;
	
	/** The product art name. */
	private String productArtName;
	
	/** The product price. */
	private String productPrice;
	
	/** The art image. */
	private String artImage;

	/**
	 * Gets the product id.
	 *
	 * @return the product id
	 */
	public Long getProductId() {
		return productId;
	}

	/**
	 * Sets the product id.
	 *
	 * @param productId the new product id
	 */
	public void setProductId(Long productId) {
		this.productId = productId;
	}

	/**
	 * Gets the product art name.
	 *
	 * @return the product art name
	 */
	public String getProductArtName() {
		return productArtName;
	}

	/**
	 * Sets the product art name.
	 *
	 * @param productArtName the new product art name
	 */
	public void setProductArtName(String productArtName) {
		this.productArtName = productArtName;
	}

	/**
	 * Gets the product price.
	 *
	 * @return the product price
	 */
	public String getProductPrice() {
		return productPrice;
	}

	/**
	 * Sets the product price.
	 *
	 * @param productPrice the new product price
	 */
	public void setProductPrice(String productPrice) {
		this.productPrice = productPrice;
	}

	/**
	 * @return the artImage
	 */
	public String getArtImage() {
		return artImage;
	}

	/**
	 * @param artImage the artImage to set
	 */
	public void setArtImage(String artImage) {
		this.artImage = artImage;
	}
	
	
	
}
