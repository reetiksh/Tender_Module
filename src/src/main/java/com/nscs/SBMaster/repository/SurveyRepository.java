package com.nscs.SBMaster.repository;

import com.nscs.SBMaster.model.Survey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface SurveyRepository extends JpaRepository<Survey, Long> {
    Optional<Survey> findByTenderNumber(String TenderNumber);

}
