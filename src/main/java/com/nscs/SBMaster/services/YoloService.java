package com.nscs.SBMaster.services;

import com.nscs.SBMaster.model.Details;
import com.nscs.SBMaster.model.Yolo;
import com.nscs.SBMaster.repository.YoloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class YoloService {

    private final YoloRepository yoloRepository;
    @Autowired
    public YoloService(YoloRepository yoloRepository) {
        this.yoloRepository = yoloRepository;
    }

    public List<Yolo> findALLByTicketNo(String ticketNo) {
        return yoloRepository.findByTicketNo(ticketNo);
    }
    public List<Yolo> findALLByuser(String user) {
        return yoloRepository.findByUser(user);
    }



}
