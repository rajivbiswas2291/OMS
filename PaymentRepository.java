package com.msr.oms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.msr.oms.entity.PaymentsEntity;

public interface PaymentRepository extends JpaRepository<PaymentsEntity,Long> {

}
