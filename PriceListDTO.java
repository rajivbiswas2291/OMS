package com.msr.oms.dto;

public class PriceListDTO {

	/** The price list id. */
	private Long priceListId;
	
	/** The price list name. */
	private String priceListName;

	public Long getPriceListId() {
		return priceListId;
	}

	public void setPriceListId(Long priceListId) {
		this.priceListId = priceListId;
	}

	public String getPriceListName() {
		return priceListName;
	}

	public void setPriceListName(String priceListName) {
		this.priceListName = priceListName;
	}
}
