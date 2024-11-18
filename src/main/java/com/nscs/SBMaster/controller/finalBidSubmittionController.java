package com.nscs.SBMaster.controller;

import com.nscs.SBMaster.model.Costing;
import com.nscs.SBMaster.model.FinalBidSubmittion;
import com.nscs.SBMaster.model.Tender;
import com.nscs.SBMaster.repository.FinalBidSubmitionRepository;
import com.nscs.SBMaster.repository.TenderRepository;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;

@Controller
public class finalBidSubmittionController {
    @Autowired
    private FinalBidSubmitionRepository FinalBidSubmitionRepository;

    @Autowired
    private TenderRepository tenderRepository;


    @GetMapping("/finalBidSubmitionList")
    public String finalBidSubmitionList(HttpServletRequest request, Model model) {
        List<Tender> emp = tenderRepository.findAll() ;

        model.addAttribute("users", emp);
        return   "finalBidSubmitionList";
    }


    @GetMapping("/finalBidSubmition/{id}")
    public String finalBidSubmition(Model model, @PathVariable("id") Long Tenderid ) {
        Optional<Tender> optionalTender = tenderRepository.findById(Tenderid);

        if (optionalTender.isPresent() ) {
            Tender tender = optionalTender.get();
            model.addAttribute("tender", tender);
            // Find the costing by tender number
            Optional<FinalBidSubmittion> FinalBidSubmittion = FinalBidSubmitionRepository.findByTenderNumber(String.valueOf(tender.getId()));
            if (FinalBidSubmittion.isPresent()) {

                model.addAttribute("FinalBidSubmittion", FinalBidSubmittion.get());

                return "finalBidSubmitionForm";
            } else {
                model.addAttribute("error", "Costing not found for the tender number: " );
            }
        } else {
            // Handle the case where the Tender is not found
            model.addAttribute("error", "Tender not found");
        }
        return  "finalBidSubmitionForm";
    }



    @PostMapping("/finalBidSubmitionSave")
    public String finalBidSubmitionSave(@Validated FinalBidSubmittion FinalBidSubmittion) {

        Optional<FinalBidSubmittion> FinalBidSubmittionExisting = FinalBidSubmitionRepository.findByTenderNumber(FinalBidSubmittion.getTenderNumber());

        if (FinalBidSubmittionExisting.isPresent()) {
            // Retrieve the existing costing object

            FinalBidSubmittion FinalBidSubmittionExisting1 = FinalBidSubmittionExisting.get();
            FinalBidSubmittion.setId(FinalBidSubmittionExisting1.getId());
           FinalBidSubmitionRepository.save(FinalBidSubmittion);
        }
        else {
            FinalBidSubmitionRepository.save(FinalBidSubmittion);
        }

        return"redirect:/finalBidSubmitionList";
    }

}
