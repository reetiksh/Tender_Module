package com.nscs.SBMaster.repository;

import com.nscs.SBMaster.model.TenderSource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TenderSourceRepository extends JpaRepository<TenderSource,Long> {
}
