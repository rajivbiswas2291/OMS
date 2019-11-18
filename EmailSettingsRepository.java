package com.msr.oms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.msr.oms.entity.EmailSettings;

/**
 * The Interface EmailSettingsRepository.
 * @author vamshib
 */
@Repository
public interface EmailSettingsRepository extends JpaRepository<EmailSettings, Long> {

}
