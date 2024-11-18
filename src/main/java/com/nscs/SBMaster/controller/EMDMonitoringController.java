package com.nscs.SBMaster.controller;


import com.nscs.SBMaster.model.*;
import com.nscs.SBMaster.repository.*;
import com.nscs.SBMaster.services.FollowUpRemarkService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class EMDMonitoringController {

    @Autowired
    private TenderRepository tenderRepository;

    @Autowired
    private BidEvaluationRepository bidEvaluationRepository;

    @Autowired
    private FeeApprovalRepository feeApprovalRepository;


    @Autowired
    private EMDMonitoringRepository emdMonitoringRepository;

    @Autowired
    private FollowUpRemarkRepository followUpRemarkRepository;

    @Autowired
    private FollowUpRemarkService followUpRemarkService;

    @GetMapping("/emd-monitoring/{id}")
    public String showEMDMonitoringForm(Model model, @PathVariable("id") Long tenderId) {
        Optional<Tender> optionalTender = tenderRepository.findById(tenderId);

        if (optionalTender.isPresent()) {
            Tender tender = optionalTender.get();
            model.addAttribute("tender", tender);

            // Find EMDMonitoring by tender number
            Optional<EMDMonitoring> emdMonitoringOptional = emdMonitoringRepository.findByTenderNumber(String.valueOf(tender.getId()));

            // Find EMDMonitoring by tender number
            Optional<FeeApproval> feeApprovalOptional = feeApprovalRepository.findByTenderNumber(String.valueOf(tender.getId()));


            // Find EMDMonitoring by tender number
            Optional<BidEvaluation> bidEvaluationOptional = bidEvaluationRepository.findByTenderNumber(String.valueOf(tender.getId()));


            if(feeApprovalOptional.isPresent()){
                model.addAttribute("feeApproval",feeApprovalOptional.get());
            }
            else{
                model.addAttribute("error", " Fee Approval  not found for the tender number: " );

            }

            if(bidEvaluationOptional.isPresent()){
                model.addAttribute("bidEvaluation",bidEvaluationOptional.get());
            }else {
                model.addAttribute("error", " Bid Evaluation not found for the tender number: " );

            }


            if (emdMonitoringOptional.isPresent()) {
                model.addAttribute("emdMonitoring", emdMonitoringOptional.get());
                List<FollowUpRemark> followUpRemarkDetailsList =
                        followUpRemarkRepository.findByEmdMonitoringId(emdMonitoringOptional.get().getId());
                if (!followUpRemarkDetailsList.isEmpty()) {
                    model.addAttribute("followUpRemarkDetailsList", followUpRemarkDetailsList);
                }
                return "EMDMonitoringGetData";
            } else {

                model.addAttribute("error", " EMD Monitoring  not found for the tender number: " );
            }
            } else {
            // Handle the case where the Tender is not found

            model.addAttribute("error", "Tender not found");

            }
        return "EMDMonitoring";
    }


    @PostMapping("/emd-monitoring")
    public String submitEMDMonitoringForm(@ModelAttribute EMDMonitoring emdMonitoring, @RequestParam List<String> remarkDate,
                                          @RequestParam List<String> remark, Model model) {

        Optional<EMDMonitoring> emdMonitoringOptional = emdMonitoringRepository.findByTenderNumber(emdMonitoring.getTenderNumber());
        EMDMonitoring savedEMDMonitoring;
        if (emdMonitoringOptional.isPresent()) {
            // Retrieve the existing EMDMonitoring object

            EMDMonitoring existingEMDMonitoring = emdMonitoringOptional.get();
            // Update existing object
            existingEMDMonitoring.updateFrom(emdMonitoring);
            savedEMDMonitoring  =  emdMonitoringRepository.save(existingEMDMonitoring);
        }
        else {
            savedEMDMonitoring = emdMonitoringRepository.save(emdMonitoring);
        }

        Long emdMonitoringId=emdMonitoring.getId();
        List<FollowUpRemark> existingEmdRemarks = followUpRemarkRepository.findByEmdMonitoringId(emdMonitoringId);

        followUpRemarkService.saveData(emdMonitoringId,remark,remarkDate);
        return "redirect:/emd-monitoringlist";
    }


    @GetMapping("/emd-monitoringlist")
    public String evaluationlist(HttpServletRequest request, Model model) {
        List<Tender> emp = tenderRepository.findAll() ;

        model.addAttribute("users", emp);
        return   "EMDMonitoringList";
    }

}
