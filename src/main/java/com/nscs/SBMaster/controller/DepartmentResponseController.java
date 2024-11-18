package com.nscs.SBMaster.controller;

import com.nscs.SBMaster.model.Department;
import com.nscs.SBMaster.model.DepartmentResponseEntity;
import com.nscs.SBMaster.model.FeeApproval;
import com.nscs.SBMaster.model.Tender;
import com.nscs.SBMaster.repository.DepartmentRepository;
import com.nscs.SBMaster.repository.DepartmentResponseRepository;
import com.nscs.SBMaster.repository.TenderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
@RequestMapping("/department")
public class DepartmentResponseController {


    @Autowired
    private TenderRepository tenderRepository;

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private DepartmentResponseRepository departmentResponseRepository;

    // Display the form
    @GetMapping("/{departmentName}/tender/{tenderId}")
    public String showDepartmentResponseForm(@PathVariable String departmentName,
                                             @PathVariable Long tenderId,
                                             Model model) {
        Department department = departmentRepository.findByName(departmentName)
                .orElseThrow(() -> new IllegalArgumentException("Invalid department name: " + departmentName));

        Tender tender = tenderRepository.findById(tenderId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid tender ID: " + tenderId));

        // Check if a response already exists
        DepartmentResponseEntity response = departmentResponseRepository.findByTenderAndDepartment(tender, department)
                .orElse(new DepartmentResponseEntity());

        response.setTender(tender);
        response.setDepartment(department);

        model.addAttribute("departmentResponse", response);
        model.addAttribute("departmentName", departmentName);
        model.addAttribute("tender", tender);

        return "Departments"; // Thymeleaf template
    }

    // Handle form submission
    @PostMapping("/{departmentName}/tender/{tenderId}/save")
    public String saveDepartmentResponse(@PathVariable String departmentName,
                                         @PathVariable Long tenderId,
                                         @ModelAttribute DepartmentResponseEntity departmentResponse,
                                         @RequestParam String action, // "saveDraft" or "submit"
                                         RedirectAttributes redirectAttributes) {
        Department department = departmentRepository.findByName(departmentName)
                .orElseThrow(() -> new IllegalArgumentException("Invalid department name: " + departmentName));

        Tender tender = tenderRepository.findById(tenderId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid tender ID: " + tenderId));

        departmentResponse.setDepartment(department);
        departmentResponse.setTender(tender);

        Optional<DepartmentResponseEntity> response3=departmentResponseRepository.findByTenderAndDepartment(tender,department);

        if (response3.isPresent()) {
            // Retrieve the existing  object

            DepartmentResponseEntity existingDepartmentResponse = response3.get();
            departmentResponse.setId(existingDepartmentResponse.getId());
        }
        if ("saveDraft".equals(action)) {
            departmentResponse.setDraft(true);
        } else if ("submit".equals(action)) {
            departmentResponse.setDraft(false);
        }

        departmentResponseRepository.save(departmentResponse);

        redirectAttributes.addFlashAttribute("message", "Response saved successfully.");

        return "redirect:/department/" + departmentName + "/tender/" + tenderId;
    }

    // Handle cancel action
    @PostMapping("/{departmentName}/tender/{tenderId}/cancel")
    public String cancelDepartmentResponse(@PathVariable String departmentName,
                                           @PathVariable Long tenderId,
                                           RedirectAttributes redirectAttributes) {
        // Implement any required logic on cancel
        redirectAttributes.addFlashAttribute("message", "Action cancelled.");
        return "redirect:/tenders"; // Redirect to tender list or appropriate page
    }
}

