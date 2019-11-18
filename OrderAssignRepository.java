package com.msr.oms.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.msr.oms.entity.OrderAssign;

@Repository
public interface OrderAssignRepository extends JpaRepository<OrderAssign, Long> {
}
