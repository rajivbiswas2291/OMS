package com.msr.oms.dto;

// TODO: Auto-generated Javadoc
/**
 * The Class CurrencyDTO.
 */
/**
 * @author rajiv.biswas
 *
 */
public class CurrencyDTO {

	/** The currency id. */
	private Long currencyId;
	
	/** The currency code. */
	private String currencyCode;
	
	/** The currency name. */
	private String currencyName;

	public Long getCurrencyId() {
		return currencyId;
	}

	public void setCurrencyId(Long currencyId) {
		this.currencyId = currencyId;
	}

	public String getCurrencyCode() {
		return currencyCode;
	}

	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}

	public String getCurrencyName() {
		return currencyName;
	}

	public void setCurrencyName(String currencyName) {
		this.currencyName = currencyName;
	}

}
