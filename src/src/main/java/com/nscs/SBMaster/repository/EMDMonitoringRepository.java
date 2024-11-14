package com.nscs.SBMaster.repository;

import com.nscs.SBMaster.model.EMDMonitoring;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EMDMonitoringRepository extends JpaRepository<EMDMonitoring, Long> {
     Optional<EMDMonitoring> findByTenderNumber(String TenderNumber);}