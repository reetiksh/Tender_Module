package com.nscs.SBMaster.services;

import com.nscs.SBMaster.model.Details;
import com.nscs.SBMaster.model.Maintenance;
import com.nscs.SBMaster.repository.DetailsRepository;
import com.nscs.SBMaster.repository.MaintenanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MaintenanceService {

    @Autowired
    private DetailsRepository detailsRepository;
    @Autowired
    private MaintenanceRepository maintenanceRepository;
        public void deleteItem(Long id) {
            maintenanceRepository.deleteById(id);

    }

    public Maintenance findByTicketNo(String ticketNo) {
        return maintenanceRepository.findByTicketNo(ticketNo);
    }

    public Maintenance getItemById(Long id) {
        return maintenanceRepository.findById(id).orElse(null);
    }

    public void updateItem(Long id, Maintenance updatedItem) {
        Maintenance maintenance = getItemById(id);
        if (maintenance != null) {
//maintenance.setId(updatedItem.getId());
//            maintenance.setPublishDate(updatedItem.getPublishDate());
//            maintenance.setDueDate(updatedItem.getDueDate());
//            maintenance.setNameOfAsset(updatedItem.getNameOfAsset());

            // Set other fields as needed
            maintenanceRepository.save(maintenance);
        }
//
//        public void updateStatus(String ticketNo, Maintenance uItem) {
//            Maintenance maintenance = findByTicketNo(ticketNo);
//            if (maintenance != null) {
////maintenance.setId(updatedItem.getId());
////            maintenance.setPublishDate(updatedItem.getPublishDate());
////            maintenance.setDueDate(updatedItem.getDueDate());
////
////            maintenance.setTicketNo(updatedItem.getTicketNo());
//                maintenance.setStatus(uItem.getStatus());
//
//                // Set other fields as needed
//                maintenanceRepository.save(maintenance);
//            }








        // Logging to check saved details






    }

}
