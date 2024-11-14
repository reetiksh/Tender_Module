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
@Table(name = "costing")
public class Costing {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String tenderNumber;
    private String asPerSurvey;
    private String asPerTender;
    private String approvedRates;
    private String costingQuotedRates;
    private String quotedRatesRoundOff;

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

    public String getAsPerSurvey() {
        return asPerSurvey;
    }

    public void setAsPerSurvey(String asPerSurvey) {
        this.asPerSurvey = asPerSurvey;
    }

    public String getAsPerTender() {
        return asPerTender;
    }

    public void setAsPerTender(String asPerTender) {
        this.asPerTender = asPerTender;
    }

    public String getApprovedRates() {
        return approvedRates;
    }

    public void setApprovedRates(String approvedRates) {
        this.approvedRates = approvedRates;
    }

    public String getCostingQuotedRates() {
        return costingQuotedRates;
    }

    public void setCostingQuotedRates(String costingQuotedRates) {
        this.costingQuotedRates = costingQuotedRates;
    }

    public String getQuotedRatesRoundOff() {
        return quotedRatesRoundOff;
    }

    public void setQuotedRatesRoundOff(String quotedRatesRoundOff) {
        this.quotedRatesRoundOff = quotedRatesRoundOff;
    }

    public void updateFrom(Costing source) {
        if (source == null) {
            return;
        }
        this.tenderNumber = source.getTenderNumber();
        this.asPerSurvey = source.getAsPerSurvey();
        this.asPerTender = source.getAsPerTender();
        this.approvedRates = source.getApprovedRates();
        this.costingQuotedRates = source.getCostingQuotedRates();
        this.quotedRatesRoundOff = source.getQuotedRatesRoundOff();
    }
}
