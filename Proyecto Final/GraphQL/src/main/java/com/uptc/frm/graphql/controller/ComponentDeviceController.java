package com.uptc.frm.graphql.controller;

import com.uptc.frm.graphql.jpa.models.ComponentDevice;
import com.uptc.frm.graphql.services.ComponentDeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import java.util.List;

@Controller
public class ComponentDeviceController {

    @Autowired
    private ComponentDeviceService componentDeviceService;

    @QueryMapping(name = "findAllComponentDevices")
    public List<ComponentDevice> getAllComponentDevices() {
        return componentDeviceService.findAllComponentDevices();
    }

    @QueryMapping(name = "findComponentDevicesByComponentId")
    public List<ComponentDevice> findComponentDevicesByComponentId(@Argument Integer componentId) {
        return componentDeviceService.findComponentDeviceByComponentId(componentId);
    }

    @QueryMapping(name = "findComponentDevicesByDeviceId")
    public List<ComponentDevice> findComponentDevicesByDeviceId(@Argument Integer deviceId) {
        return componentDeviceService.findComponentDeviceByDeviceId(deviceId);
    }

    @QueryMapping(name = "findComponentDeviceByComponentDeviceId")
    public ComponentDevice findComponentDeviceByComponentDeviceId(@Argument Integer componentDeviceId) {
        return componentDeviceService.findComponentDeviceByComponentDeviceId(componentDeviceId);
    }

    @MutationMapping
    public ComponentDevice createComponentDevice(@Argument ComponentDevice inputComponentDevice) {
        return componentDeviceService.createComponentDevice(inputComponentDevice);
    }

    @MutationMapping
    public ComponentDevice updateComponentDevice(@Argument ComponentDevice inputComponentDevice) {
        return componentDeviceService.updateComponentDevice(inputComponentDevice);
    }

    @MutationMapping
    public String deleteComponentDevice(@Argument Integer componentDeviceId) {
        ComponentDevice componentDevice = findComponentDeviceByComponentDeviceId(componentDeviceId);
        if(componentDevice != null) {
            componentDeviceService.deleteComponentDeviceByComponentDeviceId(componentDeviceId);
            return "La relación componente aparato con id: "+componentDeviceId+" ha sido eliminado con exito";
        }else{
            return "La relación componente aparato con id: "+componentDeviceId+" no existe";
        }
    }

}
