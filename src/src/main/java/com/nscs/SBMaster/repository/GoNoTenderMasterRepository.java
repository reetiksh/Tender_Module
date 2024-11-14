package com.nscs.SBMaster.repository;

import com.nscs.SBMaster.model.GoNoTenderMaster;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@Repository
public interface GoNoTenderMasterRepository extends JpaRepository<GoNoTenderMaster, Long> {

    @Modifying
    @Query(value= "update tender_detail SET proceed = 'Y' WHERE  id=:query", nativeQuery = true)
    int gonoproceed(@Param("query") String query);

}
