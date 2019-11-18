package com.msr.oms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.msr.oms.entity.Customer;

/**
 * The Interface CustomerRepository.
 */
@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

	@Query(value = "select * from customer where status!=:status", nativeQuery = true)
	public List<Customer> getAllBrandsByStatus(@Param("status") Integer status);

	public Customer findByCompanyEmail(String companyEmail);

	@Modifying
	@Query(value = "update customer set status = :status where customer_id = :customerId", nativeQuery = true)
	public int deleteCustomer(@Param("status") Integer status, @Param("customerId") Long customerId);

	@Query(value = "select customer_name from customer where customer_id=:customerId", nativeQuery = true)
	public String getBrandNameByCustomerId(@Param("customerId") Long customerId);

	@Query(value = "select * from customer where company_email=:company_email and status!=:status", nativeQuery = true)
	public Customer findByCompanyEmailAndStatus(@Param("company_email") String companyEmail,@Param("status") Integer status);
	
	
	@Query(value = "select brand_id from brands_master b,customer c where b.brand_name=c.customer_name and c.customer_id=:customerId", nativeQuery = true)
	public Long getBrandIdByCustomerId(@Param("customerId") Long customerId);
	
}
