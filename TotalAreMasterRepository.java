package com.msr.oms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.msr.oms.entity.TotalAreMaster;

/**
 * The Interface TotalAreMasterRepository.
 */
@Repository
public interface TotalAreMasterRepository extends JpaRepository<TotalAreMaster, Long> {
}
