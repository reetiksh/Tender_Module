package com.nscs.SBMaster.services;

import com.nscs.SBMaster.model.ComponentMaster;
import com.nscs.SBMaster.repository.ComponentMasterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComponentMasterService {

    @Autowired
    private ComponentMasterRepository componentMasterRepository;

    public List<ComponentMaster> getAllComponents() {
        return componentMasterRepository.findAll();
    }


    public List<ComponentMaster> getComponentsByStep(String step) {
        return componentMasterRepository.findByStep(step);
    }

}
