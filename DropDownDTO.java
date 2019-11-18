package com.msr.oms.dto;

import java.util.List;

// TODO: Auto-generated Javadoc
/**
 * The Class DropDownDTO.
 */
public class DropDownDTO {

	/** The customer DTO. */
	private List<CustomerDTO> customers;
	
	/** The manufacture dto. */
	private List<ManufacturerDTO> manufacturers;
	
	/** The currency dto. */
	private List<CurrencyDTO> currencies;
	
	/** The price list dto. */
	private List<PriceListDTO> priceList;
	
	/** The shipping cost dto. */
	private List<ShippingCostDTO> shippingCost;

	/** The total are dto. */
	private List<TotalAreDto> totalAre;
	
	private List<OrderAssignDto> assignTo;

	/**
	 * Gets the customers.
	 *
	 * @return the customers
	 */
	public List<CustomerDTO> getCustomers() {
		return customers;
	}

	/**
	 * Sets the customers.
	 *
	 * @param customers the new customers
	 */
	public void setCustomers(List<CustomerDTO> customers) {
		this.customers = customers;
	}

	/**
	 * Gets the manufacturers.
	 *
	 * @return the manufacturers
	 */
	public List<ManufacturerDTO> getManufacturers() {
		return manufacturers;
	}

	/**
	 * Sets the manufacturers.
	 *
	 * @param manufacturers the new manufacturers
	 */
	public void setManufacturers(List<ManufacturerDTO> manufacturers) {
		this.manufacturers = manufacturers;
	}

	/**
	 * Gets the currencies.
	 *
	 * @return the currencies
	 */
	public List<CurrencyDTO> getCurrencies() {
		return currencies;
	}

	/**
	 * Sets the currencies.
	 *
	 * @param currencies the new currencies
	 */
	public void setCurrencies(List<CurrencyDTO> currencies) {
		this.currencies = currencies;
	}

	/**
	 * Gets the price list.
	 *
	 * @return the price list
	 */
	public List<PriceListDTO> getPriceList() {
		return priceList;
	}

	/**
	 * Sets the price list.
	 *
	 * @param priceList the new price list
	 */
	public void setPriceList(List<PriceListDTO> priceList) {
		this.priceList = priceList;
	}

	/**
	 * Gets the shipping cost.
	 *
	 * @return the shipping cost
	 */
	public List<ShippingCostDTO> getShippingCost() {
		return shippingCost;
	}

	/**
	 * Sets the shipping cost.
	 *
	 * @param shippingCost the new shipping cost
	 */
	public void setShippingCost(List<ShippingCostDTO> shippingCost) {
		this.shippingCost = shippingCost;
	}

	/**
	 * Gets the total are.
	 *
	 * @return the total are
	 */
	public List<TotalAreDto> getTotalAre() {
		return totalAre;
	}

	/**
	 * Sets the total are.
	 *
	 * @param totalAre the new total are
	 */
	public void setTotalAre(List<TotalAreDto> totalAre) {
		this.totalAre = totalAre;
	}

	public List<OrderAssignDto> getAssignTo() {
		return assignTo;
	}

	public void setAssignTo(List<OrderAssignDto> assignTo) {
		this.assignTo = assignTo;
	}
	
	
	
	
	
	
}
