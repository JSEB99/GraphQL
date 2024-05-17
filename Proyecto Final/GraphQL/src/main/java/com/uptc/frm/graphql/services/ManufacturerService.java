package com.uptc.frm.graphql.services;

import com.uptc.frm.graphql.jpa.models.Manufacturer;
import com.uptc.frm.graphql.jpa.repository.ComponentRepository;
import com.uptc.frm.graphql.jpa.repository.ManufacturerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManufacturerService {

    @Autowired
    private ManufacturerRepository manufacturerRepository;
    @Autowired
    @Lazy
    private ComponentService componentService;
    @Autowired
    private ComponentRepository componentRepository;

    public List<Manufacturer> findAllManufacturers() {
        return manufacturerRepository.findAll();
    }

    public Manufacturer findByManufacturerId(Integer manufacturerId){
        return manufacturerRepository.findById(manufacturerId).orElse(null);
    }

    public Manufacturer createManufacturer(Manufacturer inputManufacturer){
        return manufacturerRepository.save(inputManufacturer);
    }

    public Manufacturer updateManufacturer(Manufacturer inputManufacturer){
        Manufacturer manufacturer = findByManufacturerId((int) inputManufacturer.getManufacturerId());
        if (manufacturer != null){
            if (manufacturer.getFiscalDomain() != inputManufacturer.getFiscalDomain() && inputManufacturer.getFiscalDomain() != null){
                manufacturer.setManufacturerId(inputManufacturer.getManufacturerId());
            }
            if (manufacturer.getRif() != inputManufacturer.getRif() && inputManufacturer.getRif() != null){
                manufacturer.setRif(inputManufacturer.getRif());
            }
            return manufacturerRepository.save(manufacturer);
        }
        return inputManufacturer;
    }

    public void deleteManufacturer(Integer manufacturerId){
        Integer componentId = (int) componentRepository.findComponentsByManufacturerId(manufacturerId).get(0).getComponentId();
        componentRepository.deleteById(componentId);
        manufacturerRepository.deleteById(manufacturerId);
    }


}
