package com.uptc.frm.graphql.controller;

import com.uptc.frm.graphql.jpa.models.SubType;
import com.uptc.frm.graphql.services.SubTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class SubTypeController {

    @Autowired
    private SubTypeService subTypeService;

    @QueryMapping
    public List<SubType> findAllSubTypes(){
        return subTypeService.getAllSubTypes();
    }

    @QueryMapping
    public SubType findSubTypeById(@Argument Integer subTypeId){
        return subTypeService.findSubTypeById(subTypeId);
    }

    @MutationMapping
    public SubType createSubType(@Argument SubType inputSubType){
        return subTypeService.saveSubType(inputSubType);
    }

    @MutationMapping
    public SubType updateSubType(@Argument SubType inputSubType){
        return subTypeService.updateSubType(inputSubType);
    }

    @MutationMapping
    public String  deleteSubType(@Argument Integer subTypeId){
        SubType subType = subTypeService.findSubTypeById(subTypeId);
        if(subType != null){
            subTypeService.deleteSubType(subTypeId);
            return ("El registro con id: " + subTypeId + " se elimino con exito");
        } else {
            return ("El registro con id: " + subTypeId + " no existe");
        }
    }
}
