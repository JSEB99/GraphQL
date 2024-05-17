package com.uptc.frm.graphql.services;

import com.uptc.frm.graphql.jpa.models.ComponentDevice;
import com.uptc.frm.graphql.jpa.repository.ComponentDeviceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComponentDeviceService {

    @Autowired
    private ComponentDeviceRepository componentDeviceRepository;

    public List<ComponentDevice> findAllComponentDevices() {
        return componentDeviceRepository.findAll();
    }

    public List<ComponentDevice> findComponentDeviceByComponentId(Integer componentId){
        return componentDeviceRepository.findByComponentId(componentId);
    }

}
