package com.nscs.SBMaster.repository;

import com.nscs.SBMaster.model.BidEvaluation;
import com.nscs.SBMaster.model.Costing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CostingRepository extends JpaRepository<Costing,Long> {
    Optional<Costing> findByTenderNumber(String TenderNumber);

}
