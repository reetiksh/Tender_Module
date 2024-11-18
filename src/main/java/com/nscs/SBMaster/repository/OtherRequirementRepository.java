package com.nscs.SBMaster.repository;

import com.nscs.SBMaster.model.OtherRequirement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface OtherRequirementRepository extends JpaRepository<OtherRequirement, Long> {
        Optional<OtherRequirement> findByTenderNumber(String TenderNumber);
    }

