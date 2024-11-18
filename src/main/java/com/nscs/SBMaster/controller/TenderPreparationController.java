package com.nscs.SBMaster.controller;

import com.nscs.SBMaster.model.Survey;
import com.nscs.SBMaster.model.Tender;
import com.nscs.SBMaster.model.TenderPreparation;
import com.nscs.SBMaster.repository.TenderPreparationRepository;
import com.nscs.SBMaster.repository.TenderRepository;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;

@Controller
public class TenderPreparationController {

    @Autowired
    private TenderRepository tenderRepository;

    @Autowired
    private TenderPreparationRepository tenderPreparationRepository;


    @GetMapping("/tenderPreparelist")
    public String TenderPreparelist(HttpServletRequest request, Model model) {
        List<Tender> emp = tenderRepository.findAll() ;

        model.addAttribute("users", emp);
        return   "TenderPreparelist";
    }


    @GetMapping("/tender/prepare/{id}")
    public String showTenderPreparationForm(@PathVariable("id") Long id,HttpServletRequest request, Model model) {


        // Find the Tender by its ID
        Optional<Tender> optionalTender = tenderRepository.findById(id);

        if (optionalTender.isPresent()) {
            Tender tender = optionalTender.get();
            model.addAttribute("tender", tender);

            // Find the FeeApproval by tender number
            Optional<TenderPreparation> tenderpreapare = tenderPreparationRepository.findByTenderNumber(String.valueOf(tender.getId()));

            if (tenderpreapare.isPresent()) {
                model.addAttribute("TenderPreparation", tenderpreapare.get());

                return "TenderPrepareByGetData";

            } else {
                model.addAttribute("error", "Tender Prepare not found for the tender number: " );
            }
        } else {
            // Handle the case where the Tender is not found
            model.addAttribute("error", "Tender not found");
        }
        return   "TenderPrepareBy";
    }


    @PostMapping("/savetenderprepare")
    public String surveySave(@Validated TenderPreparation user, HttpServletRequest request, BindingResult result, Model model) {
        Optional<TenderPreparation> tenderPreparation = tenderPreparationRepository.findByTenderNumber(user.getTenderNumber());

        if (tenderPreparation.isPresent()) {
            // Retrieve the existing FeeApproval object

            TenderPreparation existingTenderPreparation = tenderPreparation.get();
            // Update existing object
            user.setId(existingTenderPreparation.getId());
            tenderPreparationRepository.save(user);
        }
        else {
            tenderPreparationRepository.save(user);
        }

        return   "redirect:/tenderPreparelist";
    }

}
