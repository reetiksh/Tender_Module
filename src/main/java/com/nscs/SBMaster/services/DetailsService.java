package com.nscs.SBMaster.services;

import com.nscs.SBMaster.model.Details;
import com.nscs.SBMaster.model.Maintenance;
import com.nscs.SBMaster.model.Yolo;
import com.nscs.SBMaster.repository.DetailsRepository;
import com.nscs.SBMaster.repository.YoloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DetailsService {

    @Autowired
    private DetailsRepository detailsRepository;

    @Autowired
    private YoloRepository yoloRepository;


    public Details findByTicketNo(String ticketNo) {
        return detailsRepository.findByTicketNo(ticketNo);
    }
    public Details getItemByTicket(String ticket) {
        return detailsRepository.findByTicketNo(ticket);
    }
    // Method to save Details entity
    public Details saveDetails(Details details) {
        return detailsRepository.save(details);
    }

    // Method to save Yolo entity
    public Yolo saveYolo(Yolo yolo) {
        return yoloRepository.save(yolo);
    }

    // Method to add a Yolo to Details entity
    public void addYoloToDetails(String ticketNo, Yolo yolo) {
        Details details = detailsRepository.findByTicketNo(ticketNo);
        if (details != null) {
            yolo.setDetails(details);
            details.getYoloList().add(yolo);
            detailsRepository.save(details);
        } else {
            throw new RuntimeException("Details with ticket_no " + ticketNo + " not found");
        }
    }




    public void updateItem(String ticketNo, Details updatedItem) {
//        Maintenance maintenance = getItemById(id);
        Details details = getItemByTicket(ticketNo);
        if (details != null) {

            details.setRemarks(details.getRemarks());

            detailsRepository.save(details);
        }
    }}
