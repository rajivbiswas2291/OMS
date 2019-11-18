package com.msr.oms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.msr.oms.entity.CurrencyMaster;

/**
 * The Interface CurrencyMasterRepository.
 */
@Repository
public interface CurrencyMasterRepository extends JpaRepository<CurrencyMaster, Long> {
}
