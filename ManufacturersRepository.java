package com.msr.oms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.msr.oms.entity.Manufacturers;

public interface ManufacturersRepository extends JpaRepository<Manufacturers, Long> {

	
	@Query(value="select * from manufacturers where status!=:status",nativeQuery = true)
	public List<Manufacturers> getAllBrandsByStatus(@Param("status") Integer status);
}
