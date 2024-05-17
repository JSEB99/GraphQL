package com.uptc.frm.graphql.controller;

import com.uptc.frm.graphql.jpa.models.Manufacturer;
import com.uptc.frm.graphql.services.ManufacturerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class ManufacturerController {

    @Autowired
    private ManufacturerService manufacturerService;

    @QueryMapping(name = "findAllManufacturers")
    public List<Manufacturer> getAllManufacturers() {
        return manufacturerService.findAllManufacturers();
    }

    @QueryMapping(name = "findManufacturerById")
    public Manufacturer findManufacturerById(@Argument Integer manufacturerId){
        return manufacturerService.findByManufacturerId(manufacturerId);
    }

    @MutationMapping
    public Manufacturer createManufacturer(@Argument Manufacturer inputManufacturer) {
        return manufacturerService.createManufacturer(inputManufacturer);
    }

    @MutationMapping
    public Manufacturer updateManufacturer(@Argument Manufacturer inputManufacturer) {
        return manufacturerService.updateManufacturer(inputManufacturer);
    }

    @MutationMapping
    public String deleteManufacturer(@Argument Integer manufacturerId){
        Manufacturer manufacturer = findManufacturerById(manufacturerId);
        if(manufacturer != null){
            manufacturerService.deleteManufacturer(manufacturerId);
            return "El fabricante con id: "+manufacturerId+" se elimino con exito";
        }else{
            return "El fabricante con id: "+manufacturerId+" no existe";
        }
    }
}
