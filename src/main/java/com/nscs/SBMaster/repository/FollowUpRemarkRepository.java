package com.nscs.SBMaster.repository;

import com.nscs.SBMaster.model.BidEvaluationParticipantsDetails;
import com.nscs.SBMaster.model.FollowUpRemark;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FollowUpRemarkRepository extends JpaRepository<FollowUpRemark, Long> {
    List<FollowUpRemark> findByEmdMonitoringId(Long emdMonitoringId);


}
