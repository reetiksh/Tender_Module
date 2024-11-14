package com.nscs.SBMaster.services;

import com.nscs.SBMaster.model.productAndServices;
import com.nscs.SBMaster.repository.productAndServiciesRepositary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
@Service
public class productAndServiciesService {


    @Autowired
    private com.nscs.SBMaster.repository.MSEbenifitsRepositary MSEbenifitsRepositary;

    @Autowired
    private productAndServiciesRepositary productAndServiciesRepositary;

    public List<productAndServices> getAllProductsMasterActivities() {
        return productAndServiciesRepositary.findAll();
    }

}