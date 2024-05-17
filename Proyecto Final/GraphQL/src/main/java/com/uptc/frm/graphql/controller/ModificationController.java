package com.uptc.frm.graphql.controller;

import com.uptc.frm.graphql.jpa.models.Modification;
import com.uptc.frm.graphql.jpa.models.Repair;
import com.uptc.frm.graphql.services.ModificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class ModificationController {
    @Autowired
    private ModificationService modificationService;
    @QueryMapping
    public Modification findModificationById(@Argument Integer idModification){
        return modificationService.findById(idModification);
    }
    @QueryMapping
    public List<Modification> findAllModifications(){
        return modificationService.findAll();
    }
   /* @MutationMapping
    public Modification createModification(@Argument Modification inputModification){
        return modificationService.createModification(inputModification);
    }
    @MutationMapping
    public Modification updateModification(@Argument Modification updateModification){
        return modificationService.updateModification(updateModification);
    }*/
    @MutationMapping
    public String deleteModification(@Argument Integer deleteModification){
        Modification modification = modificationService.findById(deleteModification);
        if (modification != null) {
            modificationService.deleteModification(deleteModification);
            return ("El cliente con id: " + deleteModification + " se elimino con exito");
        }else {
            return ("El cliente con id: " + deleteModification + " no existe");
        }
    }
    @QueryMapping
    public List<Modification> findModificationByRepaidId(@Argument Integer numRepairId){
        return modificationService.findByidRepair(numRepairId);
    }
}
