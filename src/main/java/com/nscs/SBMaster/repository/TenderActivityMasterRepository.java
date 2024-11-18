package com.nscs.SBMaster.repository;



import com.nscs.SBMaster.model.TenderActivityMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TenderActivityMasterRepository extends JpaRepository<TenderActivityMaster, Long> {
}
