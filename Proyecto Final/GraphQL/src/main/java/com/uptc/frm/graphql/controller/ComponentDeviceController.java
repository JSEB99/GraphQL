package com.uptc.frm.graphql.controller;

import com.uptc.frm.graphql.jpa.models.ComponentDevice;
import com.uptc.frm.graphql.services.ComponentDeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
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

}
