package com.nscs.SBMaster.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@Entity
@Table(name = "bid_evaluation")
public class BidEvaluation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String tenderNumber;
    private String technicalStatus;
    private String technicalDisqualifyReason;
    private String financialStatus;
    private Integer ourRank;
    private String financialDisqualifyReason;
    private String companyName;
    private Integer participantsRank;
    private Double quotedRates;
    private String atPar;
    private String atAbove;
    private String atBelow;
    private String awarded;
    private String awardedCompanyName;
    private String finalStatus;
    private String technicalDate;
    private String financialDate;
    private String awardedDate;
    private String finalDate;

    //
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

    @OneToMany(mappedBy = "bidEvaluation", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<BidEvaluationParticipantsDetails> participantsDetails = new ArrayList<>();

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

    public Integer getParticipantsRank() {
        return participantsRank;
    }

    public void setParticipantsRank(Integer participantsRank) {
        this.participantsRank = participantsRank;
    }

    public List<BidEvaluationParticipantsDetails> getParticipantsDetails() {
        return participantsDetails;
    }

    public void setParticipantsDetails(List<BidEvaluationParticipantsDetails> participantsDetails) {
        this.participantsDetails = participantsDetails;
    }

    public String getTechnicalStatus() {
        return technicalStatus;
    }

    public void setTechnicalStatus(String technicalStatus) {
        this.technicalStatus = technicalStatus;
    }

    public String getTechnicalDisqualifyReason() {
        return technicalDisqualifyReason;
    }

    public void setTechnicalDisqualifyReason(String technicalDisqualifyReason) {
        this.technicalDisqualifyReason = technicalDisqualifyReason;
    }

    public String getFinancialStatus() {
        return financialStatus;
    }

    public void setFinancialStatus(String financialStatus) {
        this.financialStatus = financialStatus;
    }

    public Integer getOurRank() {
        return ourRank;
    }

    public void setOurRank(Integer ourRank) {
        this.ourRank = ourRank;
    }

    public String getFinancialDisqualifyReason() {
        return financialDisqualifyReason;
    }

    public void setFinancialDisqualifyReason(String financialDisqualifyReason) {
        this.financialDisqualifyReason = financialDisqualifyReason;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public Integer getRank() {
        return participantsRank;
    }

    public void setRank(Integer rank) {
        this.participantsRank = rank;
    }

    public Double getQuotedRates() {
        return quotedRates;
    }

    public void setQuotedRates(Double quotedRates) {
        this.quotedRates = quotedRates;
    }

    public String getAtPar() {
        return atPar;
    }

    public void setAtPar(String atPar) {
        this.atPar = atPar;
    }

    public String getAtAbove() {
        return atAbove;
    }

    public void setAtAbove(String atAbove) {
        this.atAbove = atAbove;
    }

    public String getAtBelow() {
        return atBelow;
    }

    public void setAtBelow(String atBelow) {
        this.atBelow = atBelow;
    }

    public String getAwarded() {
        return awarded;
    }

    public void setAwarded(String awarded) {
        this.awarded = awarded;
    }

    public String getAwardedCompanyName() {
        return awardedCompanyName;
    }

    public void setAwardedCompanyName(String awardedCompanyName) {
        this.awardedCompanyName = awardedCompanyName;
    }

    public String getFinalStatus() {
        return finalStatus;
    }

    public void setFinalStatus(String finalStatus) {
        this.finalStatus = finalStatus;
    }


    public String getTechnicalDate() {
        return technicalDate;
    }

    public void setTechnicalDate(String technicalDate) {
        this.technicalDate = technicalDate;
    }

    public String getFinancialDate() {
        return financialDate;
    }

    public void setFinancialDate(String financialDate) {
        this.financialDate = financialDate;
    }

    public String getAwardedDate() {
        return awardedDate;
    }

    public void setAwardedDate(String awardedDate) {
        this.awardedDate = awardedDate;
    }

    public String getFinalDate() {
        return finalDate;
    }

    public void setFinalDate(String finalDate) {
        this.finalDate = finalDate;
    }
    public BidEvaluation() {
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

    public void updateFrom(BidEvaluation source) {
        if (source == null) {
            return;
        }
        this.tenderNumber = source.getTenderNumber();
        this.technicalStatus= source.getTechnicalStatus();
        this.technicalDisqualifyReason= source.getTechnicalDisqualifyReason();
        this.financialStatus= source.getFinancialStatus();
        this.ourRank= source.getOurRank();
        this.financialDisqualifyReason = source.getFinancialDisqualifyReason();
        this.companyName = source.getCompanyName();
        this.participantsRank = source.getParticipantsRank();
        this.quotedRates = source.getQuotedRates();
        this.atPar = source.getAtPar();
        this.atAbove = source.getAtAbove();
        this.atBelow = source.getAtBelow();
        this.awarded = source.getAwarded();
        this.awardedCompanyName = source.getAwardedCompanyName();
        this.finalStatus = source.getFinalStatus();
        this.technicalDate = source.getTechnicalDate();
        this.financialDate = source.getFinancialDate();
        this.awardedDate = source.getAwardedDate();
        this.finalDate = source.getFinalDate();
        this.userId = source.getUserId();


    }
}
