package com.nscs.SBMaster.repository;

import com.nscs.SBMaster.model.BidEvaluation;
import com.nscs.SBMaster.model.BidEvaluationParticipantsDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BidEvaluationParticipantsDetailsRepository extends JpaRepository<BidEvaluationParticipantsDetails,Long> {

    List<BidEvaluationParticipantsDetails> findBybidEvaluation(Long bidNumber);
    void deleteByBidEvaluation(Long bidEvaluationId);


}
