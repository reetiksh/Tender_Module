package com.nscs.SBMaster.model;

import com.nscs.SBMaster.services.BidEvaluationParticipantsDetailsService;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="bid_evaluation_participants_details")
public class BidEvaluationParticipantsDetails {
     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     private Long id;

    private String participantRank;
    private String participantName;
    private Long bidEvaluation;
    private String quotedRates;
    private String quotedRateType;

    public String getQuotedRateType() {
        return quotedRateType;
    }

    public void setQuotedRateType(String quotedRateType) {
        this.quotedRateType = quotedRateType;
    }

    public String getQuotedRates() {
        return quotedRates;
    }

    public void setQuotedRates(String quotedRates) {
        this.quotedRates = quotedRates;
    }

    public Long getBidEvaluation() {
        return bidEvaluation;
    }

    public void setBidEvaluation(Long bidEvaluation) {
        this.bidEvaluation = bidEvaluation;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getParticipantName() {
        return participantName;
    }

    public void setParticipantName(String participantName) {
        this.participantName = participantName;
    }

    public String getParticipantRank() {
        return participantRank;
    }

    public void setParticipantRank(String participantRank) {
        this.participantRank = participantRank;
    }
    public BidEvaluationParticipantsDetails(Long bidEvaluation,String participantRank,String participantName,String quotedRates,String quotedRateType){
        this.bidEvaluation=bidEvaluation;
        this.participantName=participantName;
        this.participantRank=participantRank;
        this.quotedRates=quotedRates;
        this.quotedRateType=quotedRateType;
    }
}
