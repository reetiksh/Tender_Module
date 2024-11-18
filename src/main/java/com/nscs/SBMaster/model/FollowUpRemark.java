package com.nscs.SBMaster.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

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

    private String remarkDate;
    private String remark;
    private Long emdMonitoringId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRemarkDate() {
        return remarkDate;
    }

    public void setRemarkDate(String remarkDate) {
        this.remarkDate = remarkDate;
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

    public FollowUpRemark(Long emdMonitoringId, String remark, String remarkDate) {
        this.remarkDate = remarkDate;
        this.remark = remark;
        this.emdMonitoringId = emdMonitoringId;
    }
}
