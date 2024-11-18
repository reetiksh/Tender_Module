package com.nscs.SBMaster.controller;

import com.nscs.SBMaster.model.Details;
import com.nscs.SBMaster.model.Maintenance;
import com.nscs.SBMaster.repository.DetailsRepository;
import com.nscs.SBMaster.repository.MaintenanceRepository;
import com.nscs.SBMaster.services.DetailsService;
import com.nscs.SBMaster.services.MaintenanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller

public class MaintenanceControllerTwo {
 @Autowired
    private MaintenanceService maintenanceService;
    @Autowired
    private DetailsService detailsService;
    @Autowired
    private DetailsRepository detailsRepository;

    @PostMapping("/delete/{id}")
    public String deleteItem(@PathVariable("id") Long id) {
        maintenanceService.deleteItem(id);
        return "redirect:/Maintlist";
    }

    @PostMapping("/Admindelete/{id}")
    public String deleteAdminItem(@PathVariable("id") Long id) {
        maintenanceService.deleteItem(id);
        return "redirect:/Adminlist";
    }



    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") Long id, Model model) {
        Maintenance maintenance = maintenanceService.getItemById(id);

        model.addAttribute("user", maintenance);

        return "EditMaint";
    }

    @PostMapping("/edit/{id}")
    public String editItem(@PathVariable("id") Long id, @ModelAttribute("user") Maintenance updatedItem) {
        maintenanceService.updateItem(id, updatedItem);
        return "redirect:/Maintlist";
    }


    @GetMapping("/AdminEdit/{id}")
    public String showAdminEditForm(@PathVariable("id") Long id, Model model) {
//
        Maintenance maintenance = maintenanceService.getItemById(id);
//
        model.addAttribute("user", maintenance);
        return "AdminEdit";
    }

    @PostMapping("/AdminEdit/{id}")
    public String editAdminItem(@PathVariable("id") Long id, @ModelAttribute("user") Maintenance updatedItem) {
        maintenanceService.updateItem(id, updatedItem);

        return "redirect:/Adminlist";
    }



}
