package com.nscs.SBMaster.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Date;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;




@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="tender_otherReqirement_detail")
public class OtherRequirement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String tenderNumber;
    private String LegalDepartment;
    private String AccountDepartment;
    private String SCMDepartment;
    private String HRDepartment;

    private String LegalDepartment_id;
    private String AccountDepartment_id;
    private String SCMDepartment_id;
    private String HRDepartment_id;

    private String userId;

    @Column(name = "insert_date_time", updatable = false)
    private LocalDateTime insertDateTime;

    @Column(name = "update_date_time")
    private LocalDateTime updateDateTime;

    @PrePersist
    protected void onCreate() {
        insertDateTime = LocalDateTime.now(); // Set the insert timestamp
        updateDateTime = insertDateTime; // Initially set update timestamp the same as insert
    }

    @PreUpdate
    protected void onUpdate() {
        updateDateTime = LocalDateTime.now(); // Set the update timestamp on updates
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public LocalDateTime getInsertDateTime() {
        return insertDateTime;
    }

    public void setInsertDateTime(LocalDateTime insertDateTime) {
        this.insertDateTime = insertDateTime;
    }

    public LocalDateTime getUpdateDateTime() {
        return updateDateTime;
    }

    public void setUpdateDateTime(LocalDateTime updateDateTime) {
        this.updateDateTime = updateDateTime;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setTenderNumber(String tenderNumber) {
        this.tenderNumber = tenderNumber;
    }

    public void setLegalDepartment(String legalDepartment) {
        LegalDepartment = legalDepartment;
    }

    public void setAccountDepartment(String accountDepartment) {
        AccountDepartment = accountDepartment;
    }

    public void setSCMDepartment(String SCMDepartment) {
        this.SCMDepartment = SCMDepartment;
    }

    public void setHRDepartment(String HRDepartment) {
        this.HRDepartment = HRDepartment;
    }

    public void setLegalDepartment_id(String legalDepartment_id) {
        LegalDepartment_id = legalDepartment_id;
    }

    public void setAccountDepartment_id(String accountDepartment_id) {
        AccountDepartment_id = accountDepartment_id;
    }

    public void setSCMDepartment_id(String SCMDepartment_id) {
        this.SCMDepartment_id = SCMDepartment_id;
    }

    public void setHRDepartment_id(String HRDepartment_id) {
        this.HRDepartment_id = HRDepartment_id;
    }

    public String getTenderNumber() {
        return tenderNumber;
    }

    public String getLegalDepartment() {
        return LegalDepartment;
    }

    public String getAccountDepartment() {
        return AccountDepartment;
    }

    public String getSCMDepartment() {
        return SCMDepartment;
    }

    public String getHRDepartment() {
        return HRDepartment;
    }

    public String getLegalDepartment_id() {
        return LegalDepartment_id;
    }

    public String getAccountDepartment_id() {
        return AccountDepartment_id;
    }

    public String getSCMDepartment_id() {
        return SCMDepartment_id;
    }

    public String getHRDepartment_id() {
        return HRDepartment_id;
    }
}
