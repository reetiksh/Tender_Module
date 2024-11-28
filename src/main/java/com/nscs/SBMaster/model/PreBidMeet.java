package com.nscs.SBMaster.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;


import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="tender_preBid_detail")
public class PreBidMeet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String tenderNumber;
    private String MeetingDate;
    private String assignTo;
    private String assignTo_id;
    private String Reminder;
    private String Reminder_id;

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

    public String getMeetingDate() {
        return MeetingDate;
    }

    public void setMeetingDate(String meetingDate) {
        MeetingDate = meetingDate;
    }

    public String getAssignTo() {
        return assignTo;
    }

    public void setAssignTo(String assignTo) {
        this.assignTo = assignTo;
    }

    public String getReminder() {
        return Reminder;
    }

    public void setReminder(String reminder) {
        Reminder = reminder;
    }

    public String getAssignTo_id() {
        return assignTo_id;
    }

    public void setAssignTo_id(String assignTo_id) {
        this.assignTo_id = assignTo_id;
    }

    public String getReminder_id() {
        return Reminder_id;
    }

    public void setReminder_id(String reminder_id) {
        Reminder_id = reminder_id;
    }
}
