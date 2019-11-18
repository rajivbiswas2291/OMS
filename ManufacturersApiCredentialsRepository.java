package com.msr.oms.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.msr.oms.entity.ManufacturersApiCredentials;

public interface ManufacturersApiCredentialsRepository extends JpaRepository<ManufacturersApiCredentials, Long> {

	@Query(value= "select * from manufacturer_api_details where manufacturer_id=:manufacturer_id and status!=:status", nativeQuery = true)
	public ManufacturersApiCredentials getApiCredentials(@Param("manufacturer_id") Long manufacturerId,@Param("status") int status);
	
}
