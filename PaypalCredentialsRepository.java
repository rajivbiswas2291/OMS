package com.msr.oms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.msr.oms.entity.PaypalCredentialsEntity;

public interface PaypalCredentialsRepository extends JpaRepository<PaypalCredentialsEntity,Long> {

}
