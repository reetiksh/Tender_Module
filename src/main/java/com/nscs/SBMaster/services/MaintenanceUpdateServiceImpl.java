package com.nscs.SBMaster.services;

import com.nscs.SBMaster.model.Maintenance;
import com.nscs.SBMaster.repository.MaintenanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class MaintenanceUpdateServiceImpl extends MaintenanceUpdateService {

    private final MaintenanceRepository maintenanceRepository;

    @Autowired
    public MaintenanceUpdateServiceImpl(MaintenanceRepository maintenanceRepository) {
        this.maintenanceRepository = maintenanceRepository;
    }

    @Override
    public Maintenance updateStatusByTicketNo(String ticketNo, String newStatus) {
        Maintenance maintenance = maintenanceRepository.findByTicketNo(ticketNo);


        maintenance.setStatus(newStatus);
        return maintenanceRepository.save(maintenance);
    }
}
