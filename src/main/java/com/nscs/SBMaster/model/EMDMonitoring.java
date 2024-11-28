package com.nscs.SBMaster.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor

@Entity
@Table(name = "emd_monitoring")
public class EMDMonitoring {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String tenderNumber;
    // Carried Forward fields
    private Double emdAmount;
    private String modeOfPayment;
    private String instrumentNo;
    private String date;
    private String emdValidity;
    private String bidValidityInDays;
    private String tenderStatus;
    private String tenderStatusDate;

    // Dropdown fields
    private String emdStatus;
    private String operationalBranch;
    private String operationalBranch_Id;
    private String branchManager;
    private String branchManager_Id;
    private String refundLetterSent; // Yes/No
    private String via; // Mail/Speed Post/By Hand

    // Display Fields
    private String ageing; // Calculated and displayed

    // Entry fields
    private String followUpPerson;
    private String concernAuthorityName;
    private String concernAuthorityDesignation;
    private String concernAuthorityContactNo;
    private String concernAuthorityEmail;

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

    // One-to-Many relationship for follow-up remarks
    @OneToMany(mappedBy = "emdMonitoringId", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<FollowUpRemark> followUpRemarks = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTenderNumber() {
        return tenderNumber;
    }

    public void setTenderNumber(String tenderNumber) {
        this.tenderNumber = tenderNumber;
    }

    public Double getEmdAmount() {
        return emdAmount;
    }

    public void setEmdAmount(Double emdAmount) {
        this.emdAmount = emdAmount;
    }

    public String getModeOfPayment() {
        return modeOfPayment;
    }

    public void setModeOfPayment(String modeOfPayment) {
        this.modeOfPayment = modeOfPayment;
    }

    public String getInstrumentNo() {
        return instrumentNo;
    }

    public void setInstrumentNo(String instrumentNo) {
        this.instrumentNo = instrumentNo;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getEmdValidity() {
        return emdValidity;
    }

    public void setEmdValidity(String emdValidity) {
        this.emdValidity = emdValidity;
    }

    public String getBidValidityInDays() {
        return bidValidityInDays;
    }

    public void setBidValidityInDays(String bidValidityInDays) {
        this.bidValidityInDays = bidValidityInDays;
    }

    public String getTenderStatus() {
        return tenderStatus;
    }

    public void setTenderStatus(String tenderStatus) {
        this.tenderStatus = tenderStatus;
    }

    public String getTenderStatusDate() {
        return tenderStatusDate;
    }

    public void setTenderStatusDate(String tenderStatusDate) {
        this.tenderStatusDate = tenderStatusDate;
    }

    public String getEmdStatus() {
        return emdStatus;
    }

    public void setEmdStatus(String emdStatus) {
        this.emdStatus = emdStatus;
    }

    public String getOperationalBranch() {
        return operationalBranch;
    }

    public void setOperationalBranch(String operationalBranch) {
        this.operationalBranch = operationalBranch;
    }

    public String getBranchManager() {
        return branchManager;
    }

    public void setBranchManager(String branchManager) {
        this.branchManager = branchManager;
    }

    public String getRefundLetterSent() {
        return refundLetterSent;
    }

    public void setRefundLetterSent(String refundLetterSent) {
        this.refundLetterSent = refundLetterSent;
    }

    public String getVia() {
        return via;
    }

    public void setVia(String via) {
        this.via = via;
    }

    public String getAgeing() {
        return ageing;
    }

    public void setAgeing(String ageing) {
        this.ageing = ageing;
    }

    public String getFollowUpPerson() {
        return followUpPerson;
    }

    public void setFollowUpPerson(String followUpPerson) {
        this.followUpPerson = followUpPerson;
    }

    public String getConcernAuthorityName() {
        return concernAuthorityName;
    }

    public void setConcernAuthorityName(String concernAuthorityName) {
        this.concernAuthorityName = concernAuthorityName;
    }

    public String getConcernAuthorityDesignation() {
        return concernAuthorityDesignation;
    }

    public void setConcernAuthorityDesignation(String concernAuthorityDesignation) {
        this.concernAuthorityDesignation = concernAuthorityDesignation;
    }

    public String getConcernAuthorityContactNo() {
        return concernAuthorityContactNo;
    }

    public void setConcernAuthorityContactNo(String concernAuthorityContactNo) {
        this.concernAuthorityContactNo = concernAuthorityContactNo;
    }

    public String getConcernAuthorityEmail() {
        return concernAuthorityEmail;
    }

    public void setConcernAuthorityEmail(String concernAuthorityEmail) {
        this.concernAuthorityEmail = concernAuthorityEmail;
    }

    public List<FollowUpRemark> getFollowUpRemarks() {
        return followUpRemarks;
    }

    public void setFollowUpRemarks(List<FollowUpRemark> followUpRemarks) {
        this.followUpRemarks = followUpRemarks;
    }
    public EMDMonitoring() {
        // Default constructor
    }

    public String getOperationalBranch_Id() {
        return operationalBranch_Id;
    }

    public void setOperationalBranch_Id(String operationalBranch_Id) {
        this.operationalBranch_Id = operationalBranch_Id;
    }

    public String getBranchManager_Id() {
        return branchManager_Id;
    }

    public void setBranchManager_Id(String branchManager_Id) {
        this.branchManager_Id = branchManager_Id;
    }

    public void updateFrom(EMDMonitoring source) {
        if (source == null) {
            return;
        }

        // Carried Forward fields
        this.tenderNumber = source.getTenderNumber();
        this.emdAmount = source.getEmdAmount();
        this.modeOfPayment = source.getModeOfPayment();
        this.instrumentNo = source.getInstrumentNo();
        this.date = source.getDate();
        this.emdValidity = source.getEmdValidity();
        this.bidValidityInDays = source.getBidValidityInDays();
        this.tenderStatus = source.getTenderStatus();
        this.tenderStatusDate = source.getTenderStatusDate();

        // Dropdown fields
        this.emdStatus = source.getEmdStatus();
        this.operationalBranch = source.getOperationalBranch();
        this.branchManager = source.getBranchManager();
        this.refundLetterSent = source.getRefundLetterSent();
        this.via = source.getVia();

        // Display fields
        this.ageing = source.getAgeing();

        // Entry fields
        this.followUpPerson = source.getFollowUpPerson();
        this.concernAuthorityName = source.getConcernAuthorityName();
        this.concernAuthorityDesignation = source.getConcernAuthorityDesignation();
        this.concernAuthorityContactNo = source.getConcernAuthorityContactNo();
        this.concernAuthorityEmail = source.getConcernAuthorityEmail();
        this.operationalBranch_Id=source.getOperationalBranch_Id();
        this.branchManager_Id= source.getOperationalBranch_Id();
        this.userId = source.getUserId();

    }


}
