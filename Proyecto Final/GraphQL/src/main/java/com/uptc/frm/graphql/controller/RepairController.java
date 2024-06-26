package com.uptc.frm.graphql.controller;

import com.uptc.frm.graphql.jpa.models.Client;
import com.uptc.frm.graphql.jpa.models.ElectronicDevice;
import com.uptc.frm.graphql.jpa.models.Modification;
import com.uptc.frm.graphql.jpa.models.Repair;
import com.uptc.frm.graphql.services.ModificationService;
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
    @Autowired
    private ModificationService modificationService;
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
            List<Modification> modifications = modificationService.findByidRepair(deleteRepair);
            if (modifications.isEmpty()){
                repairService.deleteRepair(deleteRepair);
                return ("La reparacion con id: " + deleteRepair + " se elimino con exito");
            }else{
                return ("La reparacion con id: "+ deleteRepair + " tiene "+modifications.size()+" modificaciones, por lo tanto no se puede eliminar");
            }

        }else {
            return ("La reparacion con id: " + deleteRepair + " no existe");
        }
    }
    @QueryMapping
    public List<Repair> findRepairByNumIdClient(@Argument Integer numberIdClient) {
        return repairService.findByNumberIdClient(numberIdClient);
    }
    @QueryMapping
    public List<Repair> findRepairIdByElectronicDevices(@Argument Integer idApparatus){
        return repairService.findByidApparatus(idApparatus);
    }

}
