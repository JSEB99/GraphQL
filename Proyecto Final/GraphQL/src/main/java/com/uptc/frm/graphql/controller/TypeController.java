package com.uptc.frm.graphql.controller;

import com.uptc.frm.graphql.jpa.models.Type;
import com.uptc.frm.graphql.services.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class TypeController {

    @Autowired
    private TypeService typeService;

    @QueryMapping
    public List<Type> findAllTypes(){
        return typeService.getAllTypes();
    }

    @QueryMapping
    public Type findTypeById(@Argument Integer typeId){
        return typeService.findTypeById(typeId);
    }

    @MutationMapping
    public Type createType(@Argument Type inputType){
        return typeService.saveType(inputType);
    }

    @MutationMapping
    public Type updateType(@Argument Type inputType){
        return typeService.updateType(inputType);
    }

    @MutationMapping
    public String deleteType(@Argument Integer typeId){
        String response = typeService.deleteTypeById(typeId);
        return response;
    }

}
