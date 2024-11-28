package com.nscs.SBMaster.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;


@Getter
@Setter
@AllArgsConstructor


@Entity
@Table(name = "tender_preparation")
public class TenderPreparation {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String tenderNumber;
    private String checklistPreparedBy;
    private String technicalPreparedBy;
    private String financialPreparedBy;

    private String checklistPreparedById;
    private String technicalPreparedById;
    private String financialPreparedById;

    private String checklistPreparedByLastDate;
    private String technicalPreparedByLastDate;
    private String financialPreparedByLastDate;


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

    public String getChecklistPreparedById() {
        return checklistPreparedById;
    }

    public void setChecklistPreparedById(String checklistPreparedById) {
        this.checklistPreparedById = checklistPreparedById;
    }

    public String getTechnicalPreparedById() {
        return technicalPreparedById;
    }

    public void setTechnicalPreparedById(String technicalPreparedById) {
        this.technicalPreparedById = technicalPreparedById;
    }

    public String getFinancialPreparedById() {
        return financialPreparedById;
    }

    public String getChecklistPreparedByLastDate() {
        return checklistPreparedByLastDate;
    }

    public void setChecklistPreparedByLastDate(String checklistPreparedByLastDate) {
        this.checklistPreparedByLastDate = checklistPreparedByLastDate;
    }

    public String getTechnicalPreparedByLastDate() {
        return technicalPreparedByLastDate;
    }

    public void setTechnicalPreparedByLastDate(String technicalPreparedByLastDate) {
        this.technicalPreparedByLastDate = technicalPreparedByLastDate;
    }

    public String getFinancialPreparedByLastDate() {
        return financialPreparedByLastDate;
    }

    public void setFinancialPreparedByLastDate(String financialPreparedByLastDate) {
        this.financialPreparedByLastDate = financialPreparedByLastDate;
    }

    public void setFinancialPreparedById(String financialPreparedById) {
        this.financialPreparedById = financialPreparedById;
    }


    // Constructors
    public TenderPreparation() {
    }

    public TenderPreparation(String checklistPreparedBy, String technicalPreparedBy, String financialPreparedBy) {
        this.checklistPreparedBy = checklistPreparedBy;
        this.technicalPreparedBy = technicalPreparedBy;
        this.financialPreparedBy = financialPreparedBy;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public String getChecklistPreparedBy() {
        return checklistPreparedBy;
    }

    public void setChecklistPreparedBy(String checklistPreparedBy) {
        this.checklistPreparedBy = checklistPreparedBy;
    }

    public String getTechnicalPreparedBy() {
        return technicalPreparedBy;
    }

    public void setTechnicalPreparedBy(String technicalPreparedBy) {
        this.technicalPreparedBy = technicalPreparedBy;
    }

    public String getFinancialPreparedBy() {
        return financialPreparedBy;
    }

    public void setFinancialPreparedBy(String financialPreparedBy) {
        this.financialPreparedBy = financialPreparedBy;
    }

    public String getTenderNumber() {
        return tenderNumber;
    }

    public void setTenderNumber(String tenderNumber) {
        this.tenderNumber = tenderNumber;
    }
}
