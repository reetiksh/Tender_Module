package com.nscs.SBMaster.services;
import com.nscs.SBMaster.repository.BidEvaluationParticipantsDetailsRepository;
import com.nscs.SBMaster.model.BidEvaluationParticipantsDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BidEvaluationParticipantsDetailsService {

    @Autowired
    private BidEvaluationParticipantsDetailsRepository BidEvaluationParticipantsDetailsRepository;

    public void saveData(Long id, List<String> participantRank,List<String> participantName, List<String> quotedRates,List<String> quotedRateType){


        for(int i=0;i<participantRank.size();i++){
            BidEvaluationParticipantsDetails BidEvaluationParticipantsDetails= new BidEvaluationParticipantsDetails(id,participantRank.get(i),participantName.get(i),   quotedRates.get(i),quotedRateType.get(i));
            BidEvaluationParticipantsDetailsRepository.save(BidEvaluationParticipantsDetails);
        }
    }
}
