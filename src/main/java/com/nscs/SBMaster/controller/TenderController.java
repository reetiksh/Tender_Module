package com.nscs.SBMaster.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Controller
@CrossOrigin(origins = "*")
public class TenderController {


    @Value("${jBoss.home.url}")
    private String cancelUrl;


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

    @Autowired
    private CommonParameterService commonParameterService;
    @Autowired
    private JwtUtil JwtUtil;





    @Autowired
    private BidEvaluationParticipantsDetailsRepository bidEvaluationParticipantsDetailsRepository;

    @Autowired
    private BidEvaluationRepository bidEvaluationRepository;

    @Autowired
    private BidEvaluationParticipantsDetailsService BidEvaluationParticipantsDetailsService;


    @Autowired
    private CostingRepository costingRepository;

    @Autowired
    private DepartmentResponseRepository departmentResponseRepository;

    @Autowired
    private EMDMonitoringRepository emdMonitoringRepository;

    @Autowired
    private FollowUpRemarkRepository followUpRemarkRepository;

    @Autowired
    private FollowUpRemarkService followUpRemarkService;


    @Autowired
    private FeeApprovalRepository feeApprovalRepository;

    @Autowired
    private FinalBidSubmitionRepository FinalBidSubmitionRepository;

    @Autowired
    private TenderPreparationRepository tenderPreparationRepository;

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
        model.addAttribute("cancelUrl", cancelUrl);
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
        try {

            // Fetch common parameters from the service
            commonParameter cpr = commonParameterService.fetchAndStoreCommonParameter();
            if (cpr != null) {
                // Add the fetched commonParameter to the model (if needed)
                model.addAttribute("commonParameter", cpr);
            } else {
                model.addAttribute("error", "Failed to fetch Common Parameter data.");
            }
        } catch (JsonProcessingException e) {
            model.addAttribute("error", "Error fetching Common Parameter data: " + e.getMessage());
        }

        // Hardcoded user ID (replace with actual logic as needed)
        Long userId = 12345L; // Replace 12345L with the actual user ID you want to hardcode
        model.addAttribute("userId", userId);

        model.addAttribute("cancelUrl", cancelUrl);


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
                            @RequestParam(value = "tenderDocument", required = false)  MultipartFile[] tenderDocument,
                            @RequestParam(value = "checkList", required = false)  MultipartFile[] checkList,
                            @RequestParam(value = "emdFormat", required = false)  MultipartFile[] emdFormat,
                            @RequestParam(value = "annexures", required = false)  MultipartFile[] annexures,
                            @RequestParam(value = "mseBenifit", required = false)List<String> mseBenifit)  throws IOException {

        try {
            // Fetch common parameters from the service
            commonParameter cpr = commonParameterService.fetchAndStoreCommonParameter();
            if (cpr != null) {
                // Add the fetched commonParameter to the model (if needed)
                model.addAttribute("commonParameter", cpr);
            } else {
                model.addAttribute("error", "Failed to fetch Common Parameter data.");
            }
        } catch (JsonProcessingException e) {
            model.addAttribute("error", "Error fetching Common Parameter data: " + e.getMessage());
        }
        Long userId = 12345L; // Replace 12345L with the actual user ID you want to hardcode
        model.addAttribute("userId", userId);
        model.addAttribute("cancelUrl", cancelUrl);

        model.addAttribute("user", user);
        if (result.hasErrors()) {
            return "tenderForm";
        }

        if(user.getId()==null){
            userRepository.save(user);
            tenderService.updateStep(String.valueOf(user.getId()),"Step1");
        }
        else{
            userRepository.save(user);
        }

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
                String filePath = caseDir + "/supportingDocs/" + file.getOriginalFilename();
                file.transferTo(new File(filePath));

            }
        }
        for (MultipartFile file : tenderDocument) {
            if (!file.isEmpty()) {
                // Save the file to the directory
                String filePath = caseDir + "/tenderDocument/" + file.getOriginalFilename();
                file.transferTo(new File(filePath));

            }
        }
        for (MultipartFile file : checkList) {
            if (!file.isEmpty()) {
                // Save the file to the directory
                String filePath = caseDir + "/checkList/" + file.getOriginalFilename();
                file.transferTo(new File(filePath));

            }
        }
        for (MultipartFile file : emdFormat) {
            if (!file.isEmpty()) {
                // Save the file to the directory
                String filePath = caseDir + "/emdFormat/" + file.getOriginalFilename();
                file.transferTo(new File(filePath));

            }
        }
        for (MultipartFile file : annexures) {
            if (!file.isEmpty()) {
                // Save the file to the directory
                String filePath = caseDir + "/annexures/" + file.getOriginalFilename();
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
    public String TenderEntryApproval(Tender user,Model model,@PathVariable("id") Long id,RedirectAttributes redirectAttributes) {

        if (!isStepAccessible(id, "Step2")) {
            redirectAttributes.addFlashAttribute("errorMessage", "Please complete Entry (Step 1) before accessing Approval (Step 2).");
            return "redirect:/TenderEntry";
        }
        try {
            // Fetch common parameters from the service
            commonParameter cpr = commonParameterService.fetchAndStoreCommonParameter();
            if (cpr != null) {
                // Add the fetched commonParameter to the model (if needed)
                model.addAttribute("commonParameter", cpr);
            } else {
                model.addAttribute("error", "Failed to fetch Common Parameter data.");
            }
        } catch (JsonProcessingException e) {
            model.addAttribute("error", "Error fetching Common Parameter data: " + e.getMessage());
        }

        Long userId = 12345L; // Replace 12345L with the actual user ID you want to hardcode
        model.addAttribute("userId", userId);
        model.addAttribute("cancelUrl", cancelUrl);

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


        Long userId = 12345L; // Replace 12345L with the actual user ID you want to hardcode
        model.addAttribute("userId", userId);

        // Find the Tender by its ID
        Optional<Tender> optionalTender = userRepository.findById(id);

        if (optionalTender.isPresent()) {
            Tender tender = optionalTender.get();


            Optional<Survey> surveyApproval = SurveyRepository.findByTenderNumber(String.valueOf(tender.getId()));

            model.addAttribute("tender", tender);
            if (surveyApproval.isPresent()) {
                Survey surveyApprovel = surveyApproval.get();
                String surveyApprove = surveyApprovel.getSurveyApprove();
                // Check the value of surveyApprove
                if ("1".equalsIgnoreCase(surveyApprove)) {
                    // Case when survey is approved
                    // Proceed with the next steps or logic as needed
                } else if ("2".equalsIgnoreCase(surveyApprove)) {
                    // Case when survey is rejected
                }
            }
            else{
                model.addAttribute("stepError", "Complete Step 7(Survey Approval) first");
            }

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

        Long userId = 12345L; // Replace 12345L with the actual user ID you want to hardcode
        model.addAttribute("userId", userId);

        Optional<FeeApproval> feeApprovalOptional = FeeApprovalRepository.findByTenderNumber(user.getTenderNumber());

        if (feeApprovalOptional.isPresent()) {
            // Retrieve the existing FeeApproval object

            FeeApproval existingFeeApproval = feeApprovalOptional.get();
            // Update existing object
            existingFeeApproval.updateFrom(user);
            FeeApprovalRepository.save(existingFeeApproval);
            tenderService.updateStep(String.valueOf(existingFeeApproval.getId()),"Step8");
        }
        else {
            FeeApprovalRepository.save(user);
            tenderService.updateStep(String.valueOf(user.getId()),"Step8");

        }

        return   "redirect:/FeeApprovallist";
    }

    @GetMapping("/FeeApprovallist")
    public String FeeApprovallist(HttpServletRequest request, Model model) {
        List<Tender> emp = userRepository.findAll() ;

        model.addAttribute("users", emp);
        model.addAttribute("cancelUrl", cancelUrl);
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

        try {
            // Fetch common parameters from the service
            commonParameter cpr = commonParameterService.fetchAndStoreCommonParameter();
            if (cpr != null) {
                // Add the fetched commonParameter to the model (if needed)
                model.addAttribute("commonParameter", cpr);
            } else {
                model.addAttribute("error", "Failed to fetch Common Parameter data.");
            }
        } catch (JsonProcessingException e) {
            model.addAttribute("error", "Error fetching Common Parameter data: " + e.getMessage());
        }
        Long userId = 12345L; // Replace 12345L with the actual user ID you want to hardcode
        model.addAttribute("userId", userId);
        model.addAttribute("cancelUrl", cancelUrl);
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

        try {
            // Fetch common parameters from the service
            commonParameter cpr = commonParameterService.fetchAndStoreCommonParameter();
            if (cpr != null) {
                // Add the fetched commonParameter to the model (if needed)
                model.addAttribute("commonParameter", cpr);
            } else {
                model.addAttribute("error", "Failed to fetch Common Parameter data.");
            }
        } catch (JsonProcessingException e) {
            model.addAttribute("error", "Error fetching Common Parameter data: " + e.getMessage());
        }
        Long userId = 12345L; // Replace 12345L with the actual user ID you want to hardcode
        model.addAttribute("userId", userId);
        model.addAttribute("cancelUrl", cancelUrl);

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
        tenderService.updateStep(String.valueOf(user.getId()),"Step2");
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

    @GetMapping("/rejectTender/{id}")
    public String rejectTender(@PathVariable("id") Long id, HttpServletRequest request, Model model){
        tenderService.rejecttender(String.valueOf(id));
        tenderService.updateStep(String.valueOf(id),"Step2");
        return "redirect:/Tenderlist";
    }


    @GetMapping("/PreBidEntry/{id}")
    public String PreBidEntry(@PathVariable("id") Long id,HttpServletRequest request, Model model) {

        Long userId = 12345L; // Replace 12345L with the actual user ID you want to hardcode
        model.addAttribute("userId", userId);
        model.addAttribute("cancelUrl", cancelUrl);

        // Find the Tender by its ID
        Optional<Tender> optionalTender = userRepository.findById(id);


            if (optionalTender.isPresent()) {
            Tender tender = optionalTender.get();
                Optional<TenderPreparation> tenderpreapare = tenderPreparationRepository.findByTenderNumber(String.valueOf(tender.getId()));

                model.addAttribute("tender", tender);

                if (tenderpreapare.isPresent()) {
                }
                else{

                        model.addAttribute("stepError", "Complete Step 3(Tender Prepration) first");

                }
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

        Long userId = 12345L; // Replace 12345L with the actual user ID you want to hardcode
        model.addAttribute("userId", userId);
        model.addAttribute("cancelUrl", cancelUrl);

        Optional<PreBidMeet> PreBidMeetOptional = PreBidMeetRepository.findByTenderNumber(user.getTenderNumber());

        if (PreBidMeetOptional.isPresent()) {
            // Retrieve the existing FeeApproval object

            PreBidMeet existingPreBidMeet = PreBidMeetOptional.get();
            // Update existing object
            user.setId(existingPreBidMeet.getId());
            PreBidMeetRepository.save(user);
            tenderService.updateStep(String.valueOf(user.getId()),"Step4");
        }
        else {
            PreBidMeetRepository.save(user);
            tenderService.updateStep(String.valueOf(user.getId()),"Step4");
        }

        return   "redirect:/PreBidMeetList";
    }
    @GetMapping("/PreBidMeetlist")
    public String PreBidMeetlist(HttpServletRequest request, Model model) {
        List<Tender> emp = userRepository.findAll() ;

        model.addAttribute("users", emp);
        model.addAttribute("cancelUrl", cancelUrl);
        return   "PreBidMeetlist";
    }

    @GetMapping("/OtherRequirementlist")
    public String OtherRequirementlist(HttpServletRequest request, Model model) {
        List<Tender> emp = userRepository.findAll() ;

        model.addAttribute("users", emp);
        model.addAttribute("cancelUrl", cancelUrl);
        return   "OtherRequirementlist";
    }

    @GetMapping("/OtherRequirementEntry/{id}")
    public String OtherRequirementEntry(@PathVariable("id") Long id,HttpServletRequest request, Model model) {

        Long userId = 12345L; // Replace 12345L with the actual user ID you want to hardcode
        model.addAttribute("userId", userId);

        model.addAttribute("cancelUrl", cancelUrl);

        // Find the Tender by its ID
        Optional<Tender> optionalTender = userRepository.findById(id);

        if (optionalTender.isPresent()) {
            Tender tender = optionalTender.get();
            Optional<Survey> survey = SurveyRepository.findByTenderNumber(String.valueOf(tender.getId()));
            model.addAttribute("tender", tender);

            if (survey.isPresent()) {
            }
            else{

                model.addAttribute("stepError", "Complete Step 5(Survey) first");

            }

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

        Long userId = 12345L; // Replace 12345L with the actual user ID you want to hardcode
        model.addAttribute("userId", userId);
        model.addAttribute("cancelUrl", cancelUrl);

        Optional<OtherRequirement> OtherRequirementOptional = OtherRequirementRepository.findByTenderNumber(user.getTenderNumber());

        if (OtherRequirementOptional.isPresent()) {
            // Retrieve the existing FeeApproval object

            OtherRequirement existingOtherRequirement = OtherRequirementOptional.get();
            // Update existing object
            user.setId(existingOtherRequirement.getId());
            OtherRequirementRepository.save(user);
            tenderService.updateStep(String.valueOf(user.getId()),"Step6");
        }
        else {
            OtherRequirementRepository.save(user);
            tenderService.updateStep(String.valueOf(user.getId()),"Step6");
        }

        return   "redirect:/OtherRequirementlist";
    }
    @GetMapping("/Surveylist")
    public String Surveylist(HttpServletRequest request, Model model) {
        List<Tender> emp = userRepository.findAll() ;

        model.addAttribute("users", emp);
        model.addAttribute("cancelUrl", cancelUrl);
        return   "Surveylist";
    }

    @GetMapping("/SurveyApprovallist")
    public String SurveyApprovallist(HttpServletRequest request, Model model) {
        List<Tender> emp = userRepository.findAll() ;

        model.addAttribute("users", emp);
        model.addAttribute("cancelUrl", cancelUrl);
        return   "SurveyApprovallist";
    }


    @GetMapping("/surveyEntry/{id}")
    public String surveyEntry(@PathVariable("id") Long id,HttpServletRequest request, Model model) {


        Long userId = 12345L; // Replace 12345L with the actual user ID you want to hardcode
        model.addAttribute("userId", userId);
        model.addAttribute("cancelUrl", cancelUrl);

        // Find the Tender by its ID
        Optional<Tender> optionalTender = userRepository.findById(id);



        if (optionalTender.isPresent()) {
            Tender tender = optionalTender.get();

            Optional<PreBidMeet> preBidMeet = PreBidMeetRepository.findByTenderNumber(String.valueOf(tender.getId()));
            model.addAttribute("tender", tender);
            if (preBidMeet.isPresent()) {
            }
            else{

                model.addAttribute("stepError", "Complete Step 4(PreBidMeet) first");

            }



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


        Long userId = 12345L; // Replace 12345L with the actual user ID you want to hardcode
        model.addAttribute("userId", userId);
        model.addAttribute("cancelUrl", cancelUrl);

        // Find the Tender by its ID
        Optional<Tender> optionalTender = userRepository.findById(id);

        if (optionalTender.isPresent()) {
            Tender tender = optionalTender.get();
            Optional<OtherRequirement> otherRequirement = OtherRequirementRepository.findByTenderNumber(String.valueOf(tender.getId()));

            model.addAttribute("tender", tender);

            if (otherRequirement.isPresent()) {
            }
            else{

                model.addAttribute("stepError", "Complete Step 6(OtherRequirement) first");

            }
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

        String actionType = request.getParameter("actionType"); // Get the action type from the request


        Long userId = 12345L; // Replace 12345L with the actual user ID you want to hardcode
        model.addAttribute("userId", userId);

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
        // Update step based on actionType
        if ("entry".equals(actionType)) {
            tenderService.updateStep(String.valueOf(user.getId()), "Step5");
        } else if ("approval".equals(actionType)) {
            tenderService.updateStep(String.valueOf(user.getId()), "Step7");
        }

        return   "redirect:/Surveylist";
    }

    @GetMapping("/getCprData")
    public String getCprData( Model model) {
        try {
            // Fetch common parameters from the service
            commonParameter cpr = commonParameterService.fetchAndStoreCommonParameter();

        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        return "redirect:/Surveylist";
    }

    @GetMapping("/Dashbord")
    public String showDashbord(HttpServletRequest request, Model model) {
        List<Tender> emp = userRepository.findAll() ;

        model.addAttribute("users", emp);
        return   "Dashbord";
    }


    @GetMapping("/bid-evaluation/{id}")
    public String showBidEvaluationForm(Model model,@PathVariable("id") Long Tenderid ) {
        Optional<Tender> optionalTender = userRepository.findById(Tenderid);


        try {
            // Fetch common parameters from the service
            commonParameter cpr = commonParameterService.fetchAndStoreCommonParameter();
            if (cpr != null) {
                // Add the fetched commonParameter to the model (if needed)
                model.addAttribute("commonParameter", cpr);
            } else {
                model.addAttribute("error", "Failed to fetch Common Parameter data.");
            }
        } catch (JsonProcessingException e) {
            model.addAttribute("error", "Error fetching Common Parameter data: " + e.getMessage());
        }
        Long userId = 12345L; // Replace 12345L with the actual user ID you want to hardcode
        model.addAttribute("userId", userId);

        model.addAttribute("cancelUrl", cancelUrl);

        if (optionalTender.isPresent() ) {
            Tender tender = optionalTender.get();

            Optional<FinalBidSubmittion> finalBidSubmittion = FinalBidSubmitionRepository.findByTenderNumber(String.valueOf(tender.getId()));

            model.addAttribute("tender", tender);

            if (finalBidSubmittion.isPresent()) {
            }
            else{

                model.addAttribute("stepError", "Complete Step 11(final Bid Submission) first");

            }
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
                                          @RequestParam List<String> participantName,@RequestParam List<String> quotedRates,@RequestParam List<String> quotedRateType,Model model) {

        try {
            // Fetch common parameters from the service
            commonParameter cpr = commonParameterService.fetchAndStoreCommonParameter();
            if (cpr != null) {
                // Add the fetched commonParameter to the model (if needed)
                model.addAttribute("commonParameter", cpr);
            } else {
                model.addAttribute("error", "Failed to fetch Common Parameter data.");
            }
        } catch (JsonProcessingException e) {
            model.addAttribute("error", "Error fetching Common Parameter data: " + e.getMessage());
        }

        Long userId = 12345L; // Replace 12345L with the actual user ID you want to hardcode
        model.addAttribute("userId", userId);

        model.addAttribute("cancelUrl", cancelUrl);

        Optional<BidEvaluation> bidEvaluationOptional = bidEvaluationRepository.findByTenderNumber(bidEvaluation.getTenderNumber());
        BidEvaluation savedBidEvaluation;
        if (bidEvaluationOptional.isPresent()) {
            // Retrieve the existing BidEvaluation object

            BidEvaluation existingBidEvaluation = bidEvaluationOptional.get();
            // Update existing object
            existingBidEvaluation.updateFrom(bidEvaluation);
            savedBidEvaluation =  bidEvaluationRepository.save(existingBidEvaluation);
            tenderService.updateStep(String.valueOf(existingBidEvaluation.getId()),"Step12");
        }
        else {
            savedBidEvaluation = bidEvaluationRepository.save(bidEvaluation);
            tenderService.updateStep(String.valueOf(bidEvaluation.getId()),"Step12");
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
        List<Tender> emp = userRepository.findAll() ;

        model.addAttribute("users", emp);

        model.addAttribute("cancelUrl", cancelUrl);
        return   "BidEvaluationList";
    }


    @GetMapping("/costing/{id}")
    public String showCostingForm(Model model, @PathVariable("id") Long Tenderid ) {
        Optional<Tender> optionalTender = userRepository.findById(Tenderid);

        try {
            // Fetch common parameters from the service
            commonParameter cpr = commonParameterService.fetchAndStoreCommonParameter();
            if (cpr != null) {
                // Add the fetched commonParameter to the model (if needed)
                model.addAttribute("commonParameter", cpr);
            } else {
                model.addAttribute("error", "Failed to fetch Common Parameter data.");
            }
        } catch (JsonProcessingException e) {
            model.addAttribute("error", "Error fetching Common Parameter data: " + e.getMessage());
        }
        Long userId = 12345L; // Replace 12345L with the actual user ID you want to hardcode
        model.addAttribute("userId", userId);

        model.addAttribute("cancelUrl", cancelUrl);

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
    public String submitCostingForm(@Validated Costing costing,Model model) {

        Optional<Costing> costingOptional = costingRepository.findByTenderNumber(costing.getTenderNumber());
        Costing savedCosting;
        try {
            // Fetch common parameters from the service
            commonParameter cpr = commonParameterService.fetchAndStoreCommonParameter();
            if (cpr != null) {
                // Add the fetched commonParameter to the model (if needed)
                model.addAttribute("commonParameter", cpr);
            } else {
                model.addAttribute("error", "Failed to fetch Common Parameter data.");
            }
        } catch (JsonProcessingException e) {
            model.addAttribute("error", "Error fetching Common Parameter data: " + e.getMessage());
        }

        model.addAttribute("cancelUrl", cancelUrl);

        if (costingOptional.isPresent()) {
            // Retrieve the existing costing object

            Costing existingCosting = costingOptional.get();
            // Update existing object
            existingCosting.updateFrom(costing);
            savedCosting =  costingRepository.save(existingCosting);
            tenderService.updateStep(String.valueOf(existingCosting.getId()),"Step10");
        }
        else {
            savedCosting = costingRepository.save(costing);
            tenderService.updateStep(String.valueOf(costing.getId()),"Step10");

        }

        Long costingId=savedCosting.getId();


        return"redirect:/costinglist";
    }


    @GetMapping("/costinglist")
    public String costinglist(HttpServletRequest request, Model model) {
        List<Tender> emp = userRepository.findAll() ;

        model.addAttribute("users", emp);
        model.addAttribute("cancelUrl", cancelUrl);
        return   "CostingList";
    }


    @GetMapping("/Departmentlist/{departmentName}")
    public String Departmentlist(@PathVariable String departmentName,HttpServletRequest request, Model model) {
        List<Tender> emp = userRepository.findAll() ;

        model.addAttribute("users", emp);
        model.addAttribute("departmentName", departmentName);
        model.addAttribute("cancelUrl", cancelUrl);
        return   "Departmentlist";
    }



    // Display the form
    @GetMapping("/{departmentName}/tender/{tenderId}")
    public String showDepartmentResponseForm(@PathVariable String departmentName,
                                             @PathVariable Long tenderId,
                                             Model model) {

        Optional<Tender> optionalTender = userRepository.findById(tenderId);


        try {
            // Fetch common parameters from the service
            commonParameter cpr = commonParameterService.fetchAndStoreCommonParameter();
            if (cpr != null) {
                // Add the fetched commonParameter to the model (if needed)
                model.addAttribute("commonParameter", cpr);
            } else {
                model.addAttribute("error", "Failed to fetch Common Parameter data.");
            }
        } catch (JsonProcessingException e) {
            model.addAttribute("error", "Error fetching Common Parameter data: " + e.getMessage());
        }

        Long userId = 12345L; // Replace 12345L with the actual user ID you want to hardcode
        model.addAttribute("userId", userId);

        model.addAttribute("cancelUrl", cancelUrl);

        Department department = departmentRepository.findByName(departmentName)
                .orElseThrow(() -> new IllegalArgumentException("Invalid department name: " + departmentName));

        Tender tender = userRepository.findById(tenderId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid tender ID: " + tenderId));

        // Check for Final Bid Submission
        Optional<FeeApproval> feeApproval = feeApprovalRepository.findByTenderNumber(String.valueOf(tender.getId()));

        if (!feeApproval.isPresent()) {
            model.addAttribute("stepError", "Complete Step 9 (feeApproval) first.");
        }


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
                                         RedirectAttributes redirectAttributes, Model model) {

        try {
            // Fetch common parameters from the service
            commonParameter cpr = commonParameterService.fetchAndStoreCommonParameter();
            if (cpr != null) {
                // Add the fetched commonParameter to the model (if needed)
                model.addAttribute("commonParameter", cpr);
            } else {
                model.addAttribute("error", "Failed to fetch Common Parameter data.");
            }
        } catch (JsonProcessingException e) {
            model.addAttribute("error", "Error fetching Common Parameter data: " + e.getMessage());
        }


        Long userId = 12345L; // Replace 12345L with the actual user ID you want to hardcode
        model.addAttribute("userId", userId);

        model.addAttribute("cancelUrl", cancelUrl);

        Department department = departmentRepository.findByName(departmentName)
                .orElseThrow(() -> new IllegalArgumentException("Invalid department name: " + departmentName));

        Tender tender = userRepository.findById(tenderId)
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
        tenderService.updateStep(String.valueOf(departmentResponse.getId()),"Step9");

        redirectAttributes.addFlashAttribute("message", "Response saved successfully.");

        return "redirect:/department/" + departmentName + "/tender/" + tenderId;
    }


    @GetMapping("/emd-monitoring/{id}")
    public String showEMDMonitoringForm(Model model, @PathVariable("id") Long tenderId) {

        try {
            // Fetch common parameters from the service
            commonParameter cpr = commonParameterService.fetchAndStoreCommonParameter();
            if (cpr != null) {
                // Add the fetched commonParameter to the model (if needed)
                model.addAttribute("commonParameter", cpr);
            } else {
                model.addAttribute("error", "Failed to fetch Common Parameter data.");
            }
        } catch (JsonProcessingException e) {
            model.addAttribute("error", "Error fetching Common Parameter data: " + e.getMessage());
        }
        Long userId = 12345L; // Replace 12345L with the actual user ID you want to hardcode
        model.addAttribute("userId", userId);

        model.addAttribute("cancelUrl", cancelUrl);

        Optional<Tender> optionalTender = userRepository.findById(tenderId);

        if (optionalTender.isPresent()) {
            Tender tender = optionalTender.get();


            Optional<BidEvaluation> bidEvaluation = bidEvaluationRepository.findByTenderNumber(String.valueOf(tender.getId()));

            model.addAttribute("tender", tender);

            if (bidEvaluation.isPresent()) {
            }
            else{

                model.addAttribute("stepError", "Complete Step 12(Bid Evaluation) first");

            }

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
    public String submitEMDMonitoringForm(@ModelAttribute EMDMonitoring emdMonitoring,
                                          @RequestParam List<String> remark, Model model) {

        try {
            // Fetch common parameters from the service
            commonParameter cpr = commonParameterService.fetchAndStoreCommonParameter();
            if (cpr != null) {
                // Add the fetched commonParameter to the model (if needed)
                model.addAttribute("commonParameter", cpr);
            } else {
                model.addAttribute("error", "Failed to fetch Common Parameter data.");
            }
        } catch (JsonProcessingException e) {
            model.addAttribute("error", "Error fetching Common Parameter data: " + e.getMessage());
        }

        Long userId = 12345L; // Replace 12345L with the actual user ID you want to hardcode
        model.addAttribute("userId", userId);
        model.addAttribute("cancelUrl", cancelUrl);

        Optional<EMDMonitoring> emdMonitoringOptional = emdMonitoringRepository.findByTenderNumber(emdMonitoring.getTenderNumber());
        EMDMonitoring savedEMDMonitoring;
        if (emdMonitoringOptional.isPresent()) {
            // Retrieve the existing EMDMonitoring object

            EMDMonitoring existingEMDMonitoring = emdMonitoringOptional.get();
            // Update existing object
            existingEMDMonitoring.updateFrom(emdMonitoring);
            savedEMDMonitoring  =  emdMonitoringRepository.save(existingEMDMonitoring);
            tenderService.updateStep(String.valueOf(existingEMDMonitoring.getId()),"Step13");
        }
        else {
            savedEMDMonitoring = emdMonitoringRepository.save(emdMonitoring);
            tenderService.updateStep(String.valueOf(emdMonitoring.getId()),"Step13");
        }

        Long emdMonitoringId=emdMonitoring.getId();
        List<FollowUpRemark> existingEmdRemarks = followUpRemarkRepository.findByEmdMonitoringId(emdMonitoringId);

        followUpRemarkService.saveData(emdMonitoringId,remark);
        return "redirect:/emd-monitoringlist";
    }


    @GetMapping("/emd-monitoringlist")
    public String emdevaluationlist(HttpServletRequest request, Model model) {
        List<Tender> emp = userRepository.findAll() ;

        model.addAttribute("users", emp);
        model.addAttribute("cancelUrl", cancelUrl);
        return   "EMDMonitoringList";
    }



    @GetMapping("/finalBidSubmitionList")
    public String finalBidSubmitionList(HttpServletRequest request, Model model) {
        List<Tender> emp = userRepository.findAll() ;

        model.addAttribute("users", emp);
        model.addAttribute("cancelUrl", cancelUrl);
        return   "finalBidSubmitionList";
    }


    @GetMapping("/finalBidSubmition/{id}")
    public String finalBidSubmition(Model model, @PathVariable("id") Long Tenderid ) {

        try {
            // Fetch common parameters from the service
            commonParameter cpr = commonParameterService.fetchAndStoreCommonParameter();
            if (cpr != null) {
                // Add the fetched commonParameter to the model (if needed)
                model.addAttribute("commonParameter", cpr);
            } else {
                model.addAttribute("error", "Failed to fetch Common Parameter data.");
            }
        } catch (JsonProcessingException e) {
            model.addAttribute("error", "Error fetching Common Parameter data: " + e.getMessage());
        }
        Long userId = 12345L; // Replace 12345L with the actual user ID you want to hardcode
        model.addAttribute("userId", userId);
        model.addAttribute("cancelUrl", cancelUrl);

        Optional<Tender> optionalTender = userRepository.findById(Tenderid);

        if (optionalTender.isPresent() ) {
            Tender tender = optionalTender.get();

            Optional<FinalBidSubmittion> finalBidSubmittion = FinalBidSubmitionRepository.findByTenderNumber(String.valueOf(tender.getId()));

            model.addAttribute("tender", tender);

            if (finalBidSubmittion.isPresent()) {
            }
            else{

                model.addAttribute("stepError", "Complete Step 10(Costing) first");

            }


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
    public String finalBidSubmitionSave(@Validated FinalBidSubmittion FinalBidSubmittion,Model model) {

        try {
            // Fetch common parameters from the service
            commonParameter cpr = commonParameterService.fetchAndStoreCommonParameter();
            if (cpr != null) {
                // Add the fetched commonParameter to the model (if needed)
                model.addAttribute("commonParameter", cpr);
            } else {
                model.addAttribute("error", "Failed to fetch Common Parameter data.");
            }
        } catch (JsonProcessingException e) {
            model.addAttribute("error", "Error fetching Common Parameter data: " + e.getMessage());
        }

        Long userId = 12345L; // Replace 12345L with the actual user ID you want to hardcode
        model.addAttribute("userId", userId);
        model.addAttribute("cancelUrl", cancelUrl);


        Optional<FinalBidSubmittion> FinalBidSubmittionExisting = FinalBidSubmitionRepository.findByTenderNumber(FinalBidSubmittion.getTenderNumber());

        if (FinalBidSubmittionExisting.isPresent()) {
            // Retrieve the existing costing object

            FinalBidSubmittion FinalBidSubmittionExisting1 = FinalBidSubmittionExisting.get();
            FinalBidSubmittion.setId(FinalBidSubmittionExisting1.getId());
            FinalBidSubmitionRepository.save(FinalBidSubmittion);
            tenderService.updateStep(String.valueOf(FinalBidSubmittion.getId()),"Step11");
        }
        else {
            FinalBidSubmitionRepository.save(FinalBidSubmittion);
            tenderService.updateStep(String.valueOf(FinalBidSubmittion.getId()),"Step11");
        }

        return"redirect:/finalBidSubmitionList";
    }


    @GetMapping("/tenderPreparelist")
    public String TenderPreparelist(HttpServletRequest request, Model model) {
        List<Tender> emp = userRepository.findAll() ;

        model.addAttribute("users", emp);
        model.addAttribute("cancelUrl", cancelUrl);
        return   "TenderPreparelist";
    }


    @GetMapping("/tender/prepare/{id}")
    public String showTenderPreparationForm(@PathVariable("id") Long id,HttpServletRequest request, Model model) {


        try {
            // Fetch common parameters from the service
            commonParameter cpr = commonParameterService.fetchAndStoreCommonParameter();
            if (cpr != null) {
                // Add the fetched commonParameter to the model (if needed)
                model.addAttribute("commonParameter", cpr);
            } else {
                model.addAttribute("error", "Failed to fetch Common Parameter data.");
            }
        } catch (JsonProcessingException e) {
            model.addAttribute("error", "Error fetching Common Parameter data: " + e.getMessage());
        }

        Long userId = 12345L; // Replace 12345L with the actual user ID you want to hardcode
        model.addAttribute("userId", userId);

        model.addAttribute("cancelUrl", cancelUrl);

        // Find the Tender by its ID
        Optional<Tender> optionalTender = userRepository.findById(id);

        if (optionalTender.isPresent()) {
            Tender tender = optionalTender.get();
            model.addAttribute("tender", tender);
            if(tender.getProceed()!=null) {
                if (tender.getProceed().equals("Y")) {

                } else {
                    if (tender.getProceed().equals("N")) {
                        model.addAttribute("stepError", "Tender not Autherized");
                    }


                }
            }
            else{
                model.addAttribute("stepError", "Complete Step 2 first");
            }



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


        try {
            // Fetch common parameters from the service
            commonParameter cpr = commonParameterService.fetchAndStoreCommonParameter();
            if (cpr != null) {
                // Add the fetched commonParameter to the model (if needed)
                model.addAttribute("commonParameter", cpr);
            } else {
                model.addAttribute("error", "Failed to fetch Common Parameter data.");
            }
        } catch (JsonProcessingException e) {
            model.addAttribute("error", "Error fetching Common Parameter data: " + e.getMessage());
        }

        Long userId = 12345L; // Replace 12345L with the actual user ID you want to hardcode
        model.addAttribute("userId", userId);

        model.addAttribute("cancelUrl", cancelUrl);


        Optional<TenderPreparation> tenderPreparation = tenderPreparationRepository.findByTenderNumber(user.getTenderNumber());

        if (tenderPreparation.isPresent()) {
            // Retrieve the existing FeeApproval object

            TenderPreparation existingTenderPreparation = tenderPreparation.get();
            // Update existing object
            user.setId(existingTenderPreparation.getId());
            tenderPreparationRepository.save(user);
            tenderService.updateStep(String.valueOf(user.getId()),"Step3");
        }
        else {
            tenderPreparationRepository.save(user);
            tenderService.updateStep(String.valueOf(user.getId()),"Step3");
        }

        return   "redirect:/tenderPreparelist";
    }


    private boolean isStepAccessible(Long tenderId, String requiredStep) {
        Optional<Tender> tenderOpt = userRepository.findById(tenderId);
        if (tenderOpt.isPresent()) {
            Tender tender = tenderOpt.get();
            String currentStep = tender.getCurrentStep();
            List<String> steps = List.of("Step1", "Step2", "Step3", "Step4", "Step5", "Step6", "Step7", "Step8", "Step9", "Step10", "Step11", "Step12", "Step13");
            int currentIndex = steps.indexOf(currentStep);
            int requiredIndex = steps.indexOf(requiredStep);

            // Allow access if current step is equal to or ahead of the required step
            return currentIndex >= requiredIndex - 1;
        }
        return false;
    }


//    @GetMapping("/delete/{id}")PreBidSave
//    public String deleteUser(@PathVariable("id") long id, Model model) {
//        Maintenance user = userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
//        userRepository.delete(user);
//
//        return "redirect:/index";
//    }


    @GetMapping("/openScreen/{screen}")
    public String openScreen(@PathVariable("screen") String screen, @RequestParam String userid,
                             @RequestParam String token,Model model) {
       boolean tokenchk= JwtUtil.validateToken(token,userid);

       String redirect="redirect:"+cancelUrl;
        if(tokenchk){
            redirect="redirect:/"+screen;
        }

        return redirect;
    }

    @GetMapping("/get-token")
    @ResponseBody // Indicates the response should be returned as raw content
    public String getMessage(@RequestParam(value = "userId") String userId) {
        return JwtUtil.generateToken(userId);

    }



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



