package com.nscs.SBMaster.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity

public class Yolo {






        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private long id ;
        @Column(name="remarks")
        private String remarks ;
    @Column(name="ticket_no",insertable = false, updatable = false)

        private String ticketNo ;
        @Column(name="branch_code")
        private String branchCode ;
        @Column(name="user_name")
        private String user ;

        @Column(name="needs")
        private String needs ;
    @Column(name="identifier_id")
    private long identifier ;
    public String getTicketNo() {
        return ticketNo;
    }

    public void setTicketNo(String ticketNo) {
        this.ticketNo = ticketNo;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ticket_no", referencedColumnName = "ticket_no")
    private Details details;


    // Getter and Setter for Details
    public Details getDetails() {
        return details;
    }

    public void setDetails(Details details) {
        this.details = details;
    }

    }


