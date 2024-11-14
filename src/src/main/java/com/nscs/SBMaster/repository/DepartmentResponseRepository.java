package com.nscs.SBMaster.repository;
import com.nscs.SBMaster.model.Department;
import com.nscs.SBMaster.model.DepartmentResponseEntity;
import com.nscs.SBMaster.model.Tender;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DepartmentResponseRepository extends JpaRepository<DepartmentResponseEntity, Long> {
    Optional<DepartmentResponseEntity> findByTenderAndDepartment(Tender tender, Department department);}
