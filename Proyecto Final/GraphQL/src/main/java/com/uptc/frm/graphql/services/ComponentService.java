package com.uptc.frm.graphql.services;

import com.uptc.frm.graphql.jpa.models.Component;
import com.uptc.frm.graphql.jpa.models.Manufacturer;
import com.uptc.frm.graphql.jpa.repository.ComponentDeviceRepository;
import com.uptc.frm.graphql.jpa.repository.ComponentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComponentService {

    @Autowired
    private ComponentRepository componentRepository;
    @Autowired
    @Lazy
    private ManufacturerService manufacturerService;
    @Autowired
    @Lazy
    private ComponentDeviceService componentDeviceService;
    @Autowired
    private ComponentDeviceRepository componentDeviceRepository;

    public List<Component> findAllComponents() {
        return componentRepository.findAll();
    }

    public Component findComponentById(Integer componentId) {
        return componentRepository.findById(componentId).orElse(null);
    }

    public List<Component> findComponentsByManufacturerId(Integer manufacturerId){
        return componentRepository.findComponentsByManufacturerId(manufacturerId);
    }

    public Component createComponent(Component inputComponent) {
        Manufacturer manufacturer = manufacturerService.findByManufacturerId((int) inputComponent.getManufacturerId());
        if (manufacturer != null){
            inputComponent.setManufacturers(manufacturer);
            return componentRepository.save(inputComponent);
        }
        if (manufacturer == null && inputComponent.getSpecs() == null){
            return null;
        }else {
            return componentRepository.save(inputComponent);
        }
    }

    public Component updateComponent(Component inputComponent) {
        Component component = findComponentById((int) inputComponent.getComponentId());
        Manufacturer manufacturer = manufacturerService.findByManufacturerId((int) inputComponent.getManufacturerId());
        if (component != null){
            if(inputComponent.getSpecs() != component.getSpecs() && inputComponent.getSpecs() != null){
                component.setSpecs(inputComponent.getSpecs());
            }
            if(inputComponent.getManufacturerId() != component.getManufacturerId() && manufacturer != null){
                component.setManufacturers(manufacturer);
            }
            return componentRepository.save(component);
        }
        return null;
    }

    public void deleteComponentById(Integer componentId) {
        Integer componentDeviceId = (int) componentDeviceRepository.findByComponentId(componentId).get(0).getComponentsDeviceId();
        componentDeviceRepository.deleteById(componentDeviceId);
        componentRepository.deleteById(componentId);
    }
}
