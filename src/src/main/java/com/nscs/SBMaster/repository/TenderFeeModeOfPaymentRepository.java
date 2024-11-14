package com.nscs.SBMaster.repository;

import com.nscs.SBMaster.model.TenderFeeModeOFPayment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TenderFeeModeOfPaymentRepository extends JpaRepository<TenderFeeModeOFPayment,Long> {
}
