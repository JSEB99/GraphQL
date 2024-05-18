package com.uptc.frm.graphql.controller;

import com.uptc.frm.graphql.jpa.models.Component;
import com.uptc.frm.graphql.services.ComponentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class ComponentController {

    @Autowired
    private ComponentService componentService;

    @QueryMapping(name = "findAllComponents")
    public List<Component> getAllComponents() {
        return componentService.findAllComponents();
    }

    @QueryMapping(name = "findComponentById")
    public Component getComponentById(@Argument Integer componentId) {
        return componentService.findComponentById(componentId);
    }

    @QueryMapping(name = "findComponentsByManufacturerId")
    public List<Component> getComponentsByManufacturerId(@Argument Integer manufacturerId) {
        return componentService.findComponentsByManufacturerId(manufacturerId);
    }

    @MutationMapping
    public Component createComponent(@Argument Component inputComponent) {
        return componentService.createComponent(inputComponent);
    }

    @MutationMapping
    public Component updateComponent(@Argument Component inputComponent) {
        return componentService.updateComponent(inputComponent);
    }

    @MutationMapping
    public String deleteComponent(@Argument Integer componentId) {
        Component component = getComponentById(componentId);
        if(component != null) {
            String flag = componentService.deleteComponentById(componentId);
            if(flag == "exito"){
                return "El componente con id: "+componentId+" se elimino con "+flag;
            }else{
                return "El componente con id: "+componentId+" no se elimino con exito por que tiene: "+flag;
            }

        }else{
            return "El componente con id: "+componentId+" no existe";
        }
    }

}
