package com.uptc.frm.graphql.controller;

import com.uptc.frm.graphql.jpa.models.ElectronicDevice;
import com.uptc.frm.graphql.services.ElectronicDeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class ElectronicDeviceController {

    @Autowired
    private ElectronicDeviceService electronicDeviceService;

    @QueryMapping
    public List<ElectronicDevice> findAllElectronicDevice() {
        return electronicDeviceService.findAll();
    }

    @QueryMapping(name = "findElectronicDeviceById")
    public ElectronicDevice findElectronicDeviceById(@Argument(name = "electronicDeviceId") Integer id) {
        int electronicDeviceId = id;
        return electronicDeviceService.findById(electronicDeviceId);
    }

    @QueryMapping
    public List<ElectronicDevice> findElectronicDeviceByTypeId(@Argument Integer typedId) {
        return electronicDeviceService.findByTypeId(typedId);
    }

    @MutationMapping
    public ElectronicDevice createElectronicDevice(@Argument ElectronicDevice inputDevice){
        return electronicDeviceService.createElectronicDevice(inputDevice);
    }

    @MutationMapping
    public ElectronicDevice updateElectronicDevice(@Argument ElectronicDevice inputDevice){
        return electronicDeviceService.updateElectronicDevice(inputDevice);
    }

    @MutationMapping
    public String deleteElectronicDevice(@Argument Integer electronicDeviceId){
        ElectronicDevice device = electronicDeviceService.findById(electronicDeviceId);
        if (device != null) {
            electronicDeviceService.deleteElectronicDevice(electronicDeviceId);
            return ("El registro con id: " + electronicDeviceId + " se elimino con exito");
        } else {
            return ("El registro con id: " + electronicDeviceId + " no existe");
        }
    }

}
