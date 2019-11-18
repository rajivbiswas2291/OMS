package com.msr.oms.service;

import org.springframework.http.ResponseEntity;

import com.msr.oms.dto.CustomerDTO;

/**
 * The Interface CustomerService.
 *
 * @author vamshib
 * 
 * this interface is used for doing operations like adding/editing/deleting a customer.
 */
public interface CustomerService {

	/**
	 * this method is used for saving the customer details in database.
	 *
	 * @param customerDTO the customer DTO
	 * @return CustomerDTO
	 */
	public ResponseEntity<CustomerDTO> saveCustomer(CustomerDTO customerDTO);
}
