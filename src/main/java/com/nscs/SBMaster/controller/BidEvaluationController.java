package com.nscs.SBMaster.controller;

import com.nscs.SBMaster.model.BidEvaluation;
import com.nscs.SBMaster.model.BidEvaluationParticipantsDetails;
import com.nscs.SBMaster.model.FeeApproval;
import com.nscs.SBMaster.model.Tender;
import com.nscs.SBMaster.repository.BidEvaluationParticipantsDetailsRepository;
import com.nscs.SBMaster.repository.BidEvaluationRepository;
import com.nscs.SBMaster.repository.TenderRepository;
import com.nscs.SBMaster.services.BidEvaluationParticipantsDetailsService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class BidEvaluationController {

    @Autowired
    private TenderRepository tenderRepository;

    @Autowired
    private BidEvaluationParticipantsDetailsRepository bidEvaluationParticipantsDetailsRepository;

    @Autowired
    private BidEvaluationRepository bidEvaluationRepository;

    @Autowired
    private BidEvaluationParticipantsDetailsService BidEvaluationParticipantsDetailsService;

    @GetMapping("/bid-evaluation/{id}")
    public String showBidEvaluationForm(Model model,@PathVariable("id") Long Tenderid ) {
        Optional<Tender> optionalTender = tenderRepository.findById(Tenderid);

        if (optionalTender.isPresent() ) {
            Tender tender = optionalTender.get();
            model.addAttribute("tender", tender);
            // Find the BidEvaluation by tender number
            Optional<BidEvaluation> bidEvaluationOptional = bidEvaluationRepository.findByTenderNumber(String.valueOf(tender.getId()));
            if (bidEvaluationOptional.isPresent()) {

                model.addAttribute("bidEvaluation", bidEvaluationOptional.get());

                List<BidEvaluationParticipantsDetails> bidEvaluationParticipantsDetailsList =
                        bidEvaluationParticipantsDetailsRepository.findBybidEvaluation(bidEvaluationOptional.get().getId());
                if (!bidEvaluationParticipantsDetailsList.isEmpty()) {
                    model.addAttribute("bidEvaluationParticipantsDetailsList", bidEvaluationParticipantsDetailsList);
                }
                return "BidEvaluationGetData";
                } else {
                model.addAttribute("error", "Bid Evaluation not found for the tender number: " );
            }
        } else {
            // Handle the case where the Tender is not found
            model.addAttribute("error", "Tender not found");
        }
        return  "BidEvaluation";
    }


    @PostMapping("/bid-evaluation")
    public String submitBidEvaluationForm(@Validated BidEvaluation bidEvaluation, @RequestParam List<String> participantRank,
                                          @RequestParam List<String> participantName,@RequestParam List<String> quotedRates,@RequestParam List<String> quotedRateType) {

       Optional<BidEvaluation> bidEvaluationOptional = bidEvaluationRepository.findByTenderNumber(bidEvaluation.getTenderNumber());
        BidEvaluation savedBidEvaluation;
       if (bidEvaluationOptional.isPresent()) {
            // Retrieve the existing BidEvaluation object

            BidEvaluation existingBidEvaluation = bidEvaluationOptional.get();
            // Update existing object
            existingBidEvaluation.updateFrom(bidEvaluation);
           savedBidEvaluation =  bidEvaluationRepository.save(existingBidEvaluation);
        }
        else {
           savedBidEvaluation = bidEvaluationRepository.save(bidEvaluation);
        }

        Long bidId=savedBidEvaluation.getId();
        // Delete existing participant details for this bidEvaluation
        List<BidEvaluationParticipantsDetails> existingParticipants = bidEvaluationParticipantsDetailsRepository.findBybidEvaluation(bidId);
        bidEvaluationParticipantsDetailsRepository.deleteAll(existingParticipants);

        BidEvaluationParticipantsDetailsService.saveData(bidId,participantRank,participantName,quotedRates,quotedRateType);

        return"redirect:/bid-evaluationlist";
    }

    @GetMapping("/bid-evaluationlist")
    public String evaluationlist(HttpServletRequest request, Model model) {
        List<Tender> emp = tenderRepository.findAll() ;

        model.addAttribute("users", emp);
        return   "BidEvaluationList";
    }
}


