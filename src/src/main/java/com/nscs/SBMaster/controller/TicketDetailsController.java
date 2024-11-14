package com.nscs.SBMaster.controller;

import com.nscs.SBMaster.model.Details;
import com.nscs.SBMaster.model.Maintenance;
import com.nscs.SBMaster.model.Yolo;
import com.nscs.SBMaster.repository.DetailsRepository;
import com.nscs.SBMaster.repository.YoloRepository;
import com.nscs.SBMaster.services.DetailsService;
import com.nscs.SBMaster.services.MaintenanceService;
import com.nscs.SBMaster.services.MaintenanceUpdateService;
import com.nscs.SBMaster.services.YoloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class TicketDetailsController {
//    private final MaintenanceService maintenanceService;
    private final MaintenanceUpdateService maintenanceUpdateService;
   @Autowired
  private final MaintenanceService maintenanceService;
    @Autowired
    private YoloRepository yoloRepository;

    @Autowired
    public TicketDetailsController(MaintenanceService maintenanceService,
                                 MaintenanceUpdateService maintenanceUpdateService) {
        this.maintenanceService = maintenanceService;
        this.maintenanceUpdateService = maintenanceUpdateService;
    }

  @Autowired
  private DetailsService detailsService;@Autowired
    private YoloService yoloService;

    @GetMapping("/ticketDetailsForm")
    public String showTicketDetailsForm() {
        return "TicketDetailsForm";
    }

    @PostMapping("/ticketDetails")
    public String showTicketDetails(@RequestParam("ticketNo") String ticketNo, Model model) {
        Maintenance maintenance = maintenanceService.findByTicketNo(ticketNo);
        List<Yolo> yolo = yoloService.findALLByTicketNo(ticketNo);
        if (maintenance != null) {
            model.addAttribute("maintenance", maintenance);model.addAttribute("yolo", yolo);
            return "Tick";
        } else {
            model.addAttribute("error", "Ticket not found");
            return "TicketDetailsForm";
        }
    }

    // get history


    @GetMapping("/tD")
    public String tD(@RequestParam("ticketNo") String ticketNo, Model model) {
        Maintenance maintenance = maintenanceService.findByTicketNo(ticketNo);
        List<Yolo> yolo = yoloService.findALLByTicketNo(ticketNo);
        Details details = detailsService.findByTicketNo(ticketNo);
        if (maintenance != null) {
            model.addAttribute("maintenance", maintenance);model.addAttribute("yolo", yolo);
            model.addAttribute("details", details);  return "Tick";
        } else {
            model.addAttribute("error", "Ticket not found");
            return "TicketDetailsForm";
        }
    }





    // close ticket
    @GetMapping("/closeTicket")
    public String closeTicket(@RequestParam("ticketNo") String ticketNo, Model model) {
        Maintenance maintenance = maintenanceService.findByTicketNo(ticketNo);

        if (maintenance != null) {

            return "redirect:/ticketDetails?ticketNo=" +ticketNo;
        } else {
            model.addAttribute("error", "Ticket not found");
            return "TicketDetailsForm";
        }
    }

    @GetMapping("/scrapTicket")
    public String scrapTicket(@RequestParam("ticketNo") String ticketNo, Model model) {
        Maintenance maintenance = maintenanceService.findByTicketNo(ticketNo);

        if (maintenance != null) {

            return "redirect:/ticketDetails?ticketNo=" +ticketNo;
        } else {
            model.addAttribute("error", "Ticket not found");
            return "TicketDetailsForm";
        }
    }



// latest
    @GetMapping("/ticketDetail")
    public String showTicketDetail(@RequestParam("userName") String userName, Model model) {

        List<Yolo> yolo = yoloService.findALLByuser(userName);
        if (yolo != null) {
            model.addAttribute("yolo", yolo);
            return "hhhhh";
        } else {
            model.addAttribute("error", "Ticket not found");
            return "TicketDetailsForm";
        }
    }

    @GetMapping("/ticketDetails")
    public String Details(String ticketNo, Model model,@ModelAttribute("yolo") Yolo yol,@ModelAttribute("details") Details det, String ticket) {
        Maintenance maintenance = maintenanceService.findByTicketNo(ticketNo);
        Details details = detailsService.findByTicketNo(ticketNo);
        Yolo yolo = new Yolo();
//        List<Yolo> yolo = List.of(yoloRepository.findByTicketNo(ticketNo));
//        List<Yolo> yolo = yoloService.findALLByTicketNo(ticketNo);
        model.addAttribute("det",det);
        model.addAttribute("tick",ticket);

        if (maintenance != null && details != null ) {
            model.addAttribute("maintenance", maintenance);
            model.addAttribute("yolo", yolo);
            model.addAttribute("details",details);
            return "TicketDetails"; // Return the name of your ticket details template
        } else {
            model.addAttribute("error", "Not Enough Details");
            return "o.html"; // Return a template indicating ticket not found
        }
    }




    @GetMapping("/client/{ticketNo}")
    public String show(@PathVariable("ticketNo") String ticketNo, Model model) {
        Details details = detailsService.findByTicketNo(ticketNo);
        Maintenance maintenance = maintenanceService.findByTicketNo(ticketNo);
        if (maintenance != null && details != null) {
            model.addAttribute("maintenance", maintenance);
            model.addAttribute("details",details);
            return "RemarksAndNeeds"; // Return the name of your ticket details template
        } else {
            model.addAttribute("error", "Not Enough Details");
            return "o.html"; // Return a template indicating ticket not found
        }
}

//    @PostMapping("/client")
//    public String remarksNneeds( String ticketNo, Model model, Details ui) {
//        Details details = detailsService.findByTicketNo(ticketNo);
////        user = details.getUser();
//        Maintenance maintenance = maintenanceService.findByTicketNo(ticketNo);
//        if (maintenance != null && details != null) {
//            model.addAttribute("maintenance", maintenance);
//            model.addAttribute("details",details);
//
//            detailsService.updateItem(ticketNo,ui);
//            return "redirect:/ticketDetails"; // Return the name of your ticket details template
//        } else {
//            model.addAttribute("error", "Not Enough Details");
//            return "o.html"; // Return a template indicating ticket not found
//        }

//
//
//    @PostMapping("/client")
//    public String go(@RequestParam("user") String user, @RequestParam("ticketNo") String ticketNo, @ModelAttribute("details") Details updatedDetail) {
//detailsService.updateItem(ticketNo,updatedDetail);
//
//        return "redirect:/client/{ticketNo}";
//    }}

//    @PostMapping("/client/{ticketNo}")
//    public String updateRemarks(@PathVariable String ticketNo,
//                                @ModelAttribute("details") Details updatedDetails) {
//
//        // Retrieve original details object
//        Details originalDetails = detailsService.findByTicketNo(ticketNo);
//        if (originalDetails == null) {
//            // Handle scenario where original details are not found
//            return "error"; // Redirect to an error page or handle gracefully
//        }
//
//        // Update the remarks in the original details object
//        originalDetails.setRemarks(updatedDetails.getRemarks());
//
//        // Save the updated details object
//        detailsService.updateItem(ticketNo, originalDetails);
//
//        // Redirect to the ticket details page
//        return "redirect:/ticketDetails";
//    }

}

//
//    public String addRemarks(@PathVariable("ticketNo") String ticketNo,
//                             @RequestParam("additionalRemarks") String additionalRemarks) {
//        // Fetch existing remarks for the ticketNo and append additionalRemarks
//        String existingRemarks = detailsService.getRemarksByTicketNo(ticketNo);
//        String updatedRemarks = existingRemarks + "\n" + additionalRemarks;


