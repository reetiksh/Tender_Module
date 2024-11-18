package com.nscs.SBMaster.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="tender_goNo")
public class goNoTender {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String tenderId;
    private String masterId;

    public String getTenderId() {
        return tenderId;
    }

    public void setTenderId(String tenderId) {
        this.tenderId = tenderId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMasterId() {
        return masterId;
    }

    public void setMasterId(String masterId) {
        this.masterId = masterId;
    }

    public String getOption() {
        return optionActivity;
    }

    public void setOption(String optionActivity) {
        this.optionActivity = optionActivity;
    }

    private String optionActivity;
    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    private LocalDateTime creationDate;
    @PrePersist
    protected void onCreate() {
        this.creationDate = LocalDateTime.now();
    }



    public goNoTender(String tenderId, long masterId, String activity) {
        this.tenderId = tenderId;
        this.optionActivity = activity;
        this.masterId = String.valueOf(masterId);

    }



}
