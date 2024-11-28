package com.nscs.SBMaster.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "follow_up_remarks")
public class FollowUpRemark {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(updatable = false)
    private LocalDate  remarkDate;
    private String remark;
    private Long emdMonitoringId;

    private String userId;



    @PrePersist
    protected void onCreate() {
        remarkDate = LocalDate.now(); // Set the insert timestamp

    }


    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public LocalDate  getRemarkDate() {
        return remarkDate;
    }

    public void setRemarkDate(LocalDate  remarkDate) {
        this.remarkDate = remarkDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Long getEmdMonitoringId() {
        return emdMonitoringId;
    }

    public void setEmdMonitoringId(Long emdMonitoringId) {
        this.emdMonitoringId = emdMonitoringId;
    }

    public FollowUpRemark(Long emdMonitoringId, String remark) {

        this.remark = remark;
        this.emdMonitoringId = emdMonitoringId;
    }
}
