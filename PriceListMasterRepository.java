package com.msr.oms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.msr.oms.entity.PriceListMaster;

/**
 * The Interface PriceListMasterRepository.
 */
@Repository
public interface PriceListMasterRepository extends JpaRepository<PriceListMaster, Long> {
}
