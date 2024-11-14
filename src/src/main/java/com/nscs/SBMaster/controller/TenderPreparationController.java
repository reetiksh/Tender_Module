package com.nscs.SBMaster.controller;

import com.nscs.SBMaster.model.Tender;
import com.nscs.SBMaster.model.TenderPreparation;
import com.nscs.SBMaster.repository.TenderPreparationRepository;
import com.nscs.SBMaster.repository.TenderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;

@Controller
public class TenderPreparationController {

    @Autowired
    private TenderRepository tenderRepository;

    @Autowired
    private TenderPreparationRepository tenderPreparationRepository;

    // Display the form
    @GetMapping("/tender/prepare")
    public String showTenderPreparationForm( Model model) {
        model.addAttribute("tenderPreparation", new TenderPreparation());

        return "TenderprepareBy";
    }

    // Handle form submission
    @PostMapping("/tender/prepare")
    public String submitTenderPreparationForm(@ModelAttribute TenderPreparation tenderPreparation) {
        // Save the data to the database
        tenderPreparationRepository.save(tenderPreparation);
        return "redirect:/tender/prepare?success";
    }
}
