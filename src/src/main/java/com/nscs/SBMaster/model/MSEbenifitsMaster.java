package com.nscs.SBMaster.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;


import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="mse_benifits_master")
public class MSEbenifitsMaster {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String activity;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getActivity() {
        return activity;
    }

    public void setActivity(String activity) {
        this.activity = activity;
    }
}






//
//insert into mse_benifits_master (activity) VALUES ('Tender Fees Excemption')
//insert into mse_benifits_master (activity) VALUES ('EMD Excemption')
//insert into mse_benifits_master (activity) VALUES ('Turnover Excemption')
//insert into mse_benifits_master (activity) VALUES ('Past Performance Excemption')
