package com.nscs.SBMaster.repository;

import com.nscs.SBMaster.model.FeeApproval;
import com.nscs.SBMaster.model.PreBidMeet;
import com.nscs.SBMaster.model.Tender;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface PreBidMeetRepository extends JpaRepository<PreBidMeet, Long> {
    Optional<PreBidMeet> findByTenderNumber(String TenderNumber);
    }
