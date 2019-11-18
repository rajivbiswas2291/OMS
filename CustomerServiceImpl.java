package com.msr.oms.service.impl;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.msr.oms.dto.CustomerDTO;
import com.msr.oms.service.CustomerService;

/**
 * the class CustomerServiceImpl.
 * 
 * @author vamshib
 *
 */
@Service
@Transactional
public class CustomerServiceImpl implements CustomerService{


	/*
	 * (non-Javadoc)
	 * @see com.lgndu.oms.service.CustomerService#saveCustomer(com.lgndu.oms.dto.CustomerDTO)
	 */
	@Override
	public ResponseEntity<CustomerDTO> saveCustomer(CustomerDTO customerDTO) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
