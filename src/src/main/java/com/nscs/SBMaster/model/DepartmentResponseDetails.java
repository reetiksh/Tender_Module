package com.nscs.SBMaster.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "department_response_detail")
public class DepartmentResponseDetails {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Column(name = "department_response_kid")
        private Long departmentResponseKid;  // This stores the 'id' from 'DepartmentResponseEntity'

        private String status;
        private String receivedDate;
        private String remarks;
        private boolean isDraft;

         @CreationTimestamp
        @Column(name = "submission_date_time",updatable = false,columnDefinition = "TIMESTAMP")
        private LocalDateTime submissionDateTime;

        // Many-to-One relationship with DepartmentResponseEntity
        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "department_response_id")
        private DepartmentResponseEntity departmentResponseEntity;

    public LocalDateTime getSubmissionDateTime() {
        return submissionDateTime;
    }

    public void setSubmissionDateTime(LocalDateTime entryDateTime) {
        submissionDateTime = entryDateTime;
    }

    // Getters and setters
        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public Long getDepartmentResponseKid() {
            return departmentResponseKid;
        }

        public void setDepartmentResponseKid(Long departmentResponseKid) {
            this.departmentResponseKid = departmentResponseKid;
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

        public boolean isDraft() {
            return isDraft;
        }

    public void setDraft(boolean draft) {
            isDraft = draft;
        }

        public DepartmentResponseEntity getDepartmentResponseEntity() {
            return departmentResponseEntity;
        }

        public void setDepartmentResponseEntity(DepartmentResponseEntity departmentResponseEntity) {
            this.departmentResponseEntity = departmentResponseEntity;
        }

    }


