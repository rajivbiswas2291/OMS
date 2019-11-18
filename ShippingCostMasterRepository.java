package com.msr.oms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.msr.oms.entity.ShippingCostMaster;

/**
 * The Interface ShippingCostMasterRepository.
 */
@Repository
public interface ShippingCostMasterRepository extends JpaRepository<ShippingCostMaster, Long> {

}
