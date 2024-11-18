package com.nscs.SBMaster.services;

import com.nscs.SBMaster.model.goNoTender;
import com.nscs.SBMaster.model.GoNoTenderMaster;
import com.nscs.SBMaster.repository.GoNoTenderMasterRepository;
import com.nscs.SBMaster.repository.goNoTenderRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class goNoTenderService {




    @Autowired
    private goNoTenderRepository goNoTenderRepository;

    @Autowired
    private GoNoTenderMasterRepository GoNoTenderMasterRepository;



    public List<GoNoTenderMaster> getAllMasterActivities() {
        return GoNoTenderMasterRepository.findAll();
    }
    @Transactional
    public void saveActivitiesFromMaster(List<Long> masterIds, String tenderId,boolean gono) {
        for (int i = 0; i < masterIds.size(); i++) {
            Long masterId = masterIds.get(i);
            Optional<GoNoTenderMaster> masterActivity = GoNoTenderMasterRepository.findById(masterId);

            if (masterActivity.isPresent()) {
                GoNoTenderMaster GoNoTenderMaster = masterActivity.get();



                goNoTender goNoTender = new goNoTender(tenderId,masterIds.get(i), GoNoTenderMaster.getActivity());

                goNoTenderRepository.save(goNoTender);
            }
        }
        if(gono){
            int rowsUpdated =GoNoTenderMasterRepository.gonoproceed(tenderId);
        }
    }



}
