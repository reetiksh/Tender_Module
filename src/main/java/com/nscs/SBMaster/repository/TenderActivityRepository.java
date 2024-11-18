package com.nscs.SBMaster.repository;



import com.nscs.SBMaster.model.TenderActivity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TenderActivityRepository extends JpaRepository<TenderActivity, Long> {
}
