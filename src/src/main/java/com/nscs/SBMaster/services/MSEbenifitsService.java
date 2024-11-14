package com.nscs.SBMaster.services;

import com.nscs.SBMaster.model.MSEbenifitsMaster;
import com.nscs.SBMaster.repository.TenderActivityMasterRepository;
import com.nscs.SBMaster.repository.TenderActivityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


import com.nscs.SBMaster.repository.MSEbenifitsRepositary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
@Service
public class MSEbenifitsService {


    @Autowired
    private MSEbenifitsRepositary MSEbenifitsRepositary;

    @Autowired
    private TenderActivityRepository tenderActivityRepository;

    public List<MSEbenifitsMaster> getAllMseMasterActivities() {
        return MSEbenifitsRepositary.findAll();
    }

}