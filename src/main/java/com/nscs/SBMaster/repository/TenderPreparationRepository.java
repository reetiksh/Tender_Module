package com.nscs.SBMaster.repository;


import com.nscs.SBMaster.model.Survey;
import com.nscs.SBMaster.model.TenderPreparation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TenderPreparationRepository extends JpaRepository<TenderPreparation, Long> {

    // No additional methods are required for basic CRUD operations
    Optional<TenderPreparation> findByTenderNumber(String TenderNumber);
}
