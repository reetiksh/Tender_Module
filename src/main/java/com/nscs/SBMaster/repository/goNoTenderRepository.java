package com.nscs.SBMaster.repository;


import com.nscs.SBMaster.model.goNoTender;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface goNoTenderRepository extends JpaRepository<goNoTender, Long>{

    @Query(value = "SELECT top(1)* FROM tender_go_no WHERE tender_id = :tenderId", nativeQuery = true)
   goNoTender findTendersBytenderId(@Param("tenderId") String tenderId);
}



