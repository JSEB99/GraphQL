package com.uptc.frm.graphql.controller;

import com.uptc.frm.graphql.jpa.models.Client;
import com.uptc.frm.graphql.jpa.models.Repair;
import com.uptc.frm.graphql.services.RepairService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class RepairController {
    @Autowired
    private RepairService repairService;
    @QueryMapping(name = "findRepairById")
    public Repair findRepairById(@Argument(name = "idRepair") Integer idRepair){
        return repairService.findById(idRepair);
    }
    @QueryMapping(name = "findAllRepairs")
    public List<Repair> findAllRepairs(){
        return repairService.findAllRepair();
    }
    @MutationMapping
    public Repair createRepair(@Argument Repair inputRepair){
        return repairService.createRepair(inputRepair);
    }
    @MutationMapping
    public Repair updateRepair(@Argument Repair updateRepair){
        return  repairService.updateRepair(updateRepair);
    }
    @MutationMapping
    public String deleteRepair(@Argument Integer deleteRepair){
        Repair repair = repairService.findById(deleteRepair);
        if (repair != null) {
            repairService.deleteRepair(deleteRepair);
            return ("El cliente con id: " + deleteRepair + " se elimino con exito");
        }else {
            return ("El cliente con id: " + deleteRepair + " no existe");
        }
    }

}
