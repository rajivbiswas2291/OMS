package com.msr.oms.dto;

/**
 * The Class ManufacturerDTO.
 *
 * @author rajiv.biswas
 */
public class ManufacturerDTO {

	/** The manufacture id. */
	private Long manufacturerId;

	/** The manufacture name. */
	private String manufacturerName;



	/**
	 * Gets the manufacturer name.
	 *
	 * @return the manufacturerName
	 */
	public String getManufacturerName() {
		return manufacturerName;
	}

	/**
	 * Sets the manufacturer name.
	 *
	 * @param manufacturerName the manufacturerName to set
	 */
	public void setManufacturerName(String manufacturerName) {
		this.manufacturerName = manufacturerName;
	}

	/**
	 * @return the manufacturerId
	 */
	public Long getManufacturerId() {
		return manufacturerId;
	}

	/**
	 * @param manufacturerId the manufacturerId to set
	 */
	public void setManufacturerId(Long manufacturerId) {
		this.manufacturerId = manufacturerId;
	}
}
