package com.nscs.SBMaster.controller;

import com.nscs.SBMaster.model.Details;
import com.nscs.SBMaster.model.Maintenance;
import com.nscs.SBMaster.model.Yolo;
import com.nscs.SBMaster.repository.DetailsRepository;
import com.nscs.SBMaster.repository.MaintenanceRepository;
import com.nscs.SBMaster.repository.YoloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class AllDetailsController {

    @Autowired
    private DetailsRepository detailsRepository;

    @Autowired
    private YoloRepository yoloRepository;@Autowired
    private MaintenanceRepository maintenanceRepository;

    @GetMapping("/allDetails")
    public String showAllDetails(Model model) {
        List<Details> allDetails = detailsRepository.findAll();
        List<Yolo> allYolos = yoloRepository.findAll();List<Maintenance> allMaints = maintenanceRepository.findAll();


        model.addAttribute("allDetails", allDetails);
        model.addAttribute("allYolos", allYolos);model.addAttribute("allMaints", allMaints);

        return "all-details";
    }
}

