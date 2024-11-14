package com.nscs.SBMaster.repository;

import com.nscs.SBMaster.model.BidEvaluation;
import com.nscs.SBMaster.model.FeeApproval;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BidEvaluationRepository extends JpaRepository<BidEvaluation, Long> {

        Optional<BidEvaluation> findByTenderNumber(String TenderNumber);
}
