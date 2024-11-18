package com.nscs.SBMaster.services;

import com.nscs.SBMaster.model.Costing;
import com.nscs.SBMaster.repository.CostingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CostingService {

    @Autowired
    private CostingRepository costingRepository;

    public Optional<Costing> findByTenderNumber(String tenderNumber) {
        return costingRepository.findByTenderNumber(tenderNumber);
    }

    public Costing save(Costing costing) {
        return costingRepository.save(costing);
    }
}
