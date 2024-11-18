package com.nscs.SBMaster.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="gono_tender_master")
public class GoNoTenderMaster {

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

    public String getDesc() {
        return description;
    }

    public void setDesc(String description) {
        this.description = description;
    }

    private String description;
}

















//
//insert into gono_tender_master (activity,description) VALUES ('Relevance to Core Business',' Does the tender align with the organizations core competencies and business objectives?')
//insert into gono_tender_master (activity,description) VALUES ('Market Positioning','Will winning the tender enhance the company’s market position or reputation?')
//insert into gono_tender_master (activity,description) VALUES ('Profit Margin','Does the tender offer a sufficient profit margin after considering all costs?')
//
//insert into gono_tender_master (activity,description) VALUES ('Budget Availability',' Is there an adequate budget to execute the project without financial strain?')
//insert into gono_tender_master (activity,description) VALUES ('Payment Terms','Are the payment terms favorable and aligned with the company’s cash flow requirements?')
//insert into gono_tender_master (activity,description) VALUES ('Risk vs. Reward','Does the potential reward outweigh the risks involved (e.g., financial, operational, reputational risks)?')
//insert into gono_tender_master (activity,description) VALUES ('Competitor Analysis','Is the competitive landscape favorable, or are there stronger competitors likely to outbid?')
//insert into gono_tender_master (activity,description) VALUES ('Legal and Compliance Risks','Are there any legal or regulatory risks that could impact the decision?')
//insert into gono_tender_master (activity,description) VALUES ('Human Resources','Does the company have the required skilled personnel to execute the project?')
//insert into gono_tender_master (activity,description) VALUES ('Material and Equipment','Are the necessary materials and equipment available to complete the tender requirements?')
//insert into gono_tender_master (activity,description) VALUES ('Time Constraints','Can the project be completed within the stipulated timelines?')
//insert into gono_tender_master (activity,description) VALUES ('Technical Requirements','Does the company have the technical expertise and experience to meet the tender requirements?')
//insert into gono_tender_master (activity,description) VALUES ('Past Performance','Has the company successfully executed similar projects in the past?')
//insert into gono_tender_master (activity,description) VALUES ('Client Reputation','Is the client reputable, with a history of honoring contracts and payments?')
//insert into gono_tender_master (activity,description) VALUES ('Project Location','Are there logistical challenges related to the project’s location (e.g., remote areas, high-risk zones)?')
//insert into gono_tender_master (activity,description) VALUES ('Contract Terms and Conditions','Are the terms and conditions of the contract acceptable and manageable?')
//insert into gono_tender_master (activity,description) VALUES ('Liability and Warranty',' Are the liability and warranty clauses reasonable?')
//insert into gono_tender_master (activity,description) VALUES ('Subcontractors and Partners','Are there reliable subcontractors or partners available to collaborate on the tender?')
//insert into gono_tender_master (activity,description) VALUES ('Joint Ventures','Is there a potential for forming a strategic alliance or joint venture to strengthen the bid?')
//insert into gono_tender_master (activity,description) VALUES ('Economic Environment',' Are the current market conditions favorable for undertaking the project?')
//insert into gono_tender_master (activity,description) VALUES ('Political Stability','Is there political stability in the region where the project will be executed?')
//insert into gono_tender_master (activity,description) VALUES ('Environmental Impact','Does the project comply with environmental regulations and sustainability goals?')
//insert into gono_tender_master (activity,description) VALUES ('Corporate Social Responsibility (CSR)','Does the project align with the company’s CSR policies?')
//insert into gono_tender_master (activity,description) VALUES ('Existing Relationship with Client','Does the company have a good relationship with the client, which might improve the chances of winning?')
//insert into gono_tender_master (activity,description) VALUES ('Client`s Financial Stability','Is the client financially stable and capable of funding the project?')

