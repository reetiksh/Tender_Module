package com.nscs.SBMaster.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@Entity
@Table(name = "department_responses")
public class DepartmentResponseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String status; // "Received", "Pending", "In Proceeding"
    private String receivedDate;
    private String remarks;





    @CreationTimestamp
    @Column(name = "submission_date_time", updatable = false,columnDefinition = "TIMESTAMP")
    private LocalDateTime submissionDateTime;



    // Many-to-One relationship with Tender
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tender_id", nullable = false)
    private Tender tender;

    // Many-to-One relationship with Department
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "department_id", nullable = false)
    private Department department;

    // Constructors
    public DepartmentResponseEntity() {}

    private boolean isDraft;// To indicate if it's saved as draft

    @OneToMany(mappedBy = "departmentResponseEntity", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DepartmentResponseDetails> departmentResponseDetails = new ArrayList<>();;



    public List<DepartmentResponseDetails> getDepartmentResponseDetails() {
        return departmentResponseDetails;
    }

    public void setDepartmentResponseDetails(List<DepartmentResponseDetails> departmentResponseDetails) {
        this.departmentResponseDetails = departmentResponseDetails;
    }

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

    public LocalDateTime getEntryDateTime() {
        return submissionDateTime;
    }

    public void setEntryDateTime(LocalDateTime entryDateTime) {
        submissionDateTime = entryDateTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getReceivedDate() {
        return receivedDate;
    }

    public void setReceivedDate(String receivedDate) {
        this.receivedDate = receivedDate;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public Tender getTender() {
        return tender;
    }

    public void setTender(Tender tender) {
        this.tender = tender;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public boolean isDraft() {
        return isDraft;
    }

    public void setDraft(boolean draft) {
        isDraft = draft;
    }
// Getters and Setters

}
