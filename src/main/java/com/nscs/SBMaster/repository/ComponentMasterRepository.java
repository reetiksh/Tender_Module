package com.nscs.SBMaster.repository;

import com.nscs.SBMaster.model.ComponentMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ComponentMasterRepository extends JpaRepository<ComponentMaster, Long> {
    List<ComponentMaster> findByStep(String step);
}
