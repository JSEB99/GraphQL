package com.uptc.frm.graphql.services;

import com.uptc.frm.graphql.jpa.models.Component;
import com.uptc.frm.graphql.jpa.models.ComponentDevice;
import com.uptc.frm.graphql.jpa.models.ElectronicDevice;
import com.uptc.frm.graphql.jpa.repository.ComponentDeviceRepository;
import com.uptc.frm.graphql.jpa.repository.ComponentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComponentDeviceService {

    @Autowired
    private ComponentDeviceRepository componentDeviceRepository;
    @Autowired
    private ComponentService componentService;
    @Autowired
    private ElectronicDeviceService electronicDeviceService;
    @Autowired
    private ComponentRepository componentRepository;

    public List<ComponentDevice> findAllComponentDevices() {
        return componentDeviceRepository.findAll();
    }

    public List<ComponentDevice> findComponentDeviceByComponentId(Integer componentId){
        return componentDeviceRepository.findByComponentId(componentId);
    }

    public List<ComponentDevice> findComponentDeviceByDeviceId(Integer deviceId){
        return componentDeviceRepository.findByDeviceId(deviceId);
    }

    public ComponentDevice findComponentDeviceByComponentDeviceId(Integer componentDeviceId){
        return componentDeviceRepository.findById(componentDeviceId).orElse(null);
    }

    public ComponentDevice createComponentDevice(ComponentDevice inputComponentDevice){
        Component component = componentService.findComponentById((int)inputComponentDevice.getComponentId());
        ElectronicDevice device = electronicDeviceService.findById((int) inputComponentDevice.getDeviceId());
        if(component != null){
            inputComponentDevice.setComponents(component);
        }else{
            return null;
        }
        if(device != null){
            inputComponentDevice.setElectronicDevice(device);
        }else{
            return null;
        }
        Long quantityTemp = inputComponentDevice.getQuantity();
        if(quantityTemp == null && device == null && component == null){
            return null;
        }else {
            return componentDeviceRepository.save(inputComponentDevice);
        }
    }

    public ComponentDevice updateComponentDevice(ComponentDevice inputComponentDevice){
        ComponentDevice componentDevice = findComponentDeviceByComponentDeviceId((int) inputComponentDevice.getComponentsDeviceId());
        Component component = componentService.findComponentById((int) inputComponentDevice.getComponentId());
        ElectronicDevice device = electronicDeviceService.findById((int) inputComponentDevice.getDeviceId());
        if(componentDevice != null){
            if(inputComponentDevice.getComponentId() != componentDevice.getComponentId() && component != null){
                componentDevice.setComponents(component);
            }
            if(inputComponentDevice.getDeviceId() != componentDevice.getDeviceId() && device != null){
                componentDevice.setElectronicDevice(device);
            }

            if(inputComponentDevice.getQuantity() != componentDevice.getQuantity()){
                componentDevice.setQuantity(inputComponentDevice.getQuantity());
            }
            return componentDeviceRepository.save(componentDevice);
        }
        return null;
    }

    public void deleteComponentDeviceByComponentDeviceId(Integer componentDeviceId){
        componentDeviceRepository.deleteById(componentDeviceId);
    }

}
