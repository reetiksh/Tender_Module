package com.nscs.SBMaster.controller;

import com.nscs.SBMaster.model.Details;
import com.nscs.SBMaster.model.Yolo;
import com.nscs.SBMaster.services.DetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
//@RequestMapping("/details")
public class DetailsController {

    @Autowired
    private DetailsService detailsService;

    // Endpoint to display form to add Yolo for a specific ticket_no
    @GetMapping("/addYolo")
    public String showAddYoloForm(Model model, @RequestParam("ticketNo") String ticketNo) {
        Details details = detailsService.getItemByTicket(ticketNo);
        if (details == null) {
            throw new RuntimeException("Details with ticket_no " + ticketNo + " not found");
        }
        model.addAttribute("ticketNo", ticketNo);
        model.addAttribute("details", details);
        model.addAttribute("yolo", new Yolo());
       return "redirect:/ticketDetails?ticketNo=" + ticketNo;
    }


    // Endpoint to handle form submission to add Yolo
    @PostMapping("/addYolo")
    public String addYoloSubmit(@ModelAttribute("yolo") Yolo yolo, @RequestParam("tick") String ticketNo) {
     detailsService.addYoloToDetails(ticketNo, yolo);
        return "redirect:/viewDetails?ticketNo=" + ticketNo;
    }


    // Endpoint to view Details and associated Yolo entities
    @GetMapping("/viewDetails")
    public String viewDetails(Model model, @RequestParam("ticketNo") String ticketNo) {
        Details details = detailsService.findByTicketNo(ticketNo);
        if (details != null) {
            model.addAttribute("details", details);
            return "view-details";
        } else {
            // Handle case where Details with the specified ticket_no does not exist
            throw new RuntimeException("Details with ticket_no " + ticketNo + " not found");
        }
    }
}
