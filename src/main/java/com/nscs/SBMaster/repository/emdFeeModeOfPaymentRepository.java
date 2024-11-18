package com.nscs.SBMaster.repository;

import com.nscs.SBMaster.model.emdModeOfPayment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface emdFeeModeOfPaymentRepository extends JpaRepository<emdModeOfPayment,Long> {
}
