package com.nscs.SBMaster.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;


import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="tender_detail")
public class Tender {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String publishDate;
    private String dueDate;
    private String nameOfWork;
    private String emd;
    private String tenderFees;
    private String modeOfPayment;
    private String tenderValue;
    private Boolean msePreference;
    private String zone;
    private String zone_id;
    private String department_id;
    private String department;
    private String division_id;
    private String division;
    private String proceed;
    private String customerName;
    private String customerName_id;
    private String product;
    private String modeOfPaymentEMD;
    private String preBidDate;

    private String eligibility;
    private String searchDate;
    private String bidPublishDate;
    private String submissionDateAndTime;

    private String extendedDateAndTime;
    private String participatingMonth;
    private String submissionType;
    private String bidValidity;
    private String tenderSource;
    private String tenderReferenceNumber;
    private String organization;
    private String organization_id;
    private String sector;
    private String sector_id;
    private String clientName;
    private String clientName_id;
    private String clientLocation;
    private String clientAddress;
    private String state;
    private String state_id;
    private String operationBranch;
    private String operationBranch_id;
    private String scopeOfWork;
    private String natureOfWork;
    private String natureOfWork_id;
    private String similarNature;
    private String period;
    private String perDay;
    private String perDayInLac;
    private String operationalBranch;
    private String operationalBranch_id;

    private String tenderAmount;
    private String tenderExemptedOfUs;
    private String tenderModeOFPayment;
    private String tenderInFavourOF;
    private String tenderPayableAt;
    private String tenderValidity;
    private String tenderPortalName;
    private String tenderAccountDetailACNo;
    private String tenderAccountDetailIFSC;
    private String processingAmount;
    private String processingExemptedOfUs;
    private String processingModeOFPayment;
    private String processingInFavourOF;
    private String processingPayableAt;
    private String processingPalidity;
    private String processingPortalName;
    private String processingAccountDetailACNo;
    private String processingAccountDetailIFSC;
    private String emdAmount;
    private String emdExemptedOfUs;
    private String emdModeOFPayment;
    private String emdInFavourOF;
    private String emdPayableAt;
    private String emdValidity;
    private String emdPortalName;
    private String emdAccountDetailACNo;
    private String emdAccountDetailIFSC;
    private String basedOn;
    private String Area;
    private String penaltyClause;
    private String sectionBasedOn;
    private String PBG;
    private String ratesQuotedIn;
    private String serviceCharge;



    //tender contact details
    private String tenderContactName;
    private String tenderContactEmail;
    private String tenderContactContact;
    private String status;

    public String getClientName_id() {
        return clientName_id;
    }

    public void setClientName_id(String clientName_id) {
        this.clientName_id = clientName_id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getClientName() {
        return clientName;
    }

    public String getOperationalBranch() {
        return operationalBranch;
    }

    public void setOperationalBranch(String operationalBranch) {
        this.operationalBranch = operationalBranch;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getZone_id() {
        return zone_id;
    }

    public void setZone_id(String zone_id) {
        this.zone_id = zone_id;
    }

    public String getDepartment_id() {
        return department_id;
    }

    public void setDepartment_id(String department_id) {
        this.department_id = department_id;
    }

    public String getDivision_id() {
        return division_id;
    }

    public void setDivision_id(String division_id) {
        this.division_id = division_id;
    }

    public String getCustomerName_id() {
        return customerName_id;
    }

    public void setCustomerName_id(String customerName_id) {
        this.customerName_id = customerName_id;
    }



    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getModeOfPaymentEMD() {
        return modeOfPaymentEMD;
    }

    public void setModeOfPaymentEMD(String modeOfPaymentEMD) {
        this.modeOfPaymentEMD = modeOfPaymentEMD;
    }

    public String getPreBidDate() {
        return preBidDate;
    }

    public void setPreBidDate(String preBidDate) {
        this.preBidDate = preBidDate;
    }

    public String getProceed() {
        return proceed;
    }

    public void setProceed(String proceed) {
        this.proceed = proceed;
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(String publishDate) {
        this.publishDate = publishDate;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public String getNameOfWork() {
        return nameOfWork;
    }

    public void setNameOfWork(String nameOfWork) {
        this.nameOfWork = nameOfWork;
    }

    public String getEmd() {
        return emd;
    }

    public void setEmd(String emd) {
        this.emd = emd;
    }

    public String getTenderFees() {
        return tenderFees;
    }

    public void setTenderFees(String tenderFees) {
        this.tenderFees = tenderFees;
    }

    public String getModeOfPayment() {
        return modeOfPayment;
    }

    public void setModeOfPayment(String modeOfPayment) {
        this.modeOfPayment = modeOfPayment;
    }

    public String getTenderValue() {
        return tenderValue;
    }

    public void setTenderValue(String tenderValue) {
        this.tenderValue = tenderValue;
    }

    public Boolean getMsePreference() {
        return msePreference;
    }

    public void setMsePreference(Boolean msePreference) {
        this.msePreference = msePreference;
    }

    public String getZone() {
        return zone;
    }

    public void setZone(String zone) {
        this.zone = zone;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getDivision() {
        return division;
    }

    public void setDivision(String division) {
        this.division = division;
    }

    public String getNatureOfWork_id() {
        return natureOfWork_id;
    }

    public void setNatureOfWork_id(String natureOfWork_id) {
        this.natureOfWork_id = natureOfWork_id;
    }

    public String getOperationalBranch_id() {
        return operationalBranch_id;
    }

    public void setOperationalBranch_id(String operationalBranch_id) {
        this.operationalBranch_id = operationalBranch_id;
    }

// Getters and Setters


    public String getEligibility() {
        return eligibility;
    }

    public void setEligibility(String eligibility) {
        this.eligibility = eligibility;
    }

    public String getExtendedDateAndTime() {
        return extendedDateAndTime;
    }

    public void setExtendedDateAndTime(String extendedDateAndTime) {
        this.extendedDateAndTime = extendedDateAndTime;
    }

    public String getParticipatingMonth() {
        return participatingMonth;
    }

    public void setParticipatingMonth(String participatingMonth) {
        this.participatingMonth = participatingMonth;
    }

    public String getSubmissionType() {
        return submissionType;
    }

    public void setSubmissionType(String submissionType) {
        this.submissionType = submissionType;
    }

    public String getBidValidity() {
        return bidValidity;
    }

    public void setBidValidity(String bidValidity) {
        this.bidValidity = bidValidity;
    }

    public String getTenderSource() {
        return tenderSource;
    }

    public void setTenderSource(String tenderSource) {
        this.tenderSource = tenderSource;
    }

    public String getTenderReferenceNumber() {
        return tenderReferenceNumber;
    }

    public void setTenderReferenceNumber(String tenderReferenceNumber) {
        this.tenderReferenceNumber = tenderReferenceNumber;
    }

    public String getOrganization() {
        return organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }

    public String getOrganization_id() {
        return organization_id;
    }

    public void setOrganization_id(String organization_id) {
        this.organization_id = organization_id;
    }

    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }

    public String getSector_id() {
        return sector_id;
    }

    public void setSector_id(String sector_id) {
        this.sector_id = sector_id;
    }

    public String getClientLocation() {
        return clientLocation;
    }

    public void setClientLocation(String clientLocation) {
        this.clientLocation = clientLocation;
    }

    public String getClientAddress() {
        return clientAddress;
    }

    public void setClientAddress(String clientAddress) {
        this.clientAddress = clientAddress;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getState_id() {
        return state_id;
    }

    public void setState_id(String state_id) {
        this.state_id = state_id;
    }

    public String getOperationBranch() {
        return operationBranch;
    }

    public void setOperationBranch(String operationBranch) {
        this.operationBranch = operationBranch;
    }

    public String getOperationBranch_id() {
        return operationBranch_id;
    }

    public void setOperationBranch_id(String operationBranch_id) {
        this.operationBranch_id = operationBranch_id;
    }

    public String getScopeOfWork() {
        return scopeOfWork;
    }

    public void setScopeOfWork(String scopeOfWork) {
        this.scopeOfWork = scopeOfWork;
    }

    public String getNatureOfWork() {
        return natureOfWork;
    }

    public void setNatureOfWork(String natureOfWork) {
        this.natureOfWork = natureOfWork;
    }

    public String getSimilarNature() {
        return similarNature;
    }

    public void setSimilarNature(String similarNature) {
        this.similarNature = similarNature;
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    public String getPerDay() {
        return perDay;
    }

    public void setPerDay(String perDay) {
        this.perDay = perDay;
    }

    public String getPerDayInLac() {
        return perDayInLac;
    }

    public void setPerDayInLac(String perDayInLac) {
        this.perDayInLac = perDayInLac;
    }



    public String getTenderContactName() {
        return tenderContactName;
    }

    public void setTenderContactName(String tenderContactName) {
        this.tenderContactName = tenderContactName;
    }

    public String getTenderContactEmail() {
        return tenderContactEmail;
    }

    public void setTenderContactEmail(String tenderContactEmail) {
        this.tenderContactEmail = tenderContactEmail;
    }

    public String getTenderContactContact() {
        return tenderContactContact;
    }

    public void setTenderContactContact(String tenderContactContact) {
        this.tenderContactContact = tenderContactContact;
    }

    public String getSearchDate() {
        return searchDate;
    }

    public void setSearchDate(String searchDate) {
        this.searchDate = searchDate;
    }

    public String getBidPublishDate() {
        return bidPublishDate;
    }

    public void setBidPublishDate(String bidPublishDate) {
        this.bidPublishDate = bidPublishDate;
    }

    public String getSubmissionDateAndTime() {
        return submissionDateAndTime;
    }

    public void setSubmissionDateAndTime(String submissionDateAndTime) {
        this.submissionDateAndTime = submissionDateAndTime;
    }



    public String getBasedOn() {
        return basedOn;
    }

    public void setBasedOn(String basedOn) {
        this.basedOn = basedOn;
    }

    public String getArea() {
        return Area;
    }

    public void setArea(String area) {
        Area = area;
    }

    public String getPenaltyClause() {
        return penaltyClause;
    }

    public void setPenaltyClause(String penaltyClause) {
        this.penaltyClause = penaltyClause;
    }

    public String getSectionBasedOn() {
        return sectionBasedOn;
    }

    public void setSectionBasedOn(String sectionBasedOn) {
        this.sectionBasedOn = sectionBasedOn;
    }

    public String getPBG() {
        return PBG;
    }

    public void setPBG(String PBG) {
        this.PBG = PBG;
    }

    public String getRatesQuotedIn() {
        return ratesQuotedIn;
    }

    public void setRatesQuotedIn(String ratesQuotedIn) {
        this.ratesQuotedIn = ratesQuotedIn;
    }

    public String getServiceCharge() {
        return serviceCharge;
    }

    public void setServiceCharge(String serviceCharge) {
        this.serviceCharge = serviceCharge;
    }

    public String getTenderAmount() {
        return tenderAmount;
    }

    public void setTenderAmount(String tenderAmount) {
        this.tenderAmount = tenderAmount;
    }

    public String getTenderExemptedOfUs() {
        return tenderExemptedOfUs;
    }

    public void setTenderExemptedOfUs(String tenderExemptedOfUs) {
        this.tenderExemptedOfUs = tenderExemptedOfUs;
    }

    public String getTenderInFavourOF() {
        return tenderInFavourOF;
    }

    public void setTenderInFavourOF(String tenderInFavourOF) {
        this.tenderInFavourOF = tenderInFavourOF;
    }

    public String getTenderPayableAt() {
        return tenderPayableAt;
    }

    public void setTenderPayableAt(String tenderPayableAt) {
        this.tenderPayableAt = tenderPayableAt;
    }

    public String getTenderValidity() {
        return tenderValidity;
    }

    public void setTenderValidity(String tenderValidity) {
        this.tenderValidity = tenderValidity;
    }

    public String getTenderPortalName() {
        return tenderPortalName;
    }

    public void setTenderPortalName(String tenderPortalName) {
        this.tenderPortalName = tenderPortalName;
    }

    public String getTenderAccountDetailACNo() {
        return tenderAccountDetailACNo;
    }

    public void setTenderAccountDetailACNo(String tenderAccountDetailACNo) {
        this.tenderAccountDetailACNo = tenderAccountDetailACNo;
    }

    public String getTenderAccountDetailIFSC() {
        return tenderAccountDetailIFSC;
    }

    public void setTenderAccountDetailIFSC(String tenderAccountDetailIFSC) {
        this.tenderAccountDetailIFSC = tenderAccountDetailIFSC;
    }

    public String getProcessingAmount() {
        return processingAmount;
    }

    public void setProcessingAmount(String processingAmount) {
        this.processingAmount = processingAmount;
    }

    public String getProcessingExemptedOfUs() {
        return processingExemptedOfUs;
    }

    public void setProcessingExemptedOfUs(String processingExemptedOfUs) {
        this.processingExemptedOfUs = processingExemptedOfUs;
    }

    public String getProcessingInFavourOF() {
        return processingInFavourOF;
    }

    public void setProcessingInFavourOF(String processingInFavourOF) {
        this.processingInFavourOF = processingInFavourOF;
    }

    public String getProcessingPayableAt() {
        return processingPayableAt;
    }

    public void setProcessingPayableAt(String processingPayableAt) {
        this.processingPayableAt = processingPayableAt;
    }

    public String getProcessingPalidity() {
        return processingPalidity;
    }

    public void setProcessingPalidity(String processingPalidity) {
        this.processingPalidity = processingPalidity;
    }

    public String getProcessingPortalName() {
        return processingPortalName;
    }

    public void setProcessingPortalName(String processingPortalName) {
        this.processingPortalName = processingPortalName;
    }

    public String getProcessingAccountDetailACNo() {
        return processingAccountDetailACNo;
    }

    public void setProcessingAccountDetailACNo(String processingAccountDetailACNo) {
        this.processingAccountDetailACNo = processingAccountDetailACNo;
    }

    public String getProcessingAccountDetailIFSC() {
        return processingAccountDetailIFSC;
    }

    public void setProcessingAccountDetailIFSC(String processingAccountDetailIFSC) {
        this.processingAccountDetailIFSC = processingAccountDetailIFSC;
    }

    public String getEmdAmount() {
        return emdAmount;
    }

    public void setEmdAmount(String emdAmount) {
        this.emdAmount = emdAmount;
    }

    public String getEmdExemptedOfUs() {
        return emdExemptedOfUs;
    }

    public void setEmdExemptedOfUs(String emdExemptedOfUs) {
        this.emdExemptedOfUs = emdExemptedOfUs;
    }

    public String getEmdInFavourOF() {
        return emdInFavourOF;
    }

    public void setEmdInFavourOF(String emdInFavourOF) {
        this.emdInFavourOF = emdInFavourOF;
    }

    public String getEmdPayableAt() {
        return emdPayableAt;
    }

    public void setEmdPayableAt(String emdPayableAt) {
        this.emdPayableAt = emdPayableAt;
    }

    public String getEmdValidity() {
        return emdValidity;
    }

    public void setEmdValidity(String emdValidity) {
        this.emdValidity = emdValidity;
    }

    public String getEmdPortalName() {
        return emdPortalName;
    }

    public void setEmdPortalName(String emdPortalName) {
        this.emdPortalName = emdPortalName;
    }

    public String getEmdAccountDetailACNo() {
        return emdAccountDetailACNo;
    }

    public void setEmdAccountDetailACNo(String emdAccountDetailACNo) {
        this.emdAccountDetailACNo = emdAccountDetailACNo;
    }

    public String getEmdAccountDetailIFSC() {
        return emdAccountDetailIFSC;
    }

    public void setEmdAccountDetailIFSC(String emdAccountDetailIFSC) {
        this.emdAccountDetailIFSC = emdAccountDetailIFSC;
    }

    public String getTenderModeOFPayment() {
        return tenderModeOFPayment;
    }

    public void setTenderModeOFPayment(String tenderModeOFPayment) {
        this.tenderModeOFPayment = tenderModeOFPayment;
    }

    public String getProcessingModeOFPayment() {
        return processingModeOFPayment;
    }

    public void setProcessingModeOFPayment(String processingModeOFPayment) {
        this.processingModeOFPayment = processingModeOFPayment;
    }

    public String getEmdModeOFPayment() {
        return emdModeOFPayment;
    }

    public void setEmdModeOFPayment(String emdModeOFPayment) {
        this.emdModeOFPayment = emdModeOFPayment;
    }
}