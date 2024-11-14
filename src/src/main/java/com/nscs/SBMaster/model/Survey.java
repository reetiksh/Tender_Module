package com.nscs.SBMaster.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.Date;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="tender_survey_detail")
public class Survey {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String tenderNumber;
    private String surveyRequired;
    private String surveyUnit;
    private String survey_id;
    private String surveySendDate;
    private String surveyorName;
    private String surveyorName_id;
    private String surveyStatus;
    private String surveyReceiveDate;
    private String surveyRemarks;
    private String surveyApprove;
    private String rejectRemark;


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

    public String getSurveyRequired() {
        return surveyRequired;
    }

    public void setSurveyRequired(String surveyRequired) {
        this.surveyRequired = surveyRequired;
    }

    public String getSurveyUnit() {
        return surveyUnit;
    }

    public void setSurveyUnit(String surveyUnit) {
        this.surveyUnit = surveyUnit;
    }

    public String getSurvey_id() {
        return survey_id;
    }

    public void setSurvey_id(String survey_id) {
        this.survey_id = survey_id;
    }

    public String getSurveySendDate() {
        return surveySendDate;
    }

    public void setSurveySendDate(String surveySendDate) {
        this.surveySendDate = surveySendDate;
    }

    public String getSurveyorName() {
        return surveyorName;
    }

    public void setSurveyorName(String surveyorName) {
        this.surveyorName = surveyorName;
    }

    public String getSurveyorName_id() {
        return surveyorName_id;
    }

    public void setSurveyorName_id(String surveyorName_id) {
        this.surveyorName_id = surveyorName_id;
    }

    public String getSurveyStatus() {
        return surveyStatus;
    }

    public void setSurveyStatus(String surveyStatus) {
        this.surveyStatus = surveyStatus;
    }

    public String getSurveyReceiveDate() {
        return surveyReceiveDate;
    }

    public void setSurveyReceiveDate(String surveyReceiveDate) {
        this.surveyReceiveDate = surveyReceiveDate;
    }

    public String getSurveyRemarks() {
        return surveyRemarks;
    }

    public void setSurveyRemarks(String surveyRemarks) {
        this.surveyRemarks = surveyRemarks;
    }

    public String getSurveyApprove() {
        return surveyApprove;
    }

    public void setSurveyApprove(String surveyApprove) {
        this.surveyApprove = surveyApprove;
    }

    public String getRejectRemark() {
        return rejectRemark;
    }

    public void setRejectRemark(String rejectRemark) {
        this.rejectRemark = rejectRemark;
    }
}
