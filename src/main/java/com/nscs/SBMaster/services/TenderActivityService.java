package com.nscs.SBMaster.services;


import com.nscs.SBMaster.model.TenderActivity;
import com.nscs.SBMaster.model.TenderActivityMaster;
import com.nscs.SBMaster.repository.TenderActivityMasterRepository;
import com.nscs.SBMaster.repository.TenderActivityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
@Service
public class TenderActivityService {


    @Autowired
    private TenderActivityMasterRepository tenderActivityMasterRepository;

    @Autowired
    private TenderActivityRepository tenderActivityRepository;

    public List<TenderActivityMaster> getAllMasterActivities() {
        return tenderActivityMasterRepository.findAll();
    }

    public void saveActivitiesFromMaster(List<Long> masterIds, String tenderId, List<String> users, List<String> dueDates,List<String> activityindex) {
        for (int i = 0; i < masterIds.size(); i++) {
            Long masterId = Long.valueOf(activityindex.get(Math.toIntExact(masterIds.get(i))));
            Optional<TenderActivityMaster> masterActivity = tenderActivityMasterRepository.findById(masterId);

            if (masterActivity.isPresent()) {
                TenderActivityMaster activityMaster = masterActivity.get();

                String user = users.get(Math.toIntExact(masterIds.get(i)));
                String dueDate = dueDates.get(Math.toIntExact(masterIds.get(i)));

                TenderActivity tenderActivity = new TenderActivity(tenderId, activityMaster.getActivity(), user, dueDate);

                tenderActivityRepository.save(tenderActivity);
            }
        }
    }
}
