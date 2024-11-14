package com.nscs.SBMaster.repository;

import com.nscs.SBMaster.model.ProcessingFeeModeOfPayment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProcessingFeeModeOfPaymentRepository extends JpaRepository<ProcessingFeeModeOfPayment,Long> {
}
