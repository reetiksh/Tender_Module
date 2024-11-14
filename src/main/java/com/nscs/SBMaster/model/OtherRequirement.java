package com.nscs.SBMaster.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.Date;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;




@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="tender_otherReqirement_detail")
public class OtherRequirement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String tenderNumber;
    private String LegalDepartment;
    private String AccountDepartment;
    private String SCMDepartment;
    private String HRDepartment;

    private String LegalDepartment_id;
    private String AccountDepartment_id;
    private String SCMDepartment_id;
    private String HRDepartment_id;

    public void setId(Long id) {
        this.id = id;
    }

    public void setTenderNumber(String tenderNumber) {
        this.tenderNumber = tenderNumber;
    }

    public void setLegalDepartment(String legalDepartment) {
        LegalDepartment = legalDepartment;
    }

    public void setAccountDepartment(String accountDepartment) {
        AccountDepartment = accountDepartment;
    }

    public void setSCMDepartment(String SCMDepartment) {
        this.SCMDepartment = SCMDepartment;
    }

    public void setHRDepartment(String HRDepartment) {
        this.HRDepartment = HRDepartment;
    }

    public void setLegalDepartment_id(String legalDepartment_id) {
        LegalDepartment_id = legalDepartment_id;
    }

    public void setAccountDepartment_id(String accountDepartment_id) {
        AccountDepartment_id = accountDepartment_id;
    }

    public void setSCMDepartment_id(String SCMDepartment_id) {
        this.SCMDepartment_id = SCMDepartment_id;
    }

    public void setHRDepartment_id(String HRDepartment_id) {
        this.HRDepartment_id = HRDepartment_id;
    }
}
