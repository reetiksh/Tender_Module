package com.nscs.SBMaster.repository;

import com.nscs.SBMaster.model.FeeApproval;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FeeApprovalRepository extends JpaRepository<FeeApproval, Long> {
    Optional<FeeApproval> findByTenderNumber(String TenderNumber);

}
