package com.nscs.SBMaster.repository;


import com.nscs.SBMaster.model.TenderPreparation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TenderPreparationRepository extends JpaRepository<TenderPreparation, Long> {
    // No additional methods are required for basic CRUD operations
}
