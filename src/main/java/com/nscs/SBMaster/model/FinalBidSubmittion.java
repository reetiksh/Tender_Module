package com.nscs.SBMaster.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Final_Bid_submittion")
public class FinalBidSubmittion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String tenderNumber;
    private String TechnicalApproveBy;
    private String TechnicalApproveBy_id;
    private String FinancialApproveBy;
    private String FinancialApproveBy_id;
    private String participationStatus;
    private String notParticipatedReason;

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

    public String getTechnicalApproveBy() {
        return TechnicalApproveBy;
    }

    public void setTechnicalApproveBy(String technicalApproveBy) {
        TechnicalApproveBy = technicalApproveBy;
    }

    public String getTechnicalApproveBy_id() {
        return TechnicalApproveBy_id;
    }

    public void setTechnicalApproveBy_id(String technicalApproveBy_id) {
        TechnicalApproveBy_id = technicalApproveBy_id;
    }

    public String getFinancialApproveBy() {
        return FinancialApproveBy;
    }

    public void setFinancialApproveBy(String financialApproveBy) {
        FinancialApproveBy = financialApproveBy;
    }

    public String getFinancialApproveBy_id() {
        return FinancialApproveBy_id;
    }

    public void setFinancialApproveBy_id(String financialApproveBy_id) {
        FinancialApproveBy_id = financialApproveBy_id;
    }

    public String getParticipationStatus() {
        return participationStatus;
    }

    public void setParticipationStatus(String participationStatus) {
        this.participationStatus = participationStatus;
    }

    public String getNotParticipatedReason() {
        return notParticipatedReason;
    }

    public void setNotParticipatedReason(String notParticipatedReason) {
        this.notParticipatedReason = notParticipatedReason;
    }
}
