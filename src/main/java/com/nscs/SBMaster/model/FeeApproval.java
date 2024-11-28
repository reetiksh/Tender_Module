package com.nscs.SBMaster.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;


import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="tender_Fee_Approval")
public class FeeApproval {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Size(max = 20)
    private String tenderNumber;
    @Length(max = 20)
    private String TenderFee;
    @Length(max = 1)
    private String TenderFeestatus;
    @Length(max = 50)
    private String TenderFeeInstument;
    @Length(max = 10)
    private String TenderFeeDate;
    @Length(max = 10)
    private String TenderFeeValidity;
    @Length(max = 10)
    private String TenderFeeReceiveDate;
    @Length(max = 20)
    private String TenderFeeModeOfPayment;
    @Length(max = 21)
    private String EMDFee;
    @Length(max = 21)
    private String EMDFeePending;
    @Length(max = 1)
    private String EMDFeestatus;
    @Length(max = 50)
    private String EMDFeeInstument;
    @Length(max = 10)
    private String EMDFeeDate;
    @Length(max = 10)
    private String EMDFeeValidity;
    @Length(max = 10)
    private String EMDFeeReceiveDate;
    @Length(max = 20)
    private String EMDFeeModeOfPayment;
    @Length(max = 21)
    private String ProcessingFee;
    @Length(max = 1)
    private String ProcessingFeestatus;
    @Length(max = 50)
    private String ProcessingFeeInstument;
    @Length(max = 10)
    private String ProcessingFeeDate;
    @Length(max = 10)
    private String ProcessingFeeValidity;
    @Length(max = 10)
    private String ProcessingFeeReceiveDate;
    @Length(max = 20)
    private String ProcessingFeeModeOfPayment;

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

    public String getEMDFeePending() {
        return EMDFeePending;
    }

    public void setEMDFeePending(String EMDFeePending) {
        this.EMDFeePending = EMDFeePending;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTenderNumber() {
        return tenderNumber;
    }

    public void setTenderNumber( String tenderNumber) {
        this.tenderNumber = tenderNumber;
    }

    public  String getProcessingFeeModeOfPayment() {
        return ProcessingFeeModeOfPayment;
    }

    public void setProcessingFeeModeOfPayment(@Length(max = 20) String processingFeeModeOfPayment) {
        ProcessingFeeModeOfPayment = processingFeeModeOfPayment;
    }

    public String getTenderFee() {
        return TenderFee;
    }

    public void setTenderFee(String tenderFee) {
        TenderFee = tenderFee;
    }

    public String getTenderFeestatus() {
        return TenderFeestatus;
    }

    public void setTenderFeestatus(String tenderFeestatus) {
        TenderFeestatus = tenderFeestatus;
    }

    public String getTenderFeeInstument() {
        return TenderFeeInstument;
    }

    public void setTenderFeeInstument(String tenderFeeInstument) {
        TenderFeeInstument = tenderFeeInstument;
    }

    public String getTenderFeeDate() {
        return TenderFeeDate;
    }

    public void setTenderFeeDate(String tenderFeeDate) {
        TenderFeeDate = tenderFeeDate;
    }

    public String getTenderFeeValidity() {
        return TenderFeeValidity;
    }

    public void setTenderFeeValidity(String tenderFeeValidity) {
        TenderFeeValidity = tenderFeeValidity;
    }

    public String getEMDFee() {
        return EMDFee;
    }

    public void setEMDFee(String EMDFee) {
        this.EMDFee = EMDFee;
    }

    public String getEMDFeestatus() {
        return EMDFeestatus;
    }

    public void setEMDFeestatus(String EMDFeestatus) {
        this.EMDFeestatus = EMDFeestatus;
    }

    public String getEMDFeeInstument() {
        return EMDFeeInstument;
    }

    public void setEMDFeeInstument(String EMDFeeInstument) {
        this.EMDFeeInstument = EMDFeeInstument;
    }

    public String getEMDFeeDate() {
        return EMDFeeDate;
    }

    public void setEMDFeeDate(String EMDFeeDate) {
        this.EMDFeeDate = EMDFeeDate;
    }

    public String getEMDFeeValidity() {
        return EMDFeeValidity;
    }

    public void setEMDFeeValidity(String EMDFeeValidity) {
        this.EMDFeeValidity = EMDFeeValidity;
    }

    public String getProcessingFee() {
        return ProcessingFee;
    }

    public void setProcessingFee(String processingFee) {
        ProcessingFee = processingFee;
    }

    public String getProcessingFeestatus() {
        return ProcessingFeestatus;
    }

    public void setProcessingFeestatus(String processingFeestatus) {
        ProcessingFeestatus = processingFeestatus;
    }

    public String getProcessingFeeInstument() {
        return ProcessingFeeInstument;
    }

    public void setProcessingFeeInstument(String processingFeeInstument) {
        ProcessingFeeInstument = processingFeeInstument;
    }

    public String getProcessingFeeDate() {
        return ProcessingFeeDate;
    }

    public void setProcessingFeeDate(String processingFeeDate) {
        ProcessingFeeDate = processingFeeDate;
    }

    public String getProcessingFeeValidity() {
        return ProcessingFeeValidity;
    }

    public void setProcessingFeeValidity(String processingFeeValidity) {
        ProcessingFeeValidity = processingFeeValidity;
    }

    public String getTenderFeeReceiveDate() {
        return TenderFeeReceiveDate;
    }

    public void setTenderFeeReceiveDate(String tenderFeeReceiveDate) {
        TenderFeeReceiveDate = tenderFeeReceiveDate;
    }

    public String getTenderFeeModeOfPayment() {
        return TenderFeeModeOfPayment;
    }

    public void setTenderFeeModeOfPayment(String tenderFeeModeOfPayment) {
        TenderFeeModeOfPayment = tenderFeeModeOfPayment;
    }

    public String getEMDFeeReceiveDate() {
        return EMDFeeReceiveDate;
    }

    public void setEMDFeeReceiveDate(String EMDFeeReceiveDate) {
        this.EMDFeeReceiveDate = EMDFeeReceiveDate;
    }

    public String getEMDFeeModeOfPayment() {
        return EMDFeeModeOfPayment;
    }

    public void setEMDFeeModeOfPayment(String EMDFeeModeOfPayment) {
        this.EMDFeeModeOfPayment = EMDFeeModeOfPayment;
    }

    public String getProcessingFeeReceiveDate() {
        return ProcessingFeeReceiveDate;
    }

    public void setProcessingFeeReceiveDate(String processingFeeReceiveDate) {
        ProcessingFeeReceiveDate = processingFeeReceiveDate;
    }

    public String getProcessingModeOfPayment() {
        return ProcessingFeeModeOfPayment;
    }

    public void setProcessingModeOfPayment(String processingModeOfPayment) {
        ProcessingFeeModeOfPayment = processingModeOfPayment;
    }


    public void updateFrom(FeeApproval source) {
        if (source == null) {
            return;
        }

        this.tenderNumber = source.getTenderNumber();
        this.TenderFee = source.getTenderFee();
        this.TenderFeestatus = source.getTenderFeestatus();
        this.TenderFeeInstument = source.getTenderFeeInstument();
        this.TenderFeeDate = source.getTenderFeeDate();
        this.TenderFeeValidity = source.getTenderFeeValidity();
        this.TenderFeeReceiveDate = source.getTenderFeeReceiveDate();
        this.TenderFeeModeOfPayment = source.getTenderFeeModeOfPayment();
        this.EMDFee = source.getEMDFee();
        this.EMDFeePending = source.getEMDFeePending();
        this.EMDFeestatus = source.getEMDFeestatus();
        this.EMDFeeInstument = source.getEMDFeeInstument();
        this.EMDFeeDate = source.getEMDFeeDate();
        this.EMDFeeValidity = source.getEMDFeeValidity();
        this.EMDFeeReceiveDate = source.getEMDFeeReceiveDate();
        this.EMDFeeModeOfPayment = source.getEMDFeeModeOfPayment();
        this.ProcessingFee = source.getProcessingFee();
        this.ProcessingFeestatus = source.getProcessingFeestatus();
        this.ProcessingFeeInstument = source.getProcessingFeeInstument();
        this.ProcessingFeeDate = source.getProcessingFeeDate();
        this.ProcessingFeeValidity = source.getProcessingFeeValidity();
        this.ProcessingFeeReceiveDate = source.getProcessingFeeReceiveDate();
        this.ProcessingFeeModeOfPayment = source.getProcessingFeeModeOfPayment();

        this.userId = source.getUserId();

        // ... Update any additional fields

    }
}
