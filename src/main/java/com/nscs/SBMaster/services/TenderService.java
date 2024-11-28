package com.nscs.SBMaster.services;


import com.nscs.SBMaster.model.Maintenance;
import com.nscs.SBMaster.model.Tender;
import com.nscs.SBMaster.repository.TenderRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TenderService {
    @Autowired
    private TenderRepository tenderRepository;

    public List<Tender> getAllTenders() {
        return tenderRepository.findAll();
    }


    public List<Map<String, Object>> searchSupplierDetails(String query,String query2) {
        List<Object[]> results = tenderRepository.findsupplierByQuery(query,query2);
        List<Map<String, Object>> caseDetailsList = new ArrayList<>();

        for (Object[] result : results) {
            Map<String, Object> caseDetailMap = new HashMap<>();
            caseDetailMap.put("supplier", result[0]);
            caseDetailMap.put("suplierId", result[1]);

            caseDetailsList.add(caseDetailMap);
        }

        return caseDetailsList;
    }

    public List<Map<String, Object>> searchuserDetails(String query) {
        List<Object[]> results = tenderRepository.findusrByQuery(query);
        List<Map<String, Object>> caseDetailsList = new ArrayList<>();

        for (Object[] result : results) {
            Map<String, Object> caseDetailMap = new HashMap<>();
            caseDetailMap.put("supplier", result[0]);
            caseDetailMap.put("suplierId", result[1]);

            caseDetailsList.add(caseDetailMap);
        }

        return caseDetailsList;
    }

    public Tender getTenderById(Long id) {
        return tenderRepository.findById(id).orElse(null);
    }

    public Tender saveTender(Tender tender) {
        return tenderRepository.save(tender);
    }

    public void deleteTender(Long id) {
        tenderRepository.deleteById(id);
    }

    public void updateItem(Long id, Tender updatedItem) {
        Tender tender = getTenderById(id);
        if (tender != null) {

            tender.setPublishDate(updatedItem.getPublishDate());
            tender.setDueDate(updatedItem.getDueDate());
            tender.setNameOfWork(updatedItem.getNameOfWork());
            tender.setEmd(updatedItem.getEmd());
            tender.setTenderFees(updatedItem.getTenderFees());
            tender.setModeOfPayment(updatedItem.getModeOfPayment());
            tender.setTenderValue(updatedItem.getTenderValue());
            tender.setMsePreference(updatedItem.getMsePreference());
            tender.setZone(updatedItem.getZone());
            tender.setDepartment(updatedItem.getDepartment());
            tender.setDivision(updatedItem.getDivision());
            tenderRepository.save(tender);
        }
    }

    public List<Map<String, Object>> searchAssupmstDetails(String query) {
        List<Object[]> results = tenderRepository.findassupmstByQuery(query);
        List<Map<String, Object>> caseDetailsList = new ArrayList<>();

        for (Object[] result : results) {
            Map<String, Object> caseDetailMap = new HashMap<>();
            caseDetailMap.put("supplier", result[0]);
            caseDetailMap.put("suplierId", result[1]);

            caseDetailsList.add(caseDetailMap);
        }

        return caseDetailsList;
    }

    public List<Map<String, Object>> searchAllZone(String query) {
        List<Object[]> results = tenderRepository.findzoneByQuery(query);
        List<Map<String, Object>> caseDetailsList = new ArrayList<>();

        for (Object[] result : results) {
            Map<String, Object> caseDetailMap = new HashMap<>();
            caseDetailMap.put("supplier", result[0]);
            caseDetailMap.put("suplierId", result[1]);

            caseDetailsList.add(caseDetailMap);
        }

        return caseDetailsList;
    }
    public List<Map<String, Object>> searchAllDepartment(String query) {
        List<Object[]> results = tenderRepository.findDepartmentByQuery(query);
        List<Map<String, Object>> caseDetailsList = new ArrayList<>();

        for (Object[] result : results) {
            Map<String, Object> caseDetailMap = new HashMap<>();
            caseDetailMap.put("supplier", result[0]);
            caseDetailMap.put("suplierId", result[1]);

            caseDetailsList.add(caseDetailMap);
        }

        return caseDetailsList;
    }
    public List<Map<String, Object>> searchAllstate(String query) {
        List<Object[]> results = tenderRepository.findstateByQuery(query);
        List<Map<String, Object>> caseDetailsList = new ArrayList<>();

        for (Object[] result : results) {
            Map<String, Object> caseDetailMap = new HashMap<>();
            caseDetailMap.put("supplier", result[0]);
            caseDetailMap.put("suplierId", result[1]);

            caseDetailsList.add(caseDetailMap);
        }

        return caseDetailsList;
    }


    public List<Map<String, Object>> searchAllSupplier(String query) {
        List<Object[]> results = tenderRepository.findAllsupplierByQuery(query);
        List<Map<String, Object>> caseDetailsList = new ArrayList<>();

        for (Object[] result : results) {
            Map<String, Object> caseDetailMap = new HashMap<>();
            caseDetailMap.put("supplier", result[0]);
            caseDetailMap.put("suplierId", result[1]);
            caseDetailMap.put("assupmstId", result[2]);
            caseDetailMap.put("assupmst", result[3]);
            caseDetailMap.put("Address", result[4]);
            caseDetailsList.add(caseDetailMap);
        }

        return caseDetailsList;
    }

    @Transactional
    public void approvetender(String id){
        tenderRepository.tenderApprove(id);
    }
    @Transactional
    public  void rejecttender(String id){
        tenderRepository.tenderNotApprove(id);
    }


    public List<Map<String, Object>> searchBranchData(String query) {
        List<Object[]> results = tenderRepository.findbranchByQuery(query);
        List<Map<String, Object>> caseDetailsList = new ArrayList<>();

        for (Object[] result : results) {
            Map<String, Object> caseDetailMap = new HashMap<>();
            caseDetailMap.put("supplier", result[0]);
            caseDetailMap.put("suplierId", result[1]);

            caseDetailsList.add(caseDetailMap);
        }

        return caseDetailsList;
    }
    public List<Map<String, Object>> searchDivisionData(String query) {
        List<Object[]> results = tenderRepository.finddivisionByQuery(query);
        List<Map<String, Object>> caseDetailsList = new ArrayList<>();

        for (Object[] result : results) {
            Map<String, Object> caseDetailMap = new HashMap<>();
            caseDetailMap.put("supplier", result[0]);
            caseDetailMap.put("suplierId", result[1]);

            caseDetailsList.add(caseDetailMap);
        }

        return caseDetailsList;
    }
    public List<Map<String, Object>> searchSectorData(String query) {
        List<Object[]> results = tenderRepository.findasectorByQuery(query);
        List<Map<String, Object>> caseDetailsList = new ArrayList<>();

        for (Object[] result : results) {
            Map<String, Object> caseDetailMap = new HashMap<>();
            caseDetailMap.put("supplier", result[0]);
            caseDetailMap.put("suplierId", result[1]);

            caseDetailsList.add(caseDetailMap);
        }

        return caseDetailsList;
    }

    public List<Map<String, Object>> searchNatureOfWork(String query) {
        List<Object[]> results = tenderRepository.findNatureOfWorkByQuery(query);
        List<Map<String, Object>> caseDetailsList = new ArrayList<>();

        for (Object[] result : results) {
            Map<String, Object> caseDetailMap = new HashMap<>();
            caseDetailMap.put("supplier", result[0]);
            caseDetailMap.put("suplierId", result[1]);

            caseDetailsList.add(caseDetailMap);
        }

        return caseDetailsList;
    }


    @Transactional
    public void updateStep(String id,String Step){
        tenderRepository.UpdateStep(id,Step);
    }
}
