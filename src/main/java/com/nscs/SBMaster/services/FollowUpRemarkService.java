package com.nscs.SBMaster.services;

import com.nscs.SBMaster.model.BidEvaluationParticipantsDetails;
import com.nscs.SBMaster.model.FollowUpRemark;
import com.nscs.SBMaster.repository.FollowUpRemarkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FollowUpRemarkService {

    @Autowired
    private FollowUpRemarkRepository followUpRemarkRepository;

    public void saveData(Long id, List<String> remark){


        for(int i=0;i<remark.size();i++){
            FollowUpRemark followUpRemark= new FollowUpRemark(id,remark.get(i));
            followUpRemarkRepository.save(followUpRemark);
        }
    }
}
