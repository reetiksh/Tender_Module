package com.nscs.SBMaster.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.antlr.v4.runtime.misc.NotNull;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="maintenace_req")
public class Maintenance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id ;
    @Column(name="report_date")
    private String publishDate ;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Column(name="due_date")
    private String dueDate ;
    @Column(name="team")
    private String team ;
    @NotNull
    @Column(name="name_of_asset")
    private String nameOfAsset ;
    @Column(name="main_desc")
    private String Description ;
    @Column(name="reported_by")
    private String reportedBy ;
    @Column(name="status")
    private String status ;
    @Column(name="assigned_to")
    private String assignedTo ;
    @Column(name="remarks")
    private String remarks ;
    @Column(name="ticket_no")
    private String ticketNo ;

    @OneToOne(mappedBy = "maintenance", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Details details;


    public void setStatus(String newStatus) {

    }
}
//
//    public Details getDetails() {
//        return details;
//    }
//
//    public void setDetails(Details details) {
//        this.details = details;
//    }
//
//    public String getTicketNo() {
//        return ticketNo;
//    }
//
//    public void setTicketNo(String ticketNo) {
//        this.ticketNo = ticketNo;
//    }
//
//    public String getStatus() {
//        return status;
//    }
//
//    public void setStatus(String status) {
//        this.status = status;
//    }
//
//    public long getId() {
//        return id;
//    }
//
//    public String getReportedBy() {
//        return reportedBy;
//    }
//
//    public void setReportedBy(String reportedBy) {
//        this.reportedBy = reportedBy;
//    }
//
//    public String getDescription() {
//        return Description;
//    }
//
//    public void setDescription(String description) {
//        Description = description;
//    }
//
//    public String getNameOfAsset() {
//        return nameOfAsset;
//    }
//
//    public void setNameOfAsset(String nameOfAsset) {
//        this.nameOfAsset = nameOfAsset;
//    }
//
//    public String getDueDate() {
//        return dueDate;
//    }
//
//    public void setDueDate(String dueDate) {
//        this.dueDate = dueDate;
//    }
//
//    public String getPublishDate() {
//        return publishDate;
//    }
//
//    public void setPublishDate(String publishDate) {
//        this.publishDate = publishDate;
//    }
//
//    public void setId(long id) {
//        this.id = id;
//    }
//
//    public String getRemarks() {
//        return remarks;
//    }
//
//    public void setRemarks(String remarks) {
//        this.remarks = remarks;
//    }
//
//    public String getAssignedTo() {
//        return assignedTo;
//    }
//
//    public void setAssignedTo(String assignedTo) {
//        this.assignedTo = assignedTo;
//    }}
//
//
