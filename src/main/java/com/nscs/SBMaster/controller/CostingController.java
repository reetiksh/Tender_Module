package com.nscs.SBMaster.controller;


import com.nscs.SBMaster.model.BidEvaluation;
import com.nscs.SBMaster.model.BidEvaluationParticipantsDetails;
import com.nscs.SBMaster.model.Costing;
import com.nscs.SBMaster.model.Tender;
import com.nscs.SBMaster.repository.CostingRepository;
import com.nscs.SBMaster.repository.TenderRepository;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Controller
public class CostingController {

    @Autowired
    private TenderRepository tenderRepository;

    @Autowired
    private CostingRepository costingRepository;


    @GetMapping("/costing/{id}")
    public String showCostingForm(Model model, @PathVariable("id") Long Tenderid ) {
        Optional<Tender> optionalTender = tenderRepository.findById(Tenderid);

        if (optionalTender.isPresent() ) {
            Tender tender = optionalTender.get();
            model.addAttribute("tender", tender);
            // Find the costing by tender number
            Optional<Costing> costingOptional = costingRepository.findByTenderNumber(String.valueOf(tender.getId()));
            if (costingOptional.isPresent()) {

                model.addAttribute("costing", costingOptional.get());

                return "Costing";
            } else {
                model.addAttribute("error", "Costing not found for the tender number: " );
            }
        } else {
            // Handle the case where the Tender is not found
            model.addAttribute("error", "Tender not found");
        }
        return  "Costing";
    }


    @PostMapping("/costing")
    public String submitCostingForm(@Validated Costing costing) {

        Optional<Costing> costingOptional = costingRepository.findByTenderNumber(costing.getTenderNumber());
        Costing savedCosting;
        if (costingOptional.isPresent()) {
            // Retrieve the existing costing object

            Costing existingCosting = costingOptional.get();
            // Update existing object
            existingCosting.updateFrom(costing);
            savedCosting =  costingRepository.save(existingCosting);
        }
        else {
            savedCosting = costingRepository.save(costing);
        }

        Long costingId=savedCosting.getId();


        return"redirect:/costinglist";
    }


    @GetMapping("/costinglist")
    public String costinglist(HttpServletRequest request, Model model) {
        List<Tender> emp = tenderRepository.findAll() ;

        model.addAttribute("users", emp);
        return   "CostingList";
    }
}
