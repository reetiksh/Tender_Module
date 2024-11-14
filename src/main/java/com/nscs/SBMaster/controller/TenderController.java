package com.nscs.SBMaster.controller;

import com.nscs.SBMaster.model.*;


import com.nscs.SBMaster.repository.*;


import com.nscs.SBMaster.services.*;


import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.multipart.MultipartFile;


import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Controller
@CrossOrigin(origins = "*")
public class TenderController {



    @Autowired
    private TenderRepository userRepository;

    @Autowired
    private FeeApprovalRepository FeeApprovalRepository;

    @Autowired
    private FeeApprovalService FeeApprovalService;


    @Autowired
    private goNoTenderRepository userRepositorygo;

    @Autowired
    private TenderService tenderService;

    @Autowired
    private TenderActivityService tenderActivityService;

    @Autowired
    private MSEbenifitsService MSEbenifitsService;

    @Autowired
    private goNoTenderService goNoTenderService;

    @Autowired
    private productAndServiciesService productAndServiciesService;

    @Autowired
    private ComponentMasterService componentMasterService;

    @Autowired
    private TenderSourceRepository tenderSourceRepository;

    @Value("${file.upload-dir}")
    private String baseUploadDir;


    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private PreBidMeetRepository PreBidMeetRepository;

    @Autowired
    private OtherRequirementRepository OtherRequirementRepository;

    @Autowired
    private SurveyRepository SurveyRepository;



    @GetMapping("/TenderEdit/{id}")
    public String goNoTender(@PathVariable("id") String id,Model model) {
        List<GoNoTenderMaster> user = goNoTenderService.getAllMasterActivities();
        model.addAttribute("user", user);
        model.addAttribute("tenderid", id);
        return "GoNoGoTender";
    }

    @PostMapping("/save-from-master")
    public String saveActivitiesFromMaster(@RequestParam List<Long> masterIds,
                                           @RequestParam String tenderId,
                                           @RequestParam List<String> users,
                                           @RequestParam List<String> dueDates,
                                           @RequestParam List<String> activityindex) {

        return "redirect:/Tenderlist";
    }

    @PostMapping("/saveTenderGoNo")
    public String addTernderGoNo(@RequestParam List<Long> masterIds,@RequestParam String tenderId, @RequestParam boolean gono) {
        goNoTenderService.saveActivitiesFromMaster(masterIds, tenderId,gono);

        return "redirect:/Tenderlist";
    }





    @GetMapping("/Tenderlist")
    public String showUserList(HttpServletRequest request, Model model) {
        List<Tender> emp = userRepository.findAll() ;

        model.addAttribute("users", emp);
        return   "TenderList";
    }

    @GetMapping("/AdminTenderlist")
    public String showAdminUserList(HttpServletRequest request, Model model) {
        List<Tender> emp = userRepository.findAll() ;
        model.addAttribute("users", emp);
        return   "AdminList";
    }

    @GetMapping("/TenderEntry")
    public String showSignUpForm(Tender user,Model model) {
        model.addAttribute("user", user);
        model.addAttribute("id", user.getId());
        List<MSEbenifitsMaster> msebenifits = MSEbenifitsService.getAllMseMasterActivities();
        model.addAttribute("msebenifits", msebenifits);
        List<productAndServices> products = productAndServiciesService.getAllProductsMasterActivities();
        model.addAttribute("products", products);
        List<TenderSource> TenderSource = tenderSourceRepository.findAll();
        model.addAttribute("tenderSourceOptions", TenderSource);
        List<String> months = List.of("January", "February", "March", "April", "May", "June",
                "July", "August", "September", "October", "November", "December");
        model.addAttribute("months", months);


        return "tenderForm";
    }




    @PostMapping("/saveTenderNew")
    public String addTender(@Validated Tender user, BindingResult result, Model model,
                            @RequestParam(value = "supportingDocs", required = false)  MultipartFile[] supportingDocs,
                            @RequestParam(value = "mseBenifit", required = false)List<String> mseBenifit)  throws IOException {
        model.addAttribute("user", user);
        if (result.hasErrors()) {
            return "tenderForm";
        }


        userRepository.save(user);
        Long caseId = user.getId();
        String caseDir = baseUploadDir + caseId;

        // Create directory for the caseId if it doesn't exist
        File caseDirFile = new File(caseDir);
        if (!caseDirFile.exists()) {
            caseDirFile.mkdirs();
        }

        for (MultipartFile file : supportingDocs) {
            if (!file.isEmpty()) {
                // Save the file to the directory
                String filePath = caseDir + "/" + file.getOriginalFilename();
                file.transferTo(new File(filePath));

            }
        }

        // Pass ticketId to the view using model attribute or use RedirectAttributes for redirect


        return "redirect:/Tenderlist";
    }

    @GetMapping("/TenderDetails/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
        Tender user = userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
        model.addAttribute("user", user);

        return "TenderEdit";
    }

    @GetMapping("/searchAssupmstDetails")
    @ResponseBody
    public List<Map<String, Object>> searchAssupmstDetails(@RequestParam String query) {
        return tenderService.searchAssupmstDetails(query);
    }
    @GetMapping("/searchSectorData")
    @ResponseBody
    public List<Map<String, Object>> searchSectorData(@RequestParam String query) {
        return tenderService.searchSectorData(query);
    }
    @GetMapping("/searchDivisionData")
    @ResponseBody
    public List<Map<String, Object>> searchDivisionData(@RequestParam String query) {
        return tenderService.searchDivisionData(query);
    }
    @GetMapping("/searchBranchData")
    @ResponseBody
    public List<Map<String, Object>> searchBranchData(@RequestParam String query) {
        return tenderService.searchBranchData(query);
    }
    @GetMapping("/searchNatureOfWork")
    @ResponseBody
    public List<Map<String, Object>> searchNatureOfWork(@RequestParam String query) {
        return tenderService.searchNatureOfWork(query);
    }
    @GetMapping("/searchSupplierDetails")
    @ResponseBody
    public List<Map<String, Object>> searchSupplierDetails(@RequestParam String query,@RequestParam String query2) {
        return tenderService.searchSupplierDetails(query,query2);
    }
    @GetMapping("/searchAllZone")
    @ResponseBody
    public List<Map<String, Object>> searchAllZone(@RequestParam String query) {
        return tenderService.searchAllZone(query);
    }
    @GetMapping("/searchAllDepartment")
    @ResponseBody
    public List<Map<String, Object>> searchAllDepartment(@RequestParam String query) {
        return tenderService.searchAllDepartment(query);
    }
    @GetMapping("/searchAllstate")
    @ResponseBody
    public List<Map<String, Object>> searchAllstate(@RequestParam String query) {
        return tenderService.searchAllstate(query);
    }
    @GetMapping("/searchuserDetails")
    @ResponseBody
    public List<Map<String, Object>> searchuserDetails(@RequestParam String query) {
        return tenderService.searchuserDetails(query);
    }

    @GetMapping("/searchAllSupplierDetails")
    @ResponseBody
    public List<Map<String, Object>> searchAllSupplierDetails(@RequestParam String query) {
        return tenderService.searchAllSupplier(query);
    }







    @GetMapping("/tender-activities/{id}")
    public String showTenderActivitiesForm(@PathVariable("id") Long id,Model model) {
        List<TenderActivityMaster> activities = tenderActivityService.getAllMasterActivities();
        model.addAttribute("tenderid", id);
        model.addAttribute("activities", activities);
        return "tenderactivitiesform";
    }



    @GetMapping("/TenderEntryApproval/{id}")
        public String TenderEntryApproval(Tender user,Model model,@PathVariable("id") Long id) {
        model.addAttribute("user", user);
        model.addAttribute("id", user.getId());
        List<MSEbenifitsMaster> msebenifits = MSEbenifitsService.getAllMseMasterActivities();
        model.addAttribute("msebenifits", msebenifits);
        List<productAndServices> products = productAndServiciesService.getAllProductsMasterActivities();
        model.addAttribute("products", products);
        Tender tender = userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
        model.addAttribute("user", tender);
        List<String> months = List.of("January", "February", "March", "April", "May", "June",
                "July", "August", "September", "October", "November", "December");
        model.addAttribute("months", months);

        return "tenderApproval";
    }
    @GetMapping("/api/component-visibility/{step}")
    @ResponseBody
    public List<ComponentMaster> getComponentVisibility(@PathVariable("step") String step) {
        return componentMasterService.getComponentsByStep(step);
    }



    @GetMapping("/FeeApproval/{id}")
    public String FeeApproval(@PathVariable("id") Long id,HttpServletRequest request, Model model) {


        // Find the Tender by its ID
        Optional<Tender> optionalTender = userRepository.findById(id);

        if (optionalTender.isPresent()) {
            Tender tender = optionalTender.get();
            model.addAttribute("tender", tender);

            // Find the FeeApproval by tender number
            Optional<FeeApproval> feeApprovalOptional = FeeApprovalRepository.findByTenderNumber(String.valueOf(tender.getId()));

            if (feeApprovalOptional.isPresent()) {
                model.addAttribute("feeApproval", feeApprovalOptional.get());
            } else {
                model.addAttribute("error", "Fee approval not found for the tender number: " );
            }
        } else {
            // Handle the case where the Tender is not found
            model.addAttribute("error", "Tender not found");
        }
        return   "FeeApproval";
    }
    @PostMapping("/FeeApprovalSave")
    public String FeeApproval(@Validated FeeApproval user,HttpServletRequest request,BindingResult result, Model model) {
        Optional<FeeApproval> feeApprovalOptional = FeeApprovalRepository.findByTenderNumber(user.getTenderNumber());

        if (feeApprovalOptional.isPresent()) {
            // Retrieve the existing FeeApproval object

            FeeApproval existingFeeApproval = feeApprovalOptional.get();
            // Update existing object
            existingFeeApproval.updateFrom(user);
            FeeApprovalRepository.save(existingFeeApproval);
        }
        else {
            FeeApprovalRepository.save(user);
        }

        return   "redirect:/FeeApprovallist";
    }

    @GetMapping("/FeeApprovallist")
    public String FeeApprovallist(HttpServletRequest request, Model model) {
        List<Tender> emp = userRepository.findAll() ;

        model.addAttribute("users", emp);
        return   "FeeApprovalList";
    }

    @GetMapping("/tenders")
    public String listTenders(Model model) {
        List<Tender> tenders = userRepository.findAll();
        System.out.println("Tenders fetched: " + tenders.size());
        model.addAttribute("tenders",tenders);
        return "tenders";
    }
    @GetMapping("/TenderFormEdit/{id}")
    public String tenderEditForm(@PathVariable("id") Long id,Tender user,Model model) {
        Optional<Tender> optionalTender = userRepository.findById(id);
        if (optionalTender.isPresent()) {
            Tender tender = optionalTender.get();
            model.addAttribute("user", tender);
        }
        else{
            model.addAttribute("user", user);
        }

        model.addAttribute("id", user.getId());
        List<MSEbenifitsMaster> msebenifits = MSEbenifitsService.getAllMseMasterActivities();
        model.addAttribute("msebenifits", msebenifits);
        List<productAndServices> products = productAndServiciesService.getAllProductsMasterActivities();
        model.addAttribute("products", products);
        List<String> months = List.of("January", "February", "March", "April", "May", "June",
                "July", "August", "September", "October", "November", "December");
        model.addAttribute("months", months);


        return "tenderFormEdit";
    }


    @GetMapping("/approveTenderForm/{id}")
    public String approveTenderForm(@PathVariable("id") Long id,Tender user,Model model) {
        Optional<Tender> optionalTender = userRepository.findById(id);
        if (optionalTender.isPresent()) {
            Tender tender = optionalTender.get();
            model.addAttribute("user", tender);
        }
        else{
            model.addAttribute("user", user);
        }

        model.addAttribute("id", user.getId());
        List<MSEbenifitsMaster> msebenifits = MSEbenifitsService.getAllMseMasterActivities();
        model.addAttribute("msebenifits", msebenifits);
        List<productAndServices> products = productAndServiciesService.getAllProductsMasterActivities();
        model.addAttribute("products", products);
        List<String> months = List.of("January", "February", "March", "April", "May", "June",
                "July", "August", "September", "October", "November", "December");
        model.addAttribute("months", months);


        return "tenderApproval";
    }
    @PostMapping("/approveTendersave")
    public String approveTendersave(@Validated Tender user, BindingResult result, Model model,
                            @RequestParam(value = "supportingDocs", required = false)  MultipartFile[] supportingDocs,
                            @RequestParam(value = "mseBenifit", required = false)List<String> mseBenifit)  throws IOException {
        model.addAttribute("user", user);
        if (result.hasErrors()) {
            return "tenderForm";
        }


        userRepository.save(user);
        Long caseId = user.getId();
        tenderService.approvetender(String.valueOf(caseId));
        String caseDir = baseUploadDir + caseId;

        // Create directory for the caseId if it doesn't exist
        File caseDirFile = new File(caseDir);
        if (!caseDirFile.exists()) {
            caseDirFile.mkdirs();
        }

        for (MultipartFile file : supportingDocs) {
            if (!file.isEmpty()) {
                // Save the file to the directory
                String filePath = caseDir + "/" + file.getOriginalFilename();
                file.transferTo(new File(filePath));

            }
        }

        // Pass ticketId to the view using model attribute or use RedirectAttributes for redirect


        return "redirect:/Tenderlist";
    }

    @PostMapping("/rejectTender")
    public String rejectTender(@Validated Tender user, BindingResult result, Model model){
        Long caseId = user.getId();
        tenderService.rejecttender(String.valueOf(caseId));
        return "redirect:/Tenderlist";
    }


    @GetMapping("/PreBidEntry/{id}")
    public String PreBidEntry(@PathVariable("id") Long id,HttpServletRequest request, Model model) {


        // Find the Tender by its ID
        Optional<Tender> optionalTender = userRepository.findById(id);

        if (optionalTender.isPresent()) {
            Tender tender = optionalTender.get();
            model.addAttribute("tender", tender);

            // Find the FeeApproval by tender number
            Optional<PreBidMeet> preBid = PreBidMeetRepository.findByTenderNumber(String.valueOf(tender.getId()));

            if (preBid.isPresent()) {
                model.addAttribute("preBidMet", preBid.get());
            } else {
                model.addAttribute("error", "Fee approval not found for the tender number: " );
            }
        } else {
            // Handle the case where the Tender is not found
            model.addAttribute("error", "Tender not found");
        }
        return   "PreBidMeet";
    }

    @PostMapping("/PreBidSave")
    public String PreBidSave(@Validated PreBidMeet user,HttpServletRequest request,BindingResult result, Model model) {
        Optional<PreBidMeet> PreBidMeetOptional = PreBidMeetRepository.findByTenderNumber(user.getTenderNumber());

        if (PreBidMeetOptional.isPresent()) {
            // Retrieve the existing FeeApproval object

            PreBidMeet existingPreBidMeet = PreBidMeetOptional.get();
            // Update existing object
            user.setId(existingPreBidMeet.getId());
            PreBidMeetRepository.save(user);
        }
        else {
            PreBidMeetRepository.save(user);
        }

        return   "redirect:/PreBidMeetList";
    }
    @GetMapping("/PreBidMeetlist")
    public String PreBidMeetlist(HttpServletRequest request, Model model) {
        List<Tender> emp = userRepository.findAll() ;

        model.addAttribute("users", emp);
        return   "PreBidMeetlist";
    }

    @GetMapping("/OtherRequirementlist")
    public String OtherRequirementlist(HttpServletRequest request, Model model) {
        List<Tender> emp = userRepository.findAll() ;

        model.addAttribute("users", emp);
        return   "OtherRequirementlist";
    }

    @GetMapping("/OtherRequirementEntry/{id}")
    public String OtherRequirementEntry(@PathVariable("id") Long id,HttpServletRequest request, Model model) {


        // Find the Tender by its ID
        Optional<Tender> optionalTender = userRepository.findById(id);

        if (optionalTender.isPresent()) {
            Tender tender = optionalTender.get();
            model.addAttribute("tender", tender);

            // Find the FeeApproval by tender number
            Optional<OtherRequirement> OtherRequirement = OtherRequirementRepository.findByTenderNumber(String.valueOf(tender.getId()));

            if (OtherRequirement.isPresent()) {
                model.addAttribute("OtherRequirement", OtherRequirement.get());
            } else {
                model.addAttribute("error", "Fee approval not found for the tender number: " );
            }
        } else {
            // Handle the case where the Tender is not found
            model.addAttribute("error", "Tender not found");
        }
        return   "OtherRequirementForm";
    }


    @PostMapping("/OtherRequirementSave")
    public String OtherRequirementSave(@Validated OtherRequirement user,HttpServletRequest request,BindingResult result, Model model) {
        Optional<OtherRequirement> OtherRequirementOptional = OtherRequirementRepository.findByTenderNumber(user.getTenderNumber());

        if (OtherRequirementOptional.isPresent()) {
            // Retrieve the existing FeeApproval object

            OtherRequirement existingOtherRequirement = OtherRequirementOptional.get();
            // Update existing object
            user.setId(existingOtherRequirement.getId());
            OtherRequirementRepository.save(user);
        }
        else {
            OtherRequirementRepository.save(user);
        }

        return   "redirect:/OtherRequirementlist";
    }
    @GetMapping("/Surveylist")
    public String Surveylist(HttpServletRequest request, Model model) {
        List<Tender> emp = userRepository.findAll() ;

        model.addAttribute("users", emp);
        return   "Surveylist";
    }


    @GetMapping("/surveyEntry/{id}")
    public String surveyEntry(@PathVariable("id") Long id,HttpServletRequest request, Model model) {


        // Find the Tender by its ID
        Optional<Tender> optionalTender = userRepository.findById(id);

        if (optionalTender.isPresent()) {
            Tender tender = optionalTender.get();
            model.addAttribute("tender", tender);

            // Find the FeeApproval by tender number
            Optional<Survey> Survey = SurveyRepository.findByTenderNumber(String.valueOf(tender.getId()));

            if (Survey.isPresent()) {
                model.addAttribute("Survey", Survey.get());

                return "surveyEnteryGetData";

            } else {
                model.addAttribute("error", "Fee approval not found for the tender number: " );
            }
        } else {
            // Handle the case where the Tender is not found
            model.addAttribute("error", "Tender not found");
        }
        return   "surveyEntryForm";
    }

    @GetMapping("/surveyApproval/{id}")
    public String surveyApproval(@PathVariable("id") Long id,HttpServletRequest request, Model model) {


        // Find the Tender by its ID
        Optional<Tender> optionalTender = userRepository.findById(id);

        if (optionalTender.isPresent()) {
            Tender tender = optionalTender.get();
            model.addAttribute("tender", tender);

            // Find the FeeApproval by tender number
            Optional<Survey> Survey = SurveyRepository.findByTenderNumber(String.valueOf(tender.getId()));

            if (Survey.isPresent()) {
                model.addAttribute("Survey", Survey.get());

                return "surveyEntryFormApproval";

            } else {
                model.addAttribute("error", "Fee approval not found for the tender number: " );
            }
        } else {
            // Handle the case where the Tender is not found
            model.addAttribute("error", "Tender not found");
        }
        return   "surveyEntryForm";
    }


    @PostMapping("/surveySave")
    public String surveySave(@Validated Survey user,HttpServletRequest request,BindingResult result, Model model) {
        Optional<Survey> Survey = SurveyRepository.findByTenderNumber(user.getTenderNumber());

        if (Survey.isPresent()) {
            // Retrieve the existing FeeApproval object

            Survey existingSurvey = Survey.get();
            // Update existing object
            user.setId(existingSurvey.getId());
            SurveyRepository.save(user);
        }
        else {
            SurveyRepository.save(user);
        }

        return   "redirect:/Surveylist";
    }
//    @GetMapping("/delete/{id}")PreBidSave
//    public String deleteUser(@PathVariable("id") long id, Model model) {
//        Maintenance user = userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
//        userRepository.delete(user);
//
//        return "redirect:/index";
//    }

}

//    @PostMapping("/MaintDelete/{id}")
//    public String updateUser(@PathVariable("id") long id, @Validated Maintenance user, BindingResult result, Model model) {
//        if (result.hasErrors()) {
//            user.setId(id);
//            return "TenderUpdate";
//        }
//
//        userRepository.delete(user);
//
//        return "redirect:/Maintlist";
//    }



