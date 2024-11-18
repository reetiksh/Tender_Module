package com.nscs.SBMaster.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Details {


//@Id
// @GeneratedValue(strategy = GenerationType.IDENTITY)

@Column(name="identifier_id")
private long identifier ;
    private long id ;
    @Column(name="status")
    private String status ;
    @Column(name="assigned_to")
    private String assignedTo ;
    @Column(name="remarks")
    private String remarks ;
    @Id
    @Column(name="ticket_no")
    private String ticketNo ;
    @Column(name="branch_code")
    private String branchCode ;
    @Column(name="user_name")
    private String user ;
    @Column(name="needs")
    private String needs ;
    @Column(name="counter")
    private String counter ;


    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAssignedTo() {
        return assignedTo;
    }

    public void setAssignedTo(String assignedTo) {
        this.assignedTo = assignedTo;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getTicketNo() {
        return ticketNo;
    }

    public void setTicketNo(String ticketNo) {
        this.ticketNo = ticketNo;
    }

    public String getNameOfAsset() {
        return nameOfAsset;
    }

    public void setNameOfAsset(String nameOfAsset) {
        this.nameOfAsset = nameOfAsset;
    }

    public Maintenance getMaintenance() {
        return maintenance;
    }

    public void setMaintenance(Maintenance maintenance) {
        this.maintenance = maintenance;
    }

    public String getBranchCode() {
        return branchCode;
    }

    public void setBranchCode(String branchCode) {
        this.branchCode = branchCode;
    }

    @Column(name="name_of_asset")
    private String nameOfAsset ;

    // One-to-many relationship with Yolo entity based on ticket_no
    @OneToMany(mappedBy = "details", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Yolo> yoloList = new ArrayList<>();
    // Getter and Setter for Yolo List
    public List<Yolo> getYoloList() {
        return yoloList;
    }

    public void setYoloList(List<Yolo> yoloList) {
        this.yoloList = yoloList;
    }

    public long getIdentifier() {
        return identifier;
    }

    public void setIdentifier(long identifier) {
        this.identifier = identifier;
    }

    // Add method to add Yolo to the list
    public void addYolo(Yolo yolo) {
        yoloList.add(yolo);
        yolo.setDetails(this);
    }

    // Add method to remove Yolo from the list
    public void removeYolo(Yolo yolo) {
        yoloList.remove(yolo);
        yolo.setDetails(null);
    }
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "maintenance_id")
    private Maintenance maintenance;
}